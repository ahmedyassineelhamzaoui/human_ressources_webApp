<%@ page import="com.app.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.service.EquipmentService" %>
<%@ page import="com.app.entity.User" %>
<%@ page import="com.app.entity.Equipement"%>
<%@ page import="com.app.service.UserService" %>
<%-- <% if (session.getAttribute("userLogin") ==null){
  response.sendRedirect("../../login.jsp");
}%> --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row flex-nowrap ">
        <div class="col-auto col-xl-2 px-sm-2 px-0 shadow bg-primary" style="height: 100vh;">
            <div class="d-flex flex-column mt-2 px-3 pt-2">
                <a href="#" class="pb-3 mb-md-0 text-decoration-none text-dark fs-5 d-none d-sm-inline">Resourcium<span class="text-white">Optima</span></a>
                <div class="d-flex flex-column mx-auto my-3 d-none d-sm-inline">
                    <div class="rounded-circle  overflow-hidden" style="width: 80px; height:80px;">
                        <img class="w-100" id="image"  src="../images/home.png">
                    </div>
                </div>
                <jsp:include page="../includes/asidebar.jsp"/>
            </div>
        </div>

        <%--    -- -------------------------------content ----------------------------------------%>
        <div class="col py-3 overflow-x-hidden overflow-y-scroll" style="height: 100vh">
            <%--     -- Content Wrapper ----%>
            <div class="d-flex flex-column">
                <%--     -- Main Content ----%>
                <div>
                    <%--         -- Topbar ----%>
                    <nav class="navbar navbar-expand  mb-4 shadow">
                        <div>
                            <p class="fs-5 ms-4">Welcome <span> ${ sessionScope.userName } !</span></p>
                        </div>
                    </nav>
                    <%--          End of Topbar ---%>
                    <%--          Begin Page Content ----%>
                    <div class="container-fluid">
                        <%--             Page Heading --%>
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h3 class="mb-0 text-secondary">Orders</h3>
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addOrder">
                             + Add Order
                            </button>
                        </div>
                        <div class="row">
                            <div class=" d-flex justify-content-center ">
                                <div style="width: 100%" class="card shadow mb-4 col-8">
                                    <%--                  Card Header - Dropdown ----%>
                                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                        <h6 class="m-0 font-weight-bold text-primary">Orders</h6>
                                    </div>
                                    <%--                  -- Card Body ----%>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped border">
                                                <thead class="bg-secondary bg-opacity-25">
                                                <tr>
                                                    <th scope="col">Id</th>
                                                    <th scope="col">reservation date</th>
                                                    <th scope="col">return date</th>
                                                    <th scope="col">User</th>
                                                    <th scope="col">Equipment</th>
                                                    <th scope="col">Action</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td><p></p></td>
                                                    <td><p></p></td>
                                                    <td><p></p></td>
                                                    <td><p></p></td>
                                                    <td><p></p></td>
                                                    <td>
                                                     
                                                    </td>
                                                </tr>
                                                
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Add modal for Order -->
<div class="modal fade" id="addOrder" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
    <form action="OrderServlet" method="post" class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalToggleLabel">Add Order</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
           <div>
              <label  class="form-label">reservation date</label>
		      <input type="date" name="reservationDate" placeholder="reservation date" class="form-control">
           </div>
           <div>
              <label  class="form-label">return Date</label>
		      <input type="date" name="returnDate" placeholder="return Date" class="form-control">
           </div>
           <div>
              <label  class="form-label">Equipment</label>
		      <select class="form-select" name="equipment">
                  <% EquipmentService equipmentService = new EquipmentService();
                    List<Equipement> equipments  = equipmentService.getAllEquipment();
                    for(Equipement e:equipments){
                  %>
                  <option value="<%= e.getId()%>"><%=e.getName() %></option>
                  <% } %>
              </select> 
           </div>
           <div>
              <label  class="form-label">User</label>
              <select class="form-select" name="user">
                  <% UserService userService = new UserService();
                    List<User> users  = userService.getAllUsers();
                    for(User u:users){
                  %>
                  <option value="<%= u.getId()%>"><%= u.getFirstName()+" "+u.getLastName() %></option>
                  <% } %>
              </select> 
           </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save </button>
      </div>
    </form>
  </div>
</div>
<jsp:include page="../includes/script.jsp"/>