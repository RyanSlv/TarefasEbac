package br.com.ryans.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_CARRO")
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
	@SequenceGenerator(name = "carro_seq", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "Modelo", length = 100, nullable = false)
	private String modelo;
	
	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca; 
	
	@OneToMany(mappedBy = "carro", cascade = CascadeType.ALL)
	private List<Acessorio> acessorios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	
	
}
