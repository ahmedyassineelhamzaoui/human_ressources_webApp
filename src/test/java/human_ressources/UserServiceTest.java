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

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
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
