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
        // You can perform the delete action here
        // For example, you can make an AJAX request to delete the user with the specified userId.
        // After successful deletion, you can update the table or perform any other necessary actions.
    }
