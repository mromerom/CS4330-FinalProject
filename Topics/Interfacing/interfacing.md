# Interfacing
#### *This document will explain interfacing.* 

<br></br>
## What is an interface?
An interface is a programming structure that allows the computer to enforce certain properties on an object. Essentially, interfaces describe the actions an object can do.
<br>
They differ from [classes](https://github.com/mromerom/CS4330-FinalProject/blob/master/Topics/Classes/templateMDFile.md) in that an interface provides the “specification” of the method and field names, their parameters and return types, if any. Classes that implement this interface must define and implement a method or field exactly matching the “signature” of each specified method in the interface. Additionally, interfaces cannot contain executable code, contrary to classes.

<br></br>
## Java's Implementation
```java
public interface OperateCar {

   // constant declarations, if any

   // method signatures
   
   // An enum with values RIGHT, LEFT
   int turn(Direction direction,
            double radius,
            double startSpeed,
            double endSpeed);
   int changeLanes(Direction direction,
                   double startSpeed,
                   double endSpeed);
   int signalTurn(Direction direction,
                  boolean signalOn);
   int getRadarFront(double distanceToCar,
                     double speedOfCar);
   int getRadarRear(double distanceToCar,
                    double speedOfCar);
         ......
   // more method signatures
}

// implementation in a class

public class OperateBMW760i implements OperateCar {

    // the OperateCar method signatures, with implementation --
    // for example:
    int signalTurn(Direction direction, boolean signalOn) {
       // code to turn BMW's LEFT turn indicator lights on
       // code to turn BMW's LEFT turn indicator lights off
       // code to turn BMW's RIGHT turn indicator lights on
       // code to turn BMW's RIGHT turn indicator lights off
    }

    // other members, as needed -- for example, helper classes not 
    // visible to clients of the interface
}


```

## Swift's Implementation
```
protocol Animal {
	var lives:Int { get set }
      	var limbs:Int { get }
      	func makeNoise() -> String
}

class Cat: Animal {
	var lives = 9
     	var limbs = 4
     	func makeNoise() -> String {
        return "meow"
     }
}

```

<br></br>
## Comparing
As you may have noticed, Swift, while having the ability to interface, does not call its structure an "interface"; in Swift, interfaces are called "protocols". For the most part, protocols in Swift and interfaces in Java are the same, but there are some small differences between the two.

1. Swift protocols can also specify properties that must be implemented (i.e. fields)<br>
2. Swift protocols need to deal with value/reference through the use of the mutating keyword (because protocols can be <br> 3.implemented by structs and classes)you can combine protocols at any point with the protocol<> keyword. For example, declaring a function parameter that must adhere to protocol A and B as:
```
	func foo ( var1 : protocol<A, B> ){}
```
