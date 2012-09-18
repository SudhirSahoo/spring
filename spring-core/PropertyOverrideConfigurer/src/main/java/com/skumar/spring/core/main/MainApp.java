package com.skumar.spring.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skumar.spring.core.service.SpringProp;
import com.skumar.spring.core.service.impl.SpringPropImpl;

/*
	public class PropertyOverrideConfigurer
	extends PropertyResourceConfigurer
	Property resource configurer that overrides bean property values in an application context definition. It pushes values from a properties file into bean definitions.
	
	Configuration lines are expected to be of the following form:
	
	beanName.property=value
	Example properties file:
	dataSource.driverClassName=com.mysql.jdbc.Driver
	 dataSource.url=jdbc:mysql:mydb
	In contrast to PropertyPlaceholderConfigurer, the original definition can have default values or no values at all for such bean properties. If an overriding properties file does not have an entry for a certain bean property, the default context definition is used.
	Note that the context definition is not aware of being overridden; so this is not immediately obvious when looking at the XML definition file. Furthermore, note that specified override values are always literal values; they are not translated into bean references. This also applies when the original value in the XML bean definition specifies a bean reference.
	
	In case of multiple PropertyOverrideConfigurers that define different values for the same bean property, the last one will win (due to the overriding mechanism).
	
	Property values can be converted after reading them in, through overriding the convertPropertyValue method. For example, encrypted values can be detected and decrypted accordingly before processing them.
 
 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-property-override-configurer.xml");
		
		SpringPropImpl springProp = (SpringPropImpl)context.getBean("springProp");
		System.err.println( "Configured Value: "+ springProp.getUserName());
		System.err.println( "Overrided  Value: " + springProp.getPassword());		
	}
}
