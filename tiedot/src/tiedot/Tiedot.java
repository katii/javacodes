/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiedot;

import java.util.Scanner;

/**
 *
 * @author Ohjelmistokehitys
 */
public class Tiedot {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.print("Anna etunimesi: ");
        String etunimi = myScanner.nextLine();
        System.out.print("Anna sukunimesi: ");
        String sukunimi = myScanner.nextLine();
        System.out.print("Anna osoitteesi: ");
        String osoite = myScanner.nextLine();
        System.out.print("Anna puhelinnumerosi: ");
        String puhelin = myScanner.nextLine();
        System.out.print("Anna sähköpostiosoitteesi: ");
        String email = myScanner.nextLine();
        
        // myScanner.next() lukee vain ensimmäiseen välilyöntiin asti.
        // Käyttäjä on kuitenkin lyönyt esim. nimenkin perään enterin
        // -> seuraava myScanner.nextLine() lukee siis tuon edellisen enterin
        // väliin voi laittaa vaikka 
        // myScanner.nextLine();
        
/*
        System.out.println("Etunimi: " + etunimi);
        System.out.println("Sukunimi: " + sukunimi);
        System.out.println("Osoite: " + osoite);
        System.out.println("Puhelinnumerosi: " + puhelin);
        System.out.println("Sähköpostiosoitteesi: " + email);
        
        int luku = etunimi.length() + sukunimi.length() + osoite.length();
        System.out.println("Salainen lukusi on: " + luku);
*/
        // luodaan henkilö kontruktorin kautta
        Henkilo henkilo1 = new Henkilo(etunimi, sukunimi, osoite, puhelin, email);
        henkilo1.printInformation();

        // luodaan henkilö saantifunktioiden kautta
        Henkilo henkilo2 = new Henkilo();
        henkilo2.setFirstName(etunimi);
        henkilo2.setLastName(sukunimi);
        henkilo2.setAddress(osoite);
        henkilo2.setPhoneNumber(puhelin);
        henkilo2.setEmail(email);
        
        // tulostetaan saantifunktioiden kautta 
        System.out.println("Etunimi :: " + henkilo2.getFirstName());
        System.out.println("Sukunimesi :: " + henkilo2.getLastName());
        System.out.println("Osoitteesei :: " + henkilo2.getAddress());
        System.out.println("Puhelinnumerosi :: " + henkilo2.getPhoneNumber());
        System.out.println("Sähköpostiosoitteesi :: " + henkilo2.getEmail());
    }
    
}
