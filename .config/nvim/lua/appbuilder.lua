out = require('out')
timer = require('timer')
local appbuilder = {}
--appbuilder.__index=appbuilder
function appbuilder:tb()
	local path = self:nTreeGetPathToSelected()
	--local list = appbuilder.split(path, "/")
	local command = string.format([[
		execute "tabe"
		execute "Rooter"
		execute "terminal bash"
		"call chansend(b:terminal_job_id, "cd %s")

		execute 'normal! i'
		"call chansend(b:terminal_job_id, "\<cr>")
	]], path)	
	vim.api.nvim_exec(command, true)
end
function appbuilder:goToRoot()

	--print(pathOfSelected)
	local pathOfSelected = self:nTreeGetPathToSelected()
	local list = self:split(pathOfSelected, "/")
	--print(table.getn(list))
	local index = self:indexOf(list, "core")
	local path =""
	if index ~= -1 then
		for i=1,index+1,1
			do
			path = path .. '/' .. list[i]
		end
		path = path .. '/'
	end
	local command = string.format([[NERDTreeFind %s]], path)
	vim.api.nvim_exec(command, true)
end
function appbuilder:goToSrc()
	timer:start()

	local path = self:nTreeGetPathToSelected()
	local list = self:split(path, "/")
	local name = list[table.getn(list)]
	local searchedPath = string.format("%s/src/main/java/%s/", path, name)	
	local command = string.format([[NERDTreeFind %s]], searchedPath)
	vim.api.nvim_exec(command, false)
	timer:finish()
	out:log("open src time: "..timer:result())
end
function appbuilder:split(data, separator)
	t = {}
	for str in string.gmatch(data, "([^" .. separator.. "]+)") do 
		table.insert(t, str)
	end
	return t
end
function appbuilder:indexOf(list, target)

	local length = table.getn(list)
	local index = -1
	for i=1,length,1
		do
		if list[i]==target then
			index = i
			break
		end

	end
	return index
end
function appbuilder:createDirectoriesByPath(path)

	local command = string.format([[/bin/bash -c "mkdir -p %s"]], path)
	local handler = assert(io.popen(command), "Directories creation error")
	handler:close()
	
end
function appbuilder:nTreeGetPathToSelected()

	local path = vim.api.nvim_exec([[
		let path = NtGetPathToSelected()
		echo path
	]], true)
	return path
end
function appbuilder:firstLetterUpperCase(word)

	local result = word:sub(1,1):upper()..word:sub(2)
	return result
end
function appbuilder:replaceInTextByList(text, list)
	local content = text
	for key,value in pairs(list) do
		content = string.gsub(content, key, value)
	end
	return content
end
function appbuilder:createFileByPath(path)
	local handler = assert(io.open(path, "w"), "Error of file creation")
	--local command='>'..path
--local handler = assert(io.popen(command), "File creation error " .. path)
	--io.popen("chmod +x " .. path)
	handler:close()
end
function appbuilder:insertIntoFileByShell(pathToClass, data)

	local command = "echo "..data..">"..pathToClass
	local handler =assert(io.popen(command), "Insertion to file filed "..pathToClass)
	handler:close()
end
function appbuilder:readFile(path)

	local handler = assert(io.open(path, "r"), "File opening for reading error")
	local content = handler:read("*all")
	return content
end
function appbuilder:readFileByLines(path)

	--local handler = assert(io.lines(path), "File opening for reading error")
	--local content = handler:read("*all")
	--return content
	if not self:readFile(path) then return {} end
	local linesList = {}
	for line in io.lines(path) do
		linesList[#linesList+1]=line
	end
	return linesList
end

function appbuilder:createFile(settings)
	
	self:createFileByPath(settings.pathToFile)
	local content = self:replaceInTextByList(settings.content, settings.listOfReplacement)
	out:writeToFile(settings.pathToFile, content)
end
function appbuilder:createSubProject(name)
	local pathOfSelected = self:nTreeGetPathToSelected()
	local subProjectRootPath = string.format("%s/%s", pathOfSelected, name)
	--local fullPath = subProjectRootPath.."/{src/{main/{java/{"..name..",resources}},test/{java/{"..name..",resources}}},build}"
	local fullPath=string.format("%s/{src/{main/java/{%s,resources},test/java/{%s,resources}},build}", subProjectRootPath, name, name)
	
	self:createDirectoriesByPath(fullPath)
	--os.execute("sleep 2")
	local className = self:firstLetterUpperCase(name)
	local settings = {

		pathToFile = string.format("%s/src/main/java/%s/%s.java", subProjectRootPath, name, className), 
		content = self:readFile("/root/.config/nvim/resources/App.java"),
		listOfReplacement = {
			["#packageName"] = name,
			["#className"] = className
		}
	}
	self:createFile(settings)
	
	local settings = {
		pathToFile = string.format("%s/build.gradle", subProjectRootPath),
		content = self:readFile("/root/.config/nvim/resources/build.gradle"),
		listOfReplacement = {
		['#mainClass']= string.format("mainClass='%s.%s'", name, className)
		}


	}
	self:createFile(settings)
	local testClassName = className .. "Test"	
	local settings = {
		pathToFile = string.format("%s/src/test/java/%s/%s.java", subProjectRootPath, name, testClassName),
		content = self:readFile("/root/.config/nvim/resources/AppTest.java"),
		listOfReplacement = {
			["#packageName"] = name,
			["#className" ] = testClassName
		}
	}
	self:createFile(settings)
	--vim.cmd("normal R")
	
end
function appbuilder:createNewClass(name)
	local fileName = name .. ".java"
	local path = self:nTreeGetPathToSelected()
	local pathToFile = path .. "/" .. fileName
	self:createFileByPath(pathToFile)
	vim.api.nvim_exec([[
		:Rooter
	]], true)
	local subProjectName = vim.fn.fnamemodify(vim.fn.getcwd(), ':t')
	--out:log(vim.fn.fnamemodify(vim.fn.getcwd(), ':t'))

	local insertion = "package " .. subProjectName .. ";\n" .. "class " .. self:firstLetterUpperCase(name) .. "{\n}"
	out:writeToFile(pathToFile, insertion)

	local command = string.format([[
		tabe
		e %s/%s
	]], path, fileName)
	vim.api.nvim_exec(command, true)
	
end
function appbuilder:reload()
	package.loaded["appbuilder"]=nil
	return require("appbuilder")
end
function appbuilder:listToString(list)
	string=''
	for _,value in pairs(list) do
		string = string .. value .. '\n'
	end
	return string
end
function appbuilder:getFirstCharacter(strLine)

	for c in string.gmatch(strLine, ".") do
		if (c ~= nil and c ~= "" and c ~= " ") then 
		return c
	end
	end
	return ""
end
return appbuilder
