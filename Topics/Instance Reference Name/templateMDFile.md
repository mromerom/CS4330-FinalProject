# Instance Reference Name in Data Type (class)
#### *This document will explain what this, self, and super mean.* 

<br></br>
## Instance Reference Names
Instance reference names are keywords that refer to an object's reference variable: ex. when an object calls a function in its class, it might need to reference itself, or a parent class, inorder to implement the function. 


<br></br>
## Java's Implementation
```java
public interface InterfaceSuperExample {
    
    default public void printFreshness(boolean fresh){
        if(fresh)
            System.out.println(this.getClass().getCanonicalName() + " is fresh");
        else
            System.out.println(this.getClass().getCanonicalName() + " is not fresh");
    }
    
}

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
    
    public double calculateWeighttoKg(){
        return weight * (1/2.205);
    }
    // other behaviours
}

public class Cabbage extends Vegetable implements InterfaceSuperExample{
    String kindOfFood = "Cabbage";
    boolean fresh;


    public Cabbage(double weight, boolean fresh){
        super(weight);
        // child classes must use their parent class's constructor;
        //    child classes build off parent classes, so they would
        //    be 'missing' a piece if they didn't call the parent's
        //    constructor
        // calling the parent's constructor is creating the 'main' piece(s)
        //      of this object; main being the parent portions
        // whenever a child class needs to access its variables/ functions
        //      that a parent class holds for them, they use super()
        this.fresh = fresh;
        // the this keyword is a reference to the object that is calling
        //      a function or being initialized/ created
        // it's used to manipulate the object's states 
    }

    
    public void printFresh(){
        System.out.println("Cabbage Class fresh: " + fresh);
        InterfaceSuperExample.super.printFreshness(fresh);
    }
    
    public void printWeightKg(){
        System.out.println("Cabbage Class: call to parent class.");
        System.out.println("\tWeight in lbs: " + super.weight);
        System.out.println("\tWeight in kgs: " + super.calculateWeighttoKg());
        // the super keyword can also be used to call parent functions,
        //      and variables the parent holds for the object
        //      note: one can easily say 'weight' instead of 'super.weight'
        // this can make calling multiple functions easier by 
        //      limiting the number of functions needed to get
        //      certain output (especially if the output needs to
        //      outputted multiple times)
    }
    // other behaviours
    
    
    // these keywords are special
    // this, in Java, can only reference the object that made
    //      a function call or an object that is being created
    //      aka. the current object that is in action 
    // super can only be used if the object's class extends
    //      another class
    //      note: with interfaces, super can be used as such:
    //              <interface>.super.<interfacemethod>(<parameters>);
    //                  for method calls to default methods
    
    public static void main(String[] args) {
        // TODO code application logic here
        Cabbage cabbage = new Cabbage(3.3, true);
        
        System.out.println("Freshness and weight from pounds to kg: ");
        cabbage.printFresh();
        cabbage.printWeightKg();
    }
}
```

<br></br>
## Swift's Implementation
```python

```


<br></br>
## Comparing
Both Java and Swift use the super keyword almost exactly the same. Java does not require the super call to denote when it's calling the constructor. It's simply: 
```java 
// call to Cabbage's parent's, Vegetable, constructor
super(weight);
// call to Cabbage's parent's, Vegetable, method: calculateWeighttoKg()
System.out.println("\tWeight in kgs: " + super.calculateWeighttoKg());
```. 
While Swift requires super to specify which function to call, including the constructor: 
```python
// call parent constructor(s)
super.init()
```
Swift uses self instead of this, which makes understanding the use of this/ self more apparent. Personally, I believe 'self' is much more intuitive than 'this,' as it is more clear on what object it is referencing.


<br></br>
### Practice Your Knowledge!
#### Q1
```java
```
Answer:
> 










