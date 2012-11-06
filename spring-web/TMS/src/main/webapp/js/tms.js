//Initial load of page
jQuery(document).ready(sizeContent);

//Every resize of window
jQuery(window).resize(sizeContent);

//Dynamically assign height
function sizeContent() {
    var newHeight = $("html").height() - jQuery("#header").height() - jQuery("#footer").height() + "px";
    jQuery("#content-wrapper").css("height", newHeight);
}

function doAjaxLogin() {  
	var userName = $('#userName').val();
	var userPassword = $('#userPassword').val();
	$.ajax({
	    type: "POST",
	    cache: false,
	    url: "/TMS/authenticate/performLogin",
	    dataType: "json",
	    data: {"userName": userName, "userPassword": userPassword},
	    success: function(response){ 
	    	if(response.status){
				window.location.href="/TMS/indexPage/landing";
	    	} else {
				errorInfo = response.error;
				$('#divSigninPanelError').html("Please correct following errors: <br> " + errorInfo + "<br>");
				$('#divSigninPanelError').show('');
	    	}
	    },  
	    error: function(e){
	    	alert('Error: ' + e);  
	    }  
	});  
}  

jQuery('#signInLink').live('click', function() {
	if(jQuery('#lisigninPanel').hasClass('active')) {
		$("#lisigninPanel").removeClass("active");
	} else{
		$("#lisigninPanel").addClass("active");
	}
});

/*
jQuery('#btnsigninPanelSubmit').live('click', function() {
	alert("clicked...");
    var userId = jQuery("#txtsigninPanelEmail").val();
	var password = jQuery("#txtsigninPanelPassword").val();
    alert(userId);
    alert(password);
    
});*/

