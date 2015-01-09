/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

/**
 *
 * @author Ohjelmistokehitys
 */
public class Shape {
    // kun ei ole constructori-funktiota, niin kääntäjä tekee sellaisen, siksi 
    // helloWorldissä voi käyttää new Shape()
    // kääntäjän tekemä: public Shape() {
    //                   }
    public Shape(){
        
    }
    // jos tämän tekee itse, pitäis luokan tietojäsenet määritellä constructorissa
    // constructorilla sama nimi kuin luokalla, ei paluuarvon määrittelyä
    // tehtävä: alustustoimenpiteet luokassa, jos ei tätä itse tee, niin java alustaa nollaksi
    // constructorilla voi olla argumentteja, joiden avulla asetetaan luokan tietojäsenien arvoja
    // ts. kun kutsutaan new:lla annetaan samalla alkuarvoja parametreiksi, mutta ei saa
    // asettaa suoraan, koska silloin ei tarkisteta raja-arvoja vaan set-funkkareiden kautta, joissa
    // toivottavasti tarkastetaan raja-arvot
    
    // voi olla useampi constructori, joilla eri määrät parametreja
    // public Shape(int color, int penWidth, int penColor)
    // public Shape()
    
    // kopiokonstruktori 
    // copy constructor of shape class
    
//    public Shape(Shape s) {
//        setColor(s.getColor());
//    }
    
    // jos näkyvyysmääre private/public/protected pois, niin private
    private int color = 0;
    
    // public näkyy luokan ulkopuolelle
    // kommentointi kirjoita /** ja paina enter funkkarin yläpuolella
    /**
     * 
     * @param color 
     */
    public void setColor(int color) {
        if(color >= 0){
            this.color = color;     // this = luokka itse, viittaa luokkaan itseensä, 
                                    // voi käyttää funktion sisällä, kääntäjä generoi
                                    // pakko käyttää tässä tapauksessa, koska funktion parametri(argumentti)
                                    // saman niminen kuin luokan muuttuja(ominaisuuden nimi)
        }
    }
    
    /**
     * 
     * @return 
     */
    public int getColor(){
        return color;
    }

    // Tai hiiren oikea tässä -> insert code, valitse mikä ja seuraavalta lehdeltä mille
    // muuttuja vain pitää olla ennen tätä tehtynä

    // javassa kaikki luokat perii object luokan, ei voi mitään
    // myös finalize sieltä
    // ikään kuin destructori tälle luokalle (ei pakko olla ite määriteltynä ts. overridettynä)
//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize(); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
}
