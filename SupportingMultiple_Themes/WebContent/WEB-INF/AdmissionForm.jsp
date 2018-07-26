<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>

<link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type ="text/css" />

<p><a href="/FirstSpringMVCProject/admissionForm.html?siteTheme=green">Green</a> |
<a href="/FirstSpringMVCProject/admissionForm.html?siteTheme=red">Red</a> </p>

<a href="/FirstSpringMVCProject/admissionForm.html?siteLanguage=en">English</a> |
 <a href="/FirstSpringMVCProject/admissionForm.html?siteLanguage=fr">French</a>
	<h1>${headerMessage}</h1>
	<h3> STUDENT ADMISSION FORM FOR ENGINEERING COURSES</h3>

	<form:errors path="student1.*"/>
	
	<form action="/FirstSpringMVCProject/submitAdmissionForm.html" method="post">
		<table>
		<tr><td><spring:message code="Label.studentName" /></td>  <td>       <input type="text" name="studentName" />   </td> </tr>
		<tr><td><spring:message code="Label.studentHobby" /></td>  <td>       <input type="text" name="studentHobby" />  </td> </tr>
		<tr><td><spring:message code="Label.studentMobile" /></td>  <td>       <input type="text" name="studentMobile" /> </td> </tr>
		<tr><td><spring:message code="Label.studentDOB" /></td>  <td>       <input type="text" name="studentDOB" />    </td> </tr>
		
		<tr><td><spring:message code="Label.studentSkills" /></td>  <td>    			<select name="studentSkills" multiple>
																<option value="Java Core">Java Core</option>
																<option value="Spring Core">Spring Core</option>
																<option value="Spring MVC">Spring MVC</option>
																</select><td></tr>
	</table>
	<table>
			<tr><td><spring:message code="Label.studentAddress" /></td></tr> 
		<tr>
			<td><spring:message code="Label.country" /><input type="text" name="studentAddress.country"/></td>
			<td><spring:message code="Label.city" /><input type="text" name="studentAddress.city" /></td>
			<td><spring:message code="Label.street" /><input type="text" name="studentAddress.street" /></td> 
			<td><spring:message code="Label.pincode" /><input type="text" name="studentAddress.pincode" /></td>
		</tr>
		
		<tr><td><input type="submit" value="Submit this form by clicking here" /></td></tr>
	</table>
	
	
		
	</form>
 
</body>
</html>

