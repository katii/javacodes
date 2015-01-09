/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto;

import java.util.Arrays;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;
import java.util.Random;

/**
 *
 * @author Ohjelmistokehitys
 */
public class lottoNumbers {
    private int[] luvut = new int[7];

    private Random rand;

    public lottoNumbers() {
        rand = new Random();
    }

    public int[] getNumbers(){
        
        for(int i = 0; i < 7; i++){
            int randNum = rand.nextInt(39) + 1;
            for(int j = 0; j <= i; j++){
                if(randNum == luvut[j]){
                    randNum = rand.nextInt(39) + 1;
                    j = -1;
                }
            }
            luvut[i] = randNum;
        }
//        Arrays.sort(luvut);
//        System.out.println(Arrays.toString(luvut));
        return luvut;
    }
    
    public int[][] getLottoLines(int rivit){
        int[][] lottoLines = new int[rivit][7];
//        System.out.println("montako riviä: " + rivit);
        for(int row = 0; row < rivit; row++){
            int[] uusiRivi = getNumbers();
            for(int i = 0; i < 7; i++){
                lottoLines[row][i] = uusiRivi[i];
//                System.out.println(lottoLines[row][i]);
            }
        }
    return lottoLines;
    }
    
    public void printLines(int rivit, int suunta){
        int[][] lottoLines = new int[rivit][7];
        lottoLines = getLottoLines(rivit);
        for(int row = 0; row < rivit; row++){
            int[] rivi = lottoLines[row];
            Arrays.sort(rivi);
            if(suunta == 1){
                System.out.println(Arrays.toString(rivi));
            }
            else{
                int riviKopio[] = new int[7];
                for(int i = 0; i < 7; i++){
                    riviKopio[6-i] = rivi[i];
                }
                System.out.println(Arrays.toString(riviKopio));
            }
        }
    }
}
