package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.entities.Carro;
import services.CarroService;

@Named(value = "carroBean")
@SessionScoped
public class Bean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public CarroService carroService;
	
	@Inject
	private Carro carro;
	
	private List<Carro> carros = new ArrayList<>();
	
	@PostConstruct
	public void load() {
		carros = carroService.listarTodos();
	}

	public String adicionar() {
		try {
			carroService.salvar(carro);
			
			carro = new Carro();
			
			return "listagem";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ocorreu um erro:" + e.getMessage());
			
			return null;
		}
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

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
}