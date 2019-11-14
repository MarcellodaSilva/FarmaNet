package dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.entity.Cliente;
import model.entity.Compra;
import model.entity.Estoque;
import model.entity.Historico;
import model.entity.Produto;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CompraDao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "farmanet")
	private EntityManager manager;
	private Dao<Compra> dao;
	
	public CompraDao() {}
	public CompraDao(EntityManager manager){
		dao = new Dao<Compra>(manager, Compra.class);
	}
	
	@PostConstruct
	private void initDao() {
		this.dao = new Dao<Compra>(manager, Compra.class);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Compra adiciona(Compra t) throws Exception {
		return dao.adiciona(t);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remove(Compra t) throws Exception {
		dao.remove(t);
	}

	public Compra atualiza(Compra t) throws Exception {
		return dao.atualiza(t);
	}

	public List<Compra> listaTodos() {
		return dao.listaTodos();
	}

	public Compra buscaPorId(int id) {
		return dao.buscaPorId(id);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Compra CompraCliente (Compra compra , List<Cliente> cliente) throws Exception {
		compra.setClientelist(cliente);
		return dao.adiciona(compra);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Compra CompraEstoque (Compra compra , Estoque estoque) throws Exception {
		compra.setEstoque(estoque);
		return dao.adiciona(compra);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Compra CompraProduto (Compra compra , Produto produto) throws Exception {
		compra.setProduto(produto);
		return dao.adiciona(compra);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Compra CompraHistorico(Compra t , Historico historico) throws Exception {
		t.setHistoricoList(historico);
		return dao.adiciona(t);
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Compra CompraPassandoProdutoEstoqueClienteHistorico(Compra compra , Produto produto , Estoque estoque , List<Cliente> cliente , Historico historico ) throws Exception {
		compra.setClientelist(cliente);
		compra.setEstoque(estoque);
		compra.setProduto(produto);
		compra.setHistoricoList(historico);
		return dao.adiciona(compra);
	}

}
