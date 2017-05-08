# Comparison of Reflection
## This document will discuss reflection for Java and Swift.
Both languages support reflection. However, in Swift it is called mirroring. This method is slightly different as you need to make an instance of this "mirrored" object. Below we will show examples and explain a bit more about both methods.

## Java's Reflection
Java's reflection supports and allows the use of extensibility features, class browsers and visual development environments also the use of debuggers and testing tools. The extensibility aspect allows for set up of frameworks or for the addition of newly created user-defined classes for the application that add features for the users. The class browsers and visual development environment will enumerate all members of classes helping the developers write more correct code for their applications. Lastly the use of reflection for debuggers and testing tools helps developers create more extensive test which provide better level of coverage for the tested code. Below we will show some code examples for Java's reflection API.

```
Method[] methods = aClass.getMethods();

for(Method method : methods){
    System.out.println("method = " + method.getName());
}
```
The above code snippet will print all methods gathered from a selected class. 
```
String className = this.getClass().getSimpleName();
```
The code snippet above will print out the simple name of the referenced class.
```
package com.tutorialspoint;

import java.util.GregorianCalendar;

public class ObjectDemo {

   public static void main(String[] args) {

      // create a new ObjectDemo object
      GregorianCalendar cal = new GregorianCalendar();

      // print current time
      System.out.println("" + cal.getTime());

      // print the class of cal
      System.out.println("" + cal.getClass());

      // create a new Integer
      Integer i = new Integer(5);

      // print i
      System.out.println("" + i);

      // print the class of i
      System.out.println("" + i.getClass());
   }
}
```
Above code would have the following output.
```
Sat Sep 22 00:31:24 EEST 2012
class java.util.GregorianCalendar
5
class java.lang.Integer
```
This code example is from [Tutorialpoint.com](https://www.tutorialspoint.com/java/lang/object_getclass.htm)

These are just a few things you can do with reflection in java. There is a large expansion of knowledge out there for diverse ways to use reflection. While this is good it can also be dangerous as you can find out the innerworkings of a program potentially. Also, reflection has overhead associated with it so it may not be the most efficient way to discover the interworking of a class or application if you have access to source code.

## Swift's Reflection
Swifts reflection is supported using a struct called "Mirror". This is used to create a mirror of a object from there you can query it for information. These are read-only object meaning they cannot be modified. You can make mirrors of the following types: struct, class, enum, tuple, optional, collection, dictionary and sets. Swift's mirror allows you to see the following from mirrored subjects: the objects type, any children it may have(properties), and any applicable superclass. All of this can be used to analyze classes in an application, iterate over tuples and have runtime analysis of object conformance. From here we will list a few coded examples below.
```
struct Book {
    let title: String
    let author: String?
    let published: Date
    let numberOfPages: Int
    let chapterCount: Int?
    let genres: [String]
}

let book = Book(title: "Harry Potter", author: "J.K. Rowling", published: Date(), numberOfPages: 450, chapterCount: 19, genres: ["Fantasy", "Best books ever"])
```
The above code creates a struct for a Book. After which we create an instance of book and store data into it.
```
let bookMirror = Mirror(reflecting: book)

for (name, value) in bookMirror.children {
    guard let name = name else { continue }
    print("\(name): \(type(of: value)) = '\(value)'")
}

// which prints:
// title: String = 'Harry Potter'
// author: Optional<String> = 'Optional("J.K. Rowling")'
// published: Date = '2016-10-02 19:17:43 +0000'
// numberOfPages: Int = '450'
// chapterCount: Optional<Int> = 'Optional(19)'
// genres: Array<String> = '["Fantasy", "Best books ever"]'
```
This code creates a mirror of Book then prints all of the children of the book object.
This code example comes from [makeitnew.io](https://makeitnew.io/reflection-in-swift-68a06ba0cf0e).

## Conclusion
While both languages allow you to see the innerworkings of objects I think that Java's application of reflection is less restrictive. When I say, this I am referring to native support as you can get better libraries for Swift that offer better opinions of reflection than using the Mirror struct. Java's implementation of reflection seems it would be more difficult to grasp at first but appears to offer a more in-depth look at objects and their features. Remind you these are offered natively. For Swift, their framework seems easier to use up front but maybe limiting as it only covers the aforenoted types and only has a select number of available properties. Both can work for reflection but Java's implementation is more moldable in each respective native format.
