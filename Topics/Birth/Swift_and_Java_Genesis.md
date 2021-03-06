# Language Purpose/ Genesis
### This topic will go over the following queries:
* #### Why was the language created? 
* #### What problems was the language trying to address?
* #### Is the language a reaction to a previous language or a replacement for another language?
* #### And, most importantly, what _is_ object oriented programming (OOP)?
<br></br>
## Object Oriented Programming aka. OOP
#### _A brief background of what OOP is all about will help you understand later topics in this repository._

OOP has a few basic ideas and concepts. [Every OOP language deals with](https://docs.oracle.com/javase/tutorial/java/concepts/) objects, classes, inheritance, interfaces, and packages. Classes, inheritance, and interfaces will be addressed in their respective folders in 'Topics.'

> "An object is a software bundle of related state and behavior." The state of an object is a field it has, and the behaviour is the actions an object can take or perform.

Objects typically model objects and things we use on a daily basis. For example, a lawn mower is object that has two behaviours: on and off, and it has multiple states or fields: four wheels, brand name, motor, bag, etc.

> "A package is a namespace for organizing classes and interfaces in a logical manner." 

A package can be likened to a large folder system, such as 'Topics' in this repository. All the information and details pertaining to the topic 'Classes' would be within the 'Classes' folder. You wouldn't find any code examples from 'Reflection' within 'Classes,' as this would make finding the information you need much harder.

The most important aspects of OOP are the following four principles:
1. Abstraction
   > Abstraction helps programmers focus on important details and ignore any states or behaviours that are not necessary to software. For example, you work at a university and have Staff objects. Staff members have roles, salaries, a permanent address, a phone number, etc. In order for this 'object' to be useful, the university needs to be able to store their contact information and what they do, so they can refer to it for use in directories, payroll, etc. At no point will you or the university need to know their shoe size, how many children they have, etc. These aspects are _unnecessary_ for the university's Staff object and keeping out those extraneous attributes would be keeping in line with OOP abstraction.
2. Encapsulation (or data hiding)
   > "[Through encapsulation](https://www.tutorialspoint.com/object_oriented_analysis_design/ooad_object_oriented_principles.htm), the internal details of a class can be hidden from outside." This concept makes sure the states and behaviours of an object are tied together and prevents it (_should prevent it_) from being directly manipulated by other objects. This enhances security of data.
3. Polymorphism
   > This principle can be difficult to understand. Essentially, an object is polymorphic if it can have/ take on different forms. For example, a square is a rectangle, but a rectangle is not a square. A square can be identified as a rectangle, and therefore, it has two different formulas for finding the area: area_of_square = side_length^2 *or* area_of_rectangle = width \* height. Its sides can also be defined as just side_length, as squares have equal side lengths, or width and height. This means that a square is polymorphic, which means it can 'act' two different ways, as a square *or* a rectangle.
4. Inheritance
   > *This will be addressed in 'Inheritance and Extension.'*

<br></br>
## Java
#### _We'll begin with Java, as it is much older than Swift._

Java was developed in 1995 to [union digital consumer devices and the internet](http://www.oracle.com/technetwork/java/javase/overview/javahistory-index-198355.html). It would replace C/ C++, enable the creation of web applications, have portability, and operate in distributed environments.

There were [five main goals](http://www.freejavaguide.com/history.html) Java was developed for (ie. the problems Java was made to address):
1. OOP
    > This style of programming was developed so that similar elements are grouped together.<br></br>
    It was also developed to create more generic software that could be **reused**.
    Resuability of code, or modularizing code, is one of the most important aspects of computer science. It allows for less storage, cleaner and more readable code. Code should be understandable and not repetitive. <br></br>
    *Please see below [example code of the quadratic equation](https://github.com/mromerom/CS4330-FinalProject/blob/master/Topics/Birth/javaModularizeExample.java)* 
   ```java
   double a = -16.00;
   double b = 100.00;
   double c = 6.00

   double determinant = b*-4*a*c;
   if(d < 0)
      print("Imaginary number");
   else
      double ans1 = (-b + sqrt(determinant))/(2*a);
      double ans2 = (-b + sqrt(determinant))/(2*a);
      print("x = " + ans1 + " or x = " + ans2 );

   // the above code is fine when you're not using the quadratic equation multiple times
   /* but imagine many different people needing to use this; wouldn't it be easier to
       make a copy of the option where people just send their numbers in and don't have to
       worry about creating the function themselves or taking this one and re-writing the
       input
       it would be much easier to call a function that does it for you
   */

   quadraticEquation(a, b, c);

   public void quadraticEquation(double a, double b, double c)
   {
      double determinant = b*-4*a*c;
      if(d < 0)
         print("Imaginary number");
      else{
         double ans1 = (-b + sqrt(determinant))/(2*a);
         double ans2 = (-b + sqrt(determinant))/(2*a);
         print("x = " + ans1 + " or x = " + ans2 );
      }
   }

   /* this version is much better and less wasting of time, as it is easily
         used by those who can know the name of the function and its parameters
         (what to send the function)
   */
   ```

2. Execution on multiple operating systems
    > There was a large issue with 'platform independence' when coding came about. One could not simply write a program and try to run it on all platforms one is using. Java developers created a Java byte language that would be converted to the machine's 'native' language for execution and running. Furthermore, standardized libraries were developed to allow for easier implementation of threading and graphics, etc.
3. Built-in support
    > All the pieces of java were to come together. They made it so that it actually came with its own compiler and debugging software. For most other languages, at the time, support came separately and needed to be downloaded and may have even needed to be connected with other support software.
4. Execute from remote sources securely
    > Secure execution of a programming is extremely important to protect data. Making that execution remote would allow for more difficult access to data from those who would try to compromise the software's protection and access data.
5. Easy to use
    > Java was to be a combination of all the 'better' parts of OOP. If everyone took everything thing that they liked and was considered useful (and **needed**), then a 'perfect' language would be created.  <br></br>
    OOP was designed to make code modularized and 'simple.' Combining everything that worked had seemed like the great new breakthrough the developers of Java, and everyone else, was looking for.

Java was developed more to combine aspects of a new and radical programming ideal than to *actively* replace other languages; however, because of the mostly positive response to OOP, it came to replace many of the popular languages at the time, such as C and C++.

<br></br>
## Swift

[Apple states](https://www.apple.com/swift/):
> "Swift is a robust and intuitive programming language created by Apple for building apps for iOS, Mac, Apple TV, and Apple Watch. It’s designed to give developers more freedom than ever. Swift is easy to use and open source, so anyone with an idea can create something incredible."

Programming languages used to be difficult to learn. Languages are, along with becoming much more powerful, becoming easier to use and to learn. To make something, that's difficult to understand, more fun to learn but also powerful, versatile and would "revolutionize."

1. Reduced Learning Curve
   > Swift is simpler and less strict. It allows for different learning styles to create programs without much difficulty. It is more flexible and has easy to remember rules and structures.
2. Fix 'Bad' Behaviours of Objective-C
   > Swift eliminates pointers and removes the programmer's control of variable overflow.
3. Easier, Automated Debugging
   > It can run and debug clearly in a development environment, using a read-evaluate-print loop (REPL).
4. Real-Time Output 
   > This enhances REPL that allows for instantaneous ouput as the programmer changes code or debugs.
5. Industrial Quality
   > Apple claims that Swift is strong, reliable, and even better to use for developing, for example, medical equipment. The data that would be more secure using Swift than most other languages. Swift is 'on par' with popular and most-used languages.
6. Automatic Memory Management
   > Allows for more accurate and safe memory management.

Swift's a more powerful language that is versatile in its use (some even say it was designed to build an Electric Apple vehicle). Swift is becoming the 'next best language,' _(similar to how Java was treated)_ built off of objective-C and similar languages, that will 'take over' the programming world and challenge it to be better and stronger. It was created more to find the 'perfect language' than to specifically replace any one language.



