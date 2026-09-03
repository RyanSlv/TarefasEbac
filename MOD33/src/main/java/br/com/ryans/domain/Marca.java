package br.com.ryans.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "TB_MARCA")
	public class Marca {
		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marca_seq")
		@SequenceGenerator(name = "marca_seq", sequenceName = "sq_marca", initialValue = 1, allocationSize = 1)
		private Long id;
		
		@Column(name = "Nome", length = 100, nullable = false)
		private String nome;
		
		@OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
		private List<Carro> carros;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public List<Carro> getCarros() {
			return carros;
		}

		public void setCarros(List<Carro> carros) {
			this.carros = carros;
		}
		
		
}
