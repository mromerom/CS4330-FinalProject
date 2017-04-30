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
    // Q2: Which kindOfFood do you think this would print if it were active (uncommented)?
    
    
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
        jking.printKind(); // Q3: output: ?

        System.out.println("\ncabbage, jking:");
        cabbage.printFresh(); // output: true
        jking.printFresh(); // output: false
        // overriding methos isn't necessary, but it can prove to be very useful

        System.out.println("\njking");
        jking.printRegion(); // output: January King Class region: northwest
        
        System.out.println("\nveggie = jking:");
        veggie = jking;
        veggie.printWeight(); // Q4: output?
        veggie.printKind(); // Q5: output?
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
  private var kindOfFood: String = "Vegetable";
  var weight: Double = 0;
  
  init(weight: Double){
    self.weight = weight;
    # java uses 'this' and swift uses 'self'
    #  this will be covered in a later topic,
    #  under self-referencing
  }
  
  func printWeight(){
        print(weight);
  } 
  
  func printKind(){
      print("Vegtable Class kindOfFood: " + kindOfFood)
      # see the comment under this same class's function in Java
  }
  
}
class Cabbage: Vegetable{
    var kindOfFood: String = "Cabbage";
    # since Vegetable's kindOfFood variable was private,
    #      Cabbage doesn't 'have' one
    var fresh: Bool = true;
  
    init(weight: Double, fresh: Bool){
        super.init(weight: weight)
        self.fresh = fresh;
    }
  
    # no need to add printWeight() as the parent class 
    #    provides it
  
    override func printKind(){
        print("Cabbage Class kindOfFood: " + kindOfFood)
        # Q6: if this function weren't here, what would an object of
        #      class Cabbage print instead?
    }
    
    func printFresh(){
        print("Cabbage Class fresh: " + String(fresh));
    }
  
}
class January_King: Cabbage{
    var region: String = "southwest";
  
    init(weight: Double, fresh: Bool, region: String){
        super.init(weight: weight, fresh: fresh)
        self.region = region;
    }
  
    # no need to add printWeight() as the parent class 
    #    provides it
  
    '''
    override func printKind(){
        print("January_King Class kindOfFood: " + kindOfFood)
    }
    Q7: Which kindOfFood do you think this would print if it were active (uncommented)?
    '''
    
    # no need to add printFresh() as the parent class 
    #      provides it
    
    func printRegion(){
        print("January_King class region: " + region)
    }
  
}

var veggie = Vegetable(weight: 3.2);
var cabbage = Cabbage(weight: 3.3, fresh: true);
var jking = January_King(weight: 3.4, fresh: false, region: "northwest");


print("veggie, cabbage, jking");
veggie.printWeight();
cabbage.printWeight();
jking.printWeight();

print("\nveggie, cabbage, jking");
veggie.printKind(); # output = Vegetable Class kindOfFood: Vegetable
cabbage.printKind(); # output = Cabbage Class kindOfFood: Cabbage
jking.printKind(); # Q8: output = ?

print("\ncabbage, jking");
cabbage.printFresh(); # output = true
jking.printFresh(); # output = false

print("\njking");
jking.printRegion(); # output = northwest

print("\nveggie = jking");
veggie = jking;
veggie.printWeight(); # Q9: output = ?
veggie.printKind(); # Q10: output = ?


# NOTE: Swift's comments are not denoted by #, they are: // - for single lines and /*(begin) for multiple lines (end)*/
```

<br></br>
## Java vs. Swift

The properties of inheritance and extension do not change from language to language. However, the actual coding implementation does. 
To denote that a class is a child of another, Java uses 'extends':
```java
public class Cabbage extends Vegetable(){}
```
Swift uses a colon:
```python
class Cabbage: Vegetable(){}
```

In regards to overriding parent behaviours, there are special keywords that are used to implement this. 
Java uses annotations for override: @Override, which precedes (on the same line or above) the declaration of the behaviour:
```java
@Override
public void printKind(){
    System.out.println("Cabbage Class kindOfFood: " + kindOfFood);
}
```
Swift uses simply 'override' on the same line as the declaration of the behaviour: 
```python
override func printKind(){
    print("Cabbage Class kindOfFood: " + kindOfFood)
}
```
Overriding functions is not necessary! Sometimes there's not reason to override a function, such as printWeight(). However, it would make sense to override any of the functions that are specific to the class it's printing in. For example, everyone knows a cabbage is a vegetable, but what is a January King vegetable? It would make sense, in this case, to override printKind() in January_King as such:
```java
@Override
public void printKind(){
    System.out.println("January_King Class kindOfFood: " + kindOfFood);
    // this will still print the parent class's kindOfFood, but now,
    //      the person who calls this will know that a January_King is
    //      a kind of cabbage
}
```
<br></br>
### Practice Your Knowledge!
To practice this new knowledge, can you solve the answers to Q1-5 in the Java sample code (and Q6-10 in the Swift example code)?
Try running the Java and Swift programs! (Hint: Q2 has already been slightly solved in the above section about when to override!)

#### Q1
```java
@Override
public void printKind(){
    System.out.println("Cabbage Class kindOfFood: " + kindOfFood);
    // Q1: if this function weren't here, what would an object ot
    //      class Cabbage print instead?
}
```
> Answer: If Cabbage did not override the function, cabbage.printKind() will print the same as veggie.printKind(), because the parent class doesn't know that the child class has its own variable 'kindOfFood,' as its not a share variable and will not override vegtable class's 'kindOfFood.'

#### Q2
```java
/*@Override
public void printKind(){
    System.out.println("January King Class kindOfFood: "+ kindOfFood);
}*/
// Q2: Which kindOfFood do you think this would print if it were active (uncommented)?
```
> Answer: January_King's printKind() would print Cabbage as its 'kindOfFood,' as it's declared in the Cabbage class and not modified in January_King. 


#### Q3-5
```java
veggie.printWeight(); // output: 3.2
cabbage.printWeight(); // output: 3.3
jking.printWeight(); // output: 3.4
// ...
veggie.printKind(); // output: Vegetable Class kindOfFood: Vegetable
cabbage.printKind(); // output: Cabbage Class kindOfFood: Cabbage
jking.printKind(); // Q3: output: ?
// ...
veggie = jking;
veggie.printWeight(); // Q4: output?
veggie.printKind(); // Q5: output?
```
> Answers: 
> Q3: jking.printKind() would be the same as cabbage.printKind(), because it didn't override the function or modify what 'kindOfFood' was 
> Q4: since parents can be assigned to their child class objects, veggie.printWeight() = 3.4
> Q5: according to #4, this means that veggie.printKind() = Cabbage Class kindOfFood: Cabbage



