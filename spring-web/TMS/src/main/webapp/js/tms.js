//Initial load of page
jQuery(document).ready(sizeContent);

//Every resize of window
jQuery(window).resize(sizeContent);

//Dynamically assign height
function sizeContent() {
    var newHeight = $("html").height() - jQuery("#header").height() - jQuery("#footer").height() + "px";
    jQuery("#content-wrapper").css("height", newHeight);
}



jQuery('#signInLink').live('click', function() {
	if(jQuery('#lisigninPanel').hasClass('active')) {
		$("#lisigninPanel").removeClass("active");
	} else{
		$("#lisigninPanel").addClass("active");
	}
});


jQuery('#btnsigninPanelSubmit').live('click', function() {
	alert("clicked...");
    var userId = jQuery("#txtsigninPanelEmail").val();
	var password = jQuery("#txtsigninPanelPassword").val();
    alert(userId);
    alert(password);
    
});
