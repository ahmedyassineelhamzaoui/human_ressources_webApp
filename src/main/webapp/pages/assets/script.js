function showDeleteConfirmation(userId) {
    Swal.fire({
        title: 'Delete User',
        text: 'Are you sure you want to delete this user?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, delete it!',
        cancelButtonText: 'No, cancel',
        confirmButtonColor: '#d33',
    }).then((result) => {
        if (result.isConfirmed) {
            deleteUserData(userId);
        }
    });
}

    function deleteUserData(userId) {
	
	  $.ajax({
	    url: '/human_ressources/pages/tables/UserServlet',
	    type: 'GET',
	    data: { userId: userId },
	    success: function(response) {
	      window.location.href = '/human_ressources/pages/tables/UserServlet?success=user+deleted+successfuly';
	    },
	    error: function(xhr, status, error) {
	      console.error('Failed to delete user');
	      console.log('Status: ' + status);
	      console.log('Error: ' + error);
	      console.log(xhr.responseText);
	      console.log("pages/tables/UserServlet");
      	    }
	  });
	}
	function showUserInformation(editId) {
		console.log(editId);
		$.ajax({
	    url: '/human_ressources/pages/tables/UserServlet',
	    type: 'GET',
	    data: { editId: editId },
	    success: function(response) {
        console.log(response);
	   /* document.getElementById('userName').value = user.username;
	    document.getElementById('position').value = user.position;
	    document.getElementById('hireDate').value = user.hireDate;
	    document.getElementById('departement').value = user.department;
	    document.getElementById('role').value = user.role;*/
	    },
	    error: function(xhr, status, error) {
	      console.log('Status: ' + status);
	      console.log('Error: ' + error);
	      console.log(xhr.responseText);
	      console.log("pages/tables/UserServlet");
      	    }
	  });
	  
	
	  // Populate the modal with user information
	  const userInformation = document.getElementById('userInformation');
	  userInformation.innerHTML = `
	    <div class="mb-3">
						<label class="form-label">UserName</label> <input type="text"
							name="userName" id="userName" class="form-control">
					</div>
					<div class="mb-3">
						<label class="form-label">Position</label> <input type="text"
							name="position" id="position" class="form-control">
					</div>
					<div class="mb-3">
						<label class="form-label">Hire Date</label> <input type="date"
						  name="hireDate" id="hireDate"	class="form-control">
					</div>
					<div class="mb-3">
						<label class="form-label">Department</label> <select
							name="departement" id="departement" class="form-select">
							<% for(Departement d:departments){ %>
							<option value="<%=d.getId()%>"><%=d.getName() %></option>
							<% } %>
						</select>
					</div>
					<div class="mb-3">
						<label class="form-label">Role</label> <select id="role" name="role"
							class="form-select">
							<% for(Role r:roles){ %>
							<option value="<%=r.getId()%>"><%=r.getName() %></option>
							<% } %>
						</select>
					</div>
	  `;
	

	  $('#userEditModal').modal('show');
	}
	
	document.querySelectorAll('.edit-user-modal').forEach((button) => {
	  button.addEventListener('click', (event) => {
	    const editId = event.target.getAttribute('data-edit-id');
	    showUserInformation(editId);
	  });
	});


function showDeleteConfirmationDepartment(departmentId) {
	console.log("ok")
    Swal.fire({
        title: 'Delete Department',
        text: 'Are you sure you want to delete this depaertment?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, delete it!',
        cancelButtonText: 'No, cancel',
        confirmButtonColor: '#d33',
    }).then((result) => {
        if (result.isConfirmed) {
            deleteDepartmentData(departmentId);
        }
    });
}
function deleteDepartmentData(departmentId) {
	
	  $.ajax({
	    url: '/human_ressources/pages/tables/DepartmentServlet',
	    type: 'GET',
	    data: { departmentId: departmentId },
	    success: function(response) {
	      window.location.href = '/human_ressources/pages/tables/DepartmentServlet?success=department+deleted+successfuly';
	    },
	    error: function(xhr, status, error) {
	      console.error('Failed to delete department');
	      console.log('Status: ' + status);
	      console.log('Error: ' + error);
	      console.log(xhr.responseText);
	      console.log("pages/tables/DepartmentServlet");
      	    }
	  });
	}