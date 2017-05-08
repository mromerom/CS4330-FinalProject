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
public class JavaSingletonExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // a singleton is a singular object
        //      from a class
        // that class can only have that
        //      ONE object

        System.out.println("Regular singleton: ");
        Runner runner1 = Runner.getInstance();
        System.out.print("\t");
        runner1.printName();
        System.out.print("\t");
        runner1.printMiles();
        System.out.print("\t");
        runner1.runnerToString();
        System.out.println("\tRunner name without function: "+runner1.name);
        System.out.println("\tRunner miles without function: "+runner1.miles);
        // a regular singleton is 'created'
        //      within the class itself
        // there is no way to give it its
        //      variables without doing so
        //      in the class itself
        // its variables, if not private, are
        //      still accessible
        // it can still act like any other class
        // Q1: what will the following functions print
        //      out if we make a second runner?
        System.out.println("Q1: These prints are the result of making a " 
                            +"runner2 of type Runner");
        Runner runner2 = Runner.getInstance();
        System.out.print("\t");
        runner2.printName();
        System.out.print("\t");
        runner2.printMiles();
        System.out.print("\t");
        runner2.runnerToString();
        
        // lazy singelton
        // these allow for creating the instance in
        //      the moment, but that instance is 
        //      and will be the ONLY instance
        // the instance is also only created when
        //      getInstance() is called
        System.out.println("\nLazy Singleton: ");
        LazyRunner runner3 = LazyRunner.getInstance("Payton Hosna", 2.75);
        System.out.print("\t");
        runner3.printName();
        System.out.print("\t");
        runner3.printMiles();
        System.out.print("\t");
        runner3.runnerToString();
        // Q2: what happens if we try to execute the following?
        System.out.println("Q2: These prints are a result of making a new instance runner 4 of Forrest Gump: ");
        LazyRunner runner4 = LazyRunner.getInstance("Forrest Gump", 19024.0);
        System.out.print("\t");
        runner4.printName();
        System.out.print("\t");
        runner4.printMiles();
        System.out.print("\t");
        runner4.runnerToString();
        
        // Q3: Do you see any issue with this?
        //      Lazy allows for in time instantiation,
        //      whereas regular is created in the moment,
        //      and nothing else has any chance to make 
        //      it different.
        //      So, if lazy can create the object in the 
        //      moment and send parameters, what could
        //      be an issue with this?
        
        // this will be explored through checking for
        //      thread safety
        // is a singleton thread safe?
        //      no! the first time getInstance() 
        //      is called, the thread that invoked
        //      it goes to sleep for a very small
        //      period of time, whichcould allow
        //      for some other invocation of the instance
        //      an it could be changed!
        //      (which is definitely the opposite
        //      of why singletons exist)
        // how could we make this thread safe?
        // we use synchronization!!
        //      ex. LazyRunnerThreadSafe
        //          public static LazyRunnerThreadSafe getInstance(String name, double miles)
        // synchronization 'locks onto code'
        //      in this case, the object... but more
        //      specifically, as this object is static,
        //      it locks the class
        //      it allows for one thread to act at a time
        //      and to finish its work
        //      once it is finished, the class unlocks
        //      and another thread can access the instance
        // the most important part is making sure only ONE
        //      instance is created
        System.out.println("\nLazy Runner thread safe: ");
        LazyRunnerThreadSafe runner5 = LazyRunnerThreadSafe.getInstance("Forrest Gump", 19024.0);
        System.out.print("\t");
        runner5.printName();
        System.out.print("\t");
        runner5.printMiles();
        System.out.print("\t");
        runner5.runnerToString();
    }
    
}



