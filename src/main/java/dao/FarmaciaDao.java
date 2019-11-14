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

import model.entity.Farmacia;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class FarmaciaDao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "farmanet")
	private EntityManager manager; 
	private Dao<Farmacia> dao;
	
	
	public FarmaciaDao() {}

	public FarmaciaDao(EntityManager manager){
		dao = new Dao<Farmacia>(manager, Farmacia.class);
	}

	@PostConstruct
	private void initDao() {
		this.dao = new Dao<Farmacia>(manager, Farmacia.class);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Farmacia adiciona(Farmacia t) throws Exception {
		return 
				dao.adiciona(t);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remove(Farmacia t) throws Exception {
		dao.remove(t);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Farmacia atualiza(Farmacia t) throws Exception {
		return dao.atualiza(t);
	}

	public List<Farmacia> listaTodos() {
		return dao.listaTodos();
	}

	public Farmacia buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean removePorID(Integer id) {
		manager.getTransaction().begin();
		try{
			String sql = "Delete From farmacia f Where f.id_farmacia = :idFarmacia";
			Query query = manager.createQuery(sql);
			query.setParameter("idFarmacia",id);
			query.executeUpdate();
			manager.getTransaction().commit();
			return true;
		}catch(RuntimeException e){
			manager.getTransaction().rollback();
			throw e;
		}
	}

}
