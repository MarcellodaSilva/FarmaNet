package bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import Service.ClienteService;
import model.entity.Cliente;
import java.io.Serializable;

@Named
@ViewScoped
public class LoginClienteBean implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Inject
	private Cliente cliente ;
	
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ClienteService getClienteService() {
		return clienteService;
	}
	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	public String loginCliente() {
		if(senha.trim().isEmpty() != true && login.trim().isEmpty() != true) {
			FacesContext session = FacesContext.getCurrentInstance();
			session.getExternalContext().getSessionMap().put("email",cliente);
			return "CadastroCliente?faces-redirect=true";
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "erro!", "Email ou Senha Incorretos!"));
		}
		return null;
	}
	
	public String Deslogar() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return"paginaicial?faces-redirect=true";
	}
}
