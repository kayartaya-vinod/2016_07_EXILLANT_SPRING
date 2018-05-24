package training.programs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.dao.ContactsDao;
import training.dao.DaoException;

public class P01_SprigAsFactory {

	public static void main(String[] args) throws DaoException {
		// a variable to represent spring container
		ApplicationContext ctx;
		
		// an object representing the spring container
		ctx = new ClassPathXmlApplicationContext("context.xml");
		
		ContactsDao dao = ctx.getBean("dao1", ContactsDao.class);
		
		int cc = dao.getContactsCount();
		System.out.println("There are " + cc + " contacts!");
		
		((AbstractApplicationContext) ctx).close();
	}
}









