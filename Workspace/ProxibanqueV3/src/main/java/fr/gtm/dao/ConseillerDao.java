package fr.gtm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gtm.domaine.*;

/**
 * Classe d'acces aux données pour le conseiller
 *
 */
public class ConseillerDao {

	private ConnectionDao conDao = new ConnectionDao();
	private Connection con = conDao.connect();
	private Statement st;
	private ResultSet result;


	public Conseiller getConseillerConseiller(Conseiller leConseiller) {
		try {
			String sql = "SELECT  idconseiller,nom,prenom,login,password,nbClient FROM conseiller WHERE login = '"
					+ leConseiller.getLogin() + "' and password = '" + leConseiller.getPassword() + "'";
			this.st = this.con.createStatement();
			this.result = this.st.executeQuery(sql); // Execution de la requete
			result.next();
			if (result.next()) {
				leConseiller.setIdConseiller(result.getInt("idconseiller"));
				leConseiller.setNom(result.getString("nom"));// Recuperation des donnees
				leConseiller.setPrenom(result.getString("prenom"));
				leConseiller.setLogin(result.getString("login"));
				leConseiller.setPassword(result.getString("password"));
				leConseiller.setNbClient(result.getInt("nbClient"));
				}else {
				leConseiller.setIdConseiller(0);
			}
			return leConseiller; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probleme lors de la recuperation du client !");
			e.printStackTrace();
			return leConseiller;
		}
	}

	/**
	 * Methode permettant d'obtenir un objet conseiller à partir de son login. Les informations du conseiller sont tirees de la base de données
	 * @param login
	 * @return
	 */
	public Conseiller getConseiller(String login) {
		try {
			String sql = "SELECT  idconseiller,nom,prenom,login,password,nbClient FROM conseiller WHERE login = '"
					+ login + "'";
			this.st = this.con.createStatement();
			this.result = this.st.executeQuery(sql); // Execution de la requete
			// result.next();
			Conseiller leConseiller = new Conseiller();
				leConseiller.setIdConseiller(result.getInt("idconseiller"));
				leConseiller.setNom(result.getString("nom"));// Recuperation des donnees
				leConseiller.setPrenom(result.getString("prenom"));
				leConseiller.setNbClient(result.getInt("nbClient"));
		
		
			return leConseiller; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probleme lors de la recuperation du client !");
			e.printStackTrace();
			return null;
		}
	}

}