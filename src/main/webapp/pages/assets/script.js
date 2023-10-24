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

