<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<title>Spring AJAX and JQuery</title>
<script type="text/javascript">

function checkAjaxCall(){
	
	var name = $('#name').val(); 
	var location = $('#location').val(); 
	var json = {"name" : name,"location" : location};  
	$.ajax({
        url: "validateCaptchaThroughAJAX.web",
        type: 'POST',
        data: JSON.stringify(json),
        cache:false,
        beforeSend: function(xhr) {  
            xhr.setRequestHeader("Accept", "application/json");  
            xhr.setRequestHeader("Content-Type", "application/json");  
        },
        success:function(response){
        	alert("Validation: "+response.validation+"   Name: "+response.name+"  Location: "+response.location);
        },
        error:function(jqXhr, textStatus, errorThrown){
        	alert(textStatus);
        }
    });
	return true;
}

</script>
</head>
<body>
<form:form commandName="person" method="post" action="">
	<h1>Spring: ${message}</h1>
	<p>Name: <form:input path="name" id="name"/></p>
	<p>Location: <form:input path="location" id="location"/></p>
	<p><input type="button" name="Submit" value="Submit" onclick="checkAjaxCall();"></p>
	
</form:form>	
</body>
</html>