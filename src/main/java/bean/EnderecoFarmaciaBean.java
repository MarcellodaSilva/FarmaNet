package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import Service.EnderecoFarmaciaService;
import model.entity.EnderecoFarmacia;

@SuppressWarnings("deprecation")
@ManagedBean(name = "EnderecoFarmacia")
public class EnderecoFarmaciaBean implements Serializable{
private static final long serialVersionUID = 1L;
	private EnderecoFarmacia EnderecoFarmacia;
	private EnderecoFarmaciaService service;
	
	public EnderecoFarmacia getEnderecoFarmacia() {
		return EnderecoFarmacia;
	}
	public void setEnderecoFarmacia(EnderecoFarmacia enderecoFarmacia) {
		EnderecoFarmacia = enderecoFarmacia;
	}
	public EnderecoFarmaciaService getService() {
		return service;
	}
	public void setService(EnderecoFarmaciaService service) {
		this.service = service;
	}
	
	
}
