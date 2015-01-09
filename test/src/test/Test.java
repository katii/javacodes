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
public class Test {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        testLuokka test1 = new testLuokka(); // luodaan test1
        test1.increaseValues(2, 2); // staattiseen muuttujaan 2
        
        testLuokka test2 = new testLuokka(); // luodaan test2
        test2.increaseValues(3, 3); // staattiseen muuttujaan 3
        
        // staattisen muuttujan arvo näkyy kaikille olioille samana arvona
        // se on luokan muuttuja ei olion muuttuja
        // niitä on vain yksi, koska sille on vain yksi muistivaraus paikka
        
        // muut muuttujat on olion omia, ei luokan, varaukset RAMlla omilla paikoillaan
        
        // staattisella muuttujalla vois pitää lukua siitä, montako objektia on luotu.
        // olioiden määrä voisi rajata, jos tarvis
        // sillä voi pitää kirjaa luokalle yhteisistä asioita
        // sillä voi jakaa olioiden välillä yhteistä asiaa
        
        test1.printValues(); // tulostaa 2 ja 3
        test2.printValues(); // tulostaa 3 ja 3
    }
    
}
