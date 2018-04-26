package fr.gtm.domaine;

/**
 *
 * 
 * Classe métier contenant les proprietes d'un client
 *
 */
public class ClientDomaine {

	// Proprietes

	private int idClient;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String codePostal;
	private String ville;
	private int idConseiller;

	// Constructeurs

	/**
	 * Constructeur par defaut
	 */
	public ClientDomaine() {
		super();

	}

	/**
	 * Constructeur complet
	 * 
	 * @param nom
	 * @param prenom
	 * @param idClient
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param email
	 */
	public ClientDomaine(int idClient, String nom, String prenom, String email, String adresse, String codePostal,
			String ville, int idConseiller) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.idConseiller = idConseiller;
	}
	
	

	public ClientDomaine(String nom, String prenom, String email, String adresse, String codePostal, String ville,
			int idConseiller) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.idConseiller = idConseiller;
	}

	// Getters/Setters
	/**
	 * @return idClient
	 */
	public int getIdClient() {
		return idClient;
	}

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
	 * @param idClient
	 *            to set
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return Adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param adresse
	 *            to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal
	 *            to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville
	 *            to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "- Id du Client : " + this.idClient + ", Nom : " + this.nom + ", PrÃ©nom : " + this.prenom + ", Adresse : "
		+ this.adresse + ", Email : " + this.email;
	}

	
}
