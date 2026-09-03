package br.com.ryans.domain;

import jakarta.persistence.*;

	@Entity
	@Table(name = "TB_ACESSORIO")
	public class Acessorio {

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio_seq")
		@SequenceGenerator(name = "acessorio_seq", sequenceName = "sq_acessorio", initialValue = 1, allocationSize = 1)
		private Long id;
		
		@Column(name = "Nome", length = 100, nullable = false)
		private String nome;
		
		@ManyToOne
		@JoinColumn(name = "carro_id", nullable = false)
		private Carro carro;

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

		public Carro getCarro() {
			return carro;
		}

		public void setCarro(Carro carro) {
			this.carro = carro;
		}
		
		
}
