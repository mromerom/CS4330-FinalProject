/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacomputedpropertyexample;

/**
 *
 * @author MUST-2
 */
public class Strawberry {
    final String typeOfFood = "strawberry";
    String typeOfStrawberry;
    double weight;
    private String fullTypeName;
    
    public Strawberry(double weight, String typeOfStrawberry, String fullTypeName){
        this.weight = weight;
        this.typeOfStrawberry = typeOfStrawberry;
        this.fullTypeName = fullTypeName;
    }
    
    public String getFullTypeName(){
        return fullTypeName;
    }
    public void setFullTypeName(String typeOfStrawberry){
        this.typeOfStrawberry = typeOfStrawberry;
        fullTypeName = typeOfStrawberry + " " + typeOfFood;
    }
}
