<%@ page import="com.app.entity.Role" %>
<%@ page import="com.app.service.RoleService" %>
<%@ page import="com.app.util.HibernateUtil" %>
<%@ page import="jakarta.persistence.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.entity.Departement" %>
<%@ page import="com.app.service.DepartmentService" %>
<%@ page import="com.app.entity.User" %>
<jsp:include page="../includes/head.jsp" />
    <div class="container-scroller">
      <!-- partial:../../partials/_sidebar.html -->
      
      <!-- NAV BAR -->
      <jsp:include page="../includes/header.jsp" />
      <!-- END NAV BAR  -->
        <!-- partial -->
        <% User user = (User) request.getAttribute("user"); %>
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="row">
            <div class="col-12 grid-margin stretch-card">
             <div class="card">
               <div class="card-body">
                 <h4 class="card-title">Edit User Form</h4>
                 <form class="forms-sample" action="../../UserServlet" method="post">
                 <div class="row">
                    <div class="col-6 form-group">
                      <label >FirstName</label>
                      <input type="text" class="form-control" name="firstName" value="<%=user.getFirstName() %>" placeholder="FirstName">
                      <% if(request.getParameter("firstNameError")  != null){ %> 
	                       <p class="text-danger fs-3">
	                          <%=request.getParameter("firstNameError") %>
	                       </p>
	                  <% } %>
                    </div>
                    <div class="col-6 form-group">
                      <label >LastName</label>
                      <input type="text" class="form-control" value="<%=user.getLastName() %>" name="lastName" placeholder="LastName">
                      <% if(request.getParameter("lastNameError")  != null){ %> 
	                       <p class="text-danger fs-3">
	                          <%=request.getParameter("lastNameError") %>
	                       </p>
	                  <% } %>
                    </div>
                 </div>
                   <div class="form-group">
                     <label >Email address</label>
                     <input type="email" class="form-control" value="<%= user.getEmail() %>" name="email"  placeholder="Email">
                     <% if(request.getParameter("emailError")  != null){ %> 
	                       <p class="text-danger fs-3">
	                          <%=request.getParameter("emailError") %>
	                       </p>
	                  <% } %>
                   </div>
                   <div class="row">
                    <div class="col-12 form-group">
                      <label >UserName</label>
                      <input type="text" class="form-control" value="<%= user.getUsername() %>"  name="userName" placeholder="UserName">
                      <% if(request.getParameter("userNameError")  != null){ %> 
	                       <p class="text-danger fs-3">
	                          <%=request.getParameter("userNameError") %>
	                       </p>
	                  <% } %>
                    </div>
                   </div>
                   <div class="row">
                   <div class="col-6 form-group">
                     <label >Role</label>
                     <select class="form-control" name="role">
                       <%
	         
	                      List<Role> roles = (List<Role>) request.getAttribute("roles");
                          Role userRole = user.getRole();
	                      for(Role r:roles){
	                    	  Role curentRole = r;
	                      %>    
	                       <option value="<%=r.getId() %>" <%= userRole.getId() == curentRole.getId() ? "selected" : "" %>>  <%=r.getName() %></option>
	                    <% } %>
                     </select>
                   </div>
                   <div class="col-6 form-group">
                     <label for="exampleSelectGender">Department</label>
                     <select class="form-control" name="departement" >
                     <% 
                      List<Departement> departments = (List<Departement>) request.getAttribute("departments");
                      for(Departement d:departments){
	                  %>
	                      <option value="<%=d.getId() %>"><%=d.getName() %></option>
	                  <%} %>
                     </select>
                   </div>
                   </div>
                   <div class="form-group">
                     <label for="exampleInputCity1">Position</label>
                     <input type="text" class="form-control" value="<%= user.getPosition() %>" name="position" id="exampleInputCity1" placeholder="position">
                   </div>
                   <% if(request.getParameter("positionError")  != null){ %> 
	                       <p class="text-danger fs-3">
	                          <%=request.getParameter("positionError") %>
	                       </p>
	                  <% } %>
                   <button type="submit" class="btn btn-primary mr-2">Submit</button>
                   <button class="btn btn-dark" data-bs-dismiss="modal">Cancel</button>
                 </form>
               </div>
             </div>
            </div>
            
            
          <jsp:include page="../includes/footer.jsp" />
