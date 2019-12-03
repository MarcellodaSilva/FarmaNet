package bean;

import Service.ProdutoService;

import exception.ValidacaoException;
import model.entity.Produto;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import utils.DataGridView;

@Named
@ViewScoped
public class PesquisaProdutoBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ProdutoService produtoService;
    private List<Produto> produtos;
    private String nomeProduto;
    private String imagem = "remedio";
    private Produto selectedProduto;

	

    public ProdutoService getProdutoService() {
        return produtoService;
    }

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Produto getSelectedProduto() {
		return selectedProduto;
	}

	public void setSelectedProduto(Produto selectedProduto) {
		this.selectedProduto = selectedProduto;
	}

	public String listarProdutos() throws ValidacaoException {
    	produtos= produtoService.pesquisar(nomeProduto);
    	return "resultado.xhtml?faces-redirect=true";
    }
}
