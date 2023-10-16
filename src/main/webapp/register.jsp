<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Corona Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="assets/images/favicon.png" />
  </head>
  <body>
    <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="row w-100 m-0">
          <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg">
            <div class="card col-lg-4 mx-auto">
              <div class="card-body px-5 py-5">
                <h3 class="card-title text-left mb-3 text-center">Register</h3>
                <form>
                <div class="d-flex justify-content-center align-items-center">
                <div class="form-group">
                    <label>firstname</label>
                    <input type="text" name="first_name" class="form-control p_input">
                  </div>
                  <div class="form-group ml-2">
                    <label>last name</label>
                    <input type="text" name="last_name" class="form-control p_input">
                  </div>
                </div>
                <div class="d-flex justify-content-center align-items-center">
                <div class="form-group">
                    <label>Username</label>
                    <input type="text" name="user_name" class="form-control p_input">
                  </div>
                  <div class="form-group ml-2">
                    <label>Email</label>
                    <input type="email" name="email" class="form-control p_input">
                  </div>
                </div>
                <div class="d-flex justify-content-center align-items-center">
                  <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" class="form-control p_input">
                  </div>
                  <div class="form-group ml-2">
                    <label>Confirm password</label>
                    <input type="password" name="confirm_password" class="form-control p_input">
                  </div>
                </div>
                  <div class="form-group d-flex align-items-center justify-content-between">
                    <div class="form-check">
                      <input type="checkbox" class="form-check-input" value="no">
                      <label class="form-check-label"> Remember me </label>
                    </div>
                    <a href="#" class="forgot-pass">Forgot password</a>
                  </div>
                  <div class="text-center">
                    <button type="submit" class="btn btn-primary btn-block enter-btn">Create my account</button>
                  </div>
                 
                  <p class="sign-up text-center">Already have an Account?<a href="login.jsp">Log in</a></p>
                </form>
              </div>
            </div>
          </div>
          <!-- content-wrapper ends -->
        </div>
        <!-- row ends -->
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
    <script src="assets/js/off-canvas.js"></script>
    <script src="assets/js/hoverable-collapse.js"></script>
    <script src="assets/js/misc.js"></script>
    <script src="assets/js/settings.js"></script>
    <script src="assets/js/todolist.js"></script>
    <!-- endinject -->
  </body>
</html>