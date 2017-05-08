/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalambdaexamples;

import java.util.ArrayList;

/**
 *
 * @author MUST-2
 */
public class JavaLambdaExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String vName = "cabbage";
        String fName = "strawberry";
        String nName = "almond";
        String bName = "brioche";
        int nAmount = 20;
        
        System.out.println("Normal version: ");
        // before lambda expressions
        Vegetable veggie1 = new Vegetable(){
            public void veggie(){
                System.out.println("Vegetable: " + vName);
            }
        };
        veggie1.veggie();
        // to call the method from the interface, we have to create
        //      a new object AND the function veggie()
        
        System.out.println("\nLambda version: ");
        // here's a lambda expression of this
        Vegetable veggie2 = ()->{
                System.out.println("Vegetable: " + vName);
        };
        // since the functional interface has only one abstract
        //      method, we don't need to specify the name of the function
        // the function type is ()->()
        //      it receives no parameters and returns nothing
        veggie2.veggie();
        // in this case, we eliminate the need to declare
        //      what kind of object veggie2 is, and we
        //      didn't need to specify what function we're replacing
        
        System.out.println("\nLambda return version: ");
        // let's see what else we can do
        // what if our function returns something?
        Fruit fruity = ()->{
            return "Fruit: " + fName;
        };
        System.out.println(fruity.fruity());
        
        // what if the function has parameters?
        System.out.println("\nLambda multiple parameter version: ");
        Nut nutty = (type, amount)->{
            System.out.println("Nut type: " + type 
                                + "\nNumber of pieces: " + amount);
        };
        nutty.nutty(nName, nAmount);
        // the function type is (String, it)->()
        //      it receives a String and an int and returns nothing
        
        // what if we have parameters and need to return something?
        System.out.println("\nLambda multiple parameter and return version: 1: ");
        Bread bready1 = (type)->{
            String str1 = "Bread: ";
            String str2 = str1 + type;
            return str2;
        };
        System.out.println(bready1.bready(bName));
        // lambda expressions can have multiple lines
        //      although in this case, it's slightly unnecessary 
        // the function type is (String)->(String)
        //      it receives a String and returns String
        
        System.out.println("\nLambda multiple parameter and return version: 2: ");
        Bread bready2 = (type)->("Bread: " + type);
        // it turns out, you don't need the {} or return keyword
        //      this is more suitable for simpler functions
        System.out.println(bready2.bready(bName));
        // the function type is (String)->(String)
        //      it receives a String and returns String
        
        
        // can we use a lambda expression in a functional interface? 
        AllFoods allFoods = new AllFoods();
        ArrayList<String> nuts = new ArrayList<>();
        ArrayList<Integer> nutAmounts = new ArrayList<>();
        nuts.add(nName);
        nuts.add("cashew");
        nuts.add("pistachio");
        nuts.add("macadamia");
        nutAmounts.add(nAmount);
        nutAmounts.add(13);
        nutAmounts.add(12);
        nutAmounts.add(7);
        System.out.println("\nBefore using a closure in a function call: ");
        allFoods.printNutsAndAmounts(nuts, nutAmounts);
        System.out.println("After using a closure in a function call: to print only even amounts: ");
        allFoods.printNutsAndAmounts(nuts, nutAmounts, n -> n%2 == 0);
        // the lambda expression can be passed as a parameter
        //      it also could've been used inside the function
        //      if that were so, then we couldn't print all the odd
        System.out.println("After using a closure in a function call: to print only odd amounts: ");
        allFoods.printNutsAndAmounts(nuts, nutAmounts, n -> n%2 != 0);
        // or with only a certain range of pieces
        System.out.println("After using a closure in a function call: to print only amounts < 15: ");
        allFoods.printNutsAndAmounts(nuts, nutAmounts, n -> n < 15);
        // this is all possible due to Predicate being a functional interface
        // this is also known as passing a 'behavior'
        
        // these lambda expressions act as 'quick' functions (anonymous)
        //      they can have multiple lines, ex. lines 63-67
        //      or they can be simple, like the rest of the examples
        // to use a lambda expression, the expression MUST be
        //      from a functional interface
    }
    
}
