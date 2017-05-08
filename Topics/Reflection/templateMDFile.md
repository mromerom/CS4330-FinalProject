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

These are just a few things you can do with reflection in java. There is a large expansion of knowledge out there for diverse ways to use reflection. While this is good it can also be dangerous as you can find out the innerworkings of a program potentially. Also, reflection has overhead associated with it so it may not be the most efficient way to discover the interworking of a class or application if you have access to source code.

## Swift's Reflection

## Conclusion
