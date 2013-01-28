package com.mypos.terminal.service;

import java.util.Collection;

import javax.annotation.Resource;


import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mypos.terminal.Terminal;

@Service(value = "terminalService")
@Transactional
public class HqlTerminalService implements TerminalService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	private Session session()
	{
		return sessionFactory.getCurrentSession();
	}
	
	
	@SuppressWarnings("unchecked")//sigurnost tipa podataka
	@Override
	public Collection<Terminal> getAll()
	{
		logger.debug("Dohvati sve pos-terminale.");
		
		//session od hibernate
		Session session = session();
		
		//hibernate upit
		Query query = session.createQuery("FROM POS_TerminalAdmin");
		
		//dohvati sve iz kolekcije
		return query.list();
		
	}
	
	//dohvaca jedan terminal
	@Override
	public Terminal get(Long posId)
	{
		Session session = session();
		Terminal terminal = (Terminal) session.get(Terminal.class, posId);
		return terminal;
	}
	
	//dodaje novi terminal
	@Override
	public Terminal save(Terminal terminal)
	{
		logger.debug("Spremi novi pos-terminal.");
		session().saveOrUpdate(terminal);
		return terminal;
	}
	
	//brise terminal
	@Override
	public void delete(Long posId)
	{
		session().delete(get(posId));
	}
	
	//azurira terminal
	@Override
	public void edit(Terminal terminal)
	{
		logger.debug("Azuriraj pos-terminal");
		Terminal existingTerminal = (Terminal) session().get(Terminal.class, terminal.getPosId());
		
		existingTerminal.setPosOwner(terminal.getPosOwner());
		existingTerminal.setPosLocation(terminal.getPosLocation());
		existingTerminal.setPosActivation(terminal.getPosActivation());
		
		session().save(existingTerminal);
	}
}
