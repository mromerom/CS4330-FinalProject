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
public class January_King extends Cabbage{
    String region;
    // other states

    public January_King(double weight, boolean fresh, String region){
        super(weight, fresh);
        // this super would create the piece of this object that is a cabbage,
        //    and that cabbage object would create the other piece of this object
        //    that is a vegetable
        this.region = region;
    } 
    
    /*@Override
    public void printKind(){
        System.out.println("January King Class kindOfFood: "+ kindOfFood);
    }*/
    // Which kindOfFood do you think this would print if it were active (uncommented)?
    
    
    public void printRegion(){
        System.out.println("January King Class region: " + region);
    }
}
