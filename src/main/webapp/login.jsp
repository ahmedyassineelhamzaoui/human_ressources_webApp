<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body class="bg-primary">
<section class="vh-100">
    <div class="container py-5 h-100">
        <% if(request.getParameter("error") !=null){ %>
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
		  <strong>Error! </strong><%= request.getParameter("error") %>
		  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
		<% } %>
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-6 ">
                <div class="bg-dark text-white rounded">
                    <div class="card-body p-5 text-center">
                        <div class="mb-4"><h3>Login</h3></div>
                        <form action="LoginServlet" method="post">
                            <div class="mb-4">
                                <label class="form-label">userName</label>
                                <input type="text" class="form-control" name="userLogin" required>
                            </div>
                            <div class="mb-4">
                                <label class="form-label">Password</label>
                                <input type="password" class="form-control" name="password" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>