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
    private int selectedStation;
    
    public PostoTableModel() {
        postos = new ArrayList();
    }
    
    public boolean existsInList(String razaoSocial){
        for(int i=0; i<postos.size(); i++){
            if(postos.get(i).getRazaoSocial().equals(razaoSocial)){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Posto> getPostos(){
        return postos;
    }
    
    public void addPosto(Posto p){
        postos.add(0, p);
    }

    public int getSelectedStation() {
        return selectedStation;
    }

    public void setSelectedStation(int selectedStation) {
        this.selectedStation = selectedStation;
    }
    
    public void removePosto(int index){
        postos.remove(index);
    }
    
    public void alteraPosto(int index, Posto p){
        postos.set(index, p);
    }
    
}
