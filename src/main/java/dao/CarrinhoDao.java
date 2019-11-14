package dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.Carrinho;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CarrinhoDao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "farmanet")
	private EntityManager manager; 
	private Dao<Carrinho> dao;
	
	public CarrinhoDao() {}

	public CarrinhoDao(EntityManager manager){
		dao = new Dao<Carrinho>(manager, Carrinho.class);
	}

	@PostConstruct
	private void initDao() {
		this.dao = new Dao<Carrinho>(manager, Carrinho.class);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Carrinho adiciona(Carrinho t) throws Exception {
		return dao.adiciona(t);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remove(Carrinho t) throws Exception {
		dao.remove(t);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Carrinho atualiza(Carrinho t) throws Exception {
		return dao.atualiza(t);
	}

	public List<Carrinho> listaTodos() {
		return dao.listaTodos();
	}

	public Carrinho buscaPorId(int id) {
		return dao.buscaPorId(id);
	}

}
