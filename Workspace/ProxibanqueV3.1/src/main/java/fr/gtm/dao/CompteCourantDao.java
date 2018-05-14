package fr.gtm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import fr.gtm.domaine.ClientDomaine;
import fr.gtm.domaine.CompteCourant;

public class CompteCourantDao {

	private ConnectionDao conDao = new ConnectionDao();
	private Connection con = conDao.connect();

	/**
	 * methode qui nous permet de creer un nouveau compte courant dans la base de
	 * donnees
	 * 
	 * @param leCompteCourant objet compte courant contenant les informations sur le nouveau compte a creer
	 * @return booleen qui indique le succes ou l'echec de la creation
	 */
	public boolean createCompteCourant(CompteCourant leCompteCourant) {
		boolean reponse = false; // Creation de la variable de sortie
		try {
			String sql = "INSERT INTO `compte`(`numCompte`,`dateCreation`, `solde`,`idTypeCompte`,`idClient`,`decouvert`) VALUES ('"
					+ leCompteCourant.getNumCompte() + "', '" + leCompteCourant.getDateCreation() + "', '"
					+ leCompteCourant.getSolde() + "', '" + leCompteCourant.getIdTypeCompte() + "', '"
					+ leCompteCourant.getIdClient() + "', " + leCompteCourant.getDecouvert() + ");";
			PreparedStatement stmt = this.con.prepareStatement(sql); // Connexion et preparation de la requete

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
	 * methode qui nous permet d'afficher le compte courant dans la base de donnees appartenant a un client donne
	 * 
	 * @param c objet de type ClientDomaine correspondant au client possedant le compte
	 * @return objet de type CompteCourant contenant les informations sur le compte
	 */
	public CompteCourant getCompteCourant(ClientDomaine c) {
		CompteCourant leCompteCourant = new CompteCourant();
		try {
			String sql = "SELECT  `idCompte`, `dateCreation`, `solde`, `idTypeCompte`, `idClient`, `decouvert` FROM `compte` WHERE idClient = "
					+ c.getIdClient() + " and taux is null";
			PreparedStatement stmt = this.con.prepareStatement(sql); // Connexion et preparation de la requete

			ResultSet result = stmt.executeQuery(sql); // Execution de la requete
			if (result.first()) {
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
	 * methode qui nous permet de mettre a  jour un compte courant dans la base de
	 * donnees
	 * 
	 * @param leCompteCourant objet de type CompteCourant contenant les nouvelles proprietes du compte
	 * @return objet Compte modifie
	 */
	public CompteCourant updateCompteCourant(CompteCourant leCompteCourant) {
		try {
			String sql = "UPDATE `compte` SET `numCompte` = '" + leCompteCourant.getNumCompte()
					+ "', `dateCreation` = '" + leCompteCourant.getDateCreation() + "', `solde` = "
					+ leCompteCourant.getSolde() + "', `idTypeCompte` = " + leCompteCourant.getIdTypeCompte()
					+ "', `idClient` = " + leCompteCourant.getIdClient() + "', `decouvert` = "
					+ leCompteCourant.getDecouvert() + " WHERE `idClient` = " + leCompteCourant.getIdClient();
			PreparedStatement stmt = this.con.prepareStatement(sql); // Connexion et preparation de la requete

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
	 * methode qui nous permet de supprimer un compte courant dans la base de
	 * donnees
	 * 
	 * @param leCompteCourant objet compte courant a supprimer
	 * @return booleen qui indique le succes ou l'echec de la suppression
	 */
	public boolean deleteCompteCourant(CompteCourant leCompteCourant) {
		boolean reponse = false; // Creation variable de retour
		try {
			String sql = "DELETE FROM compte WHERE `idClient` = " + leCompteCourant.getIdClient();

			PreparedStatement stmt = this.con.prepareStatement(sql); // Connexion et preparation de la requete

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
	 * methode qui nous permet de mettre a  jour un solde apres virement dans la
	 * base de donnees
	 * 
	 * @param leCompteCourant objet de type compte courant contenant le solde a modifier dans la base de donnees
	 * @return objet de type compte courant
	 */
	public CompteCourant updateSolde(CompteCourant leCompteCourant) {
		try {
			String sql = "UPDATE `compte` SET `solde` = '" + leCompteCourant.getSolde() + "' WHERE `numCompte` = "
					+ leCompteCourant.getNumCompte();
			PreparedStatement stmt = this.con.prepareStatement(sql); // Connexion et preparation de la requete

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
