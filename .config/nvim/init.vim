call plug#begin('~/.config/nvim/plugged')


"Deoplete plugin
if has('nvim')
 Plug 'Shougo/deoplete.nvim', { 'do': ':UpdateRemotePlugins' }
else

 Plug 'Shougo/deoplete.nvim'
 Plug 'roxma/nvim-yarp'
 Plug 'roxma/vim-hug-neovim-rpc'
endif

let g:deoplete#enable_at_startup = 1
 Plug 'deoplete-plugins/deoplete-lsp'
set runtimepath+=~/.config/nvim/plugged/deoplete.nvim

"let s:pattern='\w*'
"""call deoplete#custom#option('auto_complete_delay', 100)

"call deoplete#custom#source('javacomplete2', 
			"\ 'max_abbr_width', 20)

"call deoplete#custom#source('javacomplete2',
			"\ 'max_menu_width', 80)



"call deoplete#custom#source('omni', 'functions', {
		    "\ 'java': ['javacomplete#Complete']
		    "\})

"call deoplete#custom#option('omni_patterns', {
		"\ 'java': s:pattern,
		"\})

call deoplete#custom#var('around', {
		\   'range_above': 15,
		\   'range_below': 15,
		\   'mark_above': '[↑]',
		\   'mark_below': '[↓]',
		\   'mark_changes': '[*]',
		\})
""call deoplete#custom#option('sources', {
		""\ 'java': ['buffer', 'file', 'omni']
		""\})

	""call deoplete#custom#var('omni', 'input_patterns', {
	    "\ 'java': '[^. *\t0-9]\-\->\w*' 
		    "\})
set completeopt+=noinsert
set completeopt+=noselect



 "assuming you're using vim-plug: https://github.com/junegunn/vim-plug
    "Plug 'ncm2/ncm2'
    "Plug 'roxma/nvim-yarp'


    "Plug 'ncm2/ncm2-bufword'
    "Plug 'ncm2/ncm2-path'
    "Plug 'ncm2/ncm2-tagprefix'
    ""Plug 'ncm2/ncm2-ultisnips'
    ""Plug 'ncm2/ncm2-markdown-subscope'
    "Plug 'ncm2/ncm2-rst-subscope'
    " enable ncm2 for all g:airline#extensions#tabline#buffer_nr_show
    "au User Ncm2Plugin call ncm2#register_source({
	    "\ 'name' : 'java',
	    "\ 'priority': 9,
	    "\ 'subscope_enable': 1,
	    "\ 'scope': ['java'],
	    "\ 'mark': 'java',
	    "\ 'word_pattern': '[\w\-]+',
	    "\ 'complete_pattern': ':\s*',
	    "\ 'on_complete': ['ncm2#on_complete#omni', 'javacomplete#Complete']
	    "\ })



    "autocmd BufEnter * call ncm2#enable_for_buffer()

    "" IMPORTANT: :help Ncm2PopupOpen for more information
    "set completeopt=noinsert,menuone,noselect

    "" NOTE: you need to install completion sources to get completions. Check
    "" our wiki page for a list of sources: https://github.com/ncm2/ncm2/wiki

"nvim-jtdls options
 Plug 'mfussenegger/nvim-jdtls'

 "autocmd FileType java :Rooter | lua require('java')

 "if has('nvim-0.5')
  "augroup lsp
    "au!
    "au filetype java lua require('jdtls').start_or_attach({cmd = {'startServer.sh'}, root_dir=require('jdtls.setup').find_root({'gradle.build'}), command=require('jdtls.setup').add_commands()})
  "augroup end
"endif

command! -buffer JdtCompile lua require('jdtls').compile()
command! -buffer JdtUpdateConfig lua require('jdtls').update_project_config()
command! -buffer JdtJol lua require('jdtls').jol()
command! -buffer JdtBytecode lua require('jdtls').javap()
command! -buffer JdtJshell lua require('jdtls').jshell()


"-- `code_action` is a superset of vim.lsp.buf.code_action and you'll be able to
"-- use this mapping also with other language servers
nnoremap <A-CR> <Cmd>lua require('jdtls').code_action()<CR>
vnoremap <A-CR> <Esc><Cmd>lua require('jdtls').code_action(true)<CR>
nnoremap <leader>r <Cmd>lua require('jdtls').code_action(false, 'refactor')<CR>

nnoremap <A-o> <Cmd>lua require'jdtls'.organize_imports()<CR>
nnoremap crv <Cmd>lua require('jdtls').extract_variable()<CR>
vnoremap crv <Esc><Cmd>lua require('jdtls').extract_variable(true)<CR>
nnoremap crc <Cmd>lua require('jdtls').extract_constant()<CR>
vnoremap crc <Esc><Cmd>lua require('jdtls').extract_constant(true)<CR>
vnoremap crm <Esc><Cmd>lua require('jdtls').extract_method(true)<CR>


"-- If using nvim-dap
"-- This requires java-debug and vscode-java-test bundles, see install steps in this README further below.
nnoremap <leader>df <Cmd>lua require'jdtls'.test_class()<CR>
nnoremap <leader>dn <Cmd>lua require'jdtls'.test_nearest_method()<CR>

"end nvim-jdtls options
"
"
 Plug 'neovim/nvim-lspconfig'
"Plug 'nvim-lua/completion-nvim'

" Plug 'itchyny/lightline.vim'
 Plug 'vim-airline/vim-airline'
 
 let g:airline_powerline_fonts = 1 
 Plug 'vim-airline/vim-airline-themes'
 Plug 'ervandew/supertab'
 let g:SuperTabDefaultCompletionType = "<c-n>"
 Plug 'preservim/nerdtree'
 "Plug 'kyazdani42/nvim-web-devicons' " for file icons
 "Plug 'kyazdani42/nvim-tree.lua'

 "let g:nvim_tree_side = 'right' "left by default
"let g:nvim_tree_width = 40 "30 by default, can be width_in_columns or 'width_in_percent%'
"let g:nvim_tree_ignore = [ '.git', 'node_modules', '.cache' ] "empty by default
"let g:nvim_tree_gitignore = 1 "0 by default
"let g:nvim_tree_auto_open = 1 "0 by default, opens the tree when typing `vim $DIR` or `vim`
"let g:nvim_tree_auto_close = 1 "0 by default, closes the tree when it's the last window
"let g:nvim_tree_auto_ignore_ft = [ 'startify', 'dashboard' ] "empty by default, don't auto open tree on specific filetypes.
"let g:nvim_tree_quit_on_open = 1 "0 by default, closes the tree when you open a file
"let g:nvim_tree_follow = 1 "0 by default, this option allows the cursor to be updated when entering a buffer
"let g:nvim_tree_follow_update_path = 1 "0 by default, will update the path of the current dir if the file is not inside the tree.
"Default is 0
"let g:nvim_tree_indent_markers = 1 "0 by default, this option shows indent markers when folders are open
"let g:nvim_tree_hide_dotfiles = 1 "0 by default, this option hides files and folders starting with a dot `.`
"let g:nvim_tree_git_hl = 1 "0 by default, will enable file highlight for git attributes (can be used without the icons).
"let g:nvim_tree_highlight_opened_files = 1 "0 by default, will enable folder and file icon highlight for opened files/directories.
"let g:nvim_tree_root_folder_modifier = ':~' "This is the default. See :help filename-modifiers for more options
"let g:nvim_tree_tab_open = 1 "0 by default, will open the tree when entering a new tab and the tree was previously open
"let g:nvim_tree_auto_resize = 0 "1 by default, will resize the tree to its saved width when opening a file
"let g:nvim_tree_disable_netrw = 0 "1 by default, disables netrw
"let g:nvim_tree_hijack_netrw = 0 "1 by default, prevents netrw from automatically opening when opening directories (but lets you keep its other utilities)
"let g:nvim_tree_add_trailing = 1 "0 by default, append a trailing slash to folder names
"let g:nvim_tree_group_empty = 1 " 0 by default, compact folders that only contain a single folder into one node in the file tree
"let g:nvim_tree_lsp_diagnostics = 1 "0 by default, will show lsp diagnostics in the signcolumn. See :help nvim_tree_lsp_diagnostics
"let g:nvim_tree_disable_window_picker = 1 "0 by default, will disable the window picker.
"let g:nvim_tree_hijack_cursor = 0 "1 by default, when moving cursor in the tree, will position the cursor at the start of the file on the current line
"let g:nvim_tree_icon_padding = ' ' "one space by default, used for rendering the space between the icon and the filename. Use with caution, it could break rendering if you set an empty string depending on your font.
"let g:nvim_tree_symlink_arrow = ' >> ' " defaults to ' ➛ '. used as a separator between symlinks' source and target.
"let g:nvim_tree_update_cwd = 1 "0 by default, will update the tree cwd when changing nvim's directory (DirChanged event). Behaves strangely with autochdir set.
"let g:nvim_tree_respect_buf_cwd = 1 "0 by default, will change cwd of nvim-tree to that of new buffer's when opening nvim-tree.
"let g:nvim_tree_refresh_wait = 500 "1000 by default, control how often the tree can be refreshed, 1000 means the tree can be refresh once per 1000ms.
"let g:nvim_tree_window_picker_exclude = {
    "\   'filetype': [
    "\     'packer',
    "\     'qf'
    "\   ],
    "\   'buftype': [
    "\     'terminal'
    "\   ]
    "\ }
"" Dictionary of buffer option names mapped to a list of option values that
"" indicates to the window picker that the buffer's window should not be
"" selectable.
"let g:nvim_tree_special_files = { 'README.md': 1, 'Makefile': 1, 'MAKEFILE': 1 } " List of filenames that gets highlighted with NvimTreeSpecialFile
"let g:nvim_tree_show_icons = {
    "\ 'git': 1,
    "\ 'folders': 0,
    "\ 'files': 0,
    "\ 'folder_arrows': 0,
    "\ }
""If 0, do not show the icons for one of 'git' 'folder' and 'files'
""1 by default, notice that if 'files' is 1, it will only display
""if nvim-web-devicons is installed and on your runtimepath.
""if folder is 1, you can also tell folder_arrows 1 to show small arrows next to the folder icons.
""but this will not work when you set indent_markers (because of UI conflict)

"" default will show icon by default if no icon is provided
"" default shows no icon by default
"let g:nvim_tree_icons = {
    "\ 'default': '',
    "\ 'symlink': '',
    "\ 'git': {
    "\   'unstaged': "✗",
    "\   'staged': "✓",
    "\   'unmerged': "",
    "\   'renamed': "➜",
    "\   'untracked': "★",
    "\   'deleted': "",
    "\   'ignored': "◌"
    "\   },
    "\ 'folder': {
    "\   'arrow_open': "",
    "\   'arrow_closed': "",
    "\   'default': "",
    "\   'open': "",
    "\   'empty': "",
    "\   'empty_open': "",
    "\   'symlink': "",
    "\   'symlink_open': "",
    "\   },
    "\   'lsp': {
    "\     'hint': "",
    "\     'info': "",
    "\     'warning': "",
    "\     'error': "",
    "\   }
    "\ }

"nnoremap <C-n> :NvimTreeToggle<CR>
"nnoremap <leader>r :NvimTreeRefresh<CR>
"nnoremap <leader>n :NvimTreeFindFile<CR>
"" NvimTreeOpen, NvimTreeClose and NvimTreeFocus are also available if you need them

"set termguicolors " this variable must be enabled for colors to be applied properly

"" a list of groups can be found at `:help nvim_tree_highlight`
"highlight NvimTreeFolderIcon guibg=blue

 "
 "let g:NERDTreeChDirMode=2

 Plug 'preservim/nerdcommenter'


 Plug 'jiangmiao/auto-pairs'
 Plug 'webastien/vim-ctags'
 "Plug 'mfussenegger/nvim-jdtls'
 "Plug 'vim-scripts/AutoComplPop'
 "Plug 'ObserverOfTime/ncm2-jc2', {'for': ['java', 'jsp']}
 
 "Plug 'artur-shaik/vim-javacomplete2', {'for': ['java', 'jsp']} 
 "Plug 'artur-shaik/vim-javacomplete2'

 "autocmd FileType java setlocal omnifunc=javacomplete#Complete


 Plug 'davetron5000/java-javadoc-vim'
 "Plug 'uiiaoo/java-syntax.vim'
 "Plug 'kingDaniel2004/NVim_Java_Highlighting' 
 Plug 'nvim-treesitter/nvim-treesitter', {'do': ':TSUpdate'}


 Plug 'ryanoasis/vim-devicons'
 Plug 'easymotion/vim-easymotion'
 Plug 'vwxyutarooo/nerdtree-devicons-syntax'
 "Plug 'caenrique/nvim-toggle-terminal' 
 "Plug 'mikelue/vim-maven-plugin'
 "Plug 'prabirshrestha/async.vim'
 "Plug 'prabirshrestha/vim-lsp'
" (Optional) Multi-entry selection UI.
 Plug 'jnurmine/Zenburn'
 Plug 'NLKNguyen/papercolor-theme'
 Plug 'jacoborus/tender.vim'
 Plug 'morhetz/gruvbox'
 Plug 'dracula/vim'
 Plug 'ayu-theme/ayu-vim'

"fzf options
Plug 'junegunn/fzf', { 'do': { -> fzf#install() } }
Plug 'junegunn/fzf.vim'
"
" This is the default option:
"   - Preview window on the right with 50% width
"   - CTRL-/ will toggle preview window.
" - Note that this array is passed as arguments to fzf#vim#with_preview function.
" - To learn more about preview window options, see `--preview-window` section of `man fzf`.
let g:fzf_preview_window = ['right:50%', 'ctrl-/']

" Preview window on the upper side of the window with 40% height,
" hidden by default, ctrl-/ to toggle
"let g:fzf_preview_window = ['up:40%:hidden', 'ctrl-/']

" Empty value to disable preview window altogether
"let g:fzf_preview_window = []
" [Buffers] Jump to the existing window if possible
let g:fzf_buffers_jump = 1

" [[B]Commits] Customize the options used by 'git log':
let g:fzf_commits_log_options = '--graph --color=always --format="%C(auto)%h%d %s %C(black)%C(bold)%cr"'

" [Tags] Command to generate tags file
let g:fzf_tags_command = 'ctags -R'

" [Commands] --expect expression for directly executing the command
let g:fzf_commands_expect = 'alt-enter,ctrl-x'

command! -bang -nargs=? -complete=dir Files call fzf#vim#files(<q-args>, <bang>0)


"end fzf options

"telescope options
"
"Plug 'nvim-lua/plenary.nvim'
"Plug 'nvim-telescope/telescope.nvim'
"autocmd User TelescopePreviewerLoaded setlocal wrap
"
"
 Plug 'airblade/vim-rooter'

let g:rooter_patterns = ['build.gradle']
"Plug 'lgranie/vim-lsp-java'




  "Plug 'autozimu/LanguageClient-neovim', {
    "\ 'branch': 'next',
    "\ 'do': 'bash install.sh',
    "\ }

"let g:LanguageClient_autoStart = 1
"" Use the location list instead of the quickfix list to show linter warnings
"let g:LanguageClient_diagnosticsList = "Location"
"let g:LanguageClient_rootMarkers = {
"
    "\ 'java': ['app', 'gradle']
    "\ }
"let g:LanguageClient_serverCommands = {
    "\ 'java': ['~/eclipse.jdt.ls/startEclipse.sh']
    "\ }

    
    call plug#end()




  "System options
  set noswapfile
  set tags=./tags;,tags
  set autoread
  filetype plugin on
  "set autochdir
 "User interface oprions
  colorscheme dracula
  
  "let ayucolor="dark"
  "set termguicolors     " enable true colors support
  "set background=light
  set cursorline
  set cursorcolumn
  set wildmenu
  set relativenumber number
  set noerrorbells
  set visualbell
  set showcmd
  set shortmess+=c
  set t_Co=256
  set lazyredraw
  set laststatus=2
  "Indention options
  set autoindent
  set cin
  set si
  "inoremap { {<CR>}<Esc>O	 


  set softtabstop=1
  
  "Search options
  set ignorecase
  "Text render options
  set wrap


  "Plugins option
"let g:airline#extensions#tabline#enabled = 1
"let g:airline#extensions#tabline#buffer_nr_show = 1


let g:python3_host_prog = '/usr/bin/python3'

let g:python_host_prog = '/usr/bin/python' 

let g:vimsyn_embed = 'l'



"functions definings
function! Hello(message)
  echo a:message
endfunction
function! NtGetPathToSelected()
	let n = g:NERDTreeFileNode.GetSelected()

	if n != {}
		return n.path.str()
	endif
endfunction
function! NtRefresh()
	let ct = g:NERDTree.ForCurrentTab()
	call ct.getRoot().refresh()|call ct.render()
      "call g:NERDTree.ForCurrentTab().getRoot().refresh()	| g:NERDTree.ForCurrentTab().render()
endfunction
function! CreateProject(name)
	execute 'cd '.NtGetPathToSelected()
	execute 'silent !mkdir ' a:name 

	"execute 'redraw'
	"call NtRefresh()
	"sleep 2
	execute 'normal r'
	"execute 'NERDTreeRefreshRoot'
	execute 'cd ' a:name
	call GradleInit()
endfunction
function! CreateProjectFromPath(name)
	execute 'silent !mkdir ' a:name

	"execute 'redraw'
	"call NtRefresh()
	"sleep 2
	execute 'normal r'
	"execute 'NERDTreeRefreshRoot'
	execute 'cd ' a:name
	call GradleInit()
endfunction
function! RemoveProject(name)
	
	execute 'cd '.NtGetPathToSelected()
	execute 'silent !rm -rf ' a:name  
	"execute 'redraw'
	execute 'normal r'
endfunction
function! Remove()
	let path = NtGetPathToSelected()
	if confirm("Remove ".path, "&yes &no", 1)==1
		execute "silent !rm -rf ".path
		execute "normal r"
	endif	
endfunction
function! Source ()
	silent source $MYVIMRC
endfunction
function! Reload()
	lua appbuilder = appbuilder.reload()
endfunction
function! GoToSrc()
	lua appbuilder:goToSrc()
endfunction
function! GoToRoot()
	"let pathToSelected = NtGetPathToSelected()
	"let valsList = split(pathToSelected, '/')

	"let path = v:lua.test(valsList)
	"execute 'NERDTreeFind '.path
	"echo path
	
	lua appbuilder:goToRoot()


endfunction
function! CreateSubProject(name)

	call luaeval('appbuilder:createSubProject(_A)', a:name)
endfunction
function! Test1(name)
endfunction
function! Test2()
	lua out:log("Hello there!!!")	
endfunction
function! Build()
	
	tabe | terminal bash
	execute 'Rooter'
	call chansend(b:terminal_job_id, 'gradle run')
	execute 'normal! i'
	call chansend(b:terminal_job_id, "\<cr>")
	
endfunction
function! CreateNewClass(name)
	"let lastPath = !$PWD
	"let fileName = a:name.'.java'
	"let pathToSelected = NtGetPathToSelected()
	"call MoveToDirection(pathToSelected)
	"execute 'silent !> '.fileName
	
	"execute 'normal r'
	":Rooter
	""call MoveToDirection(lastPath)
	":tabe | execute 'e '.pathToSelected.'/'.fileName
	call luaeval('appbuilder:createNewClass(_A)', a:name)
endfunction

function! MoveToDirection(path)
	execute 'cd '.a:path
endfunction
function! GradleInit()
	
	tabe | terminal bash

	call chansend(b:terminal_job_id, 'gradle init --type java-application')
	execute 'normal! i'
	call chansend(b:terminal_job_id, "\<cr>")
	
endfunction
function! Tb()
	lua appbuilder:tb()
endfunction
function! Terminal()
	"let path = NtGetPathToSelected()
	"tabe | terminal bash
	""execute 'terminal cd '. path
	call v:lua.test2()
endfunction
function Edit(path)
	:tabe
		execute ':e '.a:path
endfunction
  "map options
"nnoremap mo <C-w>o 
"nnoremap mh <C-w>h 
"nnoremap mj <C-w>j 
"nnoremap mk <C-w>k 
"nnoremap ml <C-w>l
nnoremap <C-p> :tabprevious<ENTER>
nnoremap <C-n> :tabnext<ENTER>

nnoremap <C-h> ^
nnoremap <C-l> $
vnoremap <C-h> ^
vnoremap <C-l> $
nnoremap <leader>n :NERDTree .<CR>
nnoremap <Tab> :tabprevious<ENTER>
nnoremap <BS> :tabnext<ENTER>
"nnoremap <S-Tab> :tabprevious<ENTER>
nnoremap = $
nnoremap - ^
nnoremap L $
nnoremap H ^
vnoremap = $
vnoremap - ^
nnoremap <A-s> :GoToSrc<ENTER>
nnoremap <A-r> :GoToRoot<ENTER>
nnoremap <A-t> :Tree<ENTER>
nnoremap ` :tabprevious <ENTER>
tnoremap <silent> <Esc> <C-\><C-n>
"inoremap <silent> <Esc> <C-O>:stopinsert<CR>
inoremap jj <Esc>
inoremap <C-Space> <C-x><C-o>

"command options 
command! EditConfig :tabe | :e $MYVIMRC 
					

command! Tb call Tb()
command! Terminal call Terminal()
command! NT :tabe | NERDTree
command! GoToSrc call GoToSrc()

command! GoToRoot call GoToRoot()

command! -nargs=1 CreateSubProject call CreateSubProject(<f-args>)

command! -nargs=1 RemoveProject call RemoveProject(<f-args>)
command! Remove call Remove()
command! -nargs=1 CreateProject call CreateProject(<f-args>)
command! -nargs=1 CreateProjectFromPath call CreateProjectFromPath(<f-args>)


command! -nargs=1 Test1 call Test1(<f-args>)
command! Test2 call Test2()
command! Source call Source()
command! Reload call Reload()
command! Build call Build()
command! Old :browse oldfiles
command! Tree :tabe | :NERDTree | execute 'normal <C-w>o'
command! -nargs=1 CreateNewClass call CreateNewClass(<f-args>)
command! -nargs=1 Edit call Edit(<f-args>)
"let g:JavaComplete_GradleExecutable = './gradlew'
"
"


lua <<EOF
require'nvim-treesitter.configs'.setup {
  ensure_installed = "maintained", -- one of "all", "maintained" (parsers with maintainers), or a list of languages
  ignore_install = { "javascript" }, -- List of parsers to ignore installing
  highlight = {
    enable = true,              -- false will disable the whole extension
    disable = { "c", "rust" },  -- list of language that will be disabled
    -- Setting this to true will run `:h syntax` and tree-sitter at the same time.
    -- Set this to `true` if you depend on 'syntax' being enabled (like for indentation).
    -- Using this option may slow down your editor, and you may see some duplicate highlights.
    -- Instead of true it can also be a list of languages
    additional_vim_regex_highlighting = false,
  },
}
vim.lsp.handlers["textDocument/hover"] = vim.lsp.with(
                   vim.lsp.handlers.hover, {
                     -- Use a sharp border with `FloatBorder` highlights
                     border = "single"
                   }
                 )


appbuilder = require("appbuilder")

EOF
