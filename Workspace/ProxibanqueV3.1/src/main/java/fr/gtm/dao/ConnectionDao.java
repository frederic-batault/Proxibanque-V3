package fr.gtm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * classe connection a la bdd
 * 
 *
 */
public class ConnectionDao {
	
	/**
	 * @return objet de type connection utilise par les autres methodes de la couche DAO
	 */
	public Connection connect() {
		try {
			// Chargement du driver (dans le pilote)
			Class.forName("com.mysql.jdbc.Driver");

			// Connexion a la base de donnee
			String url = "jdbc:mysql://localhost:3306/proxibanquebddv3";
			String login = "root";
			String mdp = "";
			Connection connection = DriverManager.getConnection(url, login, mdp);

			return connection;
		} catch (ClassNotFoundException e) {
			System.out.println("Probleme chargement du driver !");
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			System.out.println("Probleme de connexion a la base de donnee !");
			e.printStackTrace();
			return null;
		}
	}
	
}
