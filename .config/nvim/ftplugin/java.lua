appbuilder = require("appbuilder")
--local linesList = appbuilder.readFileByLines('/root/startServer.sh')
--print(#content)
--appbuilder.log(appbuilder.listToString(content))
--for _,line in pairs(linesList) do
	--local firstCharacter = appbuilder.getFirstCharacter(line)
	--if (firstCharacter =='-') then
		--appbuilder.log(line)
	--end
--end
vim.api.nvim_exec(":Rooter", true)
local workspace_dir = vim.fn.fnamemodify(vim.fn.getcwd(), ':p:h:t')
--local workspace_dir = vim.fn.getcwd()
--CreateNewClassCreateNewClassCreateNewClass}
out:log(workspace_dir)
local command = 
{'/usr/lib/jvm/java-11-openjdk-arm64/bin/java',
	'-Declipse.application=org.eclipse.jdt.ls.core.id1',
	'-Dosgi.bundles.defaultStartLevel=4',
	'-jar', '/opt/eclipse/eclipse.jdt.ls/org.eclipse.jdt.ls.product/target/repository/plugins/org.eclipse.equinox.launcher_1.6.200.v20210416-2027.jar',
  '-Dlog.level=ALL',
  
  '-Dlog.protocol=true',

  '-Declipse.product=org.eclipse.jdt.ls.core.product',

  '-configuration', '/opt/eclipse/eclipse.jdt.ls/org.eclipse.jdt.ls.product/target/repository/config_linux',
	
	
  '-data' ,'/root/workspace/' .. workspace_dir,
  '--add-modules=ALL-SYSTEM',

  '--add-opens java.base/java.util=ALL-UNNAMED',

  '--add-opens java.base/java.lang=ALL-UNNAMED'
  	

	}
--content = appbuilder.ReplaceInTextByList(content, listOfReplacement)
local config = {
  -- The command that starts the language server
  cmd = command,

  -- This is the default if not provided, you can remove it. Or adjust as needed.
  -- One dedicated LSP server & client will be started per unique root_dir
  root_dir = require('jdtls.setup').find_root({'build.gradle'}),
  require('jdtls.setup').add_commands()
}

require('jdtls').start_or_attach(config)
