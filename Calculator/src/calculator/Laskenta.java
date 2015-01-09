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
public class Laskenta {

    private float value1;
    private float value2;
    
    // tilavaraus tehdään heapistä, kun on new operaattori
    // heapin osoite stackkiin, 2*10 tavua heapista
    // java alustaa nämä nollaksi
    private int[] arrayInt = new int[10];
    // tämän tila varataan ???
    private int[] arrayInt2 = {1,2,3,5,8,89};
    // ja tällä varataan tila heapista
    int value = 2;    
    private int index = 0;
    
    // myös tämä on sallittua
    private Object[] test = new Object[10];
    // funktiossa test[0] = new Object();
    
    // ylläolevien elinkaari on tästä luokasta luodun objektin elinikä

    // funktion argumenteille ja sen sisällä varatuille muuttujille varataan stackista
    // näiden elinkaari = funktiokutsun mitta
    
    public void setArrayValue(int value){
        // set something to array
        if(index < 10){
            arrayInt[index] = value;
            index++;
        }
    }
    
    public void printArray(){
        for(int i = 0; i < 10; i++){
            System.out.println(arrayInt[i]);
        }
    }
    
    
    /**
     * Constructor of this class
     * @param val1
     * @param val2 
     */
    public Laskenta(float val1, float val2) {
        value1 = val1;
        value2 = val2;
    }

    public void add(){
        System.out.println("Result of addition: " + (value1 + value2));
    }
    
    public void multiply(){
        System.out.println("Result of multiply: " + (value1 * value2));
    }
    
    public void divide(){
        if(value2 != 0){
            System.out.println("Result of division: " + (value1 / value2));
        }
        else{
            System.out.println("Cannot divide with 0");
        }
    }
    
    public void subtract(){
        System.out.println("Result of subtraction: " + (value1 - value2));
    }
    
}
