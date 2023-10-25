package human_ressources;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.service.EquipmentService;

public class TestEquipementService {

	private EquipmentService equipmentService;
	@Before
	public void setUp() throws Exception {
		equipmentService = new EquipmentService();
	}

	@After
	public void tearDown() throws Exception {
		equipmentService = null;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
