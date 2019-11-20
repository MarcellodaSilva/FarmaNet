package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import Service.ProdutoService;
import model.entity.Produto;

@SuppressWarnings("deprecation")
@ManagedBean(name = "Produto")
public class ProdutoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Produto produto;
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
