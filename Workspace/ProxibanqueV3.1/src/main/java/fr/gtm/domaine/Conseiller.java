package fr.gtm.domaine;

import java.util.ArrayList;

/**
 * 
 *
 */

public class Conseiller {

	// Proprietes
	private String nom;
	private String prenom;
	private int idConseiller;
	private String login;
	private String password;
	ArrayList<ClientDomaine> listeClients;
	private int nbClient;

	// Constructeurs

	/**
	 * Constructeur par defaut
	 * 
	 */
	public Conseiller() {
		super();
	}

	/**
	 * Constructeur sans clients
	 * 
	 * @param nom
	 * @param prenom
	 * @param idConseiller
	 * @param login
	 * @param password
	 */
	public Conseiller(String nom, String prenom, int idConseiller, String login, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.idConseiller = idConseiller;
		this.login = login;
		this.password = password;
	}

	/**
	 * Constructeur complet
	 * 
	 * @param nom
	 * @param prenom
	 * @param idConseiller
	 * @param login
	 * @param password
	 * @param listeClients
	 * @param nbClient
	 */
	public Conseiller(String nom, String prenom, int idConseiller, String login, String password,
			ArrayList<ClientDomaine> listeClients, int nbClient) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.idConseiller = idConseiller;
		this.login = login;
		this.password = password;
		this.listeClients = listeClients;
		this.nbClient = nbClient;
	}

	// Getter/Setters
	/**
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return idConseiller
	 */
	public int getIdConseiller() {
		return idConseiller;
	}

	/**
	 * @param idConseiller
	 *            to set
	 */
	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	/**
	 * @return login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return listeClients
	 */
	public ArrayList<ClientDomaine> getListeClients() {
		return listeClients;
	}

	/**
	 * @param listeClients
	 *            to set
	 */
	public void setListeClients(ArrayList<ClientDomaine> listeClients) {
		this.listeClients = listeClients;
	}

	/**
	 * @return nbClient
	 */
	public int getNbClient() {
		return nbClient;
	}

	/**
	 * @param nbClient
	 *            to set
	 */
	public void setNbClient(int nbClient) {
		this.nbClient = nbClient;
	}

	@Override
	public String toString() {

		return "- Id du Conseiller : " + this.idConseiller + ", Nom : " + this.nom + ", Prénom : " + this.prenom
				+ ", Le nombre de clients : " + this.nbClient;
	}

}
