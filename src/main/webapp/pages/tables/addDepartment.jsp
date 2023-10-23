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
                            <h3 class="mb-0 text-secondary">Add Department</h3>
                        </div>
                        <div class="row">
                            <div class=" d-flex justify-content-center ">
                                <div class="card shadow mb-4 col-8">
                                    <%--                  Card Header - Dropdown ----%>
                                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                        <h6 class="m-0 font-weight-bold text-primary">add Department</h6>
                                    </div>
                                    <%--                  -- Card Body ----%>
                                    <div class="card-body">
                                        <form action="DepartmentServlet" method="post">
                                         <div class="mb-3">
										    <label  class="form-label">Name</label>
										    <input type="text" name="name" class="form-control"  >
										  </div>
										  <div class=" mb-3">
										    <label class="form-label">head Of Department</label>
										    <input type="text" name="headOfDepartment" class="form-control" >
										  </div>
                                         <div class=" mb-3">
									    	<div class="form-floating">
											  <textarea name="description" class="form-control" style="height: 100px"></textarea>
											  <label for="floatingTextarea2">Description</label>
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