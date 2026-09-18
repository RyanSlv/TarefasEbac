package br.com.ryans.vendas.online.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ryans.vendas.online.domain.Cliente;
import br.com.ryans.vendas.online.usecase.BuscaCliente;
import br.com.ryans.vendas.online.usecase.CadastroCliente;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

	
	private final BuscaCliente buscaCliente;
	private final CadastroCliente cadastroCliente;
	
	public ClienteResource(BuscaCliente buscarCliente, CadastroCliente cadastroCliente) {
	    this.buscaCliente = buscarCliente;
		this.cadastroCliente = cadastroCliente;
	}
	
	@GetMapping
	public ResponseEntity<Page<Cliente>> buscar(Pageable pageable) {
		return ResponseEntity.ok(buscaCliente.buscar(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable String id) {
		return ResponseEntity.ok(buscaCliente.buscarPorId(id));
	}
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<Cliente> buscarPorCpf(@PathVariable Long cpf) {
		return ResponseEntity.ok(buscaCliente.buscarPorCpf(cpf));
	}
	
	@GetMapping("/isCadastrado/{id}")
	public ResponseEntity<Boolean> isCadastrado(@PathVariable String id) {
		return ResponseEntity.ok(buscaCliente.isCadastrado(id));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok(cadastroCliente.cadastrar(cliente));
	}
	
	@PutMapping
	public ResponseEntity<Cliente> atualizar(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok(cadastroCliente.atualizar(cliente));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> remover(@PathVariable String id) {
		cadastroCliente.remover(id);
		return ResponseEntity.ok("Removido com sucesso");
	}
	
}
