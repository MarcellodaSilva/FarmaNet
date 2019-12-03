package utils;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Service.ProdutoService;
import exception.ValidacaoException;
import model.entity.Produto;

@Named
@ViewScoped
public class DataGridView implements Serializable {
     
	private static final long serialVersionUID = 1L;

	private List<Produto> produtos;
	private String imagem = "remedio";
     
    public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	private Produto selectedProduto;
     
    @Inject
    private ProdutoService produtoService;

	public Produto getSelectedProduto() {
		return selectedProduto;
	}

	public void setSelectedProduto(Produto selectedProduto) {
		this.selectedProduto = selectedProduto;
	}

	public void setProdutoServivce(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
     
    public String listarProdutos(String produto) throws ValidacaoException {
    	produtos= produtoService.pesquisar(produto);
    	return "resultado.xhtml?faces-redirect=true";
    }
 
   
}