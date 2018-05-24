package training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import training.cfg.AppConfig2;
import training.dao.ContactsDao;
import training.dao.DaoException;
import training.entity.Contact;

public class P04_TestingHibernateTemplate {

	public static void main(String[] args) throws DaoException {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig2.class);
		
		ContactsDao dao = ctx.getBean(ContactsDao.class);
		
		System.out.println("dao is an instanceof " + dao.getClass());
		
		Contact c1 = dao.getContact(1);
		System.out.println(c1);
		c1.setEmail("vinod@knowledgeworksindia.com");
		dao.updateContact(c1);
		
		int cc = dao.getContactsCount();
		System.out.println("cc = " + cc);
		
		
		ctx.close();
	}
}
