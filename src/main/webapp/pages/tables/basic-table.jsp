<%@ page import="com.app.service.UserService" %>
<%@ page import="jakarta.persistence.EntityManager" %>
<%@ page import="com.app.util.HibernateUtil" %>
<%@ page import="com.app.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="jakarta.persistence.EntityManagerFactory" %>
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
            <div class="d-flex justify-content-end align-items-center mb-2">
                <a class="nav-link btn btn-success create-new-button"  href="addUser.jsp">+ Create New User</a>
            </div>
            <% if(request.getParameter("success") !=null) { %>
	            <div id="successMessage" class="col-lg-12 grid-margin stretch-card">
		            <div style="width:100%" class="alert alert-success alert-dismissible fade show" role="alert">
					  <strong class="mr-2">Success!</strong><%=request.getParameter("success") %>
					</div>
	            </div>
           	<%} %>
           	<%                                            
            EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        UserService us = new UserService(entityManager);
           	List<User> users = us.getAllUsers();
           	%>
            <div class="row">
              <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <div class="table-responsive">
                      <table class="table table-striped">
                        <thead>
                          <tr>
                            <th> First name </th>
                            <th> Last name </th>
                            <th> User name </th>
                            <th> Email </th>
                            <th> position </th>
                            <th> department </th>
                            <th> role </th>
                            <th> action </th>
                          </tr>
                        </thead>
                        <tbody>
                         <% for(User u:users){ %>
                          <tr>
                            <td><%=u.getFirstName() %>  </td>
                            <td><%=u.getLastName() %>   </td>
                            <td><%=u.getUsername() %>   </td>
                            <td><%=u.getEmail() %>   </td>
                            <td><%=u.getPosition() %>   </td>
                            <td><%=u.getDepartment().getName() %>   </td>
                            <td><%=u.getRole().getName() %>   </td>
                            <td></td>
                          </tr>
                        <% } %> 
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
              
             
          <!-- content-wrapper ends -->
          <!-- partial:../../partials/_footer.html -->
          <footer class="footer">
            <div class="d-sm-flex justify-content-center justify-content-sm-between">
              <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © bootstrapdash.com 2020</span>
              <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"> Free <a href="https://www.bootstrapdash.com/bootstrap-admin-template/" target="_blank">Bootstrap admin templates</a> from Bootstrapdash.com</span>
            </div>
          </footer>
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
    <script src="../../assets/js/users.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <!-- End custom js for this page -->
  </body>
</html>