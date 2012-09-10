If you simpley write
<property name="date" value="2012-11-09" />
and write the below code in you bean, then you get EXCEPTION: Failed to convert property value of type 'java.lang.String' to required type 'java.util.Date'
	Date date;
 
	public void setDate(Date date) {
		this.date = date;
	}

	


In Spring, you can inject a Date via two methods :
1. Factory bean
Declare a dateFormat bean, in “customer” bean, reference “dateFormat” bean as a factory bean. 
The factory method will call SimpleDateFormat.parse() to convert String into Date object automatically.

<bean id="dateFormat" class="java.text.SimpleDateFormat">
		<constructor-arg value="yyyy-MM-dd" />
	</bean>
 
	<bean id="customer" class="com.mkyong.common.Customer">
		<property name="date">
			<bean factory-bean="dateFormat" factory-method="parse">
				<constructor-arg value="2010-01-31" />
			</bean>
		</property>
	</bean>

NOTE: Applicable only for one property.


	
2. CustomDateEditor
Declares a CustomDateEditor class to convert String into java.util.Date.

	<bean id="dateEditor"
	   class="org.springframework.beans.propertyeditors.CustomDateEditor">
 
		<constructor-arg>
			<bean class="java.text.SimpleDateFormat">
				<constructor-arg value="yyyy-MM-dd" />
			</bean>
		</constructor-arg>
		<constructor-arg value="true" />
	</bean>
And declares another “CustomEditorConfigurer”, to make Spring convert bean properties whose type is java.util.Date.

NOTE: Applicable for all properties in xml ???