import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.gtm.service.ConseillerService;

public class ConseillerServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAuthentificationTrue() {
		ConseillerService ref = new ConseillerService();
		assertTrue(ref.authentification("david.pro", "123"));
	}

	@Test
	public void testAuthentificationFalse() {
		ConseillerService ref = new ConseillerService();
		assertFalse(ref.authentification("david.pro", "456"));
	}
}
