package training.cfg;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableTransactionManagement
@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = { "training.web", "training.aop", "training.dao.impl" })
public class AppConfig2 {

	@Bean(name = "viewResolver")
	public ViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/pages/");
		vr.setSuffix(".jsp");
		return vr;
	}

	@Bean(autowire = Autowire.BY_NAME)
	public PlatformTransactionManager txMgr() {
		System.out.println("HibernateTransactionManager instance created!");
		return new HibernateTransactionManager();
	}

	// session-factory
	@Bean(name = "sessionFactory")
	@Scope("singleton")
	public LocalSessionFactoryBean lsfb() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
		return lsfb;
	}

	@Bean(autowire = Autowire.BY_NAME)
	public HibernateTemplate template() {
		return new HibernateTemplate();
	}
}
