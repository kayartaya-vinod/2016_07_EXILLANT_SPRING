package training.programs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import training.cfg.AppConfig1;
import training.dao.ContactsDao;
import training.dao.DaoException;

public class P02_AnnotationConfigClient {

	public static void main(String[] args) throws DaoException {
		ApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig1.class);

		ContactsDao dao = ctx.getBean(ContactsDao.class);
		int cc = dao.getContactsCount();
		
		System.out.printf("There are %d contacts\n", cc);
		
		((AbstractApplicationContext) ctx).close();
	}
}







