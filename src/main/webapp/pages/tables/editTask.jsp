<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.app.entity.Task" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Task task = (Task) request.getAttribute("task"); %>
 <form action="EditTaskServlet" method="post">
       <div>
         <label>deadline</label>
         <input name="deadline" type="date" value="<%= task.getDeadline()%>">
       </div>
       <div>
         <label>description</label>
         <input name="description" type="text" value="<%= task.getDescription()%>">
       </div>
       <div>
         <label>priority</label>
         <input name="priority" type="text" value="<%= task.getPriority()%>">
       </div>
       <div>
         <label>status</label>
         <input name="status" type="text" value="<%= task.getStatus()%>">
       </div>
       <div>
         <label>user</label>
         <input name="user" type="number" value="<%= task.getAssignedUser()%>">
       </div>
       <input type="submit" value="submit">
    </form>
</body>
</html>