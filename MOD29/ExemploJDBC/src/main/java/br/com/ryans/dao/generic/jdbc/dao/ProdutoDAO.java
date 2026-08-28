package br.com.ryans.dao.generic.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ryans.dao.generic.jdbc.ConnectionFactory;
import br.com.ryans.domain.Produto;

public class ProdutoDAO implements IProdutoDAO {
	
	@Override 
	public Integer cadastrar(Produto produto) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;	
		try {
			connection = ConnectionFactory.getConnection();
			String sql = getSqlInsert();
			stm = connection.prepareStatement(sql);
			adicionarParametrosInsert(stm, produto);
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}	finally {
			closeConnection(connection, stm, null);
		}
	}


	@Override
	public Integer atualizar(Produto produto) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		try { 
			connection = ConnectionFactory.getConnection();
			String sql = getSqlUpdate();
			stm = connection.prepareStatement(sql);
			adicionarParametrosUpdate(stm, produto);
			return stm.executeUpdate();
		}	catch (Exception e) {
			throw e;
		}	finally {
			closeConnection(connection, stm, null);

		}
	}
	

	@Override
	public Produto buscar(Integer id) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Produto produto = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = getSqlSelect();
			stm = connection.prepareStatement(sql);
			adicionarParametrosSelect(stm, id);
			rs = stm.executeQuery();
			
			if (rs.next()) {
				produto = new Produto();
				Integer codigo = rs.getInt("ID");
				String nome = rs.getString("NOME");
				Double preco = rs.getDouble("PRECO");
				Integer quantidade = rs.getInt("QUANTIDADE");
				
				produto.setId(codigo);
				produto.setNome(nome);
				produto.setPreco(preco);
				produto.setQuantidade(quantidade);
				
			}
		}	catch (Exception e) {
			throw e;
		}	finally {
			closeConnection(connection, stm, rs);
		}	return produto;
	}
	

	@Override 
	public Integer excluir(Produto produto) throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = getSqlDelete();
			stm = connection.prepareStatement(sql);
			adicionarParametrosDelete(stm, produto);
			return stm.executeUpdate();
		}	catch (Exception e) {
			throw e; 
		}	finally {
			closeConnection(connection, stm, null);
		}
	}


	@Override
	public List<Produto> buscarTodos() throws Exception {
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		List<Produto> list = new ArrayList<>();
		Produto produto = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = getSqlSelectAll();
			stm = connection.prepareStatement(sql);
			rs = stm.executeQuery();
			
			while (rs.next()) {
				produto = new Produto();
				
				Integer id = rs.getInt("ID");
				String nome = rs.getString("NOME");
				Double preco = rs.getDouble("PRECO");
				Integer quantidade = rs.getInt("QUANTIDADE");
				
				produto.setId(id);
				produto.setNome(nome);
				produto.setPreco(preco);
				produto.setQuantidade(quantidade);
				
				list.add(produto);
			}
		}	catch (Exception e) {
			throw e;
		}	finally {
			closeConnection(connection, stm, rs);
		}
		return list;
	}

	private String getSqlSelectAll() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM PRODUTOS");
		return sb.toString();
	}
	
	private String getSqlUpdate() {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE PRODUTOS ");
		sb.append("SET NOME = ?, PRECO = ?, QUANTIDADE = ? ");
		sb.append("WHERE ID = ?");
		return sb.toString();
	}
	
	private String getSqlDelete() {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM PRODUTOS ");
		sb.append("WHERE ID = ?");
		return sb.toString();
	}
	
	private String getSqlSelect() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM PRODUTOS  ");
		sb.append("WHERE ID =  ?");
		return sb.toString();
	}
	
	private String getSqlInsert() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO PRODUTOS (NOME, PRECO, QUANTIDADE)");
		sb.append(" VALUES (?, ?, ?)");
		return sb.toString();
	}
	
	private void adicionarParametrosUpdate(PreparedStatement stm, Produto produto) throws SQLException {
		stm.setString(1,produto.getNome());
		stm.setDouble(2,produto.getPreco());
		stm.setInt(3,produto.getQuantidade());
		stm.setInt(4,produto.getId());

	}
	
	private void adicionarParametrosInsert(PreparedStatement stm, Produto produto) throws SQLException {
		stm.setString(1, produto.getNome());
		stm.setDouble(2, produto.getPreco());
		stm.setInt(3, produto.getQuantidade());
	}
	
	private void adicionarParametrosSelect(PreparedStatement stm, Integer id) throws SQLException {
		stm.setInt(1, id);
	}
	
	private void adicionarParametrosDelete(PreparedStatement stm, Produto produto) throws SQLException {
		stm.setInt(1, produto.getId());
	}
	
	private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}	catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

