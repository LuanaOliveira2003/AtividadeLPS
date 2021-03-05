/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class Comissao {
    private String tabelaNome = "tbl_comissao";
    private int id;
    private String nome;
    private float valor;
    
    public Comissao() {
   
    }

    public Comissao(int id, String nome, float valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public ResultSet index() throws SQLException {
        PreparedStatement ps = Conexao.connection().prepareStatement(String.format("SELECT * FROM %s", tabelaNome));
        ResultSet rs = ps.executeQuery();

        return rs;
    }
    
    public ResultSet deletar(Integer id) throws SQLException {
        PreparedStatement ps = Conexao.connection().prepareStatement("DELETE FROM tbl_comissao WHERE id_comissao = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }

    public int editar(Comissao comissao) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("comissao" + comissao.getId( ));
        try {
            if (comissao.getId() == 0) {
                ps = Conexao.connection().prepareStatement("INSERT INTO tbl_comissao (nome,valor) VALUES(?, ?)");
                ps.setString(1, comissao.getNome());
                ps.setFloat(2, comissao.getValor());

            } else {
                ps = Conexao.connection().prepareStatement("UPDATE tbl_comissao SET nome = ?, valor = ?WHERE id_comissao = ?");
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
