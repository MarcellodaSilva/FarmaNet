package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

import Service.CarrinhoService;
import model.entity.Carrinho;

@SuppressWarnings("deprecation")
@ManagedBean(name = "Carrinho")

public class CarrinhoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Carrinho carrinho ;
	private CarrinhoService servidorCarrinho;
	
	
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	public CarrinhoService getServidorCarrinho() {
		return servidorCarrinho;
	}
	public void setServidorCarrinho(CarrinhoService servidorCarrinho) {
		this.servidorCarrinho = servidorCarrinho;
	}
}