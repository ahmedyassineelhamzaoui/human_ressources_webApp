/**
 * 
 */
package human_ressources;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.service.UserService;
import com.app.entity.*;
/**
 * 
 */
public class UserServiceTest {

	private UserService userService;
	


	
	@Before
	public void setUp() throws Exception {
		userService = new UserService();
	}

	
	@After
	public void tearDown() throws Exception {
		userService = null;
	}

	@Test
	public void testAddUser() {
		User user = new User();
        user.setUsername("testuser");
        user.setFirstName("Test");
        user.setLastName("User");
        user.setEmail("testuser@example.com");
        user.setPassword("testpassword");
        user.setPosition("Tester");
        Role role = userService.findRoleById(1); 
        Departement department = userService.findDepartementById(1);
        user.setRole(role);
        user.setDepartment(department);
        userService.addUser(user);

        User addedUser = userService.findByUserLogin("testuser");

        assertNotNull(addedUser);
        assertEquals("testuser", addedUser.getUsername());
        assertEquals("Test", addedUser.getFirstName());
        assertEquals("User", addedUser.getLastName());
        assertEquals("testuser@example.com", addedUser.getEmail());
        userService.deleteUser(addedUser.getId());
	}
	 @Test
	    public void testUpdateUser() {
	        User user = new User();
	        user.setUsername("testuser");
	        user.setFirstName("InitialFirst");
	        user.setLastName("InitialLast");
	        user.setEmail("initial@example.com");
	        user.setPassword("initialpassword");
	        user.setPosition("InitialPosition");
	        Role role = userService.findRoleById(1); 
	        Departement department = userService.findDepartementById(1);
	        user.setRole(role);
	        user.setDepartment(department);
	        userService.addUser(user);

	        User addedUser = userService.findByUserLogin("testuser");
	        assertNotNull(addedUser);

	        addedUser.setFirstName("UpdatedFirst");
	        addedUser.setLastName("UpdatedLast");
	        addedUser.setEmail("updated@example.com");
	        addedUser.setPosition("UpdatedPosition");

	        userService.updateUser(addedUser, addedUser.getId());

	        User updatedUser = userService.findUserById(addedUser.getId());
	        assertNotNull(updatedUser);

	        assertEquals("UpdatedFirst", updatedUser.getFirstName());
	        assertEquals("UpdatedLast", updatedUser.getLastName());
	        assertEquals("updated@example.com", updatedUser.getEmail());
	        assertEquals("UpdatedPosition", updatedUser.getPosition());

	        userService.deleteUser(addedUser.getId());
	    }
	 @Test
	 public void tsetDeleteUser() {
		 User user = new User();
		 user.setFirstName("testfirstname");
		 user.setLastName("testlastname");
		 user.setUsername("testUsername");
		 user.setEmail("testemail");
		 user.setPosition("tesposititron");
		 user.setPassword("ojkskosk");
		 userService.addUser(user);
		 User addedUser = userService.findByUserLogin("testUsername");
		 assertNotNull(addedUser);
		 userService.deleteUser(addedUser.getId());
		 User deletedUser = userService.findByUserLogin("testUsername");
		 assertNull(deletedUser);
		 
	 }
	 @Test
	    public void testFindByUserLogin() {
	        User testUser = new User();
	        testUser.setUsername("testuser");
	        testUser.setEmail("testuser@example.com");
	        userService.addUser(testUser);

	        User foundUser = userService.findByUserLogin("testuser");

	        assertNotNull(foundUser);

	        userService.deleteUser(foundUser.getId());
	    }
	 @Test
	    public void testFindUserById() {
	        User testUser = new User();
	        testUser.setUsername("testuser");
	        testUser.setEmail("testuser@example.com");
	        userService.addUser(testUser);

	        User foundUser = userService.findUserById(testUser.getId());

	        assertNotNull(foundUser);

	        userService.deleteUser(foundUser.getId());
	    }
     @Test
        public void testGetAllUser() {
    	 List<User> listOfUsersBefor = userService.getAllUsers();
    	 User user = new User();
    	 user.setEmail("hello@gmail.com");
    	 user.setFirstName("yassine");
    	 user.setUsername("yassine09");
    	 userService.addUser(user);
    	 User userAdded =  userService.findUserById(user.getId());
    	 assertNotNull(userAdded);
    	 List<User> users = userService.getAllUsers();
    	 assertEquals(listOfUsersBefor.size() + 1, users.size());
    	 assertNotNull(users);
    	 assertFalse(users.isEmpty());
    	 userService.deleteUser(user.getId());
     }
}
