package human_ressources;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.entity.Departement;
import com.app.entity.User;
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
     @Test
        public void testRemoveDepartment() {
    	    Departement d = new Departement();
    	    d.setDescription("ok");
            d.setHeadOfDepartment("silmpo");
            d.setName("isio");
            departmentService.addDepartment(d);
            Departement dep = departmentService.findById(d.getId());
            assertNotNull(dep);
            departmentService.removeDepartment(dep);
            Departement depDeleted = departmentService.findById(d.getId());
            assertNull(depDeleted);
        }
     @Test
	    public void testFindDepartmentById() {
	        Departement department = new Departement();
	        department.setName("testname");
	        department.setDescription("test description");
	        department.setHeadOfDepartment("test head of department");
	        departmentService.addDepartment(department);

	        Departement deparmentFound = departmentService.findById(department.getId());

	        assertNotNull(deparmentFound);

	        departmentService.removeDepartment(deparmentFound);
	    }
     @Test
     public void testGetAllDepartment() {
 	 List<Departement> departmentsBefor = departmentService.getAllDepartment();
 	 Departement departement = new Departement();
 	 departement.setDescription("descr");
 	 departement.setHeadOfDepartment("headofdepart");
 	 departement.setName("name");
 	 departmentService.addDepartment(departement);
 	 List<Departement> departmentsAfter = departmentService.getAllDepartment();
 	 assertNotNull(departmentsAfter);
 	 assertFalse(departmentsAfter.isEmpty());
 	 assertEquals(departmentsBefor.size() +1, departmentsAfter.size());
 	 departmentService.removeDepartment(departement);
  }
}
