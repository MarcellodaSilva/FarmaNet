package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import Service.EnderecoClienteService;
import model.entity.EnderecoCliente;

@SuppressWarnings("deprecation")
@ManagedBean(name = "EnderecoCliente")
public class EnderecoCLienteBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private EnderecoCliente enderecoCliente;
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
