# Unique Features
## *This article will discuss unique features in Java and Swift*

## Unique features in Java
Java is seen has highly compactible because of its use of the Java virtual machine (JVM). This allowed Java applications to be compiled once into bytecode and then run on any JVM running on any platform. This made Java as well-known as it is today and because of this Java is boasted to be on over 9 billion devices worldwide. These devices are but not limited to Windows, Linux, Android, Mac and iOS. I consider this to be unique because at the time programs would need to be recompiled or rewritten for every machine / OS that it was going to be used on. Even though in early computing the JVM overhead was enough to cause concern the advancement of technology and thus the speed of computing pushed the universal JVM and its applications to become a substantial portion of the market. 

* Passed by Value: Even though Java's objects are managed by references and all object variables have references they are not passed by reference to methods.  Here is an example to put things into perspective:
```
public void fun(Point p1, Point p2){
p1.x = 4;
p1.y = 4;
Point temp = p1;
p1 = p2;
p2 = temp;
}

public static void main(String [] args)
{
   Point one = new Point (1,1);
   Point two = new Point (2,2);
   System.out.println("P1.X: " + one.x + "P1.Y: " + one.y);
   System.out.println("P2.X: " + two.x + "P2.Y: " + two.y);
   fun(one, two);
   System.out.println("P1.X: " + one.x + "P1.Y: " + one.y);
   System.out.println("P2.X: " + two.x + "P2.Y: " + two.y);   
}
```
The output we would achieve from this is:
```
P1.X: 1 P1.Y: 1
P2.X: 2 P2.Y: 2
P1.X: 4 P1.Y: 4
P2.X: 1 P2.Y: 1
```
 * So now you might be confused because during our fun method we did set p1 equal to p2 and p2 equal to p1. Since these are pass via value we set p1 x and y to 4. Afterwards, we just swapped the values of p1 to p2. Meaning that p2 in fact was point to p1 because of this p2 is unchanged in main as it was never truly modified by reference in which it would have swapped p1 and p2 in main.

* Factories: While Java isn't the only OO language to implement factories, I find these unique. They are unique because they are objects that create other objects. These factories can be used to determine what type of object should be made then creating that new object and returning it. Below is an example of such an instance where this would be needed.
```
public class ImageReaderFactory {
    public static ImageReader createImageReader(ImageInputStreamProcessor iisp) {
        if (iisp.isGIF()) {
            return new GifReader(iisp.getInputStream());
        }
        else if (iisp.isJPEG()) {
            return new JpegReader(iisp.getInputStream());
        }
        else {
            throw new IllegalArgumentException("Unknown image type.");
        }
    }
}
```

## Unique features in Swift
Though not all of these features are exclusive to Swift, the progressive implementation of functional programming practices set Swift apart as an Object Oriented Language. Here are some of Swift's more interesting features:
* Named parameters: Not exclusive to Swift, this feature is borrowed from Objective-C. Allowing users to name a parameter can help improve code readability. Example:
```
func greet(person: String) -> String {
    let greeting = "Hello, " + person + "!"
    return greeting
}
```
* Custom operators: Swift's statically-typed nature allows allows users to define custom operators, which the compiler will determine when to apply. Example:
```
// Operator definition
prefix operator ++

prefix func ++ (value: Int) -> Int {
    return value + 2
}

// Example
let value = 10
// result = 12
let result = ++value
```
* Closures as parameters: Closures are self-contained blocks of functionality that can be passed around and used in your code. Closures in Swift are similar to lambdas in Java. If your closure is too long, you can use trailing closure syntax to still pass it as a parameter in a function. Example:
```
someFunctionThatTakesAClosure(closure: {
    // closure's body goes here
})
 
// Here's how you call this function with a trailing closure instead:
 
someFunctionThatTakesAClosure() {
    // trailing closure's body goes here
}
```
* Namespacing: In Swift you can create nested structs, enums, and classes inside of classes and structs. This lets you create namespaces.
```
class Farm {
  var pen = Array<Animal>()
  
  init() {
  }
  
  func addAnimal(animal: Animal) {
    pen.append(animal)
  }
  
  class Animal {
    var name: String
    
    init(name: String) {
      self.name = name
    }
  }
  
  class Horse: Animal {}
  
  class Dog: Animal {
    var breed: String
    
    init(name: String, breed: String) {
      self.breed = breed
      super.init(name: name)
    }
  }
}
```
* Convenience initializers: Convenience initializers are secondary, supporting initializers for a class. You can define a convenience initializer to call a designated initializer from the same class as the convenience initializer with some of the designated initializer’s parameters set to default values. You can also define a convenience initializer to create an instance of that class for a specific use case or input value type. Example:
```
convenience init(parameters) {
    statements
}
```
* Optionals: Making a list of unique or interesting features in Swift is impossible without mentioning optionals. handle the absence of a value. Optionals say either “there is a value, and it equals x” or “there isn’t a value at all”. Example:
```
var stockCode:String? = findStockCode("Facebook") 	// ? designates an optional; there may or may not be a value
let text = "Stock Code - "
if stockCode {
    let message = text + stockCode!			// ! unwraps the optional to retrieve the value stored in stockCode
    println(message)
}
```
