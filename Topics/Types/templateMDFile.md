# Comparison of Types
## This document will discuss types for Java and Swift.
Swift and Java are relatively similar in that they both have value and reference types. Value data types send a copy of themselves when sent to a function or assigned to another variable. Where as reference types will send / give a reference of the object they reference meaning both variable holding that reference are pointing to the same object.

## Java's Types
In Java however their value types are called primitive types. These primitive types are: boolean, byte, char, short, int, long, float and double.
### Value Type
Following are some code examples of Java primitive types.
```
int a = 2;
char b = 'b';
boolean f = false;
double d = 3.40;
```
### Reference Type
Assume we have a class called Ball. The following code will show example of a reference type using class Ball.
```
Ball b = new Ball();

Ball a = b;
// Ball a and b will reference the same object
```
## Swift's Types
In Swift we have both value and reference types. However, depending on who you talk too swift also have "primitive" types.
### "Primitive" Value Types
These "primitive" types are Int, Float, Double, Bool, String and Character. Now the reason these are considered "primitive" is because they compiler hooks into the underlying way the CPU processes these data type naturally. It is important to understand that there is no difference between these data types like the ones in Java. For example int and Integer in Java are completely different. You do not have to declare types for these "primitive" types are they are implied based on what data is being assigned to them.
 
```
var a = 1
var b = false
var c = 3.4
```
### Value Types
True value types as declared by Apple are struct, enum and tuple. 
```
struct A { var data: Int = 1}
var a = A()
var b = a
a.data = 42
//Upon printing a would print 42 and b would print -1 showing that they are using value type and just being copied.
```
### Reference Types
Reference types are usually user defined types that are declared by creating a class. These types will be passed via reference and not value like the aforementioned types.
```
class A { var data: Int = 1}
var a = A()
var b = a
a.data = 42
//Upon printing a would print 42 and b would print 42 showing that they are using value type and just being copied.
```
## Conclusion
It is not surprising that Java and Swift have very close definitions of their data types as they are both Object-Oriented languages. Most notable is that of Java's primitive data types are they are different from their reference type counter part. I would like to say that I prefer Swift's implementation of their value and reference type data because you do not need to worry about the difference of int and Integer as they do not exist in Swift in the same capacity as in Java. There is Int and Integer in which you can use both interchangeably. This is not a correct coding method as Integer is the protocol Int uses. So it is always correct to refer to an integer as an Int.


