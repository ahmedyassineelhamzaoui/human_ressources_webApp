<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Equipment here</title>
</head>
<body>

   <form action="EquipmentServlet" method="post">
    <div>
      <label>Name </label>
      <input type="text" name="name" >
    </div>
   <div>
      <label>Mantenance Date </label>
      <input type="date" name="maintenaceDate" >
    </div>
    <div>
      <label>purchase Date </label>
      <input type="date" name="purchaseDate" >
    </div>
    <div>
      <label>Status </label>
      <input type="text" name="status" >
    </div>
    <div>
      <label>Type </label>
      <input type="text" name="type" >
    </div>
    <div>
      <label>User id </label>
      <input type="number" name="user_id" >
    </div>
          <input type="submit" value="submit" >
   </form>
</body>
</html>