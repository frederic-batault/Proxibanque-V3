package fr.gtm.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import fr.gtm.service.ConseillerService;

@ManagedBean(name = "loginBean")
public class LoginBean implements Serializable {

	// propri�t�s
	private String login;
	private String motDePasse;
	private static final long serialVersionUID = 1L;

	// m�thodes get/set
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	// constructeurs
	public LoginBean(String login, String motDePasse) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
	}

	public LoginBean() {
		super();
	}

	// M�thode de taitement
	public Object authentification() {
		// instanciation de la classe service
		ConseillerService refConseillerService = new ConseillerService();
		// appel de la m�thode service pour v�rifier si le mot de passe entr� est bon
		boolean authentifie = refConseillerService.authentification(login, motDePasse);
		// envoi � la bonne page en fonction du r�sultat
		if (authentifie == true) {

			return "conseiller";

		} else {
			return "erreurConnexion";
		}
	}
}
