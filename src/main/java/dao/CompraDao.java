package dao;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.entity.Compra;

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

	public Compra adiciona(Compra t) throws Exception {
		return dao.adiciona(t);
	}

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

}
