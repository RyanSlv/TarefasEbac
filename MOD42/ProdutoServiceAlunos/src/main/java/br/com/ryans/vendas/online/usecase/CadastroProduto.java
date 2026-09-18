package br.com.ryans.vendas.online.usecase;

import org.springframework.stereotype.Service;

import br.com.ryans.vendas.online.domain.Produto;
import br.com.ryans.vendas.online.domain.Produto.Status;
import br.com.ryans.vendas.online.repository.IProdutoRepository;

@Service
public class CadastroProduto {

    private final IProdutoRepository produtoRepository;

    public CadastroProduto(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrar(Produto produto) {
        produto.setStatus(Status.ATIVO);
        return produtoRepository.insert(produto);
    }

    public Produto atualizar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void remover(String id) {
        Produto produto = produtoRepository.findById(id).orElseThrow();

        produto.setStatus(Status.INATIVO);
        produtoRepository.save(produto);
    }
}