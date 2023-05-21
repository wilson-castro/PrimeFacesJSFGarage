package Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import model.entities.Carro;
import services.CarroService;

@ManagedBean
public class CarroBean {

	
	@Inject
	public CarroService carroService;
	@Inject
	public Carro carro;
	
	public List<Carro> carros;

	public void load() {
		carros = carroService.listarTodos();
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void adicionar() {
		try {
			carroService.salvar(carro);
			carro = new Carro();
			
		} catch (Exception e) {
			System.out.println("Ocorreu um erro:" + e.getMessage());
		}
	}
}