package bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Service.EnderecoClienteService;
import model.entity.EnderecoCliente;

@Named
@ViewScoped
public class EnderecoCLienteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EnderecoCliente enderecoCliente;
	
	@Inject
	private EnderecoClienteService service;
	
	public EnderecoCliente getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(EnderecoCliente enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	public EnderecoClienteService getService() {
		return service;
	}
	public void setService(EnderecoClienteService service) {
		this.service = service;
	}
	
	
}
