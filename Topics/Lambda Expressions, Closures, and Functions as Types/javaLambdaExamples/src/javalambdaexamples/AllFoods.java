/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalambdaexamples;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author MUST-2
 */
public class AllFoods {
    public AllFoods(){}
    
    public void printNutsAndAmounts(ArrayList<String> nuts, ArrayList<Integer> amounts){
        System.out.println("Here are my nuts: ");
        for(int i=0; i<nuts.size() && i<amounts.size(); i++){
            System.out.println("\t"+ nuts.get(i) + ": "+amounts.get(i)+" pieces");
        }
    }
    
    public void printNutsAndAmounts(ArrayList<String> nuts, ArrayList<Integer> amounts, Predicate<Integer> p){
        System.out.println("Here are my nuts with a limited amount of pieces: ");
        for(int i=0; i<nuts.size() && i<amounts.size(); i++){
            if(p.test(amounts.get(i))){
                System.out.println("\t"+ nuts.get(i) + ": "+amounts.get(i)+" pieces");
            }
        }
    }
}
