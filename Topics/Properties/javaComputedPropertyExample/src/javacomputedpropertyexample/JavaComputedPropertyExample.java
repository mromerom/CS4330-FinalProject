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
public class JavaComputedPropertyExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cName = "january king";
        String sFName = "strawberry";
        String sTName = "fragaria vesca";
        String sFTName = sFName + " " + sTName;
        Cabbage cabbage = new Cabbage(2, "january king");
        Strawberry strawb = new Strawberry(0.1, sTName, sFTName);
        
        
        System.out.println("Cabbage computed properties: get:");
        System.out.println("\tCabbage: food type: " + cabbage.typeOfFood);
        System.out.println("\tCabbage: cababge type: " + cabbage.typeOfCabbage);
        System.out.println("\tCabbage: full type: " + cabbage.getFullTypeName());
        System.out.println("Cabbage computed properties: set:");
        System.out.println("\tCabbage: food type: " + cabbage.typeOfFood);
        cabbage.setFullTypeName("bok choy");
        System.out.println("\tCabbage: cababge type: " + cabbage.typeOfCabbage);
        System.out.println("\tCabbage: full type: " + cabbage.getFullTypeName());
        // computed properties are private properties
        //      that are 'set' and 'gotten'('get')
        //      through methods
        // this is a means of protecting the roperty
        //      itself, so no direct access is
        //      allowed (aka. cabbage.fullTypeName)
        
        
        System.out.println("\nStrawberry computed properties: set in constructor:");
        System.out.println("\tStrawberry: food type: " + strawb.typeOfFood);
        System.out.println("\tStrawberry: Strawberry type: " + strawb.typeOfStrawberry);
        System.out.println("\tStrawberry: full type: " + strawb.getFullTypeName());
        System.out.println("Strawberry computed properties: set:");
        System.out.println("\tStrawberry: food type: " + strawb.typeOfFood);
        strawb.setFullTypeName("fragaria x ananassa");
        System.out.println("\tStrawberry: Strawberry type: " + strawb.typeOfStrawberry);
        System.out.println("\tStrawberry: full type: " + strawb.getFullTypeName());
        // note: in this case, it's probably better to 
        //      set and get through the functions alone
        //      instead of the constructor
    }
    
}
