package human_ressources;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.service.EquipmentService;
import com.app.service.UserService;
import com.app.entity.*;
public class TestEquipementService {

	private EquipmentService equipmentService;
	private UserService userService;
	@Before
	public void setUp() throws Exception {
		equipmentService = new EquipmentService();
		userService      = new UserService();
	}

	@After
	public void tearDown() throws Exception {
		equipmentService = null;
		userService      = null;
	}

	@Test
	public void testAddEquipment() {
	    Equipement equipment = new Equipement();
	    equipment.setName("equipment name");
	    equipment.setStatus("valable");
	    equipment.setMaintenanceDate(null);
	    equipment.setPurchaseDate(null);
	    equipment.setType("type");
	    User user = userService.findUserById(1);
	    equipment.setAssignedUser(user);
	    equipmentService.SaveEquipment(equipment);
	    Equipement equipmentFounded = equipmentService.findById(equipment.getId());
	    assertNotNull(equipmentFounded);
	    equipmentService.deleteEquipment(equipmentFounded);
	}
	 @Test
     public void testRemoveEquipment() {
 	    Equipement equipment = new Equipement();
 	    equipment.setName("equipment name");
	    equipment.setStatus("valable");
	    equipment.setMaintenanceDate(null);
	    equipment.setPurchaseDate(null);
	    equipment.setType("type");
	    User user = userService.findUserById(1);
	    equipment.setAssignedUser(user);
	    equipmentService.SaveEquipment(equipment);

	    Equipement equipmentFounded = equipmentService.findById(equipment.getId());
        assertNotNull(equipmentFounded);
        equipmentService.deleteEquipment(equipmentFounded);
        Equipement equipmentDeleted = equipmentService.findById(equipmentFounded.getId());
        assertNull(equipmentDeleted);
     }
	 @Test
	    public void testFindEquipmentById() {
		 Equipement equipment = new Equipement();
	 	    equipment.setName("equipment name");
		    equipment.setStatus("valable");
		    equipment.setMaintenanceDate(null);
		    equipment.setPurchaseDate(null);
		    equipment.setType("type");
		    User user = userService.findUserById(1);
		    equipment.setAssignedUser(user);
		    equipmentService.SaveEquipment(equipment);

		    Equipement equipmentFounded = equipmentService.findById(equipment.getId());

	        assertNotNull(equipmentFounded);

	        equipmentService.deleteEquipment(equipmentFounded);
	    }
	  @Test
	     public void testGetAllEquipment() {
	 	 List<Equipement> equipementsBefor = equipmentService.getAllEquipment();
		 	Equipement equipment = new Equipement();
	 	    equipment.setName("equipment name");
		    equipment.setStatus("valable");
		    equipment.setMaintenanceDate(null);
		    equipment.setPurchaseDate(null);
		    equipment.setType("type");
		    User user = userService.findUserById(1);
		    equipment.setAssignedUser(user);
		    equipmentService.SaveEquipment(equipment);
		 	List<Equipement> equipmentsAfter = equipmentService.getAllEquipment();
		 	assertNotNull(equipmentsAfter);
		 	assertFalse(equipmentsAfter.isEmpty());
		 	assertEquals(equipementsBefor.size() +1, equipmentsAfter.size());
		 	equipmentService.deleteEquipment(equipment);
	  }
}
