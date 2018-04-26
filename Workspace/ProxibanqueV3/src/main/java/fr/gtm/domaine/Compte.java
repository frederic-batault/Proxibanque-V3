package fr.gtm.domaine;

/**
 * Classe abstraite Compte, dont sont heritees les classes CompteCourant et
 * CompteEpargne
 * 
 * 
 *
 */
public abstract class Compte {

	// Proprietes
	private String numCompte;
	private float solde;
	private String dateCreation;
	private int idTypeCompte;
	private int idClient;

	// Constructeurs

	/**
	 * Constructeur par defaut
	 */
	public Compte() {
	}

	/**
	 * Constructeur Complet
	 * 
	 * @param numeroCompte
	 * @param solde
	 * @param dateCreation
	 */
	public Compte(String numCompte, float solde, String dateCreation, int idTypeCompte, int idClient) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.idTypeCompte = idTypeCompte;
		this.idClient = idClient;
	}
	
	public Compte(String numCompte, float solde, String dateCreation) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateCreation = dateCreation;
	}

	// Getters/Setters

	/**
	 * @return numeroCompte
	 */
	public String getNumCompte() {
		return numCompte;
	}

	/**
	 * @param numeroCompte
	 *            to set
	 */
	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	/**
	 * @return solde
	 */
	public float getSolde() {
		return solde;
	}

	/**
	 * @param solde
	 *            to set
	 */
	public void setSolde(float solde) {
		this.solde = solde;
	}

	/**
	 * @return dateCreation
	 */
	public String getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation
	 *            to set
	 */
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * @return idTypeCompte
	 */
	public int getIdTypeCompte() {
		return idTypeCompte;
	}

	/**
	 * @param idTypeCompte
	 *            to set
	 */
	public void setIdTypeCompte(int idTypeCompte) {
		this.idTypeCompte = idTypeCompte;
	}

	/**
	 * @return idClient
	 */
	public int getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient
	 *            to set
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

}
