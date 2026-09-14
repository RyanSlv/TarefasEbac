package br.com.ryans.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.ryans.domain.Cliente;

public class ClienteDAO implements IClienteDAO {

    private static final List<Cliente> clientes = new ArrayList<>();

    private static Long proximoId = 1L;

    @Override
    public Boolean cadastrar(Cliente cliente) {

        Cliente clienteCadastrado = consultar(cliente.getCpf());

        if (clienteCadastrado != null) {
            return false;
        }

        cliente.setId(proximoId++);
        clientes.add(cliente);
        return true;
    }

    @Override
    public void excluir(Cliente cliente) {
        clientes.remove(cliente);
    }

    @Override
    public Cliente alterar(Cliente cliente) {

        Cliente clienteCadastrado = consultar(cliente.getCpf());

        if (clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setEndereco(cliente.getEndereco());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
            return clienteCadastrado;
        }
        return null;
    }

    @Override
    public Cliente consultar(Long cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return new ArrayList<>(clientes);
    }
}