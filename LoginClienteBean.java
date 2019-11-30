package bean;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import Service.ClienteService;
import exception.ValidacaoException;
import model.entity.Cliente;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginClienteBean implements Serializable {
private static final long serialVersionUID = 1L;
	
	
	@Inject
	private ClienteService clienteService;
	
	private String login;
	
	private String senha;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public ClienteService getClienteService() {
		return clienteService;
	}
	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	public String loginCliente() {
		try{
			if(senha.trim().isEmpty() != true && login.trim().isEmpty() != true) {
				Cliente clientesession = clienteService.loginCliente(senha, login);
				if(clientesession != null) {
					FacesContext session = FacesContext.getCurrentInstance();
					session.getExternalContext().getSessionMap().put("cliente",clientesession);
					return "pagina_inicial?faces-redirect=true";
				}else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "erro!", "Email ou Senha Incorretos!"));
				}
		}
	
		}catch(Exception v) {
			v.getMessage();
		}
		return null;
			
	}
	public String Deslogar() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return"LoginCliente?faces-redirect=true";
	}
}
