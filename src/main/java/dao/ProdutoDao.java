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
import javax.persistence.TypedQuery;

import exception.ValidacaoException;
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
		String hql = "DELETE FROM Usuario WHERE id = :id";
		Query query = manager.createQuery(hql);
		query.setParameter("id", id);
		int modificados = query.executeUpdate();
		if(modificados > 0) return true;
		else return false;
	}
	
	public List<Produto> Pesquisar(String nome) throws ValidacaoException{
		try {
		manager.getTransaction().begin();
		String sql = "select  p.valor p.nome p.descricao p.validade p.tipo p.marca from estoque_produto ep produto p \n" + 
				"         where ep.id_produto = p.id_produto and p.nome like '%:nome%'";
		TypedQuery<Produto> query = manager.createQuery(sql, Produto.class);
		query.setParameter("nome", nome);
		query.executeUpdate();
		manager.getTransaction().commit();
		return query.getResultList();
		}catch(Exception e) {
			e.getMessage();
			manager.getTransaction().rollback();
			throw new ValidacaoException("Deu erro em pesquisar ");
		}
		
	}

}
