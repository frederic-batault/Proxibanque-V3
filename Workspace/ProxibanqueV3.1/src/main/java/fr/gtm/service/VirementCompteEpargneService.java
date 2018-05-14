package fr.gtm.service;

import fr.gtm.dao.CompteCourantDao;
import fr.gtm.dao.CompteEpargneDao;
import fr.gtm.domaine.CompteCourant;
import fr.gtm.domaine.CompteEpargne;

/**
 * Classe Service qui permet d'effectuer les virements d'un compte epargne à un
 * compte courant
 * 
 * @author Stagiaire
 *
 */
public class VirementCompteEpargneService {

	/**
	 * instanciation de ma dao
	 */
	CompteCourantDao daoCC = new CompteCourantDao();
	CompteEpargneDao daoCE = new CompteEpargneDao();

	/**
	 * 
	 * @param compte1
	 *            Un compte de classe CompteEpargne (compte debite)
	 * @param compte2
	 *            Un compte de classe CompteCourant (compte credite)
	 * @param montant
	 * @return
	 */
	public boolean effectuerVirementCompteEpargneACompteCourant(CompteEpargne compte1, CompteCourant compte2,
			float montant) {
		float soldeCompte1 = compte1.getSolde();
		float soldeCompte2 = compte2.getSolde();
		float nouveauSoldeCompte1 = soldeCompte1 - montant;
		float nouveauSoldeCompte2 = soldeCompte2 + montant;

		compte1.setSolde(nouveauSoldeCompte1);
		compte1 = this.daoCE.updateSolde(compte1);
		compte2.setSolde(nouveauSoldeCompte2);
		compte2 = this.daoCC.updateSolde(compte2);

		return true;

	}

}
