/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Classes.Imovel;
import dao.ConexaoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class ImovelDAO {
    private static ImovelDAO instancia;
    
    public static ImovelDAO getInstance() {
        if (instancia == null) {
            instancia = new ImovelDAO();
        }
        return instancia;
    }
    
    public ImovelDAO() {
    }
    
     public ResultSet index() throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement(String.format("SELECT * FROM tbl_imovel"));
        ResultSet rs = ps.executeQuery();

        return rs;
    }
    
    public ResultSet deletar(Integer id) throws SQLException {
        PreparedStatement ps = ConexaoDAO.connection().prepareStatement("DELETE FROM tbl_imovel WHERE id_imovel = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }

    public int editar(Imovel imovel) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("imovel" + imovel.getId( ));
        try {
            if (imovel.getId() == 0) {
                ps = ConexaoDAO.connection().prepareStatement("INSERT INTO tbl_imovel (cidade, estado, cep, rua, bairro, numero, referencia, valor) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, imovel.getCidade());
                ps.setString(2, imovel.getEstado());
                ps.setString(3, imovel.getCep());
                ps.setString(4, imovel.getRua());
                ps.setString(5, imovel.getBairro());
                ps.setInt(6, imovel.getNumero());
                ps.setString(7, imovel.getReferencia());
                ps.setFloat(8, imovel.getValor());
                
            } else {
                ps = ConexaoDAO.connection().prepareStatement("UPDATE tbl_imovel SET cidade = ?, estado = ?, cep = ?, rua = ?, bairro = ?, numero = ?, referencia = ?, valor = ? WHERE id_imovel = ?");
                ps.setString(1, imovel.getCidade());
                ps.setString(2, imovel.getEstado());
                ps.setString(3, imovel.getCep());
                ps.setString(4, imovel.getRua());
                ps.setString(5, imovel.getBairro());
                ps.setInt(6, imovel.getNumero());
                ps.setString(7, imovel.getReferencia());
                ps.setFloat(8, imovel.getValor());
                ps.setInt(9, imovel.getId());
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
