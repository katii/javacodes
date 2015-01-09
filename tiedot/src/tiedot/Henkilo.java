/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiedot;

/**
 *
 * @author Ohjelmistokehitys
 */
public class Henkilo {
    
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;

    /**
     * 
     */
    public Henkilo() {
        this.firstName = "";
        this.lastName = "";
        this.address = "";
        this.phoneNumber = "";
        this.email = "";
    }

    /**
     * 
     * @param firstName
     * @param lastName
     * @param address
     * @param phoneNumber
     * @param email 
     */
    public Henkilo(String firstName, String lastName, String address, String phoneNumber, String email) {
        /*
        // Näin voisi tehdä, mutta ei ota tietojen rajoitteisiin mitään kantaa, joten älä tee näin
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        */
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    public void printInformation(){
        System.out.println("Etunimi: " + firstName);
        System.out.println("Sukunimi: " + lastName);
        System.out.println("Osoite: " + address);
        System.out.println("Puhelin: " + phoneNumber);
        System.out.println("Email: " + email);
    }
    
    public String getFirstName() {
        return firstName;
    }

    //Etunimen minimipituus on 2 merkkiä ja maksimipituus 30 merkkiä.
    public void setFirstName(String firstName) {
        if(2 <= firstName.length() && firstName.length() <= 30){
            this.firstName = firstName;
        }
        else{
            System.out.println("Etunimen pituuden on oltava 2-30 merkkiä");
        }
    }

    public String getLastName() {
        return lastName;
    }
    
    //  Sukunimen minimipituus on 1 merkki ja maksimi on 30 merkkiä.
    public void setLastName(String lastName) {
        if(1 <= lastName.length() && lastName.length() <= 30){
            this.lastName = lastName;
        }
        else{
            System.out.println("Sukunimen pituuden on oltava 1-30 merkkiä");
        }
    }

    public String getAddress() {
        return address;
    }

    //  Osoitteen minimipituus on 8 merkkiä ja maksimi 100 merkkiä. 
    public void setAddress(String address) {
        if(8 <= address.length() && address.length() <= 100){
            this.address = address;
        }
        else{
            System.out.println("Osoitteen pituuden on oltava 10-100 merkkiä");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Puhelinumeron pituus täytyy olla 13 merkkiä. 
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() == 13){
            this.phoneNumber = phoneNumber;
         }
        else{
            System.out.println("Puhelinnumeron pituuden on oltava 10-100 merkkiä");
        }
    }

    public String getEmail() {
        return email;
    }

    // Sähköpostiosoiteesta täytyy löytyä @ merkki. 
    public void setEmail(String email) {
        if(email.contains("@")){
            this.email = email;
        }
        else{
            System.out.println("Sähköpostiosoitteessa pitää olla merkki @");
        }
    }
    
    
}
