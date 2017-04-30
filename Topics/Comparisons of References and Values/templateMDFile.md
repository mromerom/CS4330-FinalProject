# Inheritance/ Extension
#### *This document will explain how values are compared, ie. comparing two strings.*

<br></br>
## References and Values
Comparing two variables and checking if they are 'the same' ca be pretty tricky. For primitive types (int, double, char), a simple == is used. These primitive types only contain the values associated with the variable. However, many comparisons are made on objects (String, Double, CustomObj). These contain much more information about the variable than just its value. For example, in the topic Inheritance and Extension, Cabbage's have a weight and freshness, say you wanted had a few cabbage objects and wanted to see if any are the same. How could you do that? 

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

public class Cabbage extends Vegetable{
    String kindOfFood = "Cabbage";
    // since Cabbage class doesn't have access to private variables
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
    
    /*@Override
    public void printKind(){
        System.out.println("Cabbage Class kindOfFood: " + kindOfFood);
        // Q1: if this function weren't here, what would an object ot
        //      class Cabbage print instead?
    }*/
    
    public void printFresh(){
        System.out.println("Cabbage Class fresh: " + fresh);
    }
    
    
    public boolean equals(Cabbage other){
        if(!(other instanceof Cabbage))
            return false;
        
        return this.weight == other.weight && this.fresh == other.fresh;
    }
    // we need to override the .equals() function in order to compare
    //      every attribute
    
    // other behaviours

public static void main(String[] args) {
        Cabbage cabbage1 = new Cabbage(3.3, true);
        Cabbage cabbage2 = new Cabbage(3.4, false);
        Cabbage cabbage3 = new Cabbage(3.3, true);
        Cabbage cabbage4 = new Cabbage(3.3, false);
        
        String str1 = "Hi";
        String str2 = "Hello";
        String str3 = "Hi";
        
        int i = 3;
        int j = 3;
        int k = 2;
        System.out.println("Primitive Comparisons:");
        System.out.println("i = " + i + ", j = " + j + ", k = " + k);
        System.out.println("i == j: " + (i == j));
        System.out.println("i == k: " + (i == k));
        
        System.out.println("\nObject Comparisons:");
        System.out.println("Cabbage1: ");
            System.out.println("\tweight: " + cabbage1.weight);
            System.out.println("\tfresh: " + cabbage1.fresh);
        System.out.println("Cabbage2: ");
            System.out.println("\tweight: " + cabbage2.weight);
            System.out.println("\tfresh: " + cabbage2.fresh);
        System.out.println("Cabbage3: ");
            System.out.println("\tweight: " + cabbage3.weight);
            System.out.println("\tfresh: " + cabbage3.fresh);
        System.out.println("Cabbage4: ");
            System.out.println("\tweight: " + cabbage4.weight);
            System.out.println("\tfresh: " + cabbage4.fresh);
        // we can see from the declarations and these prints that
        //      only cabbage1 and cabbage3 are truly 'equal' or the same
        // let's compare them with ==
        System.out.println("\nComparing objects with ==: ");
        System.out.println("cabbage1 == cabbage 3: " + (cabbage1 == cabbage3));
        System.out.println("cabbage1 == cabbage 2: " + (cabbage1 == cabbage2));
        System.out.println("cabbage1 == cabbage 4: " + (cabbage1 == cabbage4));
        System.out.println("cabbage2 == cabbage 3: " + (cabbage2 == cabbage3));
        System.out.println("cabbage2 == cabbage 4: " + (cabbage2 == cabbage4));
        System.out.println("cabbage3 == cabbage 4: " + (cabbage3 == cabbage4));
        // why are none of these correct??
        // with objects, == checks to see if the variables are pointing to
        //      the same object (explicitly the same: the variables point to 
        //      the same address of the object)
        
        System.out.println("\nComparing objects with == (fixed): ");
        System.out.println("Cabbage cabbage5 = cabbage2;");
        Cabbage cabbage5 = cabbage2;
        System.out.println("cabbage2 == cabbage 5: " + (cabbage2 == cabbage5));
        // Q1: what will this output? what does this mean?
        System.out.println("cabbage5.weight = 5;");
        cabbage5.weight = 5;
        System.out.println("cabbage5.weight = " + cabbage5.weight);
        System.out.println("cabbage2.weight = " + cabbage2.weight);
        // Q2: based on your conclusion from Q1, what will these two statements output?
        
        // now let's backtrack
        // we know that cabbage1 and cabbage3 are the same, how do we compare them?
        // now let's backtrack
        // we know that cabbage1 and cabbage3 are the same, how do we compare them?
        // let's learn about .equals()
        System.out.println("\nComparing Strings with str1.equals(str2): ");
        System.out.println("str1 = " + str1 + ", str2 = " + str2 + ", str3 = " + str3);
        System.out.println("str1.equals(str3): " + (str1.equals(str3)));
        System.out.println("str1.equals(str2): " + (str1.equals(str2)));
        System.out.println("str2.equals(str3): " + (str2.equals(str3)));
        // this is a special function developed for String objects
        // all objects have this function, actually, but it doesn't
        //      always work as expected 
        // for Strings, we know we're specifically looking at each character
        //      and the character's order in the string and seeing if str1
        //      has the same string as str3, which it does
        // for custom objects, there needs to be specificity
        //      ex. what makes two objects the same?
        //      typically, this means seeing if the objects are the same instance,
        //          if this is true, then one would have to compare all the variables
        //          ex. Cabbages have weight and fresh (kindOfFood can be ignored)
        
        // fortunately we can use our knowledge of overriding
        //      to make this function do what we want it too
        //      (see the overriden function in Cabbage class)
        // Q3: a. what will these lines output if the function isn't overriden?
        //     b. will any print true? why?
        System.out.println("\nComparing Objects with overidden .equals(): ");
        System.out.println("cabbage1.equals(cabbage3): " + (cabbage1.equals(cabbage3)));
        System.out.println("cabbage1.equals(cabbage2): " + (cabbage1.equals(cabbage2)));
        System.out.println("cabbage1.equals(cabbage4): " + (cabbage1.equals(cabbage4)));
        System.out.println("cabbage2.equals(cabbage3): " + (cabbage2.equals(cabbage3)));
        System.out.println("cabbage2.equals(cabbage4): " + (cabbage2.equals(cabbage4)));
        System.out.println("cabbage3.equals(cabbage4): " + (cabbage3.equals(cabbage4)));
        System.out.println("cabbage2.equals(cabbage5): " + (cabbage2.equals(cabbage5)));
        // Q4: what will cabbage2.equals(cabbage5) output if equals() IS overriden?
        // now this can be a small hassle trying to compare every variable of an object,
        //      but it can be very useful for finding duplicate information
        // however, most programming suggests to have a 'primary key' that
        //      makes objects unqiue; then, one would compare those keys
    }
```

<br></br>
## Swift's Implementation



<br></br>
## Comparing



<br></br>
## Practice Your Knowledge!
Q1
Q2
Q3
Q4
