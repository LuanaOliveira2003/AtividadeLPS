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
public class Cliente {
    private String tabelaNome = "tbl_cliente";
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private int idade;
    
    
    public Cliente() {
        
    }

    public Cliente(int id, String nome, String cpf, String endereco, int idade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = idade;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
     
    public ResultSet index() throws SQLException {
        PreparedStatement ps = Conexao.connection().prepareStatement(String.format("SELECT * FROM %s", tabelaNome));
        ResultSet rs = ps.executeQuery();

        return rs;
    }
    
    public ResultSet deletar(Integer id) throws SQLException {
        PreparedStatement ps = Conexao.connection().prepareStatement("DELETE FROM tbl_cliente WHERE id_cliente = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }

    public int editar(Cliente cliente) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("cliente" + cliente.getId( ));
        try {
            if (cliente.getId() == 0) {
                ps = Conexao.connection().prepareStatement("INSERT INTO tbl_cliente (nome, cpf, endereco, idade) VALUES(?, ?, ?, ?)");
                ps.setString(1, cliente.getNome());
                ps.setString(2, cliente.getCpf());

                ps.setString(3, cliente.getEndereco());
                ps.setInt(4, cliente.getIdade());
                
            } else {
                ps = Conexao.connection().prepareStatement("UPDATE tbl_cliente SET nome = ?, cpf = ?, endereco = ?, idade = ? WHERE id_cliente = ?");
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
