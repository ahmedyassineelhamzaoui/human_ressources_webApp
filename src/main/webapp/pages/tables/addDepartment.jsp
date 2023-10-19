<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../includes/head.jsp" />
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
           
          <jsp:include page="../includes/footer.jsp" />
