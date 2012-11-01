<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
		<div id="divSigninWrapper">
			<ul id="ulSignin"  class="ulSignin over">
				<li class="" id="lisigninPanel">
					<a  title="Sign In" href="#" class="block top" id="signInLink">Sign In<span>&nbsp;</span></a>
		            <div class="dropDownDIV signinPanel">
		                <span class="wrappertop">&nbsp;</span> <span id="divsigninPanelError"></span>
		                <label for="txtsigninPanelEmail">
		                    Username / E-Mail address</label>
		                <input class="active" id="txtsigninPanelEmail" type="text">
		                <label for="txtsigninPanelPasswordClear">
		                    Password</label>
		                <input id="txtsigninPanelPassword" type="password">
		                <a href="/forgotPassword" title="Forgot password?" style="padding: 0 0 8px 2px;
		                    display: block;">Did you forget your password?</a>
		                <div>
		                    <input id="chksinginPanelRemember" name="chksinginPanelRemember" type="checkbox"><label for="chksinginPanelRemember">Remember me</label>
		                    <div class="clear">
		                        <!--clear-->
		                    </div>
		                </div>
		                <button id="btnsigninPanelSubmit" class="button-blue">
		                    Sign In <span id="divsigninPanelSuccess">&nbsp;</span></button>
		                Don't have an account? <a href="/register" title="Sign up now">Sign up now!</a>
		                
		            </div>
				</li>
			</ul>
		</div>
	
</body>
</html>