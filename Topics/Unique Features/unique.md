# Unique Features
## *This article will discuss unique features in Java and Swift*

## Unique features in Java
* I'm and unordered list
	* I'm a sub unordered list!

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
