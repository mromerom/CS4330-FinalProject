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
public class JavaInheritanceExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vegetable veggie = new Vegetable(3.2);
        Cabbage cabbage = new Cabbage(3.3, true);
        January_King jking = new January_King(3.4, false, "northwest");
        
        System.out.println("veggie, cabbage, jking:");
        veggie.printWeight(); // output: 3.2
        cabbage.printWeight(); // output: 3.3
        jking.printWeight(); // output: 3.4
        System.out.println("\nveggie, cabbage, jking:");
        veggie.printKind(); // output: Vegetable Class kindOfFood: Vegetable
        cabbage.printKind(); // output: Cabbage Class kindOfFood: Cabbage
        jking.printKind(); // Q2: output: ?

        System.out.println("\ncabbage, jking:");
        cabbage.printFresh(); // output: true
        jking.printFresh(); // output: false
        // overriding methos isn't necessary, but it can prove to be very useful

        System.out.println("\njking");
        jking.printRegion(); // output: January King Class region: northwest
        
        System.out.println("\nveggie = jking:");
        veggie = jking;
        veggie.printWeight(); // Q3: output?
        veggie.printKind(); // Q4: output?
        //veggie.printFresh();
        //  parent classes can be assigned to their child classes, because
        //      the child classes will have every state/behaviour of the parent;
        //      this means, however, that the parent can only use the states/behaviours
        //      it has defined in its own class
        //  even though jking has a different weight and kindOfFood, these are
        //      states within Vegetable, so veggie can become jking
        
        //jking = cabbage;
        // child classes cannot be parent classes, as the require more states
        //      or behaviours than their parent class has
        //  if they don't, they're typically an unnecessary class, as the child
        //      should build off of the parent, making it more specific

    }
    
}
