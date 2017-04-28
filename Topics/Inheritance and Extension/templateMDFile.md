# Inheritance/ Extension
#### *This document will explain, compare, and give examples of how Java and Swift implement inheritance.*

<br></br>
## Inheritance and Extension
Inheritance is when an object is built up from another object; this is usually explained as an IS-A relationship. For example, vegetables are healthy foods that humans (should) eat. A cabbage *is* a vegetable, and a carrot *is* a vegetable; in this instance, vegetables would be a 'parent' (extended) class and cabbage and carrot would be two different 'child' (inheriting) classes. Each 'child' of an object is a more specific version of its parent; another example of this is: a january_king **is a** cabbage **is a** vegetable. You can also think of the taxonomic rank, Domain->Kingdom->Phylum->Class->Order->Family->Genus->Species, with each rank/ level getting progressively more specific towards a single kind of animal or plant. 

In programming implementation, a 'child' class is said to *extend* a 'parent' class, and the 'child' class is said to have *inherited* the states and behaviours of the 'parent' class. Any non-private states or behaviours that the parent class has declared will be a part of the child class's states and behaviours; the behaviours do not need to be written in the child class, *unless* the child class' version of that behaviour is different. If this is true, then the child class will automatically override the parent's behaviour(s). 

<br></br>
## Java's Implementation
```java
public class Vegetable{
  String kindOfFood = 'Vegetable';
  double weight;
  // other states
  
  public Vegetable(double weight){
      this.weight = weight;
  }

  public void printWeight(){
      print(weight);
   } 
  // other behaviours
}

public class Cabbage extends Vegetable{
  double weight;
  // other states
  
  public Cabbage(double weight){
      this.weight = weight;
  }

  public void printWeight(){
      print(weight);
   } 
  // other behaviours
}

public class January_King extends Cabbage{
  double weight;
  // other states
  
  public January_King(double weight){
      this.weight = weight;
  }
  
   public void printWeight(){
      print(weight);
   } 
  // other behaviours
}

// the printWeight() in each class would override the one in the parent's class
// the string called kindOfFood is (if not private) available to all the child classes of Vegetable for manipulation
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
In regards to overriding parent behaviours, there are special keywords that are used to implement this. However, they are *not* required. Java uses annotations for override: @override, which precedes the declaration of a behavior (states are easily manipulated if they are not private in the parent class), and Swift uses simply 'override' on the same line as the declaration of the behaviour (Swift can also use this notation for variables as noted in ```python class January_King_Override: Cabbage```).




