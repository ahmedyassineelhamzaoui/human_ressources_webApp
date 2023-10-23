<%@ page import="com.app.entity.Role" %>
<%@ page import="java.util.List" %>

<%-- <% if (session.getAttribute("userLogin") ==null){
  response.sendRedirect("../../login.jsp");
}%> --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Roles</title>
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
                </div>
                <ul class="nav flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start">
                    <li class="nav-item">
                        <a href="dash.jsp" class="nav-link px-0 text-white">
                            <i class="bi bi-house"></i>
                            <span class="ms-1 d-none d-sm-inline">Dashboard</span>
                        </a>
                    </li>
                    <li>
                        <a href="EmployeesServlet" class="nav-link px-0 text-white">
                            <i class="bi bi-speedometer2"></i>
                            <span class="ms-1 d-none d-sm-inline">Users</span>
                        </a>
                    </li>
                    <li>
                        <a href="DepartmentServlet" class="nav-link px-0 text-white">
                            <i class="bi bi-speedometer2"></i>
                            <span class="ms-1 d-none d-sm-inline">Department</span>
                        </a>
                    </li>
                    <li>
                        <a href="TasksServlet" class="nav-link px-0 text-white">
                            <i class="bi bi-plus-circle"></i>
                            <span class="ms-1 d-none d-sm-inline">Tasks</span>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="nav-link px-0 text-white">
                            <i class="bi bi-person-circle"></i>
                            <span class="ms-1 d-none d-sm-inline">Equipment</span></a>
                    </li>
                    <li>
                        <a href="profile.jsp" class="nav-link px-0 text-white">
                            <i class="bi bi-person-circle"></i>
                            <span class="ms-1 d-none d-sm-inline">Profile</span></a>
                    </li>
                    <li>
                        <a href="#" class="nav-link px-0 text-white">
                            <i class="bi bi-box-arrow-left"></i>
                            <span class="ms-1 d-none d-sm-inline">Logout</span> </a>
                    </li>
                </ul>
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
                            <h3 class="mb-0 text-secondary">Roles</h3>
                        </div>
                        <div class="row">
                            <div class=" d-flex justify-content-center ">
                                <div class="card shadow mb-4 col-8">
                                    <%--                  Card Header - Dropdown ----%>
                                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                        <h6 class="m-0 font-weight-bold text-primary">roles</h6>
                                    </div>
                                    <%--                  -- Card Body ----%>
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped border">
                                                <thead class="bg-secondary bg-opacity-25">
                                                <tr>
                                                    <th scope="col">Id</th>
                                                    <th scope="col">Name</th>
                                                    <th scope="col">Action</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <% if (request.getAttribute("roles") != null) {
                                                    List<Role> roles = (List<Role>) request.getAttribute("roles");
                                                    for (Role r:roles) {%>
                                                <tr>
                                                    <td><p><%= r.getId() %></p></td>
                                                    <td><p><%= r.getName() %></p></td>
                                                    <td>
                                                        <form action="EmployeesServlet" method="post">
                                                            <input type="text" value="<%=r.getId()%>" name="userId" hidden>
                                                            <button type="submit" class="btn btn-danger">Delete</button>
                                                        </form>
                                                    </td>
                                                </tr>
                                                <%} } %>
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
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>