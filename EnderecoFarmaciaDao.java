package dao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.entity.EnderecoFarmacia;
import model.entity.Farmacia;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class EnderecoFarmaciaDao implements Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "farmanet")
	private EntityManager manager;
	private Dao<EnderecoFarmacia> dao;
	
	public EnderecoFarmaciaDao() {}
	
	public EnderecoFarmaciaDao(EntityManager manager) {
		dao = new Dao<EnderecoFarmacia>(manager, EnderecoFarmacia.class);
	}
	
	@PostConstruct
	private void initDao() {
		this.dao = new Dao<EnderecoFarmacia>(manager, EnderecoFarmacia.class);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adiciona(EnderecoFarmacia t)  {
		 dao.adiciona(t);	
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remove(EnderecoFarmacia t) throws Exception {
		dao.remove(t);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public EnderecoFarmacia atualiza(EnderecoFarmacia t) throws Exception {
		return dao.atualiza(t);
	}
	
	public EnderecoFarmacia buscaPorId(Integer id) {
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
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void EnderecoFarmaciaFarmacia (EnderecoFarmacia t , Farmacia farmacia) {
		t.setFarmacia(farmacia);
		 dao.adiciona(t);
	}
}
