package services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.daos.DAO;
import model.entities.Carro;

public class CarroService {
	
	private final DAO carroRepository;

	public CarroService() {
		this.carroRepository = new DAO();
	}
	
	public void salvar(Carro carro) {
		carroRepository.salva(carro);
	}
	
	public void salvarComDataString(Carro novoCarro, String data) {

		Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = new java.sql.Date( ((Date)formatter.parse(data)).getTime() );
        } catch (ParseException e) {            
            e.printStackTrace();
            System.out.println("Ocorreu um erro no método ´salvarShowComDataString´ : " + e.getLocalizedMessage());
        }
        
        novoCarro.setDataFabricacao(date);
        
		salvar(novoCarro);
	}
	
	public List<Carro> listarTodos() {
		return carroRepository.buscaTodos();
	}
	
	public Carro procuraPorId(Integer idCarro) {
		return carroRepository.procurarPorId(idCarro);
	}
	
	public void deleta(Integer idCarro) {
		carroRepository.deleta( procuraPorId(idCarro) );
	}

}
