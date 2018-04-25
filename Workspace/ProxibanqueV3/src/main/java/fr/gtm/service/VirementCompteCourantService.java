package fr.gtm.service;

import fr.gtm.dao.CompteCourantDao;
import fr.gtm.dao.CompteEpargneDao;
import fr.gtm.domaine.CompteCourant;
import fr.gtm.domaine.CompteEpargne;

/**
 * Classe Service qui permet d'effectuer les virements d'un compte courant à un compte epargne
 * 
 * @author Stagiaire
 *
 */
public class VirementCompteCourantService {
	
	CompteCourantDao daoCC = new CompteCourantDao();
	CompteEpargneDao daoCE = new CompteEpargneDao();

	/**
	 * Methode qui permet d'effectuer un virement compteCourant a compteEpargne
	 * 
	 * @param compte1
	 *            Un compte de classe CompteCourant (compte debite)
	 * @param compte2
	 *            Un compte Epargne de classe Compte Epargne (compte credite)
	 * @param montant
	 *            Le montant du virement
	 */
		
	public boolean effectuerVirementCompteCourantACompteEpargne(CompteCourant compte1, CompteEpargne compte2,
			float montant) {
		float soldeCompte1 = compte1.getSolde();
		float soldeCompte2 = compte2.getSolde();
		float autoDecouv = compte1.getDecouvert();
		float nouveauSoldeCompte1 = soldeCompte1 - montant;
		float nouveauSoldeCompte2 = soldeCompte2 + montant;
		if (nouveauSoldeCompte1 < -autoDecouv) {
			return false;
		} else {
			compte1.setSolde(nouveauSoldeCompte1);
			compte1=this.daoCC.updateSolde(compte1);
			compte2.setSolde(nouveauSoldeCompte2);
			compte2=this.daoCE.updateSolde(compte2);

		}
		return true;

	}

}
