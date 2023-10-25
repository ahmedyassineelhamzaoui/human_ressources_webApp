package human_ressources;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.service.DepartmentService;

public class DepartmentServiceTest {

	private DepartmentService departmentService;
	@Before
	public void setUp() throws Exception {
		departmentService = new DepartmentService();
	}

	@After
	public void tearDown() throws Exception {
		departmentService = null;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
