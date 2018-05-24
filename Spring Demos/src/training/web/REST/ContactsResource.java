package training.web.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import training.dao.ContactsDao;
import training.dao.DaoException;
import training.entity.Contact;

@RestController
@RequestMapping("/rest")
public class ContactsResource {

	@Autowired
	ContactsDao dao;
	
	@RequestMapping(value="/contacts", 
			produces="application/json",
			method=RequestMethod.GET)
	public List<Contact> getAllContacts() throws DaoException{
		return dao.getAllContacts();
	}
	
	@RequestMapping(value="/contacts/{id}",
			produces={"application/json", "application/xml"},
			method=RequestMethod.GET)
	public Contact getOneContact(@PathVariable Integer id) throws DaoException{
		return dao.getContact(id);
	}
	
	@RequestMapping(value="/contacts",
			consumes={"application/json", "application/xml"},
			produces={"application/json", "application/xml"},
			method=RequestMethod.POST)
	public Contact createContact(@RequestBody Contact contact) throws DaoException{
		dao.createContact(contact);
		return contact;
	}
}














