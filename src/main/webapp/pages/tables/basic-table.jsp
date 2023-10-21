<%@ page import="com.app.service.UserService" %>
<%@ page import="jakarta.persistence.EntityManager" %>
<%@ page import="com.app.util.HibernateUtil" %>
<%@ page import="com.app.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="jakarta.persistence.EntityManagerFactory" %>
<jsp:include page="../includes/head.jsp" />
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
           	List<User> users = (List<User>) request.getAttribute("users");
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
                            <td>
                               <div class="d-flex  align-items-center">
	                               <a href="" type="button" class="btn btn-danger btn-rounded btn-icon d-flex justify-content-center align-items-center mr-1">
	                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
									  <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
									</svg>
	                               </a>
	                               <a href="EditUserServlet?id=<%=u.getId() %>" class="btn btn-warning btn-rounded btn-icon d-flex justify-content-center align-items-center">
	                               <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
									  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
									  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
									</svg>
	                               </a>
	                           </div>
                            </td>
                          </tr>
                        <% } %> 
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
              
                     <jsp:include page="../includes/footer.jsp" />
