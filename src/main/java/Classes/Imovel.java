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
    
   
    
}
