package bean;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Service.ClienteService;
import exception.ValidacaoException;
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
	
	public String loginCliente()  {
		try {
			if(clienteService.loginCliente(senha, login) == 1) {
				return "PaginaInicial";
			}
			return "LoginCliente"; 
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return "LoginCliente";
	}
}
