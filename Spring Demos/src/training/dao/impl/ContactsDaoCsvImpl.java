package training.dao.impl;

import java.util.List;

import training.dao.ContactsDao;
import training.dao.DaoException;
import training.entity.Contact;

public class ContactsDaoCsvImpl implements ContactsDao {

	public ContactsDaoCsvImpl() {
		System.out.println("ContactsDaoCsvImpl constructed!!");
	}
	
	@Override
	public int getContactsCount() throws DaoException {
		System.out.println("Getting the count from CSV file...");
		return 0;
	}

	@Override
	public void createContact(Contact contact) throws DaoException {
		throw new DaoException("Not implemented!");
	}

	@Override
	public Contact getContact(Integer id) throws DaoException {
		throw new DaoException("Not implemented!");
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		throw new DaoException("Not implemented!");
	}

	@Override
	public void deleteContact(Contact contact) throws DaoException {
		throw new DaoException("Not implemented!");
	}

	@Override
	public List<Contact> getAllContacts() throws DaoException {
		throw new DaoException("Not implemented!");
	}

	@Override
	public List<Contact> search(String token) throws DaoException {
		throw new DaoException("Not implemented!");
	}

}
