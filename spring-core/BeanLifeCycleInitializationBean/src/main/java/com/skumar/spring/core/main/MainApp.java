package com.skumar.spring.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.service.impl.CustomerServiceImpl;

/*
	public interface InitializingBean
	
	Interface to be implemented by beans that need to react once all their properties have been set by a BeanFactory: 
	for example, to perform custom initialization, or merely to check that all mandatory properties have been set.
	
	An alternative to implementing InitializingBean is specifying a custom init-method, 
	for example in an XML bean definition. For a list of all bean lifecycle methods, see the BeanFactory javadocs. 
	Methods:
	void 	afterPropertiesSet()
          Invoked by a BeanFactory after it has set all bean properties supplied (and satisfied BeanFactoryAware and ApplicationContextAware).
          
          
	In Spring, InitializingBean and DisposableBean are two marker interfaces, a useful way for Spring to perform certain actions upon bean initialization and destruction.

    For bean implemented InitializingBean, it will run afterPropertiesSet() after all bean properties have been set.
    For bean implemented DisposableBean, it will run destroy() after Spring container is released the bean.
    
    I would not recommend to use InitializingBean and DisposableBean interface, 
    because it will tight coupled your code to Spring. 
    A better approach should be specifying the init-method and destroy-method attributes in your bean configuration file.
 */

public class MainApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-beanLifeCycle-InitializationBean.xml");
		CustomerServiceImpl output = (CustomerServiceImpl)context.getBean("customer");
        System.out.println(output);
        //ConfigurableApplicationContext context1 = null;
        
        context.close();
	}
}
