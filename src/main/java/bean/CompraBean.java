package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;


import Service.CompraService;
import model.entity.Compra;
@SuppressWarnings("deprecation")
@ManagedBean(name = "Compra")

public class CompraBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Compra compra;
	private CompraService serviceCompra;
	
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public CompraService getServiceCompra() {
		return serviceCompra;
	}
	public void setServiceCompra(CompraService serviceCompra) {
		this.serviceCompra = serviceCompra;
	}
	
	
}
