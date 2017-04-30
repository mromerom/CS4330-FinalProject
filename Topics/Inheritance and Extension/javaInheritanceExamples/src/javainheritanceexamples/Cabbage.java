/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javainheritanceexamples;

/**
 *
 * @author MUST-2
 */
public class Cabbage extends Vegetable{
    String kindOfFood = "Cabbage";
    // since Cabbage class doesn't have access to private variables
    //  it would NOT be overriding the parent classes 'kindOfFood'
    // also, weight is not a state that needs to be
    boolean fresh;
    // this state will NOT be withing the parent class, meaning
    //      the parent class has no state called fresh
    // other states

    public Cabbage(double weight, boolean fresh){
        super(weight);
        // child classes must use their parent class's constructor;
        //    child classes build off parent classes, so they would
        //    be 'missing' a piece if they didn't call the parent's
        //    constructor
        // calling the parent's constructor is creating the 'main' piece(s)
        //      of this object; main being the parent portions
        this.fresh = fresh;
    }
    
    // adding a printWeight() is unneccessary, as th parent class
    //      is already implementing it
    
    /*@Override
    public void printKind(){
        System.out.println("Cabbage Class kindOfFood: " + kindOfFood);
        // Q1: if this function weren't here, what would an object ot
        //      class Cabbage print instead?
    }*/
    
    public void printFresh(){
        System.out.println("Cabbage Class fresh: " + fresh);
    }
    // other behaviours
}
