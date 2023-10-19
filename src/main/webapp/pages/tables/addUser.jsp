<%@ page import="com.app.entity.Role" %>
<%@ page import="com.app.service.RoleService" %>
<%@ page import="com.app.util.HibernateUtil" %>
<%@ page import="jakarta.persistence.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.entity.Departement" %>
<%@ page import="com.app.service.DepartmentService" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Corona Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="../../assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="../../assets/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="../../assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="../../assets/images/favicon.png" />
  </head>
  <body>
    <div class="container-scroller">
      <!-- partial:../../partials/_sidebar.html -->
      
      <!-- NAV BAR -->
      <jsp:include page="../includes/header.jsp" />
      <!-- END NAV BAR  -->
        <!-- partial -->
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="row">
            <div class="col-12 grid-margin stretch-card">
             <div class="card">
               <div class="card-body">
                 <h4 class="card-title">Add User Form</h4>
                 <form class="forms-sample" action="../../UserServlet" method="post">
                 <div class="row">
                    <div class="col-6 form-group">
                      <label >FirstName</label>
                      <input type="text" class="form-control" name="firstName" placeholder="FirstName">
                    </div>
                    <div class="col-6 form-group">
                      <label >LastName</label>
                      <input type="text" class="form-control"name="lastName" placeholder="LastName">
                    </div>
                 </div>
                   <div class="form-group">
                     <label >Email address</label>
                     <input type="email" class="form-control" name="email"  placeholder="Email">
                   </div>
                   <div class="row">
                    <div class="col-6 form-group">
                      <label >UserName</label>
                      <input type="text" class="form-control"  name="userName" placeholder="UserName">
                    </div>
                    <div class="col-6 form-group">
                      <label >Password</label>
                      <input type="password" class="form-control"  name="password" placeholder="Password">
                    </div>
                   </div>
                   <div class="row">
                   <div class="col-6 form-group">
                     <label >Role</label>
                     <select class="form-control" name="role">
                       <%
	                      EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
	                      EntityManager entityManager = entityManagerFactory.createEntityManager();
	                      RoleService rs = new RoleService(entityManager);
	                      List<Role> roles = rs.getAllRoles();
	                      for(Role r:roles){ %>
	                       <option value="<%=r.getId() %>"><%=r.getName() %></option>
	                    <% } %>
                     </select>
                   </div>
                   <div class="col-6 form-group">
                     <label for="exampleSelectGender">Department</label>
                     <select class="form-control" name="departement" >
                     <% 
                      DepartmentService ds = new DepartmentService(entityManager);
                      List<Departement> departments = ds.getAllDepartment();
                      for(Departement d:departments){
	                  %>
	                      <option value="<%=r.getId() %>"><%=d.getName() %></option>
	                  <%} %>
                     </select>
                   </div>
                   </div>
                   <div class="form-group">
                     <label for="exampleInputCity1">Position</label>
                     <input type="text" class="form-control" name="position" id="exampleInputCity1" placeholder="position">
                   </div>
                   <button type="submit" class="btn btn-primary mr-2">Submit</button>
                   <button class="btn btn-dark" data-bs-dismiss="modal">Cancel</button>
                 </form>
               </div>
             </div>
            </div>
            
             
          <!-- content-wrapper ends -->
          <!-- partial:../../partials/_footer.html -->
          <jsp:include page="../includes/footer.jsp" />

          <!-- partial -->
        </div>
        <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="../../assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="../../assets/js/off-canvas.js"></script>
    <script src="../../assets/js/hoverable-collapse.js"></script>
    <script src="../../assets/js/misc.js"></script>
    <script src="../../assets/js/settings.js"></script>
    <script src="../../assets/js/todolist.js"></script>    
   
  </body>
</html>