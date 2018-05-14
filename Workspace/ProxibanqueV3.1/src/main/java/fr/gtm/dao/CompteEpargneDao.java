package fr.gtm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.gtm.domaine.ClientDomaine;
import fr.gtm.domaine.CompteEpargne;

public class CompteEpargneDao {

	private ConnectionDao conDao = new ConnectionDao();
	private Connection con = conDao.connect();

	/**
	 * methode qui nous permet de creer un nouveau compte Epargne dans la base de
	 * donnees
	 * 
	 * @param leCompteEpargne
	 * @return
	 */
	public boolean createCompteEpargne(CompteEpargne leCompteEpargne) {
		boolean reponse = false; // Creation de la variable de sortie
		try {

			String sql = "INSERT INTO `compte`(`numCompte`,`dateCreation`, `solde`,`idTypeCompte`,`idClient`,`taux`) VALUES ('"
					+ leCompteEpargne.getNumCompte() + "', '" + leCompteEpargne.getDateCreation() + "', '"
					+ leCompteEpargne.getSolde() + "', '" + leCompteEpargne.getIdTypeCompte() + "', '"
					+ leCompteEpargne.getIdClient() + "', " + leCompteEpargne.getTauxRemuneration() + ");";
			PreparedStatement stmt = this.con.prepareStatement(sql); // Connexion et preparation de la requete

			int result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) { // Lecture des resultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probleme lors de la creation de Compte Epargne !");
			e.printStackTrace();
			return reponse;
		}
	}

	/**
	 * methode qui nous permet d'afficher un compte epargne dans la base de donnees
	 * 
	 * @param c
	 * @return
	 */
	public CompteEpargne getCompteEpargne(ClientDomaine c) {
		CompteEpargne leCompteEpargne = new CompteEpargne();
		try {
			String sql = "SELECT  `idCompte`, `dateCreation`, `solde`, `idTypeCompte`, `idClient`, `taux` FROM `compte` WHERE idClient = "
					+ c.getIdClient() + " and decouvert is null";
			PreparedStatement stmt = this.con.prepareStatement(sql); // Connexion et preparation de la requete

			ResultSet result = stmt.executeQuery(sql); // Exï¿½cution de la requete
			if (result.first()) {
				leCompteEpargne.setNumCompte(result.getString("idCompte"));// Recuperation des donnees
				leCompteEpargne.setDateCreation(result.getString("dateCreation"));
				leCompteEpargne.setSolde(result.getFloat("solde"));
				leCompteEpargne.setIdTypeCompte(result.getInt("idTypeCompte"));
				leCompteEpargne.setIdClient(result.getInt("idClient"));
				leCompteEpargne.setTauxRemuneration(result.getInt("taux"));
			}
			return leCompteEpargne; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probleme lors de l'affichage du compte Epargne !");
			e.printStackTrace();
			return leCompteEpargne;
		}
	}

	/**
	 * methode qui nous permet de mettre a jour un compte Epargne dans la base de
	 * donnees
	 * 
	 * @param leCompteEpargne
	 * @return
	 */
	public CompteEpargne updateCompteEpargne(CompteEpargne leCompteEpargne) {
		try {
			String sql = "UPDATE `compte` SET `numCompte` = '" + leCompteEpargne.getNumCompte()
					+ "', `dateCreation` = '" + leCompteEpargne.getDateCreation() + "', `solde` = "
					+ leCompteEpargne.getSolde() + "', `idTypeCompte` = " + leCompteEpargne.getIdTypeCompte()
					+ "', `idClient` = " + leCompteEpargne.getIdClient() + "', `decouvert` = "
					+ leCompteEpargne.getTauxRemuneration() + " WHERE `idClient` = " + leCompteEpargne.getIdClient();

			PreparedStatement stmt = this.con.prepareStatement(sql); // Connexion et preparation de la requete

			int result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) {
				return leCompteEpargne; // retour de la reponse
			} else {
				System.out.println("Un probleme est survenu lors de la modification du Compte Epargne.");
				return leCompteEpargne;// retour de la reponse
			}
		} catch (SQLException e) {
			System.out.println("Probleme lors de la modification du Compte Epargne !");
			e.printStackTrace();
			return leCompteEpargne;// retour de la reponse
		}
	}

	/**
	 * methode qui nous permet de supprimer compte Epargne dans la base de donnees
	 * 
	 * @param leCompteEpargne
	 * @return
	 */
	public boolean deleteCompteEpargne(CompteEpargne leCompteEpargne) {
		boolean reponse = false; // Creation variable de retour
		try {
			String sql = "DELETE FROM compte WHERE `idClient` = " + leCompteEpargne.getIdClient();
			PreparedStatement stmt = this.con.prepareStatement(sql); // Connexion et preparation de la requete
			

			int result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) { // Lecture des resultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Problï¿½me lors de la suppression du Compte Epargne !");
			e.printStackTrace();
			return reponse;
		}
	}

	/**
	 * methode qui nous permet de mettre a  jour un solde apres virement dans la
	 * base de donnees
	 * 
	 * @param leCompteEpargne
	 * @param montant
	 * @return
	 */
	public CompteEpargne updateSolde(CompteEpargne leCompteEpargne) {
		try {
			String sql = "UPDATE `compte` SET `solde` = '" + leCompteEpargne.getSolde() + "' WHERE `numCompte` = "
					+ leCompteEpargne.getNumCompte();
			PreparedStatement stmt = this.con.prepareStatement(sql); // Connexion et preparation de la requete
			
			float result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) {
				return leCompteEpargne; // retour de la reponse
			} else {
				System.out.println("Un probleme est survenu lors du virement sur le Compte Epargne.");
				return leCompteEpargne;// retour de la reponse
			}
		} catch (SQLException e) {
			System.out.println("Probleme lors du virement !");
			e.printStackTrace();
			return null;// retour de la reponse
		}
	}

}
