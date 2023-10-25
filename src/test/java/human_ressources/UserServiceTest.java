/**
 * 
 */
package human_ressources;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
		UserService userService = new UserService();
		User user = new User();
		user.setLastName(null);
		user.setEmail(null);
		user.setFirstName(null);
		user.setPassword(null);
		user.setPosition(null);
		user.setHireDate(null);
		user.setDepartment(null);
		user.setRole(null);
		userService.addUser(user);
	}
	

}
