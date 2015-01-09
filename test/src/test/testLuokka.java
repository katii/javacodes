/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Ohjelmistokehitys
 */
public class testLuokka {
    private int value;
    private static int static_value; // kääntäjä varaa tilan staattisesta muistista
    // jos rajoitettaus, niin tässä = 0 ja konstruktorissa ++
    
    void increaseValues(int value1, int value2){
        value = value1;
        static_value = value2;
        
    }
    
    void printValues(){
        System.out.println("Non static: " + value);
        System.out.println("Static: " + static_value);
    }
    
    // tälle funktiolle vain yksi muistivaraus vaikka ois miljoona objektia
    // kun koodi käännetty, tilavaraus staattisessa kontekstissa, tilavaraus muistissa
    // kun sovellus käynnistetään ja niitä voi käyttää luomatta objektia ts. voisi
    // kutsua mainista ilman, että on tehty muuta tyyliin:
    // testLuokka.printValuesStat();
    // tulostaa arvon nolla, kun ei ole käytetty
    // staattisessa kontekstissa esim. tämä funkkari ei voi käyttää normimuuttujaa,
    // siksi, koska tavan muuttujaa ei ole olemassa ellei oliota ole luotu ts. 
    // kääntäjä ei varaa normimuuttujalle tilaa staattiselle muistialueelle, kun ei
    // tiedä, onko olioita luotu
    public static void printValuesStat(){
        System.out.println("Static: " + static_value);
    }
}
