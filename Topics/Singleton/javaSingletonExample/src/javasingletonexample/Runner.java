/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasingletonexample;

/**
 *
 * @author MUST-2
 */
public final class Runner {
    String name;
    double miles;
    
    private static final String runner = "Dean Karnazes";
    private static final double runnerMiles = 350.0;
    private static final Runner INSTANCE = new Runner(runner, runnerMiles);
    
    private Runner(String name, double miles){
        this.name = name;
        this.miles = miles;
    }
    
    public static Runner getInstance(){
        return INSTANCE;
    }
    
    public void printName(){
        System.out.println("Runner name: "+ this.name);
    }
    public void printMiles(){
        System.out.println("Runner miles: "+ this.miles);
    }
    
    public void runnerToString(){
        System.out.println("Runner: "+this.name+" has run: "+this.miles+" miles");
    }
}







