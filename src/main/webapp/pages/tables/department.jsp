<%@ page import="com.app.entity.Departement"%>
<%@ page import="java.util.List"%>
<%-- <% if (session.getAttribute("userLogin") ==null){
  response.sendRedirect("../../login.jsp");
}%> --%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Tasks</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<div class="row flex-nowrap ">
			<div class="col-auto col-xl-2 px-sm-2 px-0 shadow bg-primary"
				style="height: 100vh;">
				<div class="d-flex flex-column mt-2 px-3 pt-2">
					<a href="#"
						class="pb-3 mb-md-0 text-decoration-none text-dark fs-5 d-none d-sm-inline">Resourcium<span
						class="text-white">Optima</span></a>
					<div class="d-flex flex-column mx-auto my-3 d-none d-sm-inline">
						<div class="rounded-circle  overflow-hidden"
							style="width: 80px; height: 80px;">
							<img class="w-100" id="image" src="../images/home.png"
								alt="Profile image">
						</div>
					</div>
					<jsp:include page="../includes/asidebar.jsp" />
				</div>
			</div>

			<%--    -- -------------------------------content ----------------------------------------%>
			<div class="col py-3 overflow-x-hidden overflow-y-scroll"
				style="height: 100vh">
				<%--     -- Content Wrapper ----%>
				<div class="d-flex flex-column">
					<%--     -- Main Content ----%>
					<div>
						<%--         -- Topbar ----%>
						<nav class="navbar navbar-expand  mb-4 shadow">
							<div>
								<p class="fs-5 ms-4">
									Welcome <span> ${ sessionScope.userName } !</span>
								</p>
							</div>
						</nav>
						<%--          End of Topbar ---%>
						<%--          Begin Page Content ----%>
						<div class="container-fluid">
							<%--             Page Heading --%>
							<div
								class="d-sm-flex align-items-center justify-content-between mb-4">
								<h3 class="mb-0 text-secondary">Department</h3>
								<button type="button" class="btn btn-primary"
									data-bs-toggle="modal" data-bs-target="#exampleModal">
									+ Add Department</button>
							</div>
							<div class="row">
								<div class=" d-flex justify-content-center ">
									<div class="card shadow mb-4 col-8">
										<%--                  Card Header - Dropdown ----%>
										<div
											class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
											<h6 class="m-0 font-weight-bold text-primary">Department</h6>
										</div>
										<%--                  -- Card Body ----%>
										<div class="card-body">
											<div class="table-responsive" style="max-height: 300px; overflow-y: auto;">
												<table class="table table-striped border">
													<thead class="bg-secondary bg-opacity-25">
														<tr>
															<th scope="col">Name</th>
															<th scope="col">Head of Department</th>
															<th scope="col">Description</th>
															<th scope="col">Action</th>
														</tr>
													</thead>
													<tbody>
														<% if (request.getAttribute("departements") != null) {
                                                    List<Departement> departmentList = (List<Departement>) request.getAttribute("departements");
                                                    for (Departement d:departmentList) {%>
														<tr>
															<td scope="col"><p><%= d.getName() %></p></td>
															<td scope="col"><p><%= d.getHeadOfDepartment() %></p></td>
															<td scope="col"><p><%= d.getDescription() %></p></td>
															<td scope="col">
																<div class="d-flex justify-content-between align-items-center">												
																<button type="button" class="btn btn-danger" onclick="showDeleteConfirmationDepartment(<%= d.getId() %>);">
																<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
																  <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
																</svg>
                                                                </button>
																<button type="button" data-editdepartment-id="<%= d.getId() %>" class="btn btn-warning edit-user-modal">
																<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
																  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
																  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
																</svg>
																</button>
															</div>
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
	<%--modal--%>
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<form action="DepartmentServlet" method="post" class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Add a
						Department</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="mb-4">
						<label class="form-label">Name</label> <input type="text"
							class="form-control" name="name" placeholder="name" required>
					</div>
					<div class="mb-3">
						<label class="form-label">Description</label>
						<textarea class="form-control" name="description" placeholder="description" rows="3"></textarea>
					</div>
					<div class="mb-4">
						<label class="form-label">Head Department</label> <input
							type="text" class="form-control" placeholder="Head Department" name="headOfDepartment" required>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">Add</button>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="../includes/script.jsp" />