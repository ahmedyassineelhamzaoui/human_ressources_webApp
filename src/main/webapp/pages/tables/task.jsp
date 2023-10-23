<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <form action="TaskServlet" method="post">
       <div>
         <label>deadline</label>
         <input name="deadline" type="date">
       </div>
       <div>
         <label>description</label>
         <input name="description" type="text">
       </div>
       <div>
         <label>priority</label>
         <input name="priority" type="text">
       </div>
       <div>
         <label>status</label>
         <input name="status" type="text">
       </div>
       <div>
         <label>user</label>
         <input name="user" type="number">
       </div>
       <input type="submit" value="submit">
    </form>
</body>
</html>