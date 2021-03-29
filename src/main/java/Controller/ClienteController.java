/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import dao.ClienteDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class ClienteController {
    
    public int salvar(int id, String nome, String cpf, String endereco, int idade) throws SQLException, ParseException{
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setIdade(idade);
        
        ClienteDAO dao = new ClienteDAO();
        
        return ClienteDAO.getInstance().editar(cliente);
    }
     
     public void delete(int id) throws SQLException{
        ClienteDAO.getInstance().deletar(id);
    }
    
    public ResultSet index() throws SQLException{
        return ClienteDAO.getInstance().index();
    }
    
}
