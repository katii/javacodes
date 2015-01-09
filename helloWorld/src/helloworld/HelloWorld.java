/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.util.Map;
import java.util.Scanner; // yksittäinen luokka ko. paketista
// import java.util.*; // tuo kaikki luokat, jotka util packagessa on, älä käytä

/**
 *
 * @author Ohjelmistokehitys
 */
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Check if the user has given some arguments
        // testaus: Run -> Set project configuration -> Customize -> Arguments
        if(args.length == 0) {
            System.out.println("Give your name as command line argument");
            System.exit(1);
        }
        else {
            if(args[0].equals("-help")) {
                System.out.println("Name printer version 1.2");
                System.out.println("Application asks your name. Type the name and press enter");
                System.out.println("Application will print your name with greeting");
            }
            // args[1] se seuraava argumentti
        }
        
        // github solita kansalaisaloite lähdekoodi java pohjainen
        // opetushallitus aiku aijotain muuta koko cloire stackki 
        // dev.solita.fi muuta luettavaa
        
        // JavaProgrammingBasics.pptx page 14
//        System.out.println("Hello World!");
//        Map<String, String> env = System.getenv(); // OR right click + fix imports
//        System.out.println(env);
//        System.out.println(env.get("LOCALAPPDATA"));

        // JavaProgrammingBasics.pptx page 18
        System.out.println("Write your name:");
        // create a scanner object for reading input
        Scanner myScanner = new Scanner(System.in);

        // wait until user hits enter key, then store input in name variable
//        String name = myScanner.next(); // tulostaa ekaan white spaceen asti
        String name = myScanner.nextLine(); // tulostaa myös white spacen jälkeisen

        // print out
        System.out.println("hello there " + name + ", your name length is: " + name.length());
        
        // poista välilyöntien määrä
        String name2 = name.replaceAll("\\s", "");
        System.out.println("actually the length is: " + name2.length());
        System.out.println("Give me your address:");
        
        String addr = myScanner.nextLine();
        
        // trim() poistaa välilyönnit alusta ja lopusta
        System.out.println("your address is: " + addr.trim());
        
        // lisatietoja luokista ALT + F1 luokan kohdalla
        
        // luokka objekti = heapista tila
        Shape shape = new Shape();
        shape.setColor(-2); // (pisteopraattori) palauttaa nollan, kun < 0
        System.out.println(shape.getColor());
        shape.setColor(22); // 
        System.out.println(shape.getColor());
        
        // käyttää kopiokonstruktoria 
        // ideana luoda yksi ja luoda siitä kopioita
//        Shape shape2 = new Shape(shape);

        // tiedon kapselointi: kapselointi luokan sisälle, yksityinen luokalle, private
        // public       periytyy, voi viitata luokan ja paketin ulkopuolelta
        // protected    periytyy, voi viitata luokan ulkopuolelta, mutta ei paketin ulkopuolelta
        // private      ei periydy, ei voi viitata luokan ulkopuolelta
          
    }
 
/*
 // sieventämätön lottokone
    
    public void getNumbers(){
        
        System.out.println("luvut 0: " + Arrays.toString(luvut));
        for(int i = 0; i < 7; i++){
            System.out.println("iiiiii: " + i);
            int randNum = rand.nextInt(39) + 1;
            System.out.println("randNum ennen for: " + randNum);
            for(int j = 0; j <= i; j++){
                System.out.println("jjjjj: " + j);
                System.out.println("randNum in FOR: " + randNum);
                if(randNum == luvut[j]){
                    randNum = rand.nextInt(39) + 1;
                    j = -1;
                    System.out.println("randNum UUSI: " + randNum);
                }
            }
            System.out.println("randNum: " + randNum);
            luvut[i] = randNum;
            System.out.println("luvut: " + Arrays.toString(luvut));
            
        }
        Arrays.sort(luvut);
        System.out.println("luvut end: " + Arrays.toString(luvut));
    }
}
    */    
}
