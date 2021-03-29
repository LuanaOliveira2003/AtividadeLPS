/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Corretor;
import dao.CorretorDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class CorretorController {
    public int salvar(int id, String nome, String cpf, String endereco, int idade, int salario) throws SQLException, ParseException{
        Corretor corretor = new Corretor();
        corretor.setId(id);
        corretor.setNome(nome);
        corretor.setCpf(cpf);
        corretor.setEndereco(endereco);
        corretor.setIdade(idade);
        corretor.setSalario(salario);
        
        CorretorDAO dao = new CorretorDAO();
        
        return CorretorDAO.getInstance().editar(corretor);
    }
     
     public void delete(int id) throws SQLException{
        CorretorDAO.getInstance().deletar(id);
    }
    
    public ResultSet index() throws SQLException{
        return CorretorDAO.getInstance().index();
    }
    
}
