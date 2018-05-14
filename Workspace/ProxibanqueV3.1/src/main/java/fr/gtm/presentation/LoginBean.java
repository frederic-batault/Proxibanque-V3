package fr.gtm.presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.gtm.domaine.ClientDomaine;
import fr.gtm.domaine.Conseiller;
import fr.gtm.service.ClientService;
import fr.gtm.service.ConseillerService;

/**
 * Classe Bean gerant l'interaction avec les ecrans web JSF
 *
 */

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	// proprietes
	private static final long serialVersionUID = 1L;

	private Conseiller refConseiller = new Conseiller();
	private ClientDomaine refClient = new ClientDomaine();
	private int numClient; // client indique par l'utilisateur (pour modif)
	private ClientDomaine ancienClient = new ClientDomaine();// anciennes infos di client (pour modif)

	// methodes get/set

	public Conseiller getRefConseiller() {
		return refConseiller;
	}

	public void setRefConseiller(Conseiller refConseiller) {
		this.refConseiller = refConseiller;
	}

	public ClientDomaine getRefClient() {
		return refClient;
	}

	public void setRefClient(ClientDomaine refClient) {
		this.refClient = refClient;
	}

	public int getNumClient() {
		return numClient;
	}

	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}

	public ClientDomaine getAncienClient() {
		return ancienClient;
	}

	public void setAncienClient(ClientDomaine ancienClient) {
		this.ancienClient = ancienClient;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// constructeurs
	public LoginBean(List<ClientDomaine> listeClients, Conseiller refConseiller, ClientDomaine client, int numClient,
			ClientDomaine ancienClient) {
		super();
		// this.listeClients = listeClients;
		this.refConseiller = refConseiller;
		this.refClient = client;
		this.numClient = numClient;
		this.ancienClient = ancienClient;
	}

	public LoginBean() {
		super();
	}

	// Methodes de taitement
	/**
	 * methode permettant de verifier le mot de passe saisi par un conseiller dans
	 * la page de connexion
	 * 
	 * @return
	 */
	public Object authentification() {
		// instanciation de la classe service
		ConseillerService refConseillerService = new ConseillerService();
		ClientService refClientService = new ClientService();
		// appel de la methode service pour verifier si le mot de passe entre est bon
		boolean authentifie = refConseillerService.authentification(refConseiller.getLogin(),
				refConseiller.getPassword());
		// envoit de la bonne page en fonction du resultat
		if (authentifie == true) {
			this.refConseiller = refConseillerService.getConseiller(refConseiller.getLogin());
			this.refConseiller.setListeClients(refClientService.getAllClient(this.refConseiller));
			return "Conseiller";

		} else {
			return "ErreurConnexion";
		}
	}

	/**
	 * methode permettant d'afficher les anciennes valeurs d'un client sur l'ecran
	 * de modification
	 * 
	 * @return
	 */
	public Object afficherAncien() {
		ClientService refClientService = new ClientService();
		// affichage des anciennes valeurs
		this.ancienClient = refClientService.getClient(this.numClient);
		return "ModifClient";
	}

	/**
	 * methode permettant de modifier les proprietes d'un client a partir des
	 * informations saisies par l'utilisateur dans l'ecran ad hoc
	 * 
	 * @return
	 */
	public Object modifier() {
		// instanciation de la couche service
		ClientService refService = new ClientService();
		// récupération du client correspondant au numero demande
		this.ancienClient = refService.getClient(this.numClient);
		// conservation des anciennes valeurs des id (non demandees dans le formulaire
		// de modif)
		// this.refClient.setIdClient(this.numClient);
		// this.refClient.setIdConseiller(this.ancienClient.getIdClient());
		// appel de la methode service update pour modifier la bdd en fonction
		ClientDomaine retour = refService.updateClient(refClient);
		this.refClient = retour;
		return "ModifClient";
	}
}
