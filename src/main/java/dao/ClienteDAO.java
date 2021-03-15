/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Classes.Cliente;
import dao.ConexaoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class ClienteDAO {
    private static ClienteDAO instancia;
    
    public static ClienteDAO getInstance() {
        if (instancia == null) {
            instancia = new ClienteDAO();
        }
        return instancia;
    }
    
    public ClienteDAO() {
    }
    
    public ResultSet index() throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement(String.format("SELECT * FROM tbl_cliente"));
        ResultSet rs = ps.executeQuery();

        return rs;
    }
    
    public ResultSet deletar(Integer id) throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement("DELETE FROM tbl_cliente WHERE id_cliente = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }

    public int editar(Cliente cliente) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("cliente" + cliente.getId( ));
        try {
            if (cliente.getId() == 0) {
                ps = ConexaoDAO.connection().prepareStatement("INSERT INTO tbl_cliente (nome, cpf, endereco, idade) VALUES(?, ?, ?, ?)");
                ps.setString(1, cliente.getNome());
                ps.setString(2, cliente.getCpf());

                ps.setString(3, cliente.getEndereco());
                ps.setInt(4, cliente.getIdade());
                
            } else {
                ps = ConexaoDAO.connection().prepareStatement("UPDATE tbl_cliente SET nome = ?, cpf = ?, endereco = ?, idade = ? WHERE id_cliente = ?");
                ps.setString(1, cliente.getNome());
                ps.setString(2, cliente.getCpf());
                ps.setString(3, cliente.getEndereco());
                ps.setInt(4, cliente.getIdade());
                ps.setInt(5, cliente.getId());
            }

        } catch (SQLException e) {
            System.out.println(e + "error");
        }
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        int idx = 0;
        if (rs.next()) {
            idx = rs.getInt(1);
        }
        return idx;
    }
    
}
