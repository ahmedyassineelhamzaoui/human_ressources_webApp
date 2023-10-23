<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>404</title>
</head>
<body>
<div class="d-flex justify-content-center align-items-center vh-100">
    <div class="container">
        <div class="text-center">
            <h1 style="color:orange" class="display-1">404</h1>
            <h3 class="font-weight-bold">The page you are looking for cannot be found!</h3>
            <p class="font-weight-bold mb-4">You may have typed the address incorrectly or the page may have moved.</p>
            <div>
                <a style="background:orange;color:aliceblue" href="{{url('home')}}" class="btn  px-4 py-2 rounded-pill"> Back to Home</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>