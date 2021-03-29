/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Corretor;
import dao.ConexaoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class CorretorDAO {
    
    private static CorretorDAO instancia;
    
    public static CorretorDAO getInstance() {
        if (instancia == null) {
            instancia = new CorretorDAO();
        }
        return instancia;
    }
    
    public CorretorDAO() {
    }
     public ResultSet index() throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement(String.format("SELECT * FROM tbl_corretor"));
        ResultSet rs = ps.executeQuery();

        return rs;
    }
    
    public ResultSet deletar(Integer id) throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement("DELETE FROM tbl_corretor WHERE id_corretor = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }

    public int editar(Corretor corretor) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("corretor" + corretor.getId( ));
        try {
            if (corretor.getId() == 0) {
                ps = ConexaoDAO.connection().prepareStatement("INSERT INTO tbl_corretor (nome, cpf, endereco, idade, salario) VALUES(?, ?, ?, ?, ?)");
                ps.setString(1, corretor.getNome());
                ps.setString(2, corretor.getCpf());

                ps.setString(3, corretor.getEndereco());
                ps.setInt(4, corretor.getIdade());
                ps.setFloat(5, corretor.getSalario());
            } else {
                ps = ConexaoDAO.connection().prepareStatement("UPDATE tbl_corretor SET nome = ?, cpf = ?, endereco = ?, idade = ?, salario = ? WHERE id_corretor = ?");
                ps.setString(1, corretor.getNome());
                ps.setString(2, corretor.getCpf());
                ps.setString(3, corretor.getEndereco());
                ps.setInt(4, corretor.getIdade());
                ps.setFloat(5, corretor.getSalario());
                ps.setInt(6, corretor.getId());
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
