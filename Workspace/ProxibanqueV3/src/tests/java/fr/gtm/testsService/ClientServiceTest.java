import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.gtm.domaine.ClientDomaine;
import fr.gtm.domaine.Conseiller;
import fr.gtm.service.ClientService;

@RunWith(Parameterized.class)
public class ClientServiceTest {

	private boolean reponseCreate;
	private ClientDomaine reponseRead;
	private ClientDomaine reponseUpdate;
	private boolean reponseDelete;
	private List<ClientDomaine> reponseGetAll;
	private ClientDomaine argumentCreate;
	private ClientDomaine argumentRead;
	private ClientDomaine argumentUpdate;
	private ClientDomaine argumentDelete;
	private Conseiller argumentGetAll;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	// tableau des param�tres
	@Parameters
	static public List<Object[]> getParameters() {
		Object[][] parameters = { {} };
		return Arrays.asList(parameters);

	}

	@Test
	public void testCreateClient() {
		ClientService ref = new ClientService();
		assertEquals(reponseCreate, ref.createClient(argumentCreate));
		// effacement du client cr��
		boolean b = ref.deleteClient(argumentCreate);
	}

	@Test
	public void testGetClient() {
		ClientService ref = new ClientService();
		assertEquals(reponseCreate, ref.createClient(argumentCreate));
		// effacement du client cr��
		boolean b = ref.deleteClient(argumentCreate);
	}

	@Test
	public void testUpdateClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteClient() {
		ClientService ref = new ClientService();
		// cr�ation d'un client en base � effacer
		ClientDomaine refClient = new ClientDomaine(100, "a", "b", "c", "d", "e", "f", 1);
		boolean b = ref.createClient(refClient);
		// test
		assertEquals(reponseDelete, ref.deleteClient(argumentDelete));
	}

	@Test
	public void testGetAllClient() {
		ClientService ref = new ClientService();
		
	}

}
