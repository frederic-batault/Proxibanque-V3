package fr.gtm.service;


import fr.gtm.dao.CompteCourantDao;
import fr.gtm.domaine.ClientDomaine;
import fr.gtm.domaine.CompteCourant;

public class CompteCourantService {

		CompteCourantDao dao = new CompteCourantDao();

		/**
		 * methode qui nous permet de creer un compte courant
		 * @param leCompteCourant
		 * @return
		 */
		public boolean createCompteCourant(CompteCourant leCompteCourant) {
			boolean reponse = dao.createCompteCourant(leCompteCourant);
			return reponse; // retour de la reponse
		}

		/**
		 * methode qui nous permet d'afficher un compte courant
		 * @param c
		 * @return
		 */
		public CompteCourant getCompteCourant(ClientDomaine c) {
			CompteCourant leCompteCourant = new CompteCourant();
			leCompteCourant = dao.getCompteCourant(c);
			return leCompteCourant;
		}

		/**
		 * methode qui nous permet de mettre a jour un compte courant
		 * @param leCompteCourant
		 * @return
		 */
		public CompteCourant updateCompteCourant(CompteCourant leCompteCourant) {
			leCompteCourant = dao.updateCompteCourant(leCompteCourant);
			return leCompteCourant;
		}

		/**
		 * methode qui nous permet de supprimer un compte courant
		 * @param leCompteCourant
		 * @return
		 */
		public boolean deleteCompteCourant(CompteCourant leCompteCourant) {
			boolean reponse = dao.deleteCompteCourant(leCompteCourant);
			return reponse; // retour de la r�ponse
		}
		
		
		
		
		
		
		
		/**
		 * methode qui nous permet de mettre a jour le solde apres virement
		 * @param leCompteCourant
		 * @param montant
		 * @return
		 */
		public float updateSolde(CompteCourant leCompteCourant,float montant) {
			leCompteCourant=dao.updateCompteCourant(leCompteCourant);
			return leCompteCourant.getSolde ();
		}
		
		/**
		 * Methode pour crediter un compte courant
		 * 
		 * @param monCompte
		 *            Un compte courant de classe CompteCourant
		 * @param montant
		 *            Le montant a crediter
		 */
		public CompteCourant crediterCompteCourant(CompteCourant monCompteCourant, float montant) {
			float solde = monCompteCourant.getSolde();
			float nouveauSolde = solde + montant;
			monCompteCourant.setSolde(nouveauSolde);
			monCompteCourant=this.dao.updateSolde(monCompteCourant);
			return monCompteCourant;

		}
		
		/**
		 * Methode pour debiter un compte Courant
		 * 
		 * @param monCompteCourant
		 *            Un compte de classe CompteCourant
		 * @param montant
		 *            Le montant a debiter
		 */
		public boolean debiterCompteCourant(CompteCourant monCompteCourant, float montant) {
			float solde = monCompteCourant.getSolde();
			float nouveauSolde = solde - montant;
			float autoDecouv = monCompteCourant.getDecouvert();
			if (nouveauSolde >= -autoDecouv) {
				monCompteCourant.setSolde(nouveauSolde);
				monCompteCourant=this.dao.updateSolde(monCompteCourant);
				return true;
			} else {
				return false;
			}

		}
}
