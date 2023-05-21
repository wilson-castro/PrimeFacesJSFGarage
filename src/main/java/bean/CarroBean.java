package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.entities.Carro;
import services.CarroService;

@Named
@ViewScoped
public class CarroBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CarroService carroService;
	@Inject
	private Carro carro;
	@Inject
	private List<Carro> carros;

	@PostConstruct
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

	public void add() {
		try {
			carroService.salvar(carro);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro:" + e.getMessage());
		}
	}
}
