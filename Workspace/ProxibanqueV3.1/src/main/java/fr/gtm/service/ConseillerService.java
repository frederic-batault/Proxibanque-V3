package fr.gtm.service;

import java.io.Serializable;

import fr.gtm.dao.ConseillerDao;
import fr.gtm.domaine.Conseiller;

/**
 * Classe contenant les méthodes métier de gestion des conseillers
 *
 */
public class ConseillerService implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Méthode permettant de récupérer un conseiller (objet) à partir de son login
	 * @param Login login du conseiller recherché
	 * @return Conseiller
	 */
	public Conseiller getConseiller(String login) {
		// instanciation de la classe dao
		ConseillerDao refConseillerDao = new ConseillerDao();
		// appel de la méthode getConseiller d ela dao
		Conseiller refConseiller = refConseillerDao.getConseiller(login);
		return refConseiller;
	}

	/**
	 * Méthode permettant de vérifier le mot de passe d'un conseiller souhaitant se connecter.
	 * Récupère le mot de passe correspondant au login entré et le compare au mot de passe entré
	 * @param login login entré
	 * @param pwd mot de passe entré
	 * @return booléen indiquant si le mot de passe entré est bon ou pas
	 */
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
