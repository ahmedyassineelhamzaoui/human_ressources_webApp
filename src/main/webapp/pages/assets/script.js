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
    const url = `/UserServlet?userId=${userId}`;

    fetch(url, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then(response => {
        if (response.ok) {
            // Successful deletion
            Swal.fire('Deleted!', 'The user has been deleted.', 'success');
            
            // You may also update the user interface, e.g., remove the user from the table
        } else {
            Swal.fire('Error', 'An error occurred while deleting the user.', 'error');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        Swal.fire('Error', 'An error occurred while deleting the user.', 'error');
    });
}
