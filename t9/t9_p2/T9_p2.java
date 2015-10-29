/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t9_p2;

/**
 *
 * @author Inutiu
 */
public class T9_p2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Parking park;
        Vehicle car;
        Vehicle moto;
        
        park = new Parking();
        car = new Vehicle("car", "12345");
        moto = new Vehicle("moto", "54321");
        
        car.enterParking(park);
        // não consegui colocar Sleep
        car.exitParking(park);
        moto.enterParking(park);
        // não consegui botar Sleep
        moto.exitParking(park);
        
        
    }
    
}
