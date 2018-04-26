package fr.gtm.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;


@ManagedBean(name = "redirectionModifBean")
public class redirectionModif implements Serializable {
	private static final long serialVersionUID = 1L;

	public Object rediriger() {
		return "ModifClient";
	}
}
