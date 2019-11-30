package dao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.entity.Cliente;
import model.entity.EnderecoCliente;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class EnderecoClienteDao implements Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "farmanet")
	private EntityManager manager;
	private Dao<EnderecoCliente> dao;
	
	public EnderecoClienteDao() {}
	
	public EnderecoClienteDao(EntityManager manager) {
		dao = new Dao<EnderecoCliente>(manager, EnderecoCliente.class);
	}

	@PostConstruct
	private void initDao() {
		this.dao = new Dao<EnderecoCliente>(manager, EnderecoCliente.class);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adiciona(EnderecoCliente t) {
		 dao.adiciona(t);	
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remove(EnderecoCliente t) throws Exception {
		dao.remove(t);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public EnderecoCliente atualiza(EnderecoCliente t) throws Exception {
		return dao.atualiza(t);
	}
	
	
	public EnderecoCliente buscaPorId(Integer id) {
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
	public void adicionarClienteEndereco(Cliente cliente , EnderecoCliente  endereco) {
		endereco.setCliente(cliente);
		dao.adiciona(endereco);

	}
}
