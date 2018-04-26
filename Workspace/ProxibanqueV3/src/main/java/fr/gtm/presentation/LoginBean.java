package fr.gtm.presentation;

import java.io.Serializable;
import java.util.List;


import javax.faces.bean.ManagedBean;


import fr.gtm.domaine.ClientDomaine;
import fr.gtm.domaine.Conseiller;
import fr.gtm.service.ClientService;
import fr.gtm.service.ConseillerService;

/**
 * Classe Bean gerant l'interaction avec les ecrans web JSF
 *
 */
@ManagedBean(name = "loginBean")
public class LoginBean implements Serializable {

	// propriétés
	private String login;
	private String motDePasse;
	private static final long serialVersionUID = 1L;
	private List<ClientDomaine> listeClients;
	private Conseiller refConseiller;
	private String nom;
	private String prenom;
	private int id;

	// anciennes infos di client (pour modif)
	private int ancienIdClient;
	private String ancienNom;
	private String ancienPrenom;
	private String ancienEmail;
	private String ancienAdresse;
	private String ancienCodePostal;
	private String ancienVille;
	private int ancienIdConseiller;

	private int client; // client indiqué par l'utilisateur (pour modif)

	// nouvelles infos du client (pour modif)
	private int idClient;
	private String nomClient;
	private String prenomClient;
	private String email;
	private String adresse;
	private String codePostal;
	private String ville;
	private int idConseiller;

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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAncienIdClient() {
		return ancienIdClient;
	}

	public void setAncienIdClient(int ancienIdClient) {
		this.ancienIdClient = ancienIdClient;
	}

	public String getAncienNom() {
		return ancienNom;
	}

	public void setAncienNom(String ancienNom) {
		this.ancienNom = ancienNom;
	}

	public String getAncienPrenom() {
		return ancienPrenom;
	}

	public void setAncienPrenom(String ancienPrenom) {
		this.ancienPrenom = ancienPrenom;
	}

	public String getAncienEmail() {
		return ancienEmail;
	}

	public void setAncienEmail(String ancienEmail) {
		this.ancienEmail = ancienEmail;
	}

	public String getAncienAdresse() {
		return ancienAdresse;
	}

	public void setAncienAdresse(String ancienAdresse) {
		this.ancienAdresse = ancienAdresse;
	}

	public String getAncienCodePostal() {
		return ancienCodePostal;
	}

	public void setAncienCodePostal(String ancienCodePostal) {
		this.ancienCodePostal = ancienCodePostal;
	}

	public String getAncienVille() {
		return ancienVille;
	}

	public void setAncienVille(String ancienVille) {
		this.ancienVille = ancienVille;
	}

	public int getAncienIdConseiller() {
		return ancienIdConseiller;
	}

	public void setAncienIdConseiller(int ancienIdConseiller) {
		this.ancienIdConseiller = ancienIdConseiller;
	}

	public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nom) {
		this.nomClient = nomClient;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LoginBean() {
		super();
	}

	// constructeurs

	// Méthodes de taitement
	/**
	 * methode permettant de verifier le mot de passe saisi par un conseiller dans la page de connexion
	 * @return
	 */
	public Object authentification() {
		// instanciation de la classe service
		ConseillerService refConseillerService = new ConseillerService();
		// appel de la méthode service pour vérifier si le mot de passe entré est bon
		boolean authentifie = refConseillerService.authentification(login, motDePasse);
		// envoi à la bonne page en fonction du résultat
		if (authentifie == true) {
			this.refConseiller = refConseillerService.getConseiller(login);
			this.prenom = refConseiller.getPrenom();
			this.nom = refConseiller.getNom();
			this.id = refConseiller.getIdConseiller();

			ClientService refClientService = new ClientService();
			this.listeClients = refClientService.getAllClient(this.refConseiller);

			return "Conseiller";

		} else {
			return "ErreurConnexion";
		}
	}

	/**
	 * methode permettant d'afficher les anciennes valeurs d'un client sur l'ecran de modification
	 * @return
	 */
	public Object afficherAncien() {
		ClientService refService = new ClientService();
		// affichage des anciennes valeurs
//		FacesContext fc = FacesContext.getCurrentInstance();
//		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//		int client = params.get("modif");
		ClientDomaine ancienClient = refService.getClient(client);
		this.ancienIdClient = ancienClient.getIdClient();
		this.ancienPrenom = ancienClient.getPrenom();
		this.ancienNom = ancienClient.getNom();
		this.ancienEmail = ancienClient.getEmail();
		this.ancienAdresse = ancienClient.getAdresse();
		this.ancienCodePostal = ancienClient.getCodePostal();
		this.ancienVille = ancienClient.getVille();
		this.ancienIdConseiller = ancienClient.getIdConseiller();

		return "ModifClient";
	}

	/**
	 * methode permettant de modifier les proprietes d'un client a partir des informations saisies par l'utilisateur dans l'ecran ad hoc
	 * @return
	 */
	public Object modifier() {
		ClientService refService = new ClientService();

		// conservation des anciennes valeurs des id
		this.idConseiller = ancienIdConseiller;
		this.idClient = ancienIdClient;
		// création d'un objet client avec les nouvelles infos
		ClientDomaine refClient = new ClientDomaine(this.idClient, this.nomClient, this.prenomClient, this.email,
				this.adresse, this.codePostal, this.ville, this.idConseiller);
		// appel de la méthode service update
		ClientDomaine retour = refService.updateClient(refClient);

		return "ModifClient";
	}
}
