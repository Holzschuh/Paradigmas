/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Inutiu
 */
public class Posto {
    
    private String CNPJ;
    private String razaoSocial;
    private String nomeFantasia;
    private String bandeira;
    private String endereco;
    private String bairro;
    private String CEP;
    private String imagem;
    private final static int maxCombustiveis = 10;
    private ArrayList<Combustivel> combustiveis;

    public Posto(){
        combustiveis = new ArrayList();
    }
    
    public Posto(String CNPJ, String razaoSocial, String nomeFantasia, String bandeira, String endereco, String bairro, String CEP, String imagem){
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.bandeira = bandeira;
        this.bandeira = endereco;
        this.bairro = bairro;
        this.CEP = CEP;
        this.imagem = imagem;
        combustiveis = new ArrayList();
    }
    
    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    public void addCombustivel(Combustivel c){
        if(combustiveis.size() == maxCombustiveis)
            combustiveis.remove(maxCombustiveis - 1);
        
        combustiveis.add(0, c);
    }
}
