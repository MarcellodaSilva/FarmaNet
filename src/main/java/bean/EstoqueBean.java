package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import Service.EstoqueService;
import model.entity.Estoque;

@SuppressWarnings("deprecation")
@ManagedBean(name = "Estoque")
public class EstoqueBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Estoque estoque;
	private EstoqueService service;
	
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	public EstoqueService getService() {
		return service;
	}
	public void setService(EstoqueService service) {
		this.service = service;
	}
	
	

}
