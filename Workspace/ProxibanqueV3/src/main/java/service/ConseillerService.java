package service;

import java.io.Serializable;

import domaine.Conseiller;

public class ConseillerService implements Serializable {

	private static final long serialVersionUID = 1L;

	public Conseiller getConseiller(String Login) {
		// instanciation du conseiller en attendant la DAO
		Conseiller refConseiller = new Conseiller(1, "nom", "prenom", "prenom.nom", "123");
		return refConseiller;
	}

	public boolean authentification(String login, String pwd) {
		// récupération du conseiller à partir du login
		Conseiller refConseiller = getConseiller(login);
		// récupération du mot de passe de la base
		String pwdBase = refConseiller.getPassword();
		// comparaison des mot de passes
		if (pwd.equals(pwdBase)) {
			return true;
		} else {
			return false;
		}
	}
}
