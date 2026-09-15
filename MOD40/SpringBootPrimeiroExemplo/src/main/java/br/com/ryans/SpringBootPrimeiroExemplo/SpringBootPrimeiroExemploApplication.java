package br.com.ryans.SpringBootPrimeiroExemplo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.ryans.domain.Cliente;
import br.com.ryans.repository.IClienteRepository;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.ryans.repository")
@EntityScan("br.com.ryans.*")
@ComponentScan(basePackages = "br.com.ryans")
public class SpringBootPrimeiroExemploApplication implements CommandLineRunner{
	
	 private static final Logger log =
	            LoggerFactory.getLogger(SpringBootPrimeiroExemploApplication.class);

	    @Autowired
	    private IClienteRepository repository;

	    public static void main(String[] args) {
	        SpringApplication.run(SpringBootPrimeiroExemploApplication.class, args);
	    }

	    @Override
	    public void run(String... args) throws Exception {
	        log.info("StartApplication...");

	        Cliente cliente = createCliente();
	        repository.save(cliente);
	    }

	    private Cliente createCliente() {
	        return Cliente.builder()
	                .cidade("SP")
	                .cpf(11122233344L)
	                .email("Teste@teste.com")
	                .end("End")
	                .estado("SP")
	                .nome("Teste Spring Boot")
	                .numero(102030)
	                .tel(1122222222L)
	                .build();
	    }
	}