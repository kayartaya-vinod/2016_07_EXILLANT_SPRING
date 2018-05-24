package training.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import training.dao.ContactsDao;
import training.dao.DaoException;
import training.entity.Contact;

@Repository("dao")
@SuppressWarnings("unchecked")
public class ContactsDaoHibernateTemplateImpl implements ContactsDao {

	@Autowired
	private HibernateTemplate template;

	@PostConstruct
	public void init() {
		System.out.println("template is an instanceof " + template.getClass());
	}

	@Override
	public void createContact(Contact contact) throws DaoException {
		try {
			template.save(contact);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Contact getContact(Integer id) throws DaoException {
		try {
			return template.get(Contact.class, id);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		try {
			template.update(contact);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void deleteContact(Contact contact) throws DaoException {
		try {
			template.delete(contact);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Contact> getAllContacts() throws DaoException {
		try {
			return (List<Contact>) template.find("from Contact");
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Contact> search(String token) throws DaoException {
		try {
			String hql = "from Contact where firstname like ? " + "or lastname like ? " + "or email like ? "
					+ "or phone like ? " + "or address like ?";
			token = "%" + token + "%";

			return (List<Contact>) template.find(hql, token, token, token, token, token);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public int getContactsCount() throws DaoException {
		try {
			return ((Long) template.find("select count(c) from Contact c").get(0)).intValue();
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

}
