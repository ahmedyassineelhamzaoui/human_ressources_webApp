package human_ressources;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.entity.Departement;
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
	    public void testAddDepartment() {
	        Departement department = new Departement();
	        department.setName("Test Department");
	        department.setHeadOfDepartment("Test Head");
	        department.setDescription("Test Description");

	        departmentService.addDepartment(department);

	        Departement departement =  departmentService.findById(department.getId());
	        assertNotNull(departement);
	        departmentService.removeDepartment(department);
	    }

}
