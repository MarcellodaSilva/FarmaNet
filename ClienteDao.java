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
import model.entity.Cliente;
import model.entity.Compra;
import model.entity.Farmacia;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ClienteDao implements Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "farmanet")
	private EntityManager manager; 
	
	private Dao<Cliente> dao;
	
	public ClienteDao() {}
	
	public void ClienteDAO(EntityManager manager){
		dao = new Dao<Cliente>(manager, Cliente.class);
	}
	
	@PostConstruct
	private void initDao() {
		this.dao = new Dao<Cliente>(manager, Cliente.class);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adiciona(Cliente t)  {
		dao.adiciona(t);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remove(Cliente t) throws Exception {
		dao.remove(t);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Cliente atualiza(Cliente t) throws Exception {
		return dao.atualiza(t);
	}

	public List<Cliente> listaTodos() {
		return dao.listaTodos();
	}

	public Cliente buscaPorId(Integer id) {
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
	public void clienteCompra (Cliente t , List<Compra> compra) {
		t.setCompralist(compra);
		dao.adiciona(t);
	}
	public Cliente loginCliente(String senha , String login)  {
		try {
			String sql = "select c from Cliente c where c.senha =:senha and c.login =:login";
			TypedQuery<Cliente> query = manager.createQuery(sql , Cliente.class);
			query.setParameter("senha",senha);
			query.setParameter("login",login);
			Cliente cliente = query.getSingleResult();
			if(cliente != null && cliente.getLogin().equals(login) && cliente.getSenha().equals(senha)) {
				return cliente;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return null;
			
	}
	

}
