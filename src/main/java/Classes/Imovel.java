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
public class Imovel {
    private String tabelaNome = "tbl_imovel";
    private int id;
    private String cidade;
    private String estado;
    private String cep;
    private String rua;
    private String bairro;
    private int numero;
    private String referencia;
    private float valor;
    
    public Imovel() {
       
    }

    public Imovel(int id, String cidade, String estado, String cep, String rua, String bairro, int numero, String referencia, float valor) {
        this.id = id;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.referencia = referencia;
        this.valor = valor;
    }
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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
        PreparedStatement ps = Conexao.connection().prepareStatement("DELETE FROM tbl_imovel WHERE id_imovel = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }

    public int editar(Imovel imovel) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("imovel" + imovel.getId( ));
        try {
            if (imovel.getId() == 0) {
                ps = Conexao.connection().prepareStatement("INSERT INTO tbl_imovel (cidade, estado, cep, rua, bairro, numero, referencia, valor) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, imovel.getCidade());
                ps.setString(2, imovel.getEstado());
                ps.setString(3, imovel.getCep());
                ps.setString(4, imovel.getRua());
                ps.setString(5, imovel.getBairro());
                ps.setInt(6, imovel.getNumero());
                ps.setString(7, imovel.getReferencia());
                ps.setFloat(8, imovel.getValor());
                
            } else {
                ps = Conexao.connection().prepareStatement("UPDATE tbl_imovel SET cidade = ?, estado = ?, cep = ?, rua = ?, bairro = ?, numero = ?, referencia = ?, valor = ? WHERE id_imovel = ?");
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
