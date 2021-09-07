<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Admin</title>
</head>
<body>
 <center>
  <h1>LEANER'S ACADEMY</h1>
        
 </center>
    <div align="center">
    
<!-- This page should have links to add masters and view students and class report -->
Welcome <c:out value="${userid}" />
<ul>
<li><a href="add-class-master.jsp">Add New Class Details</a></li>
<li><a href="add-subject-master.jsp">Add New Subject Details</a></li>
<li><a href="add-teacher-master.jsp">Add New Teacher Details</a></li>
<li><a href="subjectMapList">Add Subject to Class </a></li>
<li><a href="mapTeacher">Add Teacher to Sujects of Class</a></li>
<li><a href="student">View Student Detail</a></li>
<li><a href="classReport">View Class Report</a></li>
</ul>
</div>
</body>
</html>