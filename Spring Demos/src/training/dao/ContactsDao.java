package training.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import training.entity.Contact;

public interface ContactsDao {

	// CRUD OPERATIONS
	@Transactional
	public void createContact(Contact contact) throws DaoException;

	public Contact getContact(Integer id) throws DaoException;

	@Transactional
	public void updateContact(Contact contact) throws DaoException;

	@Transactional
	public void deleteContact(Contact contact) throws DaoException;

	// QUERIES

	public List<Contact> getAllContacts() throws DaoException;

	public List<Contact> search(String token) throws DaoException;

	public int getContactsCount() throws DaoException;
}
