/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto;

import java.util.Scanner;

/**
 *
 * @author Ohjelmistokehitys
 */
public class Lotto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        lottoNumbers numerot = new lottoNumbers();
        
        System.out.print("Montako lottoriviä arvotaan? ");
        int rivit = myScanner.nextInt();

        System.out.print("Järjestetäänkö rivit 1) nousevaan järjestykseen vai 2) laskevaan järjestykseen? (1/2) ");
        int suunta = myScanner.nextInt();
        System.out.println("main " + suunta);
        
        System.out.println("Lottorivisi:");
        numerot.printLines(rivit, suunta);


        
/*        lottoNumbers numerot = new lottoNumbers();
        numerot.getLottoLines(rivit);
*/
/*
        System.out.println("Lottorivisi:");
        for(int i = 0; i < rivit; i++){
            lottoNumbers numerot = new lottoNumbers();
            numerot.getNumbers();
        }
*/        
        System.out.println("");
    }
    
}
