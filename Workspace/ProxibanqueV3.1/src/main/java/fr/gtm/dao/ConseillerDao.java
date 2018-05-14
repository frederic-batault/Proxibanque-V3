package fr.gtm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.gtm.domaine.*;

/**
 * Classe d'acces aux donnees pour le conseiller
 *
 */
public class ConseillerDao {
	
	// private Statement connect() {
	// try {
	// // Chargement du driver (dans le pilote)
	// Class.forName("com.mysql.jdbc.Driver");
	//
	// // Connexion la base de donnee
	// String url = "jdbc:mysql://localhost:3306/proxibanquebddv3";
	// String login = "root";
	// String mdp = "root";
	// Connection connection = DriverManager.getConnection(url, login, mdp);
	//
	// // Pr�paration de la requete
	// Statement stmt = connection.createStatement();
	// return stmt;
	// } catch (ClassNotFoundException e) {
	// System.out.println("Probleme chargement du driver !");
	// e.printStackTrace();
	// Statement stmt = null;
	// return stmt;
	// } catch (SQLException e) {
	// System.out.println("Probleme de connexion a la base de donnee !");
	// e.printStackTrace();
	// Statement stmt = null;
	// return stmt;
	// }
	// }

	private ConnectionDao conDao = new ConnectionDao();
	private Connection con = conDao.connect();

	//
	//
	// public Conseiller getConseillerConseiller(Conseiller leConseiller) {
	// try {
	// String sql = "SELECT idconseiller,nom,prenom,login,password,nbClient FROM
	// conseiller WHERE login = '"
	// + leConseiller.getLogin() + "' and password = '" + leConseiller.getPassword()
	// + "'";
	// this.st = this.con.createStatement();
	// this.result = this.st.executeQuery(sql); // Execution de la requete
	// result.next();
	// if (result.next()) {
	// leConseiller.setIdConseiller(result.getInt("idconseiller"));
	// leConseiller.setNom(result.getString("nom"));// Recuperation des donnees
	// leConseiller.setPrenom(result.getString("prenom"));
	// leConseiller.setLogin(result.getString("login"));
	// leConseiller.setPassword(result.getString("password"));
	// leConseiller.setNbClient(result.getInt("nbClient"));
	// }else {
	// leConseiller.setIdConseiller(0);
	// }
	// return leConseiller; // retour de la reponse
	// } catch (SQLException e) {
	// System.out.println("Probleme lors de la recuperation du client !");
	// e.printStackTrace();
	// return leConseiller;
	// }
	// }

	/**
	 * Methode permettant d'obtenir un objet conseiller a partir de son login. Les
	 * informations du conseiller sont tirees de la base de donnees
	 * 
	 * @param login du conseiller dont on souhaite les autres informations
	 * @return objet conseiller
	 */
	public Conseiller getConseiller(String login) {
		try {
			PreparedStatement stmt = this.con.prepareStatement(
					"SELECT  idconseiller,nom,prenom,login,password,nbClients FROM conseiller WHERE login = ? ");
			stmt.setString(1, login);

			// Statement stmt = this.connect();
			// String sql = "SELECT idconseiller,nom,prenom,login,password,nbClients FROM
			// conseiller WHERE login = '"
			// + login + "'";

			// this.stmt = this.con.createStatement();
			ResultSet result = stmt.executeQuery();
			// Execution de la requete
			result.next();
			Conseiller leConseiller = new Conseiller();
			leConseiller.setIdConseiller(result.getInt("idconseiller"));
			leConseiller.setNom(result.getString("nom"));// Recuperation des donnees
			leConseiller.setPrenom(result.getString("prenom"));
			leConseiller.setLogin(result.getString("login"));
			leConseiller.setPassword(result.getString("password"));
			leConseiller.setNbClient(result.getInt("nbClients"));

			return leConseiller; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probleme lors de la recuperation du conseiller !");
			e.printStackTrace();
			return null;
		}
	}

}