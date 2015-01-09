/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Ohjelmistokehitys
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Laskenta device = new Laskenta(0,0);
        device.multiply();
        device.add();
        device.divide();
        device.subtract();

        Laskenta device2 = new Laskenta(3,0);
        device2.multiply();
        device2.add();
        device2.divide();
        device2.subtract();
        
        Laskenta device3 = new Laskenta(0,2);
        device3.multiply();
        device3.add();
        device3.divide();
        device3.subtract();

        Laskenta device4 = new Laskenta(3,2);
        device4.multiply();
        device4.add();
        device4.divide();
        device4.subtract();

        Laskenta device5= new Laskenta(2,3);
        device5.multiply();
        device5.add();
        device5.divide();
        device5.subtract();
        
        device.setArrayValue(55);
        device.setArrayValue(56);
        device.setArrayValue(67);
        device.setArrayValue(67);
        device.setArrayValue(67);
        device.printArray();

    }
    
}
