package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.daos.DAO;

public final class JPAUtil {
	private JPAUtil() {}
	
	
	//============================== ENTITY MANAGER FACTORY ==============================//

	private static final String  NOME_DA_UNIDADE_DE_PERSISTENCIA = "JSF-CRUD";
	
	private static EntityManagerFactory instanciaFabricadorDeGerenciadorDeEntidades;
	
	
	public static EntityManagerFactory instanciaFabricadorDeGerenciadorDeEntidades() {
		if (instanciaFabricadorDeGerenciadorDeEntidades == null) {
			instanciaFabricadorDeGerenciadorDeEntidades = Persistence.createEntityManagerFactory(NOME_DA_UNIDADE_DE_PERSISTENCIA);
		}
		
		return instanciaFabricadorDeGerenciadorDeEntidades;
	}
	
	//=============================== CARRO DAO FACTORY ===================================//
	
	private static DAO carroRepository;
	
	public static DAO instanciaCarroRepository(){
		if (carroRepository == null) {
			carroRepository = new DAO();
		}
		
		return carroRepository;
	}

}
