package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import Service.HistoricoService;
import model.entity.Historico;

@SuppressWarnings("deprecation")
@ManagedBean(name = "Historico")
public class HistoricoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Historico historico;
	private HistoricoService service;
	public Historico getHistorico() {
		return historico;
	}
	public void setHistorico(Historico historico) {
		this.historico = historico;
	}
	public HistoricoService getService() {
		return service;
	}
	public void setService(HistoricoService service) {
		this.service = service;
	}
	
	

}
