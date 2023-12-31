<%@ page import="com.app.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.service.*" %>
<%@ page import="com.app.entity.*" %>
<% if (session.getAttribute("userLogin") ==null){
  response.sendRedirect("../../login.jsp");
}%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
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
                        <img class="w-100" id="image"  src="images/home.png">
                    </div>
                    <div class="d-flex flex-column text-black">
                        <span class="fw-bold text-white">test</span>
                        <span class="text-white" style="font-size: 12px">test</span>
                    </div>
                    <jsp:include page="../includes/asidebar.jsp"/>
                </div>
            </div>
        </div>

        <%--    -- -------------------------------content ----------------------------------------%>
        <div class="col py-3 overflow-x-hidden overflow-y-scroll" style="height: 100vh">
            <%--     -- Content Wrapper ----%>
            <div class="d-flex flex-column">
                <%--     -- Main Content ----%>
                <div>
                 <%  RoleService rs = new RoleService();
                     List<Role> roles = rs.getAllRoles();
                     DepartmentService ds = new DepartmentService();
                     List<Departement> departments = ds.getAllDepartment();
                 %>
                    <div class="container-fluid">
                        <%--             Page Heading --%>
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h3 class="mb-0 text-secondary">Add Users</h3>
                        </div>
                        <div class="row">
                            <div class=" d-flex justify-content-center ">
                                <div class="card shadow mb-4 col-8">
                                    <%--                  Card Header - Dropdown ----%>
                                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                        <h6 class="m-0 font-weight-bold text-primary">add User</h6>
                                    </div>
                                    <%--                  -- Card Body ----%>
                                    <div class="card-body">
                                        <form>
                                        <div class="row">
                                         <div class="col-6 mb-3">
										    <label  class="form-label">First name</label>
										    <input type="text" name="firstName" class="form-control"  >
										  </div>
										  <div class=" col-6 mb-3">
										    <label class="form-label">Last Name</label>
										    <input type="text" name="lastName" class="form-control" >
										  </div>
                                         </div>
                                         <div class="row">
                                         <div class="col-6 mb-3">
										    <label  class="form-label">Email address</label>
										    <input type="email" name="email" class="form-control"  >
										  </div>
										  <div class=" col-6 mb-3">
										    <label  class="form-label">Password</label>
										    <input type="password" name="password" class="form-control">
										  </div>
                                         </div>
                                         <div class="row">
                                         <div class="col-6 mb-3">
										    <label  class="form-label">Username</label>
										    <input type="text" name="userName" class="form-control" >
										  </div>
										  <div class=" col-6 mb-3">
										    <label  class="form-label">Position</label>
										    <input type="text" name="position" class="form-control" >
										  </div>
                                         </div> 
										 <div class="row">
                                         <div class="col-4 mb-3">
										    <label  class="form-label">Hire Date</label>
										    <input type="date" class="form-control" >
										  </div>
										  <div class=" col-4 mb-3">
										    <label  class="form-label">Department</label>
										    <select name="departement_id" class="form-select" >
											  <% for(Departement d:departments){ %>
											   <option value="<%=d.getId()%>"><%=d.getName() %></option>
											  <% } %>
											</select>
										  </div>
										  <div class=" col-4 mb-3">
										    <label  class="form-label">Role</label>
										    <select name="role_id" class="form-select" >
											 <% for(Role r:roles){ %>
											   <option value="<%=r.getId()%>"><%=r.getName() %></option>
											  <% } %>
											</select>
										  </div>
                                         </div> 
										  <button type="submit" class="btn btn-primary">Submit</button>
										</form>
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
<jsp:include page="../includes/script.jsp"/>