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
public class LazyRunner {
    String name;
    double miles;
    private static volatile LazyRunner instance = null;
    
    private LazyRunner(String name, double miles){
        this.name = name;
        this.miles = miles;
    }
    
    public static LazyRunner getInstance(String name, double miles){
        if(instance == null){
                if(instance == null){
                    instance = new LazyRunner(name, miles);
            }
        }
        return instance;
    }
    
    
    public void printName(){
        System.out.println("Lazy Runner name: "+ this.name);
    }
    public void printMiles(){
        System.out.println("Lazy Runner miles: "+ this.miles);
    }
    
    public void runnerToString(){
        System.out.println("Lazy Runner: "+this.name+" has run: "+this.miles+" miles");
    }
}
