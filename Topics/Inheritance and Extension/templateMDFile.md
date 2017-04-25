# Inheritance/ Extension
#### *This document will explain, compare, and give examples of how Java and Swift implement inheritance.*

<br></br>
## Inheritance and Extension
Inheritance is when an object is built up from another object; this is usually explained as an IS-A relationship. For example, vegetables are healthy foods that humans (should) eat. A cabbage *is* a vegetable, and a carrot *is* a vegetable; in this instance, vegetables would be a 'parent' (extended) class and cabbage and carrot would be two different 'child' (inheriting) classes. Each 'child' of an object is a more specific version of its parent; another example of this is: a january_king_cabbage is a cabbage is a vegetable (similar to how taxonomy works). 

In programming implementation, a 'child' class is said to *extend* a 'parent' class, and the 'child' class is said to have *inherited* the states and behaviours of the 'parent' class.

<br></br>
## Java's Implementation
```java
public class Vegetable{
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
  String kindOfFood = 'Vegetable';
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

public class January_King_Cabbage extends Cabbage{
  double weight;
  // other states
  
  public January_King_Cabbage(double weight){
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
```

<br></br>
## Java vs. Swift

