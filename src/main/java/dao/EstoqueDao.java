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

import model.entity.Estoque;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class EstoqueDao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "farmanet")
	private EntityManager manager;
	private Dao<Estoque> dao;
	
	public EstoqueDao() {}

	public EstoqueDao(EntityManager manager){
		dao = new Dao<Estoque>(manager, Estoque.class);
	}
	
	@PostConstruct
	private void initDao() {
		this.dao = new Dao<Estoque>(manager, Estoque.class);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Estoque adiciona(Estoque t) throws Exception {
		return dao.adiciona(t);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remove(Estoque t) throws Exception {
		dao.remove(t);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Estoque atualiza(Estoque t) throws Exception {
		return dao.atualiza(t);
	}

	public List<Estoque> listaTodos() {
		return dao.listaTodos();
	}

	public Estoque buscaPorId(int id) {
		return dao.buscaPorId(id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean removePorID(Integer id) {
		manager.getTransaction().begin();
		try{
			String sql = "Delete From Estoque e Where e.id_estoque = :idEstoque";
			Query query = manager.createQuery(sql);
			query.setParameter("idEstoque",id);
			query.executeUpdate();
			manager.getTransaction().commit();
			return true;
		}catch(RuntimeException e){
			manager.getTransaction().rollback();
			throw e;
		}
	}
}
