//Initial load of page
jQuery(document).ready(sizeContent);

//Every resize of window
jQuery(window).resize(sizeContent);

//Dynamically assign height
function sizeContent() {
    var newHeight = $("html").height() - jQuery("#header").height() - jQuery("#footer").height() + "px";
    jQuery("#content-wrapper").css("height", newHeight);
}