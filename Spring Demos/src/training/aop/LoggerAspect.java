package training.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
	
	// pointcuts
	
	@Pointcut("execution(* training.dao.ContactsDao.get*(..))")
	public void pc1(){}
	
	@Pointcut("execution(* training.dao.ContactsDao.*(training.entity.Contact))")
	public void pc2(){}


	// advice
	@Before("pc1() || pc2()")
	public void log(JoinPoint jp){
		System.out.println("Inside the LoggerAspect.log() method...");
		System.out.println("Method called = " + jp.getSignature().getName());
	}
	
}



