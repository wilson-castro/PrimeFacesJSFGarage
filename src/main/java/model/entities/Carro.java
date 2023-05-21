package model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.enums.TipoCombustivel;

@Entity
@Table(name="carros")
public class Carro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataFabricacao;
	
	@Column(nullable = false)
	private Float velocidadeMaxima;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private TipoCombustivel combustivel;
	
	public Carro() {
		super();

	}
	public Carro( String modelo, String marca, Date dataFabricacao, Float velocidadeMaxima, TipoCombustivel combustivel) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.dataFabricacao = dataFabricacao;
		this.velocidadeMaxima = velocidadeMaxima;
		this.combustivel = combustivel;
	}

	public Carro(Integer id, String modelo, String marca, Date dataFabricacao, Float velocidadeMaxima, TipoCombustivel combustivel) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.dataFabricacao = dataFabricacao;
		this.velocidadeMaxima = velocidadeMaxima;
		this.combustivel = combustivel;
	}



	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Float getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(Float velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public TipoCombustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(TipoCombustivel combustivel) {
		this.combustivel = combustivel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
