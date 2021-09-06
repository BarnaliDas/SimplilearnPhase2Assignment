<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Report</title>
</head>
<body>
<!-- show list of sutdent with class mapping -->
 <center>
  <h1>LEANER'S ACADEMY</h1>
        
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Students</h2></caption>
            <tr>
                <th>Student ID</th>
                <th>Student Name</th>
          	  <th>Class Enrolled</th>
                
            </tr>
            <c:forEach var="stu" items="${listStudent}">
                <tr>
                    <td><c:out value="${stu.id}" /></td>
                    <td><c:out value="${stu.studentName}" /></td>
                 	<td><c:out value="${stu.studentClasses.className}" /></td> 
                   
                </tr>
            </c:forEach>
        </table>
    </div> 

</body>
</html>