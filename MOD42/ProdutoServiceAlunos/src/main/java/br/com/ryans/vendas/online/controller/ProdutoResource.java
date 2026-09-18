package br.com.ryans.vendas.online.controller;

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

import br.com.ryans.vendas.online.domain.Produto;
import br.com.ryans.vendas.online.domain.Produto.Status;
import br.com.ryans.vendas.online.usecase.BuscaProduto;
import br.com.ryans.vendas.online.usecase.CadastroProduto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {

    private final BuscaProduto buscaProduto;
    private final CadastroProduto cadastroProduto;

    public ProdutoResource(BuscaProduto buscaProduto, CadastroProduto cadastroProduto) {
        this.buscaProduto = buscaProduto;
        this.cadastroProduto = cadastroProduto;
    }

    @GetMapping
    public ResponseEntity<Page<Produto>> buscar(Pageable pageable) {
        return ResponseEntity.ok(buscaProduto.buscar(pageable));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Page<Produto>> buscarPorStatus(Pageable pageable,@PathVariable Status status) {

        return ResponseEntity.ok(buscaProduto.buscar(pageable, status));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> buscarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(buscaProduto.buscarPorCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody @Valid Produto produto) {

        return ResponseEntity.ok(cadastroProduto.cadastrar(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> atualizar(@RequestBody @Valid Produto produto) {

        return ResponseEntity.ok(cadastroProduto.atualizar(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable String id) {
        cadastroProduto.remover(id);
        return ResponseEntity.ok("Produto inativado com sucesso");
    }
}