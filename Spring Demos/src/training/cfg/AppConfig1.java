package training.cfg;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;

import training.dao.ContactsDao;
import training.dao.impl.ContactsDaoJdbcImpl;

// this is an alternative for the XML configuration
// @Configuration
public class AppConfig1 { // equivalent of <beans> root element

	// Spring invokes each of the method defined in this class
	// and annotated with @Bean, gets the return value and keeps the same
	// with an id. By default, the name of the function "dao" is used
	// as the id. We can override it by specifying a name - @Bean(name="xyz")

	@Bean(autowire = Autowire.BY_TYPE, initMethod="doSomethingInTheStart")
	public ContactsDao dao() {

		return new ContactsDaoJdbcImpl();
	}

	@Bean
	public BasicDataSource dbcp() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("org.hsqldb.jdbcDriver");
		bds.setUrl("jdbc:hsqldb:hsql://localhost/training");
		bds.setUsername("sa");
		bds.setPassword("");

		bds.setInitialSize(5);
		bds.setMinIdle(5);
		bds.setMaxIdle(10);
		bds.setMaxActive(15);
		bds.setMaxWait(15);

		return bds;
	}
}
