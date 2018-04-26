package fr.gtm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;

import fr.gtm.domaine.*;

/**
 * Classe qui gère la communication avec la base de donnéee concernant les propriétés d'un client
 */
public class ClientDao {

	private ConnectionDao conDao = new ConnectionDao();
	private Connection con = conDao.connect();

	/**
	 * methode qui nous permet de creer un nouveau client
	 * 
	 * @param leClient objet client
	 * @return booleen indiquant le succès ou l'échec de la création
	 */
	public boolean createClient(ClientDomaine leClient) {
		boolean reponse = false; // Creation de la variable de sortie
		try {
			PreparedStatement stmt = this.con.prepareStatement(
					"INSERT INTO `client`(`nom`, `prenom`, `email`, `adresse`,`codePostal`,`ville`,idConseiller) VALUES (?, ?, ?, ?, ?, ?, ?)");

			stmt.setString(1, leClient.getNom());
			stmt.setString(2, leClient.getPrenom());
			stmt.setString(3, leClient.getEmail());
			stmt.setString(4, leClient.getAdresse());
			stmt.setString(5, leClient.getCodePostal());
			stmt.setString(5, leClient.getVille());
			stmt.setString(6, leClient.getEmail());
			stmt.setInt(7, leClient.getIdConseiller());

			int result = stmt.executeUpdate(); // Execution de la requete
			if (result > 0) { // Lecture des esultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probleme lors de la creation du client !");
			e.printStackTrace();
			return reponse;
		}
	}

	/**
	 * methode qui nous permet d'afficher un client
	 * 
	 * @param leClient
	 * @return
	 */
	public ClientDomaine getClient(ClientDomaine leClient) {
		try {
			PreparedStatement stmt = this.con.prepareStatement("SELECT  * FROM `client` WHERE idClient = ?");
			stmt.setInt(1, leClient.getIdClient());
			ResultSet result = stmt.executeQuery(); // Execution de la requete
			result.next();
			leClient.setNom(result.getString("nom"));
			leClient.setPrenom(result.getString("prenom"));
			leClient.setEmail(result.getString("email"));// Recuperation des donnees
			leClient.setAdresse(result.getString("adresse"));
			leClient.setCodePostal(result.getString("codePostal"));
			leClient.setVille(result.getString("ville"));
			leClient.setIdConseiller(result.getInt("idConseiller"));
			return leClient; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probleme lors de la recuperation du client !");
			e.printStackTrace();
			return leClient;
		}
	}

	/**
	 * methode qui nous permet de mettre a  jour client
	 * 
	 * @param leClient objet client contenant les nouvelles informations sur le client
	 * @return objet client modifié
	 */
	public ClientDomaine updateClient(int idClient) {
		try {
			ClientDomaine leClient=new ClientDomaine();
			String sql = "UPDATE `client` SET `nom` = '" + leClient.getNom() + "', `prenom` = '" + leClient.getPrenom()
					+ "', `email` = '" + leClient.getEmail() + "', `adresse` = '" + leClient.getAdresse()
					+ "', `codePostal` = '" + leClient.getCodePostal() + "', `ville` = '" + leClient.getVille()
					+ "' WHERE `idClient` = " + idClient;
			PreparedStatement stmt = this.con.prepareStatement(sql); // Connexion et preparation de la requete

			int result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) {
				return leClient; // retour de la reponse
			} else {
				System.out.println("Un problï¿½me est survenu lors de la modification du client.");
				return leClient;// retour de la reponse
			}
		} catch (SQLException e) {
			System.out.println("Probleme lors de la modification du client !");
			e.printStackTrace();
			return null;// retour de la reponse
		}
	}

	/**
	 * methode qui nous permet de supprimer un client
	 * 
	 * @param monClient objet client qui correspond au client à supprimer de la base
	 * @return booleen indiquant le succès ou l'échec de la suppression
	 */
	public boolean deleteClient(ClientDomaine monClient) {
		boolean reponse = false; // Creation variable de retour
		try {

			String sql = "DELETE FROM client WHERE `idClient` = " + monClient.getIdClient();
			PreparedStatement stmt = this.con.prepareStatement(sql); // Connexion et preparation de la requete
			int result = stmt.executeUpdate(sql); // Exï¿½cution de la requï¿½te
			if (result > 0) { // Lecture des rï¿½sultats
				reponse = true;
			}
			return reponse; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Problï¿½me lors de la suppression du client !");
			e.printStackTrace();
			return reponse;
		}
	}

	/**
	 * methode qui nous permet d'afficher la liste des clients affilies à un conseiller donne
	 * 
	 * @param c objet conseiller correspondant au conseiller pour lequel on souhaite la liste des clients affilies
	 * @return liste d'objets de type ClientDomaine
	 */
	public ArrayList<ClientDomaine> getAllClient(Conseiller c) {
		ArrayList<ClientDomaine> listClients = new ArrayList<ClientDomaine>();
		try {

			String sql = "SELECT * FROM `client` where idconseiller = " + c.getIdConseiller();
			PreparedStatement stmt = this.con.prepareStatement(sql); // Connexion et preparation de la requete
			ResultSet result = stmt.executeQuery(sql); // Execution de la requete
			while (result.next()) {
				ClientDomaine leClient = new ClientDomaine(); // Creation de la variable de sortie
				leClient.setIdClient(result.getInt("idClient")); // Recuperation des donnees
				leClient.setNom(result.getString("nom"));
				leClient.setPrenom(result.getString("prenom"));
				leClient.setEmail(result.getString("email"));
				leClient.setAdresse(result.getString("adresse"));
				leClient.setCodePostal(result.getString("codePostal"));
				leClient.setVille(result.getString("ville"));
				leClient.setIdConseiller(result.getInt("idConseiller"));
				listClients.add(leClient);
			}
			return listClients;// retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probleme lors de la recuperation des client !");
			e.printStackTrace();
			return listClients;// retour de la reponse
		}
	}

}
