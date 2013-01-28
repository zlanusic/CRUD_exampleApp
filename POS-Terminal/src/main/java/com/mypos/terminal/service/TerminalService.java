package com.mypos.terminal.service;

import java.util.Collection;

import com.mypos.terminal.Terminal;

public interface TerminalService {

	public Collection<Terminal> getAll();//sve pos-e
	public Terminal get(Long posId);//jedan pos
	public Terminal save(Terminal terminal);//dodaj
	public void delete(Long posId);//bisi
	public void edit(Terminal terminal);//uredi
}
