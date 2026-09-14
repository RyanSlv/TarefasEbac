<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.Collection" %>
<%@ page import="br.com.ryans.domain.Cliente" %>
<%@ page import="br.com.ryans.service.ClienteService" %>
<%@ page import="br.com.ryans.service.IClienteService" %>

<%
    IClienteService clienteService = new ClienteService();

    String acao = request.getParameter("acao");

    String mensagem = "";

    Cliente clienteEdicao = null;

    if ("cadastrar".equals(acao)) {

        try {

            String nome = request.getParameter("nome");
            Long cpf = Long.valueOf(request.getParameter("cpf"));
            Long tel = Long.valueOf(request.getParameter("tel"));
            String endereco = request.getParameter("endereco");
            Integer numero = Integer.valueOf(request.getParameter("numero"));
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");

            Cliente cliente = new Cliente();

            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setTel(tel);
            cliente.setEndereco(endereco);
            cliente.setNumero(numero);
            cliente.setCidade(cidade);
            cliente.setEstado(estado);

            Boolean resultado = clienteService.cadastrar(cliente);

            if (resultado) {
                mensagem = "Cliente cadastrado com sucesso!";
            } else {
                mensagem = "Já existe um cliente cadastrado com este CPF.";
            }

        } catch (Exception e) {
            mensagem = "Erro ao cadastrar cliente.";
        }
    }

    if ("excluir".equals(acao)) {

        try {

            Long cpf = Long.valueOf(request.getParameter("cpf"));

            Cliente cliente = clienteService.consultar(cpf);

            if (cliente != null) {
                clienteService.excluir(cliente);
                mensagem = "Cliente excluído com sucesso!";
            }

        } catch (Exception e) {
            mensagem = "Erro ao excluir cliente.";
        }
    }

    if ("editar".equals(acao)) {

        try {

            Long cpf = Long.valueOf(request.getParameter("cpf"));

            clienteEdicao = clienteService.consultar(cpf);

        } catch (Exception e) {
            mensagem = "Erro ao localizar cliente.";
        }
    }

    if ("atualizar".equals(acao)) {

        try {

            String nome = request.getParameter("nome");
            Long cpf = Long.valueOf(request.getParameter("cpf"));
            Long tel = Long.valueOf(request.getParameter("tel"));
            String endereco = request.getParameter("endereco");
            Integer numero = Integer.valueOf(request.getParameter("numero"));
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");

            Cliente cliente = new Cliente();

            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setTel(tel);
            cliente.setEndereco(endereco);
            cliente.setNumero(numero);
            cliente.setCidade(cidade);
            cliente.setEstado(estado);

            Cliente atualizado = clienteService.alterar(cliente);

            if (atualizado != null) {
                mensagem = "Cliente atualizado com sucesso!";
            } else {
                mensagem = "Cliente não encontrado.";
            }

        } catch (Exception e) {
            mensagem = "Erro ao atualizar cliente.";
        }
    }

    Collection<Cliente> clientes = clienteService.buscarTodos();
%>

<!DOCTYPE html>

<html lang="pt-BR">

<head>

<meta charset="UTF-8">

<title>Cadastro de Clientes</title>

<style>

    body {
        font-family: Arial, sans-serif;
        background: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 90%;
        max-width: 1100px;
        margin: 40px auto;
        background: white;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 0 10px #cccccc;
    }

    h1 {
        text-align: center;
    }

    .formulario {
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 15px;
    }

    .campo {
        display: flex;
        flex-direction: column;
    }

    label {
        font-weight: bold;
        margin-bottom: 5px;
    }

    input {
        padding: 8px;
        font-size: 14px;
    }

    input[type=number]::-webkit-outer-spin-button,
    input[type=number]::-webkit-inner-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }

    input[type=number] {
        -moz-appearance: textfield;
        appearance: textfield;
    }

    button {
        margin-top: 20px;
        padding: 10px 20px;
        cursor: pointer;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        border: 1px solid #cccccc;
        padding: 8px;
        text-align: left;
    }

    th {
        background: #eeeeee;
    }

    .mensagem {
        padding: 10px;
        margin-bottom: 20px;
        background: #eeeeee;
        font-weight: bold;
    }

    .acoes a {
        margin-right: 10px;
    }

</style>

</head>

<body>

<div class="container">

<h1>Cadastro de Clientes</h1>

<%
    if (!mensagem.isEmpty()) {
%>

<div class="mensagem">
    <%= mensagem %>
</div>

<%
    }
%>

<%
    if (clienteEdicao == null) {
%>

<h2>Novo Cliente</h2>

<form method="post">

<input type="hidden" name="acao" value="cadastrar">

<div class="formulario">

<div class="campo">
<label>Nome</label>
<input type="text" name="nome" required>
</div>

<div class="campo">
<label>CPF</label>
<input type="number" name="cpf" required>
</div>

<div class="campo">
<label>Telefone</label>
<input type="number" name="tel" required>
</div>

<div class="campo">
<label>Endereço</label>
<input type="text" name="endereco" required>
</div>

<div class="campo">
<label>Número</label>
<input type="number" name="numero" required>
</div>

<div class="campo">
<label>Cidade</label>
<input type="text" name="cidade" required>
</div>

<div class="campo">
<label>Estado</label>
<input type="text" name="estado" required>
</div>

</div>

<button type="submit">
Cadastrar
</button>

</form>

<%
    } else {
%>

<h2>Editar Cliente</h2>

<form method="post">

<input type="hidden" name="acao" value="atualizar">

<div class="formulario">

<div class="campo">
<label>Nome</label>
<input
    type="text"
    name="nome"
    value="<%= clienteEdicao.getNome() %>"
    required>
</div>

<div class="campo">
<label>CPF</label>
<input
    type="number"
    name="cpf"
    value="<%= clienteEdicao.getCpf() %>"
    readonly>
</div>

<div class="campo">
<label>Telefone</label>
<input
    type="number"
    name="tel"
    value="<%= clienteEdicao.getTel() %>"
    required>
</div>

<div class="campo">
<label>Endereço</label>
<input
    type="text"
    name="endereco"
    value="<%= clienteEdicao.getEndereco() %>"
    required>
</div>

<div class="campo">
<label>Número</label>
<input
    type="number"
    name="numero"
    value="<%= clienteEdicao.getNumero() %>"
    required>
</div>

<div class="campo">
<label>Cidade</label>
<input
    type="text"
    name="cidade"
    value="<%= clienteEdicao.getCidade() %>"
    required>
</div>

<div class="campo">
<label>Estado</label>
<input
    type="text"
    name="estado"
    value="<%= clienteEdicao.getEstado() %>"
    required>
</div>

</div>

<button type="submit">
Atualizar
</button>

<a href="index.jsp">
Cancelar
</a>

</form>

<%
    }
%>

<hr>

<h2>Clientes cadastrados</h2>

<table>

<thead>

<tr>
<th>ID</th>
<th>Nome</th>
<th>CPF</th>
<th>Telefone</th>
<th>Endereço</th>
<th>Número</th>
<th>Cidade</th>
<th>Estado</th>
<th>Ações</th>
</tr>

</thead>

<tbody>

<%
    for (Cliente cliente : clientes) {
%>

<tr>

<td><%= cliente.getId() %></td>
<td><%= cliente.getNome() %></td>
<td><%= cliente.getCpf() %></td>
<td><%= cliente.getTel() %></td>
<td><%= cliente.getEndereco() %></td>
<td><%= cliente.getNumero() %></td>
<td><%= cliente.getCidade() %></td>
<td><%= cliente.getEstado() %></td>

<td class="acoes">

<a href="?acao=editar&cpf=<%= cliente.getCpf() %>">
Editar
</a>

<a href="?acao=excluir&cpf=<%= cliente.getCpf() %>">
Excluir
</a>

</td>

</tr>

<%
    }
%>

</tbody>

</table>

</div>

</body>

</html>