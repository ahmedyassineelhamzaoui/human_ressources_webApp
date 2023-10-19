<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                 <h4 class="card-title">Add Department Form</h4>
                 <form class="forms-sample" action="DepartmentServlet" method="post">
                    <div class="form-group">
                      <label >Name</label>
                      <input type="text" class="form-control" name="name" placeholder="name">
                      <%if(request.getParameter("errorName") !=null){ %>
                      <p class="fs-3 text-danger"><%=request.getParameter("errorName") %> </p>
                      <%} %>
                    </div>
                    <div class="form-group">
                      <label >Head Of Department</label>
                      <input type="text" class="form-control" name="headOfDepartment" placeholder="Head Of Department">
                    </div>
                    <%if(request.getParameter("errorheadOfDepartment") !=null){ %>
                      <p class="fs-3 text-danger"><%=request.getParameter("errorheadOfDepartment") %> </p>
                    <%} %>
                   <div class="form-group">
                        <label >Description</label>
                        <textarea class="form-control" name="description"  rows="4"></textarea>
                   </div>
                   <%if(request.getParameter("errorDescription") !=null){ %>
                      <p class="fs-3 text-danger"><%=request.getParameter("errorDescription") %> </p>
                   <%} %>
                   <button type="submit" class="btn btn-primary mr-2">Submit</button>
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