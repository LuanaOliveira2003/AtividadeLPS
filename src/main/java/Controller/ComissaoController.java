/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Comissao;
import dao.ComissaoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class ComissaoController {
     public int salvar(int id, String nome,float valor) throws SQLException, ParseException{
        Comissao comissao = new Comissao();
        comissao.setId(id);
        comissao.setNome(nome);
        comissao.setValor(Float.valueOf(valor));
        ComissaoDAO dao = new ComissaoDAO();
        
        return ComissaoDAO.getInstance().editar(comissao);
    }
     
     public void delete(int id) throws SQLException{
        ComissaoDAO.getInstance().deletar(id);
    }
    
    public ResultSet index() throws SQLException{
        return ComissaoDAO.getInstance().index();
    }
    
}
