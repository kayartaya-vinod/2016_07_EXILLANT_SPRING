package training.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import training.dao.ContactsDao;
import training.dao.DaoException;

@Controller
public class ContactsController {

	// typically, DAO is not injected into WEB, but Service is.
	
	@Autowired
	private ContactsDao dao;
	
	@RequestMapping("/contact-list")
	public String getAllContacts(Model model) throws DaoException{
		model.addAttribute("contacts", dao.getAllContacts());
		return "display-contacts"; // view-name
	}
}












