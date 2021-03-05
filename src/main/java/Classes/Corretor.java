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
public class Corretor {
    private String tabelaNome = "tbl_corretor";
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private int idade;
    private int salario;
    
    
    public Corretor() {
        
    }

    public Corretor(int id, String nome, String cpf, String endereco, int idade, int salario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = idade;
        this.salario = salario;
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

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    
    public ResultSet index() throws SQLException {
        PreparedStatement ps = Conexao.connection().prepareStatement(String.format("SELECT * FROM %s", tabelaNome));
        ResultSet rs = ps.executeQuery();

        return rs;
    }
    
    public ResultSet deletar(Integer id) throws SQLException {
        PreparedStatement ps = Conexao.connection().prepareStatement("DELETE FROM tbl_corretor WHERE id_corretor = ?");
        ps.setInt(1, id);

        ps.executeUpdate();
        return null;
    }

    public int editar(Corretor corretor) throws SQLException, ParseException {
        PreparedStatement ps = null;
        System.out.println("corretor" + corretor.getId( ));
        try {
            if (corretor.getId() == 0) {
                ps = Conexao.connection().prepareStatement("INSERT INTO tbl_corretor (nome, cpf, endereco, idade, salario) VALUES(?, ?, ?, ?, ?)");
                ps.setString(1, corretor.getNome());
                ps.setString(2, corretor.getCpf());

                ps.setString(3, corretor.getEndereco());
                ps.setInt(4, corretor.getIdade());
                ps.setFloat(5, corretor.getSalario());
            } else {
                ps = Conexao.connection().prepareStatement("UPDATE tbl_corretor SET nome = ?, cpf = ?, endereco = ?, idade = ?, salario = ? WHERE id_corretor = ?");
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
