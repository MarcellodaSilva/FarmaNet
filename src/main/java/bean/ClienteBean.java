package bean;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Service.ClienteService;
import model.entity.Cliente;

@Named
@ViewScoped
public class ClienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cliente cliente ;
	
	@Inject
	private ClienteService clienteService;
	
	
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
	
	public String adicionarCliente() throws Exception {
		clienteService.cadastrarCliente(cliente);
		return "Cadastro Realizado Com Sucesso!";
	}
	
}
