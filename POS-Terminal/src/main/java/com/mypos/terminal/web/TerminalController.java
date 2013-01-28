package com.mypos.terminal.web;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.mypos.terminal.Terminal;
import com.mypos.terminal.service.HqlTerminalService;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/root")
public class TerminalController {
	
	@Resource(name = "terminalService")
	private HqlTerminalService hqlTerminalService;
	
	protected static Logger logger = Logger.getLogger("kontroler");
	
	//pregled svih pos terminala
	@RequestMapping(value = "/terminals", method = RequestMethod.GET)
	public String getTerminals(Model model)
	{
		logger.debug("Zahtjev za sve terminale");
		
		//svi terminali
		Collection<Terminal> terminals = hqlTerminalService.getAll();
		
		//dodjemo atribut na model
		model.addAttribute("terminals", terminals);
		
		//prikaz terminalsPage.jsp stranice na kraju
		return "terminalspage";
	}
	
	//prikaz stranice za dodavanje pos terminala i dodavanje novog terminala
	@RequestMapping(value = "/terminals/save", method = RequestMethod.GET)
	public String save(Model model)
	{
		logger.debug("Zahtjev za prikaz stranice za spremanje terminala");
		
		//stvaramo novi terminal i dodajemo ga na model
		model.addAttribute("terminalAtrribute", new Terminal());
		
		//prikaz savePage.jsp
		return "savepage";
	}
	
	//prikaz stranice nakon spremanja pos terminala, web view
	@RequestMapping(value = "/terminal/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("terminalAttribute") Terminal terminal)
	{
		logger.debug("Zahtjev za spremanje novog terminala");
		
		//stvarno dodavanje parametra iz metode na servis
		hqlTerminalService.save(terminal);
		
		//prikaz savedPage.jsp stanice
		return "savedpage";
	}
	
	//prikaz stranice za brisanje pos terminala, web request i brisanje postojeceg terminala
	@RequestMapping(value = "/terminals/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", required = true) Long posId, Model model)
	{
		logger.debug("Primljen zahtjev za brisanje pos terminala");
		
		//pozivanje servisa i brisanje terminala prema parametru
		hqlTerminalService.delete(posId);
		
		//dodavanje id reference na model
		model.addAttribute("id", posId);
		
		//prikaz deletedPage.jsp stranice
		return "deletedpage";
		
	}
	
	//prikazuje stranicu za editirnje postojecih pos terminala
	@RequestMapping(value = "/terminals/edit", method = RequestMethod.GET)
	public String edit(@RequestParam(value= "id", required = true) Long posId, Model model)
	{
		logger.debug("Primljen zahtjev za prikaz forme za editiranje pos terminala");
		
		//pozivamo formu za unos podataka za pos terminal
		//terminalAttribut jer naziv atributa iz .jsp forme
		model.addAttribute("terminalAttribute", hqlTerminalService.get(posId));
		
		//prikaz forme editPage.jsp
		return "updatepage";
	}
	
	//editira postojeci pos terminal pozivajuci HqlTerminalService
	//prikazuje stranicu nakon editiranja
	@RequestMapping(value = "/terminals/edit", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("terminalAttribute") Terminal terminal, 
			@RequestParam(value = "id", required = true) Long posId, Model model)
	{
		//postavljamo posId jer je iskljucen u .jsp stranici
		//mora biti aktivan jer nece biti dostupan u ModelAttribute
		terminal.setPosId(posId);
		
		//pozivanje HqlTerminaleService-a za editiranje 
		hqlTerminalService.edit(terminal);
		
		//dodavanje id reference na model
		model.addAttribute("id", posId);
		
		//prikaz editedPage.jsp
		return "updatedpage.jsp";
	}
}
