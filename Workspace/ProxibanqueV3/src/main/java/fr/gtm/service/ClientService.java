package fr.gtm.service;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import fr.gtm.dao.*;
import fr.gtm.domaine.*;

@ManagedBean(name = "clientService")
public class ClientService {

	ClientDao dao = new ClientDao();

	/**
	 * methode qui nous permet de creer un client
	 * 
	 * @param leClient objet client contanant les proprietes du client a creer
	 * @return booleen indiquant le succes ou l'echec de la creation
	 */
	public boolean createClient(ClientDomaine leClient) {
		boolean reponse = dao.createClient(leClient);
		return reponse; // retour de la reponse
	}

	/**
	 * methode qui nous permet d'afficher un client
	 * 
	 * @param idClient numero identifiant du client dont on souhaite lire les informations
	 * @return objet client contenant les informations du client
	 */
	public ClientDomaine getClient(int idClient) {
		ClientDomaine refClient = new ClientDomaine(idClient, "", "", "", "", "", "", 0);
		ClientDomaine leClient = dao.getClient(refClient);
		;
		return leClient;
	}

	/**
	 * methode qui nous permet de mettre a jour un client
	 * 
	 * @param leClient objet client contenant les nouvelles informations du client
	 * @return
	 */
	public ClientDomaine updateClient(ClientDomaine leClient) {
		leClient = dao.updateClient(leClient.getIdClient());
		return leClient;
	}

	/**
	 * methode qui nous permet de supprimer un client
	 * 
	 * @param leClient objet client contenant l'identifiant du client a supprimer
	 * @return booleen indiquant le succes ou l'echec de la suppression
	 */
	public boolean deleteClient(ClientDomaine leClient) {
		boolean reponse = dao.deleteClient(leClient);
		return reponse; // retour de la réponse
	}

	/**
	 * methode qui nous permet d'afficher la liste des clients d'un conseiller donne
	 * 
	 * @param c objet conseiller contenant l'identifiant du conseiller dont on souhaite connaitre les clients et leurs informations
	 * @return liste d'objet clients
	 */
	public ArrayList<ClientDomaine> getAllClient(Conseiller c) {
		ArrayList<ClientDomaine> listClients = dao.getAllClient(c);
		return listClients;
	}

}
