# Comparison of Name Spaces
## This document will discuss name spaces for Java and Swift.
Both language support name spaces which allow the developer to enforce access control inside and outside of these name spaces. Java's name spaces are called Packages and Swift's name spaces are called Modules. It is important to note that Swift also as a Package term which stores all of the applications source files and the manifest file. This is not to be confused with Swift's modules. These name space conventions are used to prevent naming conflicts, access control and help make use of classes and other relevant data easier to use.

## Java's Name Spaces (Packages)
To create a package in Java you need to first decide a name that will accurately describe the contents of the package. Then you will need to put that name with a package statement at the top of every file that is to be included with the package. Some IDE's allow you to create a package hierarchy which then allows you to create classes and interfaces with this package statement already included at the top of these files. Below are some examples of package statements in relevant files.

```
package graphics; //This is a package statement.
public class Circle{
....
}

package graphics;
public Square{
....
}
```
To import an entire package into another package to be used look at the following code:
```
import graphics.*;
```
This will allow you to refer to any class or interface in that package by its simple name(public only). Otherwise you would need to use its qualified name such as graphics.Square.method. These packages are used to link multiple relevant files together and prevent access from classes outside of a given package.

## Swift's Name Spaces (Modules)
Swifts modules are like Java's packages in that they group relevant code together and enforce access controls on which parts are available outside the module. An application can have all its code in either one module or import other modules which create a dependency on that module. If a module does not product an executable it is consider a library in Swift. It also seems that when you create a library it becomes a package as it contains the source files for the module. But once imported it is then named as a module. It seems Swift uses the names module and package freely to reference the same data just at different states. Below is an example on how to create a module:

```
public class PrimeNumbers{
.....some code....
}
```
You can then take this sample class and do an import of this class to run its methods.

```
import PrimeNumbers

public class FindPrime{

let number = PrimeNumber.prime()
....
}
```
It is suggested to use Swift Package Manager as it can make selecting target files for the imports much easier than doing it manually which requires command line input and setup.

## Conclusion
Both are surprisingly similar in nature. It is interesting how Swift naming convention of modules and packages seemed to be used interchangeably. I would like to say that Swift seems to have a more dynamic setup which allows easy addition of modules to be added to a program from the internet. Which package manager you can simply input a URL to the module you want to use and it will go and get all the required dependencies and set it up for use. For Java, any additional packages need to be added into the source code for use and packaged along with the application. From my research, it does not seem that Java supports URL linkage of new modules for use. There is still expected growth of features for Swift's Package Manager as it is a new feature to the language. This leads me to believe Swift's implementation is better than Java's.
