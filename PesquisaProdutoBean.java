package bean;

import Service.ProdutoService;
import exception.ValidacaoException;
import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.entity.Produto;

@Named
@ViewScoped
public class PesquisaProdutoBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ProdutoService produtoService;
    
    private String nomeProduto;

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
    
     public List<Produto> pesquisaProduto() throws ValidacaoException{
     return  produtoService.pesquisar(nomeProduto);   
    }
}
