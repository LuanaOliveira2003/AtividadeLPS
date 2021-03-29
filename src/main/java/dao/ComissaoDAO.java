/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Comissao;
import dao.ConexaoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class ComissaoDAO {
    private static ComissaoDAO instancia;
    
    public static ComissaoDAO getInstance() {
        if (instancia == null) {
            instancia = new ComissaoDAO();
        }
        return instancia;
    }
    
    public ComissaoDAO() {
    }
    
    public ResultSet index() throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement(String.format("SELECT * FROM tbl_comissao"));
        ResultSet rs = ps.executeQuery();

        return rs;
    }
    
    public ResultSet deletar(Integer id) throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement("DELETE FROM tbl_comissao WHERE id_comissao = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }

    public int editar(Comissao comissao) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("comissao" + comissao.getId( ));
        try {
            if (comissao.getId() == 0) {
                ps = ConexaoDAO.connection().prepareStatement("INSERT INTO tbl_comissao (nome,valor) VALUES(?, ?)");
                ps.setString(1, comissao.getNome());
                ps.setFloat(2, comissao.getValor());

            } else {
                ps = ConexaoDAO.connection().prepareStatement("UPDATE tbl_comissao SET nome = ?, valor = ?WHERE id_comissao = ?");
                ps.setString(1, comissao.getNome());
                ps.setFloat(2, comissao.getValor());  
                ps.setInt(3, comissao.getId());
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
