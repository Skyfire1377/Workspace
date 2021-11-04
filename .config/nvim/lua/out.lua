local out = {}
function out:writeToFile(path, data)

	local handler = assert(io.open(path, "w"), "io open failure buildPath")
	local result = assert(handler:write(data, "\n"), "Error during build file insertion")
	handler:close()
	return result
end

function out:log(message)
	local path = '/root/.config/nvim/resources/log.md'	
	local date = self:getDate()
	local insertString = date .. ' ' .. message
	local handler = assert(io.open(path, "a"), "io open failure buildPath")
	local result = assert(handler:write(insertString, "\n"), "Error during build file insertion")
	handler:close()
end
function out:test(message)
	self:print(message)
end
function out:print(message)
	print(message)

end

function out:getDate()
	
	local date = os.date("%Y/%m/%d %H:%M:%S")
	return date;
end
return out
