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
public class Cabbage {
    final String typeOfFood = "cabbage";
    String typeOfCabbage;
    double weight;
    private String fullTypeName;
    
    public Cabbage(double weight, String typeOfCabbage){
        this.weight = weight;
        this.typeOfCabbage = typeOfCabbage;
        fullTypeName = getFullTypeName();
    }
    
    public String getFullTypeName(){
        return typeOfCabbage + " " + typeOfFood;
    }
    public void setFullTypeName(String typeOfCabbage){
        this.typeOfCabbage = typeOfCabbage;
        fullTypeName = getFullTypeName();
    }
}
