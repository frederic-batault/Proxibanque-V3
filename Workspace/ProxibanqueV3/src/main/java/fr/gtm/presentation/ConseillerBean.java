package fr.gtm.presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.gtm.domaine.ClientDomaine;
import fr.gtm.domaine.Conseiller;
import fr.gtm.service.ClientService;

@ManagedBean(name = "conseillerBean")
public class ConseillerBean implements Serializable {

	// propriétés
	private List<ClientDomaine> listeClients;
	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{clientService}")
	private ClientService refClientService = new ClientService();
	

	// méthodes get/set
	public List<ClientDomaine> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<ClientDomaine> listeClients) {
		this.listeClients = listeClients;
	}

	public ClientService getRefClientService() {
		return refClientService;
	}

	public void setRefClientService(ClientService refClientService) {
		this.refClientService = refClientService;
	}

	// constructeurs

	// Méthode de taitement
	public void init() {
		Conseiller refConseiller = new Conseiller("", "", 1, "", "");
		this.listeClients = refClientService.getAllClient(refConseiller);
		
	}


}
