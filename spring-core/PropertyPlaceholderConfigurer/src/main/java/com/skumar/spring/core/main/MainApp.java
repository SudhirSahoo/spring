package com.skumar.spring.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.service.impl.SpringPropImpl;

/*
	public class PropertyPlaceholderConfigurer
	extends PlaceholderConfigurerSupport
	PlaceholderConfigurerSupport subclass that resolves ${...} placeholders against local properties and/or system properties and environment variables.
	
	As of Spring 3.1, PropertySourcesPlaceholderConfigurer should be used preferentially over this implementation; 
	it is more flexible through taking advantage of the Environment and PropertySource mechanisms also made available in Spring 3.1.
	
	PropertyPlaceholderConfigurer is still appropriate for use when:
	
	the spring-context module is not available (i.e., one is using Spring's BeanFactory API as opposed to ApplicationContext).
	existing configuration makes use of the "systemPropertiesMode" and/or "systemPropertiesModeName" properties. 
	Users are encouraged to move away from using these settings, and rather configure property source search order through the container's Environment; 
	however, exact preservation of functionality may be maintained by continuing to use PropertyPlaceholderConfigurer.
	Prior to Spring 3.1, the <context:property-placeholder/> namespace element registered an instance of PropertyPlaceholderConfigurer. 
	It will still do so if using the spring-context-3.0.xsd definition of the namespace. 
	That is, you can preserve registration of PropertyPlaceholderConfigurer through the namespace, even if using Spring 3.1; 
	simply do not update your xsi:schemaLocation and continue using the 3.0 XSD.

 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-property-placeholder.xml");
		
		SpringPropImpl springProp = (SpringPropImpl)context.getBean("springProp");
		System.err.println( "Configured Value: "+ springProp.getUserName());
		System.err.println( "Overrided  Value: " + springProp.getPassword());		
	}
}
