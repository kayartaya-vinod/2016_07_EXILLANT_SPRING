package training.programs;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import training.entity.Contact;

public class P03_TestingHibernate {

	// utitlity function for obtaining a Session object
	static Session getSession() {
		// Empty configuration
		Configuration cfg = new Configuration();

		// load the information from hibernate.cfg.xml
		cfg.configure();

		// build the session factory
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		// create a new session
		Session session = sessionFactory.openSession();

		return session;
	}

	public static void main(String[] args) {

		// addNewContact();
		// getOneContact();
		// updateContact();
		printAllContacts();
	}

	@SuppressWarnings("unchecked")
	static void printAllContacts() {
		// "SELECT * FROM CONTACTS"
		// String hql = "select c1 from Contact c1";
		String hql = "from Contact";
		Session session = getSession();
		Query qry = session.createQuery(hql);
		List<Contact> list = qry.list();
		session.close();

		for (Contact c : list) {
			System.out.println(c.getFirstname() + " " + c.getLastname());
		}
	}

	static void updateContact() {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Contact c1 = (Contact) session.get(Contact.class, 1);
		c1.setEmail("vinod@knowledgeworksindia.com");
		tx.commit();
		System.out.println("Data saved to db!");
	}

	static void getOneContact() {
		Integer id = 1;
		Session session = getSession();
		Contact c1 = (Contact) session.get(Contact.class, id);
		System.out.println("Contact with id " + id);
		System.out.println(c1);
		id = 2;
		c1 = (Contact) session.get(Contact.class, id);
		System.out.println("Contact with id " + id);
		System.out.println(c1);
		session.close();

	}

	static void addNewContact() {
		Contact c1 = new Contact();
		c1.setFirstname("Vinod");
		c1.setLastname("Kumar");
		c1.setEmail("vinod@vinod.co");
		c1.setPhone("9731424784");
		c1.setAddress("1st cross, 1st main, ISRO layout, Bangalore");

		Session session = getSession();
		Transaction tx = session.beginTransaction();

		try {
			session.save(c1);
			tx.commit();
			System.out.println("Data added to db!");
		} catch (HibernateException e) {
			System.err.println("There was a problem while adding new contact!");
			tx.rollback();
		}

		session.close();

	}

}
