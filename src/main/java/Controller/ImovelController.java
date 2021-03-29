/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Imovel;
import dao.ImovelDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Pichau
 */
public class ImovelController {
    
    public int salvar(int id, String cidade, String estado, String cep,String rua, String bairro, int numero, String referencia, float valor) throws SQLException, ParseException{
        Imovel imovel = new Imovel();
        imovel.setId(id);
        imovel.setCidade(cidade);
        imovel.setEstado(estado);
        imovel.setCep(cep);
        imovel.setRua(rua);
        imovel.setBairro(bairro);
        imovel.setNumero(numero);
        imovel.setReferencia(referencia);
        imovel.setValor(Float.valueOf(valor));
        ImovelDAO dao = new ImovelDAO();
        
        return ImovelDAO.getInstance().editar(imovel);
    }
     
     public void delete(int id) throws SQLException{
        ImovelDAO.getInstance().deletar(id);
    }
    
    public ResultSet index() throws SQLException{
        return ImovelDAO.getInstance().index();
    }
    
}
