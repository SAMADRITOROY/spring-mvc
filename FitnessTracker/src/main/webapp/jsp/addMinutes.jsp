<%@ page 
    language="java" 
    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib 
    prefix="spring"
    uri="http://www.springframework.org/tags"%>
    
<%@ taglib 
    prefix="form"
    uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Add Minutes</title>
        <script type="text/javascript" src="jquery-3.4.1.js"></script>
        <script type="text/javascript">
        	$(document).ready(
               	function() {
                   	$.getJSON('http://localhost:8006/FitnessTracker/activities.json', 
                   	{ajax: 'true'},
                   	function(data) {
                       	var htmlStr = '<option value="">--Please select one--</option>';
                       	var len = data.length;
                       	for(var i=0; i<len; i++) {
                           	htmlStr+= '<option value="'+ data[i].desc +'">' + data[i].desc + '</option>';
                       	}
                       	$('#activities').html(htmlStr);
                   	})
               	}
           	);
        </script>
    </head>
    <body>
         <a href="?language=en">English</a>|
         <a href="?language=es">Spanish</a>
         <form:form modelAttribute="exercise">
             <table>
                 <tr>
                     <td><spring:message code="goal.text"/></td>
                     <td><form:input path="minutes"/></td>
                     <td><form:select id="activities" path="activity"/></td>
                 </tr>
                 <tr>
                     <td colspan="3"><input type="submit" value="Submit"></td>
                 </tr>
             </table>
         </form:form>
         <p>Goal set to: ${goal.minutes}</p> 
    </body>
</html>