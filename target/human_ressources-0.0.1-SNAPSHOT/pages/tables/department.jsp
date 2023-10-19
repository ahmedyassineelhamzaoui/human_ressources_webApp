<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.entity.Departement" %>
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
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.css" rel="stylesheet" />
    
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
                <a class="nav-link btn btn-success create-new-button"  href="addDepartment.jsp">+ Create New Department</a>
            </div>
            <div class="row">
            <% 
            String success = request.getParameter("success");
            if (success != null) {
                request.setAttribute("success", success);
            }
            if(request.getAttribute("success") !=null) { %>
            <div id="successMessage" class="col-lg-12 grid-margin stretch-card">
	            <div style="width:100%" class="alert alert-success alert-dismissible fade show" role="alert">
				  <strong class="mr-2">Success!  </strong><%=request.getAttribute("success") %>
				</div>
            </div>
           <%} %>

              <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <div class="table-responsive">
                      <table class="table table-striped">
                        <thead>
                          <tr>
                            <th> Id </th>
                            <th> Description </th>
                            <th> head of department </th>
                            <th> name of department </th>
                            <th> Action </th>
                          </tr>
                        </thead>
                        <tbody>
		                     <c:forEach items="${departements}" var="d">
			                        <tr>
			                        <td><c:out value="${d.id}" /></td>
			                        <td class="py-1"><c:out value="${d.description}" /></td>
			                        <td><c:out value="${d.headOfDepartment}" /></td>
			                        <td><c:out value="${d.name}" /></td>
			                        <td>
			                            <div class="d-flex align-items-center">
			                                <a href="<c:url value='DepartmentServlet'><c:param name='action' value='deleteDepartment' /><c:param name='id' value='${d.id}' /></c:url>"
			                                   type="button" class="btn btn-danger btn-rounded btn-icon d-flex justify-content-center align-items-center mr-1">
			                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
			                                         class="bi bi-trash3" viewBox="0 0 16 16">
			                                        <!-- Your SVG code here -->
			                                    </svg>
			                                </a>
			                                <a href="" class="btn btn-warning btn-rounded btn-icon d-flex justify-content-center align-items-center">
			                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
			                                         class="bi bi-pencil-square" viewBox="0 0 16 16">
			                                        <!-- Your SVG code here -->
			                                    </svg>
			                                </a>
			                            </div>
			                        </td>
			                    </tr>
			                </c:forEach>
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
              <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright Â© bootstrapdash.com 2020</span>
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
    <script src="../../assets/js/department.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <!-- End custom js for this page -->
  </body>
</html>