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
public class Parking {
    private long arrivalTime;
    private String type;
    private String licensePlate;
    
    Parking(){
        licensePlate = "asd";
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    
    Parking(Vehicle vrum){
        arrivalTime = System.currentTimeMillis();
        type = vrum.getType();
        licensePlate = vrum.getLicensePlate();
    }
    
    public void register(Vehicle vrum){
        if(licensePlate.equals("asd"));
        arrivalTime = System.currentTimeMillis();
        type = vrum.getType();
        licensePlate = vrum.getLicensePlate();
    }
    
    public float calcPrice(Vehicle vrum){
        float price = (int) ((System.currentTimeMillis() - arrivalTime) * 3.6);
        licensePlate = "asd";
        if(type.equals("car")){
            price *= 3;
            System.out.printf("Tipo: Carro\nPreço: %.2f\n",price);
        }
        else{
            price *= 1.5;
            System.out.printf("Tipo: Moto\nPreço: %.2f\n",price);
        }
        return price;
    }
    
    
    
}
