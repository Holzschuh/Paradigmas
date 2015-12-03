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
public class PostoTableModel{
    private ArrayList<Posto> postos;

    public PostoTableModel() {
        postos = new ArrayList();
    }
    
    public void addPosto(Posto p){
        postos.add(0, p);
    }
    
    public void removePosto(int index){
        postos.remove(index);
    }
    
    public void alteraPosto(int index, Posto p){
        postos.set(index, p);
    }
    
}
