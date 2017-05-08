/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalambdaexamples;

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
        
        // these lambda expressions act as 'quick' functions
        //      they can have multiple lines, ex. lines 63-67
        //      or they can be simple, like the rest of the examples
        // lambdas can only be made from functional interfaces
    }
    
}
