package bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Service.ProdutoService;
import model.entity.Produto;

@Named
@ViewScoped
public class ProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produto produto;
	
	@Inject
	private ProdutoService service;
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public ProdutoService getService() {
		return service;
	}
	public void setService(ProdutoService service) {
		this.service = service;
	}
	
	

}
