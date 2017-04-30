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
public class Vegetable {
    private final String kindOfFood = "Vegetable";
    // private states are not transferred to child classes
    //    aka. child classes don't have them, and if they created one,
    //          it would be completely separate from the parent's version
    double weight;
    // weight is not private, and therefore MUST be used by the child classes
    // other states

    public Vegetable(double weight){
        this.weight = weight;
    }

    public void printWeight(){
        System.out.println(weight);
    } 
    
    public void printKind(){
        System.out.println("Vegetable Class kindOfFood: " + kindOfFood);
        // child class cannot access parent's private states
        //  however, a public parent method CAN access them,
        //  and if the child class were to call this function (and not override it),
        //  they could print out kindOfFood --> even though they DON'T have it
    } 
    // other behaviours
}