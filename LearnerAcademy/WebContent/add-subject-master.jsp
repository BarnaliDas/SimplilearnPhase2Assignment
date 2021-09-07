<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Subject</title>
</head>
<body>
<center>
  <h1>LEANER'S ACADEMY</h1>
        
 </center>
    <div align="center">
 
<form action="saveSubject" method="post">
<c:if test="${successMsg !=''}">
<p style="color: green"><c:out value="${successMsg}"/></p>
</c:if>
<c:if test="${failureMsg !=''}">
<p style="color: red"><c:out value="${failureMsg}"/></p>
</c:if>
Enter Subject Name:<input type="text" name="subName">
<input type="submit"  value="Add">

</form>
</div>
</body>
</html>