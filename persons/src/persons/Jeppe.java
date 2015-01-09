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
public class Jeppe extends person {

    // saman niminen muuttuja, kuin mikä on yläluokasta peritty
    // ylikirjoittaa/peittää Jeppe luokalta yläluokan weightin, joten tämä aliluokka ei näe enää yläluokan weightiä
    // jos joku perii Jeppe luokan, se perii Jeppe luokan weightin, joten ÄLÄ TEE TÄTÄ
    // private int weight;
    
    public Jeppe(int age) {
        super(age);
        
        // kantaluokassa weight muutettu protectediksi, niin tämä onnistuu
        this.weight = 23;
        
//        super(12); // välittää kantaluokan konstruktorille luvun 12, kun kerran kantaluokan kontruktorilla argumentti
        // ylläolevassa tapauksessa pakko käyttää superia
        // mutta älä käytä kovakoodattua arvoa kutsussa vaan tee aliluokan konstruktoriin sama argumentti ja välitä tieto siten.
        // super. voi viitata yläluokan funktioon, osoitin yläluokkaan
        // jos ei yläluokan konstruktorilla argumentteja, kääntäjä viittaa sinne
        System.out.println("Jeppe created.");
    }
    
    // Tämä ylikirjoittaa yläluokan metodin ja tämä on OK
    // Tapauksissa, joissa halutaan käyttää yliluokan muita ominaisuuksia, mutta joku metodi pitäis olla erilainen
    // Jepen perijät perii Jepen metodit, eivät näe yläluokan toteutusta
    // Jeppe voi superilla käyttää yliluokkaa edelleen, Jepen perijät ei
    @Override
    public void setAge(int age) {
        // superilla voi edelleen kutsua yläluokan toteutusta, jonka tämä oma funkkari
        // peitti. Tämän aliluokat ei näin voi tehdä.
        super.setAge(age);
        
    }
}
