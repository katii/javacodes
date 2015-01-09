/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

/**
 *
 * @author Ohjelmistokehitys
 */
public class Persons {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Luo instanssin sekä aliluokasta (jeppe) että koko periytymishierarkia eli myös person
        // kaikki ohjektit keskusmuistissa
        // tämä voi käyttää myös yläluokan funktioita
        Jeppe jeppe = new Jeppe(12);
        Moppe moppe = new Moppe();
        
        setWidth(jeppe);
        setWidth(moppe);
    }
    
    // person tyyppinen argumentti, siihen voi panna jepen ja mopen, koska nämä on
    // peritty personista
    // sisarluokkien välillä näin ei voi tehdä, koska jos on olemassa moppe ei ole
    // välttämättä olemassa jeppeä, mutta person on
    public static void setWidth(person p){
        p.setWeight(12);
    }
}
