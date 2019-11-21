package bean;

import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;

import Service.FarmaciaService;
import model.entity.Farmacia;

@Named
public class FarmaciaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Farmacia farmacia;
	
	@Inject
	private FarmaciaService service;
	
	
	public Farmacia getFarmacia() {
		return farmacia;
	}
	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}
	public FarmaciaService getService() {
		return service;
	}
	public void setService(FarmaciaService service) {
		this.service = service;
	}

	
}
