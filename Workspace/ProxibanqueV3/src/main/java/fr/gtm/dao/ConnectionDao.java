package fr.gtm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * classe connection a la bdd
 * @author user
 *
 */
public class ConnectionDao {
	
	public Connection connect() {
		try {
			// Chargement du driver (dans le pilote)
			Class.forName("com.mysql.jdbc.Driver");

			// Connexion a la base de donnee
			String url = "jdbc:mysql://localhost:3306/proxibanquebdd";
			String login = "root";
			String mdp = "root";
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
