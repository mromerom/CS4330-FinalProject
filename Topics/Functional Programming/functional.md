# Functional programming
#### *This article will discuss functional programming in the context of Java and Swift*
<br></br>
## What is functional programming?
Like Object Oriented Programming, functional programming is a programming paradigm which evaluates computation as mathematical functions and avoids mutable data. The main benefit of functional programming are functions without side effects, that is, functions which do not alter data unexpectedly.

## Support in Java and Swift
Both Java and Swift support functional programming in their own ways.
<br></br>
### Java's implementation
Java's implementation of functional programming is through the usage of lambda expressions, introduced in Java SE8. Lambda expressions provide a concise way of representintg a one-method interface using an expression. They also make it easier to extract data from a collection. Here's an example of a listener in Java, using a lambda expression:
<br></br>
```java
public class ListenerTest {
	public static void main(String[] args) {
         
	JButton testButton = new JButton("Test Button");
     	testButton.addActionListener(new ActionListener(){
     		@Override public void actionPerformed(ActionEvent ae){
         		System.out.println("Click Detected by Anon Class");
       		}
     	});
     
	testButton.addActionListener(e -> System.out.println("Click Detected by Lambda Listner"));
}
```
<br></br>
As we can see in the above example, the lambda is passed as a parameter. Lambdas are used for other functional programming implementations, for example, abstract factories, which are lambdas that conform to some interface and return a new object.
<br></br>
Additionally, Java SE8 brought over the ability to treat functions as first-class objects. This enables:
* Super Private Functions: Function in our class which is visible to just one method and invisble to the rest of the class
* Upgrade Design Pattern: Switches similar algorithms, depending on a parameter. For each algorithm, you write your own class, which implements a function from an interface. However, when you can store functions in an object, you just need one function object for each algorithm.
* Higher-order Functions: As a result of the first-class treatment of functions, means we are able to create higher-order functions. Higher-roder functions have two characteristics:
	* They use a function as an argument.
	* They return a function.
```java
public static Integer compute(Function<Integer, Integer> function, Integer value) {
    return function.apply(value);
}
```
Here is a good example of what functional programming looks like in Java now:
```java
public class AwesomeClass {

    public static Integer changeTheNumber(Function<Integer, Integer> func){
        Integer toChange = 5;
        return compute(func, toChange);
    }

}
```
<br></br>
### Swift's implementation
With every new iteration of Swift, it seems that Swift has been moving away from Object Oriented Programming and towards functional programming. Swift incorporates several functional programming concepts:
* Immutability: This is done using the *let* keyword (as opposed to *var*) when creating a value. The point of immutability is to write thread-safe code. Example of *let* usage:
``` 
let foo = 1
```
* Value Types: Instead of passing references, passing values creates safer code by copying on assignment. Structs are good examples of value types. Struct delcaration:
```
struct Resolution {
    var width = 0
    var height = 0
}
```
* Pure Functions: These are functions where the return value is only determined by the input value(s), free from any side effects. Example of a pure function:
```
func sum(_ a: Int, _ b: Int) -> Int { 
    return a + b 
}
```
* First-class Functions: Swift allows functions to be treated as first-class citizens, that is, to be assigned to variables. This allows us to write functions that take in other functions as arguments, as well as returning a function.
```
func sayHello() {
    print("Hi!")
}
let greeting = sayHello
greeting()
```
* Higher-order Functions: Just like in Java SE8, as a result of the first-class treatment of functions, means we are able to create higher-order functions. Higher-roder functions have two characteristics:
	* They use a function as an argument.
	* They return a function.
```
func inside() -> Void { 
    print("Hello world!")
}
func outside(inner: () -> Void) { 
    inner()
}
outside(inside) // prints Hello world!
```
