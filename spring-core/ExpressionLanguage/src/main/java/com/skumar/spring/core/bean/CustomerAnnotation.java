package com.skumar.spring.core.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("customerBean")
public class CustomerAnnotation {
	
	@Value("#{addressBean}")
	private AddressAnnotation addressAnnotation; // Example of Bean Reference
 
	@Value("#{addressBean.country}")
	private String country;
 
	@Value("#{addressBean.getFullAddress('GB Road')}")  // Example of Method Invocation
	private String fullAddress;
 
	
 
	public AddressAnnotation getAddressAnnotation() {
		return addressAnnotation;
	}



	public void setAddressAnnotation(AddressAnnotation address) {
		this.addressAnnotation = addressAnnotation;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getFullAddress() {
		return fullAddress;
	}



	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	@Override
	public String toString() {
		return "Customer [address=" + addressAnnotation + "\n, country=" + country
				+ "\n, fullAddress=" + fullAddress + "]";
	}

	
	//Relational operators
	 
		@Value("#{1 == 1}") //true
		private boolean testEqual;
	 
		@Value("#{1 != 1}") //false
		private boolean testNotEqual;
	 
		@Value("#{1 < 1}") //false
		private boolean testLessThan;
	 
		@Value("#{1 <= 1}") //true
		private boolean testLessThanOrEqual;
	 
		@Value("#{1 > 1}") //false
		private boolean testGreaterThan;
	 
		@Value("#{1 >= 1}") //true
		private boolean testGreaterThanOrEqual;
	 
		//Logical operators , numberBean.no == 999
	 
		@Value("#{addressBean.postcode == 400607 and addressBean.postcode < 99999}") //false
		private boolean testAnd;
	 
		@Value("#{addressBean.postcode == 400607 or addressBean.postcode < 900}") //true
		private boolean testOr;
	 
		@Value("#{!(addressBean.postcode == 400607)}") //false
		private boolean testNot;
	 
		//Mathematical operators
	 
		@Value("#{1 + 1}") //2.0
		private double testAdd;
	 
		@Value("#{'1' + '@' + '1'}") //1@1
		private String testAddString;
	 
		@Value("#{1 - 1}") //0.0
		private double testSubtraction;
	 
		@Value("#{1 * 1}") //1.0
		private double testMultiplication;
	 
		@Value("#{10 / 2}") //5.0
		private double testDivision;
	 
		@Value("#{10 % 10}") //0.0
		private double testModulus ;
	 
		@Value("#{2 ^ 2}") //4.0
		private double testExponentialPower;
		
		
		
		public boolean isTestEqual() {
			return testEqual;
		}



		public void setTestEqual(boolean testEqual) {
			this.testEqual = testEqual;
		}



		public boolean isTestNotEqual() {
			return testNotEqual;
		}



		public void setTestNotEqual(boolean testNotEqual) {
			this.testNotEqual = testNotEqual;
		}



		public boolean isTestLessThan() {
			return testLessThan;
		}



		public void setTestLessThan(boolean testLessThan) {
			this.testLessThan = testLessThan;
		}



		public boolean isTestLessThanOrEqual() {
			return testLessThanOrEqual;
		}



		public void setTestLessThanOrEqual(boolean testLessThanOrEqual) {
			this.testLessThanOrEqual = testLessThanOrEqual;
		}



		public boolean isTestGreaterThan() {
			return testGreaterThan;
		}



		public void setTestGreaterThan(boolean testGreaterThan) {
			this.testGreaterThan = testGreaterThan;
		}



		public boolean isTestGreaterThanOrEqual() {
			return testGreaterThanOrEqual;
		}



		public void setTestGreaterThanOrEqual(boolean testGreaterThanOrEqual) {
			this.testGreaterThanOrEqual = testGreaterThanOrEqual;
		}



		public boolean isTestAnd() {
			return testAnd;
		}



		public void setTestAnd(boolean testAnd) {
			this.testAnd = testAnd;
		}



		public boolean isTestOr() {
			return testOr;
		}



		public void setTestOr(boolean testOr) {
			this.testOr = testOr;
		}



		public boolean isTestNot() {
			return testNot;
		}



		public void setTestNot(boolean testNot) {
			this.testNot = testNot;
		}



		public double getTestAdd() {
			return testAdd;
		}



		public void setTestAdd(double testAdd) {
			this.testAdd = testAdd;
		}



		public String getTestAddString() {
			return testAddString;
		}



		public void setTestAddString(String testAddString) {
			this.testAddString = testAddString;
		}



		public double getTestSubtraction() {
			return testSubtraction;
		}



		public void setTestSubtraction(double testSubtraction) {
			this.testSubtraction = testSubtraction;
		}



		public double getTestMultiplication() {
			return testMultiplication;
		}



		public void setTestMultiplication(double testMultiplication) {
			this.testMultiplication = testMultiplication;
		}



		public double getTestDivision() {
			return testDivision;
		}



		public void setTestDivision(double testDivision) {
			this.testDivision = testDivision;
		}



		public double getTestModulus() {
			return testModulus;
		}



		public void setTestModulus(double testModulus) {
			this.testModulus = testModulus;
		}



		public double getTestExponentialPower() {
			return testExponentialPower;
		}



		public void setTestExponentialPower(double testExponentialPower) {
			this.testExponentialPower = testExponentialPower;
		}



		public String showLogicalOperators() {
			return "Customer [testEqual=" + testEqual + ", testNotEqual="
					+ testNotEqual + ", testLessThan=" + testLessThan
					+ ", testLessThanOrEqual=" + testLessThanOrEqual
					+ ", testGreaterThan=" + testGreaterThan
					+ ", testGreaterThanOrEqual=" + testGreaterThanOrEqual
					+ ", testAnd=" + testAnd + ", testOr=" + testOr + ", testNot="
					+ testNot + ", testAdd=" + testAdd + ", testAddString="
					+ testAddString + ", testSubtraction=" + testSubtraction
					+ ", testMultiplication=" + testMultiplication
					+ ", testDivision=" + testDivision + ", testModulus="
					+ testModulus + ", testExponentialPower="
					+ testExponentialPower + "]";
		}

		// Ternary Operator (If-Then-Else)
		@Value("#{addressBean.postcode < 999999 ? true : false}")
		private boolean warning;
	 
		public boolean isWarning() {
			return warning;
		}
	 
		public void setWarning(boolean warning) {
			this.warning = warning;
		}
		
		public boolean showTernaryOperators() {
			return this.warning;
		}
		
		
		// Lists, Maps Example
		@Value("#{addressBean.map['MapA']}")
		private String map;
	 
		@Value("#{addressBean.list[1]}")
		private String list;
	 
		public String getMap() {
			return map;
		}
	 
		public void setMap(String map) {
			this.map = map;
		}
	 
		public String getList() {
			return list;
		}
	 
		public void setList(String list) {
			this.list = list;
		}
		
		
		// Regular Expression Example
		
		// email regular expression
		String emailRegEx = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)" +
				"*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 
		// if this is a digit?
		@Value("#{'100' matches '\\d+' }")
		private boolean validDigit;
	 
		// if this is a digit + ternary operator
		@Value("#{ ('1a00' matches '\\d+') == true ? " +
				"'yes this is digit' : 'No this is not a digit'  }")
		private String msg;
	 
		// if this emailBean.emailAddress contains a valid email address?
		@Value("#{addressBean.emailAddress matches customerBean.emailRegEx}")
		private boolean validEmail;



		public String getEmailRegEx() {
			return emailRegEx;
		}



		public void setEmailRegEx(String emailRegEx) {
			this.emailRegEx = emailRegEx;
		}



		public boolean isValidDigit() {
			return validDigit;
		}



		public void setValidDigit(boolean validDigit) {
			this.validDigit = validDigit;
		}



		public String getMsg() {
			return msg;
		}



		public void setMsg(String msg) {
			this.msg = msg;
		}



		public boolean isValidEmail() {
			return validEmail;
		}



		public void setValidEmail(boolean validEmail) {
			this.validEmail = validEmail;
		}
		
		
}
