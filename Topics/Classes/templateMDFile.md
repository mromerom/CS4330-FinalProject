# Comparison of Classes
## This document will discuss how classes are implemented in Java and Swift.

## An essential concept of Object Oriented Programming, a class is simply a type of object.

<br></br>
## Java's Implementation
```java
public class Bicycle {
        
    // the Bicycle class has
    // three fields
    public int cadence;
    public int gear;
    public int speed;
        
    // the Bicycle class has
    // one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }
        
    // the Bicycle class has
    // four methods
    public void setCadence(int newValue) {
        cadence = newValue;
    }
        
    public void setGear(int newValue) {
        gear = newValue;
    }
        
    public void applyBrake(int decrement) {
        speed -= decrement;
    }
        
    public void speedUp(int increment) {
        speed += increment;
    }
        
}
```


## Swift's Implementation
```python
class Person {
 
    var firstName: String?
    var lastName: String?
    let birthPlace = "Belgium"
 
    func fullName() -> String {
        var parts: [String] = []
 
        if let firstName = self.firstName {
            parts += [firstName]
        }
 
        if let lastName = self.lastName {
            parts += [lastName]
        }
 
        return parts.joined(separator: " ")
    }
 
}
```

<br></br>

## Comparing
Because classes are a key element of Object Oriented Programming, there are obvious similarities when declaring classes in Java and Swift. However, there are several differences.

### Abstract Classes
Unlike Swift, Java has abstract classes, which may or may not contain abstract methods and cannot be instantiated. With abstract classes, you can declare fields that are not static and final, and define public, protected, and private concrete methods. They are somewhat similar to interfaces.
*Java*
```java
public abstract class GraphicObject {
   // declare fields
   // declare nonabstract methods
   abstract void draw();
}
```

### Access Control
In order to declare a class in Java, we must specify what access modifier it has. Swift, on the other hand, does not require the declaration of an access modifier to declare a class. The Java access modifiers are public, protected, no modifier (default), or private. Swift has open and public, internal, file-private, and private.

### Structs
Aside from classes, Swift also has structs, which are similar to classes. This is a feature that is not available in Java. The difference between a class and a struct in Swift, is that classes support inheritance, while structs do not. Additionally, structs are value types, meaning they are passed by value, while classes are reference types and are passed by reference.
*Swift*
```python
struct Point {
 
    var x: Int
    var y: Int
 
    init(x: Int, y: Int) {
        self.x = x
        self.y = y
    }
 
}
 
var point1 = Point(x: 0, y: 0)
var point2 = point1
 
point1.x = 10
 
print(point1.x) // 10
print(point2.x) // 0
```
