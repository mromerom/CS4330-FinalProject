# Inheritance/ Extension
#### *This document will explain, compare, and give examples of how Java and Swift implement inheritance.*

<br></br>
## Inheritance and Extension
Inheritance is when an object is built up from another object; this is usually explained as an IS-A relationship. For example, vegetables are healthy foods that humans (should) eat. A cabbage *is* a vegetable, and a carrot *is* a vegetable; in this instance, vegetables would be a 'parent' (extended) class and cabbage and carrot would be two different 'child' (inheriting) classes. Each 'child' of an object is a more specific version of its parent; another example of this is: a january_king **is a** cabbage **is a** vegetable. You can also think of the taxonomic rank, Domain->Kingdom->Phylum->Class->Order->Family->Genus->Species, with each rank/ level getting progressively more specific towards a single kind of animal or plant. 

In programming implementation, a 'child' class is said to *extend* a 'parent' class, and the 'child' class is said to have *inherited* the states and behaviours of the 'parent' class. Any non-private states or behaviours that the parent class has declared will be a part of the child class's states and behaviours; the behaviours do not need to be written in the child class, *unless* the child class' version of that behaviour is different. If this is true, then the child class will automatically override the parent's behaviour(s). 

<br></br>
## Java's Implementation
```java
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

public class Cabbage extends Vegetable{
    String kindOfFood = "Cabbage";
    // since Cabbage class doesn't have acces to private variables
    //  it would NOT be overriding the parent classes 'kindOfFood'
    // also, weight is not a state that needs to be
    boolean fresh;
    // this state will NOT be withing the parent class, meaning
    //      the parent class has no state called fresh
    // other states

    public Cabbage(double weight, boolean fresh){
        super(weight);
        // child classes must use their parent class's constructor;
        //    child classes build off parent classes, so they would
        //    be 'missing' a piece if they didn't call the parent's
        //    constructor
        // calling the parent's constructor is creating the 'main' piece(s)
        //      of this object; main being the parent portions
        this.fresh = fresh;
    }
    
    // adding a printWeight() is unneccessary, as th parent class
    //      is already implementing it
    
    @Override
    public void printKind(){
        System.out.println("Cabbage Class kindOfFood: " + kindOfFood);
        // Q1: if this function weren't here, what would an object ot
        //      class Cabbage print instead?
    }
    
    public void printFresh(){
        System.out.println("Cabbage Class fresh: " + fresh);
    }
    // other behaviours
}

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

```

<br></br>
## Swift's Implementation
#### *Swift is written here using Python markdown, as Swift markdown is not yet supported*
```python
class Vegetable{
  var kindOfFood = "Vegetable"
  var weight
  
  init(weight: double){
  }
  
  func printWeight(){
    print(weight);
  } 
}

class Cabbage: Vegetable{
  var weight
  
  init(weight: double){
  }
  
  func printWeight(){
    print(weight);
  }
}

class January_King: Cabbage{
  var weight
  
  init(weight: double){
  }
  
  func printWeight(){
    print(weight);
  }
}

# the printWeight() in each class would override the one in the parent's class
# the string called kindOfFood is (if not private) available to all the child classes of Vegetable for manipulation
# NOTE: Swift's comments are not denoted by #, they are: // - for single lines and /*(begin) for multiple lines (end)*/
```

<br></br>
## Java vs. Swift

Java and Swift's implementation of extension is very similar. 
Swift denotes class types (parent class) with a colon and Java with the keyword "extends."
In regards to overriding parent behaviours, there are special keywords that are used to implement this.. Java uses annotations for override: @Override, which precedes the declaration of a behavior (states are easily manipulated, if they are not private in the parent class), and Swift uses simply 'override' on the same line as the declaration of the behaviour; Swift can also use this notation for states as sampled in: 
```python 
  class January_King_Override: Cabbage{...}
```

To practice this new knowledge, can you solve the answers to Q1-4 in the Java sample code and Q5-? in the Swift example code?
Try running the Java and Swift programs!



