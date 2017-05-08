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
public class LazyRunnerThreadSafe {
    String name;
    double miles;
    private static volatile LazyRunnerThreadSafe instance = null;
    
    private LazyRunnerThreadSafe(String name, double miles){
        this.name = name;
        this.miles = miles;
    }
    
    public static LazyRunnerThreadSafe getInstance(String name, double miles){
        if(instance == null){
            synchronized(LazyRunnerThreadSafe.class){
                // this is a thread-safe wa to 'lock'
                //		the object until the thread if 
                //		finished working with it
                //  	once it unlocks, another thread 
                //  	can work with it
                // but once the instance is created,
                //		it cannot be changed 
                if(instance == null){
                    instance = new LazyRunnerThreadSafe(name, miles);
                }
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
