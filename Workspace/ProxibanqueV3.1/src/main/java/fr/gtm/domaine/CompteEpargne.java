package fr.gtm.domaine;

/**
 * Classe CompteEpargne heritee de la classe Compte
 * 
 *
 *
 */
public class CompteEpargne extends Compte {

	private float tauxRemuneration;

	// Constructeurs
	/**
	 * Constructeur par d�faut
	 */
	public CompteEpargne() {
		super();
	}

	
	public CompteEpargne(String numCompte, float solde, String dateCreation,float tauxRemuneration) {
		super(numCompte,solde,dateCreation);
		this.tauxRemuneration = tauxRemuneration;
	}

	//Getters/Setters
	
	public float getTauxRemuneration() {
		return tauxRemuneration;
	}


	public void setTauxRemuneration(float tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}


	
	
}
