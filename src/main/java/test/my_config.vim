
set clipboard+=unnamed

set foldmethod=indent
set foldlevel=0

imap ,, <Esc>la
map <leader>k $

set noshowmode
autocmd StdinReadPre * let s:std_in=1
autocmd VimEnter * if argc() == 0 && !exists("s:std_in") | NERDTree | endif
