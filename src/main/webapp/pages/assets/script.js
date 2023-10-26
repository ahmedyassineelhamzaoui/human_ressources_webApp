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
	function showRoleInformation(roleId) {
		$.ajax({
	    url: '/human_ressources/pages/tables/RoleServlet',
	    type: 'GET',
	    data: { roleIdToEdit: roleId },
	    success: function(response) {
			  const roleName = response.name;
              console.log(response.name)
		      const modal = $('#editRoleModal');
		      const form  = $('#editRoleModalForm');
		      $("#roleNameToEdit").val(response.name);
		       form.attr('action', 'EditRoleServlet?roleIdToEdit='+ roleId);
		       modal.modal('show');
	    },
	    error: function(xhr, status, error) {
	      console.log('Status: ' + status);
	      console.log('Error: ' + error);
	      console.log(xhr.responseText);
      	    }
	  });
	  
	}
	document.addEventListener("DOMContentLoaded", function() {
	  document.querySelectorAll('.edit-role-modal').forEach((button) => {
	    button.addEventListener('click', (event) => {
	      const roleId = event.target.closest('.edit-role-modal').getAttribute('data-editrole-id');
	      if (roleId !== null) {
	        showRoleInformation(roleId);
	        console.log(roleId);
	      }
	    });
	  });
	  document.querySelectorAll('.edit-user-modal').forEach((button) => {
	    button.addEventListener('click', (event) => {
	      const userId = event.target.closest('.edit-user-modal').getAttribute('data-edituser-id');
	      if (userId !== null) {
	        showUserInformation(userId);
	        console.log(userId);
	      }
	    });
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
function showDeleteConfirmationRole(roleId){
	console.log("ok")
    Swal.fire({
        title: 'Delete Role',
        text: 'Are you sure you want to delete this Role?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, delete it!',
        cancelButtonText: 'No, cancel',
        confirmButtonColor: '#d33',
    }).then((result) => {
        if (result.isConfirmed) {
            deleteRoleData(roleId);
        }
    });
}
function deleteRoleData(roleId){
	 $.ajax({
	    url: '/human_ressources/pages/tables/RoleServlet',
	    type: 'GET',
	    data: { roleId: roleId },
	    success: function(response) {
	      window.location.href = '/human_ressources/pages/tables/RoleServlet?success=department+deleted+successfuly';
	    },
	    error: function(xhr, status, error) {
	      console.error('Failed to delete department');
	      console.log('Status: ' + status);
	      console.log('Error: ' + error);
	      console.log(xhr.responseText);
	      console.log("pages/tables/RoleServlet");
      	    }
	  });
}
function showDeleteConfirmationEquipment(equipmentId){
	Swal.fire({
		title: 'delete equipment',
		text: 'Are you sure you want to delete this equipment ?',
		icon:'warning',
		showCancelButton:true,
		confirmButtonText:'Yes,delete it',
		cancelButtonText:'No cancel',
		confirmButtonColor:'#d33',
	}).then((result)=>{
		if(result.isConfirmed){
			deleteEquipmentData(equipmentId);
		}
	});
}
function deleteEquipmentData(equipmentId){
	console.log("method called")
	$.ajax({
	    url: '/human_ressources/pages/tables/EquipmentServlet',
	    type: 'GET',
	    data: { equipmentId: equipmentId },
	    success: function(response) {
	      window.location.href = '/human_ressources/pages/tables/EquipmentServlet?success=equipment+deleted+successfuly';
	    },
	    error: function(xhr, status, error) {
	      console.error('Failed to delete equipment');
	      console.log('Status: ' + status);
	      console.log('Error: ' + error);
	      console.log(xhr.responseText);
      	    }
	  });
}
function showDeleteTaskConfirmation(taskId){
	Swal.fire({
		title: 'delete task',
		text: 'Are you sure you want to delete this task ?',
		icon:'warning',
		showCancelButton:true,
		confirmButtonText:'Yes,delete it',
		cancelButtonText:'No cancel',
		confirmButtonColor:'#d33',
	}).then((result)=>{
		if(result.isConfirmed){
			deleteTaskData(taskId);
		}
	});
}
function deleteTaskData(taskId){
	console.log("method called")
	$.ajax({
	    url: '/human_ressources/pages/tables/TaskServlet',
	    type: 'GET',
	    data: { taskId: taskId },
	    success: function(response) {
	      window.location.href = '/human_ressources/pages/tables/TaskServlet?success=task+deleted+successfuly';
	    },
	    error: function(xhr, status, error) {
	      console.error('Failed to delete task');
	      console.log('Status: ' + status);
	      console.log('Error: ' + error);
	      console.log(xhr.responseText);
      	    }
	  });
}