package bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Service.EnderecoFarmaciaService;
import model.entity.EnderecoFarmacia;

@Named
@ViewScoped
public class EnderecoFarmaciaBean implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
    @Inject
	private EnderecoFarmacia EnderecoFarmacia;
	
    @Inject
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
