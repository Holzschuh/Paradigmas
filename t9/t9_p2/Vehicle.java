package t9_p2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Inutiu
 */
public class Vehicle {
    private String type;
    private String licensePlate;

    Vehicle(){
        type = "car";
        licensePlate = "12345";
    }
    Vehicle(String type, String licensePlate){
        this.type = type;
        this.licensePlate = licensePlate;
    }
    
    public void enterParking(Parking park){
        if(type.equals("car") || type.equals("moto"))
            park.register(this);
        else
            System.out.printf("veículo deve ser do tipo \"car\" ou \"moto\" ");
    }
    
    public void exitParking(Parking park){
        if(licensePlate.equals(park.getLicensePlate()))
            park.calcPrice(this);
    }
    
    public String getType() {
        return type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
