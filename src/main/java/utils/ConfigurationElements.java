package utils;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import bean.LoginBean;

@Named
@RequestScoped
public class ConfigurationElements implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoginBean login;

	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}
	
	public boolean UsuarioCadastrado() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		if(sessionMap.isEmpty())	
		return true;
		
		return false;
	}
	public boolean menuusuario() {
		if (!UsuarioCadastrado()) {//retorna false siginifica que existe usuario na sessão
			return true;
		}
		
		return false;
	}

}
