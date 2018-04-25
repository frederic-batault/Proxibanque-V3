package fr.gtm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gtm.domaine.ClientDomaine;
import fr.gtm.domaine.CompteCourant;

public class CompteCourantDao {

	private ConnectionDao conDao = new ConnectionDao();
	private Connection con = conDao.connect();
	
	/**
	 * methode qui nous permet de creer un nouveau compte courant dans la base de donnees
	 * @param leCompteCourant 
	 * @return 
	 */
	public boolean createCompteCourant(CompteCourant leCompteCourant) {
		boolean reponse = false; // Creation de la variable de sortie
		try {
			Statement stmt = this.con.createStatement(); // Connexion et preparation de la requete
			String sql = "INSERT INTO `compte`(`numCompte`,`dateCreation`, `solde`,`idTypeCompte`,`idClient`,`decouvert`) VALUES ('"
					+ leCompteCourant.getNumCompte()+ "', '" + leCompteCourant.getDateCreation() + "', '" + leCompteCourant.getSolde()+ "', '"
					+ leCompteCourant.getIdTypeCompte() + "', '" + leCompteCourant.getIdClient()+ "', " + leCompteCourant.getDecouvert() + ");";
			int result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) { // Lecture des resultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probleme lors de la creation de Compte Courant !");
			e.printStackTrace();
			return reponse;
		}
	}

	/**
	 * methode qui nous permet d'afficher un compte courant dans la base de donnees
	 * @param c
	 * @return
	 */
	public CompteCourant getCompteCourant(ClientDomaine c) {
		CompteCourant leCompteCourant = new CompteCourant();
		try {
			Statement stmt = this.con.createStatement(); // Connexion et preparation de la requete
			String sql = "SELECT  `idCompte`, `dateCreation`, `solde`, `idTypeCompte`, `idClient`, `decouvert` FROM `compte` WHERE idClient = "
					+ c.getIdClient()+" and taux is null";
			ResultSet result = stmt.executeQuery(sql); // Execution de la requete
			if(result.first()) {
				leCompteCourant.setNumCompte(result.getString("idCompte"));// Recuperation des donnees
				leCompteCourant.setDateCreation(result.getString("dateCreation"));
				leCompteCourant.setSolde(result.getFloat("solde"));
				leCompteCourant.setIdTypeCompte(result.getInt("idTypeCompte"));
				leCompteCourant.setIdClient(result.getInt("idClient"));
				leCompteCourant.setDecouvert(result.getInt("decouvert"));
			}
			return leCompteCourant; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probleme lors de l'affichage du compte courant !");
			e.printStackTrace();
			return leCompteCourant;
		}
	}

	/**
	 * methode qui nous permet de mettre à jour un compte courant dans la base de donnees
	 * @param leCompteCourant
	 * @return
	 */
	public CompteCourant updateCompteCourant(CompteCourant leCompteCourant) {
		try {
			Statement stmt = this.con.createStatement(); // Connexion et preparation de la requete
			String sql = "UPDATE `compte` SET `numCompte` = '" + leCompteCourant.getNumCompte() + "', `dateCreation` = '" + leCompteCourant.getDateCreation()
					+ "', `solde` = " + leCompteCourant.getSolde() + "', `idTypeCompte` = " + leCompteCourant.getIdTypeCompte()
					+ "', `idClient` = " + leCompteCourant.getIdClient() + "', `decouvert` = " + leCompteCourant.getDecouvert()
					 + " WHERE `idClient` = "
					+ leCompteCourant.getIdClient();
			int result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) {
				return leCompteCourant; // retour de la reponse
			} else {
				System.out.println("Un probleme est survenu lors de la modification du Compte Courant.");
				return leCompteCourant;// retour de la reponse
			}
		} catch (SQLException e) {
			System.out.println("Probleme lors de la modification du Compte Courant !");
			e.printStackTrace();
			return leCompteCourant;// retour de la reponse
		}
	}

	/**
	 * methode qui nous permet de supprimer un compte courant dans la base de donnees
	 * @param leCompteCourant
	 * @return
	 */
	public boolean deleteCompteCourant(CompteCourant leCompteCourant) {
		boolean reponse = false; // Creation variable de retour
		try {
			Statement stmt = this.con.createStatement(); // Connexion et preparation de la requete
			String sql = "DELETE FROM compte WHERE `idClient` = " + leCompteCourant.getIdClient();

			int result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) { // Lecture des resultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probleme lors de la suppression du Compte Courant !");
			e.printStackTrace();
			return reponse;
		}
	}

	/**
	 * methode qui nous permet de mettre à jour un solde apres virement dans la base de donnees
	 * @param leCompteCourant
	 * @param montant
	 * @return
	 */
	public CompteCourant updateSolde(CompteCourant leCompteCourant) {
		try {
			Statement stmt = this.con.createStatement(); // Connexion et preparation de la requete
			String sql = "UPDATE `compte` SET `solde` = '" 	 + leCompteCourant.getSolde() + "' WHERE `numCompte` = "
					+ leCompteCourant.getNumCompte();
			float result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) {
				return leCompteCourant; // retour de la reponse
			} else {
				System.out.println("Un probleme est survenu lors du virement sur le Compte Courant.");
				return leCompteCourant;// retour de la reponse
			}
		} catch (SQLException e) {
			System.out.println("Probleme lors du virement !");
			e.printStackTrace();
			return null;// retour de la reponse
		}
	}
}
