package fr.gtm.service;

import java.io.Serializable;

import fr.gtm.dao.ConseillerDao;
import fr.gtm.domaine.Conseiller;

/**
 * Classe contenant les m�thodes m�tier de gestion des conseillers
 *
 */
public class ConseillerService implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * M�thode permettant de r�cup�rer un conseiller (objet) � partir de son login
	 * @param Login login du conseiller recherch�
	 * @return Conseiller
	 */
	public Conseiller getConseiller(String login) {
		// instanciation de la classe dao
		ConseillerDao refConseillerDao = new ConseillerDao();
		// appel de la m�thode getConseiller d ela dao
		Conseiller refConseiller = refConseillerDao.getConseiller(login);
		return refConseiller;
	}

	/**
	 * M�thode permettant de v�rifier le mot de passe d'un conseiller souhaitant se connecter.
	 * R�cup�re le mot de passe correspondant au login entr� et le compare au mot de passe entr�
	 * @param login login entr�
	 * @param pwd mot de passe entr�
	 * @return bool�en indiquant si le mot de passe entr� est bon ou pas
	 */
	public boolean authentification(String login, String pwd) {
		// r�cup�ration du conseiller � partir du login
		Conseiller refConseiller = getConseiller(login);
		// r�cup�ration du mot de passe de la base
		String pwdBase = refConseiller.getPassword();
		// comparaison des mot de passes
		if (pwd.equals(pwdBase)) {
			return true;
		} else {
			return false;
		}
	}
}
