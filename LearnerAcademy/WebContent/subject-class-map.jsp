<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subject Mapping</title>
</head>
<body>
 <center>
  <h1>LEANER'S ACADEMY</h1>
        
 </center>
 <form action="addSubjectMapping" method="post">
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Map Subject for Class</h2></caption>
            <tr>
                <td>Select Subject</td>
                <td><select name="subject">
					  <c:forEach items="${subjectList}" var="sub" >
					    <option value="${sub.id}">
					        ${sub.subjectName}
					    </option>
					  </c:forEach>
					</select>
				</td>
          	
            </tr>

<tr>
                <td>Select Class :</td>
                <td><select name="classes">
					 <c:forEach items="${classesList}" var="cls">
					    <option value="${cls.id}">
					        ${cls.className}
					    </option>
					  </c:forEach>
					</select>
				</td></tr>
<!-- save combination mapping  -->
<tr><td colspan="2" align="center"><input type="submit" value="Save mapping" style="color: blue"></td></tr>
</table>
</form>
</body>
</html>