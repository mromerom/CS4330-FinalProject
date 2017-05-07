# Null and Nil
#### **This is an article on null and nil Java and Swift**
<br></br>
## What is a Null object?
In Object Oriented Programming, a Null (or nil) object is one with no referenced value or with defined neutral behavior. The Null Object Design Pattern describes the uses of such objects and their behavior.
<br></br>
## Null Object Design Pattern
In Java (and several other Object Oriented languages), references need to be checked to ensure they are not null before any methods invoking said references are called, because methods typically cannot be invoked on null references.
Languages like Java use the Null Object Design Pattern to circumvent this issue, in which an object implementing the expected interface with an empty method body is used. This has no side effects.
<br></br>
## Comparing Swift and Java
There is one very obvious difference between Java and Swift here, and that is that Java uses Null and Swift uses nil. A minor detail. Less superficial is the fact that Swift uses a paradigm called *optionals*. Simply put: optionals handle the absence of a value. With an optional type (designated with a *?*), there may or may not be a value, and in order to access the value (should there be one), it has to be unwrapped (forced with *!*).
<br></br>
## Java's implementation of the Null Object Design Pattern
```java
public interface Animal {
	void makeSound();
}

public class Dog implements Animal {
	public void makeSound() {
		System.out.println("woof!");
	}
}

public class NullAnimal implements Animal {
	public void makeSound() {

	}
}
```
<br></br>
## Swift's imeplementation of optionals and optional chaining
```
class ElectionPoll {
   var candidate: Pollbooth?
}
class Pollbooth {
   var name = "MP"
}

let cand = ElectionPoll()
   
if let candname = cand.candidate?.name {
   println("Candidate name is \(candname)")
}else {
   println("Candidate name cannot be retreived")
}
```
When we run the above program using playground, we get the following result:
```
Candidate name cannot be retreived
```
