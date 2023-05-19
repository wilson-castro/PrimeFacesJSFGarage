package utils;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
public abstract class DaoGenerico<T, PK> {
	
	private final EntityManager gerenciadorEntidades; 
	private final EntityManagerFactory fabricadorDeGerenciadorDeEntidades;
	
	private Class<?> clazz;
	
	
	//================================ CONSTRUCTORS ================================//
	
	public DaoGenerico() {
		this(JPAUtil.instanciaFabricadorDeGerenciadorDeEntidades());
	}
	
	public DaoGenerico(EntityManagerFactory factory) {
		this.fabricadorDeGerenciadorDeEntidades = factory;
		this.gerenciadorEntidades = factory.createEntityManager();
		this.clazz = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	//=========================== GENERIC CRUD METHODS =============================//
	
	public Object executaQuery(String query, Object... params) {
		Query createdQuery = this.gerenciadorEntidades.createQuery(query);
		
		for(int i = 0;i < params.length; i++) {
			createdQuery.setParameter(i, params[i]);
		}
		
		return createdQuery.getResultList();
		
	}
	
	public List<T> buscaTodos(){
		return this.getGerenciadorEntidades().createQuery(("FROM "+ this.clazz.getName()))
				.getResultList();
	}
	
	public T procurarPorId(PK pk) {
		return (T) this.gerenciadorEntidades.find(this.clazz, pk);
	}
	
	public void salva(T entity) {
		try {
			this.iniciaTransacao();
			this.gerenciadorEntidades.persist(entity);
			this.commitaTransacao();
		}catch(Exception e) {
			this.rollBack();
			throw e;
		}
	}
	
	public void atualiza(T entity) {
		try {
			this.iniciaTransacao();
			this.gerenciadorEntidades.merge(entity);
			this.commitaTransacao();
		}catch(Exception e) {
			this.rollBack();
			throw e;
		}
	}
	
	public void deleta(T entity) {
		try {
			this.iniciaTransacao();
			this.gerenciadorEntidades.remove(entity);
			this.commitaTransacao();
		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
		
	}
	
	//=========================== HANDLE TRANSACTIONS METHODS =============================//
	
	public void iniciaTransacao() {
		this.gerenciadorEntidades.getTransaction().begin();
	}
	
	public void commitaTransacao() {
		this.gerenciadorEntidades.getTransaction().commit();
	}
	
	public void fechaTransacao() {
		this.gerenciadorEntidades.close();
		this.fabricadorDeGerenciadorDeEntidades.close();
	}
	
	public void rollBack() {
		this.gerenciadorEntidades.getTransaction().rollback();
	}
	
	public EntityManager getGerenciadorEntidades() {
		return this.gerenciadorEntidades;
	}

}
