The Spring container can autowire relationships between collaborating beans. 
You can allow Spring to resolve collaborators (other beans) automatically for your bean by inspecting the contents of the ApplicationContext.

To enable it, just define the “autowire” attribute in <bean>.

	<bean id="customer" class="com.mkyong.common.Customer" autowire="byName" />
	
	
In Spring, 5 Auto-wiring modes are supported:
---------------------------------------------

no – (Default) No autowiring. Bean references must be defined via a ref element. 
	Changing the default setting is not recommended for larger deployments, because specifying collaborators explicitly gives greater control and clarity. 
	To some extent, it documents the structure of a system.
	
	
byName – Autowiring by property name. Spring looks for a bean with the same name as the property that needs to be autowired. 
		For example, if a bean definition is set to autowire by name, and it contains a address property (that is, it has a setAddress(..) method), 
		Spring looks for a bean definition named master, and uses it to set the property. 
		
		
byType – Auto wiring by property data type. If data type of a bean is compatible with the data type of other bean property, auto wire it.
		Allows a property to be autowired if exactly one bean of the property type exists in the container. 
		If more than one exists, a fatal exception is thrown, which indicates that you may not use byType autowiring for that bean. 
		If there are no matching beans, nothing happens; the property is not set.
		
		
constructor – Analogous to byType, but applies to constructor arguments. If there is not exactly one bean of the constructor argument type in the container, a fatal error is raised.


autodetect – If a default constructor is found, use “autowired by constructor”; Otherwise, use “autowire by type”.


Advantages:
-----------
> Autowiring can significantly reduce the need to specify properties or constructor arguments. 
	(Other mechanisms such as a bean template discussed elsewhere in this chapter are also valuable in this regard.)

> Autowiring can update a configuration as your objects evolve. For example, if you need to add a dependency to a class, 
	that dependency can be satisfied automatically without you needing to modify the configuration. 
	Thus autowiring can be especially useful during development, without negating the option of switching to explicit wiring when the code base becomes more stable.
	
Limitations and disadvantages:
------------------------------
> 	Autowiring works best when it is used consistently across a project. 
	If autowiring is not used in general, it might be confusing to developers to use it to wire only one or two bean definitions.

Consider the limitations and disadvantages of autowiring:

> 	Explicit dependencies in property and constructor-arg settings always override autowiring. 
	You cannot autowire so-called simple properties such as primitives, Strings, and Classes (and arrays of such simple properties). 
	This limitation is by-design.

> 	Autowiring is less exact than explicit wiring. Although, as noted in the above table, 
	Spring is careful to avoid guessing in case of ambiguity that might have unexpected results, 
	the relationships between your Spring-managed objects are no longer documented explicitly.

> 	Wiring information may not be available to tools that may generate documentation from a Spring container.

> 	Multiple bean definitions within the container may match the type specified by the setter method or constructor argument to be autowired. 
	For arrays, collections, or Maps, this is not necessarily a problem. 
	However for dependencies that expect a single value, this ambiguity is not arbitrarily resolved. 
	If no unique bean definition is available, an exception is thrown.

In the latter scenario, you have several options:

> 	Abandon autowiring in favor of explicit wiring.

> 	Avoid autowiring for a bean definition by setting its autowire-candidate attributes to false as described in the next section.

> 	Designate a single bean definition as the primary candidate by setting the primary attribute of its <bean/> element to true.

> 	If you are using Java 5 or later, implement the more fine-grained control available with annotation-based configuration


Excluding a bean from autowiring:
---------------------------------

You can exclude a bean from autowiring. 
In Spring's XML format, set the autowire-candidate attribute of the <bean/> element to false; 
the container makes that specific bean definition unavailable to the autowiring infrastructure (including annotation style configurations such as @Autowired).

You can also limit autowire candidates based on pattern-matching against bean names. 
The top-level <beans/> element accepts one or more patterns within its default-autowire-candidates attribute. 
For example, to limit autowire candidate status to any bean whose name ends with Repository, provide a value of *Repository. 
To provide multiple patterns, define them in a comma-separated list. 
An explicit value of true or false for a bean definitions autowire-candidate attribute always takes precedence, and for such beans, the pattern matching rules do not apply.

These techniques are useful for beans that you never want to be injected into other beans by autowiring. 
It does not mean that an excluded bean cannot itself be configured using autowiring. 
Rather, the bean itself is not a candidate for autowiring other beans.