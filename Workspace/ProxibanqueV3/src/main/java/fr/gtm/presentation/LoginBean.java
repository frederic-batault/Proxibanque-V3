package fr.gtm.presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import fr.gtm.domaine.ClientDomaine;
import fr.gtm.domaine.Conseiller;
import fr.gtm.service.ClientService;
import fr.gtm.service.ConseillerService;

@ManagedBean(name = "loginBean")
public class LoginBean implements Serializable {

	// propriétés
	private String login;
	private String motDePasse;
	private static final long serialVersionUID = 1L;
	private List<ClientDomaine> listeClients;
	private Conseiller refConseiller;

	// méthodes get/set
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<ClientDomaine> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<ClientDomaine> listeClients) {
		this.listeClients = listeClients;
	}

	public Conseiller getRefConseiller() {
		return refConseiller;
	}

	public void setRefConseiller(Conseiller refConseiller) {
		this.refConseiller = refConseiller;
	}

	// constructeurs
	public LoginBean(String login, String motDePasse) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
	}

	public LoginBean() {
		super();
	}

	// Méthodes de taitement
	public Object authentification() {
		// instanciation de la classe service
		ConseillerService refConseillerService = new ConseillerService();
		// appel de la méthode service pour vérifier si le mot de passe entré est bon
		boolean authentifie = refConseillerService.authentification(login, motDePasse);
		// envoi à la bonne page en fonction du résultat
		if (authentifie == true) {
			this.refConseiller = refConseillerService.getConseiller(login);
			return "Conseiller";

		} else {
			return "ErreurConnexion";
		}
	}

	public Object lister() {
		ClientService refClientService = new ClientService();
		ConseillerService refConseillerService = new ConseillerService();
		this.listeClients = refClientService.getAllClient(this.refConseiller);
		return "Conseiller";

	}
}
