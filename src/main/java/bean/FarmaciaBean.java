package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

import Service.FarmaciaService;
import model.entity.Farmacia;

@SuppressWarnings("deprecation")
@ManagedBean(name = "Farmacia")
@NoneScoped
public class FarmaciaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Farmacia farmacia;
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
