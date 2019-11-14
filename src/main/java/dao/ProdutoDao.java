package dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.entity.Produto;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ProdutoDao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "farmanet")
	private EntityManager manager;
	private Dao<Produto> dao;
	
	public ProdutoDao() {}

	public ProdutoDao(EntityManager manager){
		dao = new Dao<Produto>(manager, Produto.class);
	}
	
	@PostConstruct
	private void initDao() {
		this.dao = new Dao<Produto>(manager, Produto.class);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Produto adiciona(Produto t) throws Exception {
		return dao.adiciona(t);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remove(Produto t) throws Exception {
		dao.remove(t);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Produto atualiza(Produto t) throws Exception {
		return dao.atualiza(t);
	}

	
	public List<Produto> listaTodos() {
		return dao.listaTodos();
	}

	public Produto buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	} 
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean removePorID(Integer id) {
		manager.getTransaction().begin();
		try{
			String sql = "Delete From Produto p Where p.id_produto = :idProduto";
			Query query = manager.createQuery(sql);
			query.setParameter("idProduto",id);
			query.executeUpdate();
			manager.getTransaction().commit();
			return true;
		}catch(RuntimeException e){
			manager.getTransaction().rollback();
			throw e;
		}
	}

}
