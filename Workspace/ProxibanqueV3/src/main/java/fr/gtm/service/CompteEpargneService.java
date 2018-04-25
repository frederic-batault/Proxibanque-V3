package fr.gtm.service;

import fr.gtm.dao.CompteEpargneDao;
import fr.gtm.domaine.ClientDomaine;
import fr.gtm.domaine.CompteEpargne;

public class CompteEpargneService {

		CompteEpargneDao dao = new CompteEpargneDao();

		/**
		 * methode pour creer un compte epargne
		 * @param leCompteEpargne
		 * @return
		 */
		public boolean createCompteEpargne(CompteEpargne leCompteEpargne) {
			boolean reponse = dao.createCompteEpargne(leCompteEpargne);
			return reponse; // retour de la reponse
		}

		/**
		 * methode pour afficher un compte epargne
		 * @param c
		 * @return
		 */
		public CompteEpargne getCompteEpargne(ClientDomaine c) {
			CompteEpargne leCompteEpargne = new CompteEpargne();
			leCompteEpargne = dao.getCompteEpargne(c);
			return leCompteEpargne;
		}

		/**
		 * methode pour mettre a jour un compte epargne
		 * @param leCompteEpargne
		 * @return
		 */
		public CompteEpargne updateCompteEpargne(CompteEpargne leCompteEpargne) {
			leCompteEpargne = dao.updateCompteEpargne(leCompteEpargne);
			return leCompteEpargne;
		}

		/**
		 * methode pour supprimer un compte epargne
		 * @param leCompteEpargne
		 * @return
		 */
		public boolean deleteCompteEpargne(CompteEpargne leCompteEpargne) {
			boolean reponse = dao.deleteCompteEpargne(leCompteEpargne);
			return reponse; // retour de la r�ponse
		}
		
		
		
		
		
		
		
		/**
		 * Methode pour crediter un compte epargne
		 * 
		 * @param monCompte
		 * @param montant
		 *            Un compte epargne de classe CompteEpargne
		 * @return
		 */
		public CompteEpargne crediterCompteEpargne(CompteEpargne monCompteEpargne, float montant) {
			float solde = monCompteEpargne.getSolde();
			float nouveauSolde = solde + montant;
			monCompteEpargne.setSolde(nouveauSolde);
			monCompteEpargne=this.dao.updateSolde(monCompteEpargne);
			return monCompteEpargne;
		}


		
		/**
		 * Methode pour debiter un compte epargne
		 * @param monCompteEpargne
		 * @param montant
		 * @return
		 */
		public CompteEpargne debiterCompteEpargne(CompteEpargne monCompteEpargne, float montant) {
			float solde = monCompteEpargne.getSolde();
			float nouveauSolde = solde - montant;
			monCompteEpargne.setSolde(nouveauSolde);
			monCompteEpargne=this.dao.updateSolde(monCompteEpargne);
			return monCompteEpargne;

		}
}
