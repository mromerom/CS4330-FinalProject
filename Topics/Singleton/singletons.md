# Singeltons
#### *This document will explain what a singleton is, how it's implemented, if it can be thread-safe, and how to lazily instantiate it.* 

<br></br>
## Singeltons
Singletons are a restriction on a class that allows for only **_one_** object to be created. Being thread-safe means that two threads that act upon the singleton will come away with the same instance, meaning, if one is asleep after invoking the singleton, then the other cannot act and change it (if it's new/ lazy) while the other is asleep. Lazy instantiation is creating the object outside of the class. The general way, most safe, is to create the object instance *within* the class, so it's there already and no new, *unique* instances can be created.

Singletons are useful when only one object of a type is needed, and it needs to be used across many programs within a large application. Each can access and us it; however, they can, in no way, modify or change it once it has been instantiated.


<br></br>
## Java's Implementation
```java
public final class Runner {
    String name;
    double miles;
    
    private static final String runner = "Dean Karnazes";
    private static final double runnerMiles = 350.0;
    private static final Runner INSTANCE = new Runner(runner, runnerMiles);
    
    private Runner(String name, double miles){
        this.name = name;
        this.miles = miles;
    }
    
    public static Runner getInstance(){
        return INSTANCE;
    }
    
    public void printName(){
        System.out.println("Runner name: "+ this.name);
    }
    public void printMiles(){
        System.out.println("Runner miles: "+ this.miles);
    }
    
    public void runnerToString(){
        System.out.println("Runner: "+this.name+" has run: "+this.miles+" miles");
    }
}

public class LazyRunner {
    String name;
    double miles;
    private static volatile LazyRunner instance = null;
    
    private LazyRunner(String name, double miles){
        this.name = name;
        this.miles = miles;
    }
    
    public static LazyRunner getInstance(String name, double miles){
        if(instance == null){
                if(instance == null){
                    instance = new LazyRunner(name, miles);
            }
        }
        return instance;
    }
    
    
    public void printName(){
        System.out.println("Lazy Runner name: "+ this.name);
    }
    public void printMiles(){
        System.out.println("Lazy Runner miles: "+ this.miles);
    }
    
    public void runnerToString(){
        System.out.println("Lazy Runner: "+this.name+" has run: "+this.miles+" miles");
    }
}

public class LazyRunnerThreadSafe {
    String name;
    double miles;
    private static volatile LazyRunnerThreadSafe instance = null;
    
    private LazyRunnerThreadSafe(String name, double miles){
        this.name = name;
        this.miles = miles;
    }
    
    public static LazyRunnerThreadSafe getInstance(String name, double miles){
        if(instance == null){
            synchronized(LazyRunnerThreadSafe.class){
	    // this is a thread-safe wa to 'lock'
	    //		the object until the thread if 
	    //		finished working with it
	    //  	once it unlocks, another thread 
	    //  	can work with it
	    // but once the instance is created,
	    //		it cannot be changed 
                if(instance == null){
                    instance = new LazyRunnerThreadSafe(name, miles);
                }
            }
        }
        return instance;
    }
    
    
    public void printName(){
        System.out.println("Lazy Runner name: "+ this.name);
    }
    public void printMiles(){
        System.out.println("Lazy Runner miles: "+ this.miles);
    }
    
    public void runnerToString(){
        System.out.println("Lazy Runner: "+this.name+" has run: "+this.miles+" miles");
    }
}


public static void main(String[] args) {
	// a singleton is a singular object
	//      from a class
	// that class can only have that
	//      ONE object

	System.out.println("Regular singleton: ");
	Runner runner1 = Runner.getInstance();
	System.out.print("\t");
	runner1.printName();
	System.out.print("\t");
	runner1.printMiles();
	System.out.print("\t");
	runner1.runnerToString();
	System.out.println("\tRunner name without function: "+runner1.name);
	System.out.println("\tRunner miles without function: "+runner1.miles);
	// a regular singleton is 'created'
	//      within the class itself
	// there is no way to give it its
	//      variables without doing so
	//      in the class itself
	// its variables, if not private, are
	//      still accessible
	// it can still act like any other class
	// Q1: what will the following functions print
	//      out if we make a second runner?
	System.out.println("Q1: These prints are the result of making a " 
			    +"runner2 of type Runner");
	Runner runner2 = Runner.getInstance();
	System.out.print("\t");
	runner2.printName();
	System.out.print("\t");
	runner2.printMiles();
	System.out.print("\t");
	runner2.runnerToString();

	// lazy singelton
	// these allow for creating the instance in
	//      the moment, but that instance is 
	//      and will be the ONLY instance
	// the instance is also only created when
	//      getInstance() is called
	System.out.println("\nLazy Singleton: ");
	LazyRunner runner3 = LazyRunner.getInstance("Payton Hosna", 2.75);
	System.out.print("\t");
	runner3.printName();
	System.out.print("\t");
	runner3.printMiles();
	System.out.print("\t");
	runner3.runnerToString();
	// Q2: what happens if we try to execute the following?
	System.out.println("Q2: These prints are a result of making a new instance runner 4 of Forrest Gump: ");
	LazyRunner runner4 = LazyRunner.getInstance("Forrest Gump", 19024.0);
	System.out.print("\t");
	runner4.printName();
	System.out.print("\t");
	runner4.printMiles();
	System.out.print("\t");
	runner4.runnerToString();

	// Q3: Do you see any issue with this?
	//      Lazy allows for in time instantiation,
	//      whereas regular is created in the moment,
	//      and nothing else has any chance to make 
	//      it different.
	//      So, if lazy can create the object in the 
	//      moment and send parameters, what could
	//      be an issue with this?

	// this will be explored through checking for
	//      thread safety
	// is a singleton thread safe?
	//      no! the first time getInstance() 
	//      is called, the thread that invoked
	//      it goes to sleep for a very small
	//      period of time, whichcould allow
	//      for some other invocation of the instance
	//      an it could be changed!
	//      (which is definitely the opposite
	//      of why singletons exist)
	// how could we make this thread safe?
	// we use synchronization!!
	//      ex. LazyRunnerThreadSafe
	//          public static LazyRunnerThreadSafe getInstance(String name, double miles)
	// synchronization 'locks onto code'
	//      in this case, the object... but more
	//      specifically, as this object is static,
	//      it locks the class
	//      it allows for one thread to act at a time
	//      and to finish its work
	//      once it is finished, the class unlocks
	//      and another thread can access the instance
	// the most important part is making sure only ONE
	//      instance is created
	System.out.println("\nLazy Runner thread safe: ");
	LazyRunnerThreadSafe runner5 = LazyRunnerThreadSafe.getInstance("Forrest Gump", 19024.0);
	System.out.print("\t");
	runner5.printName();
	System.out.print("\t");
	runner5.printMiles();
	System.out.print("\t");
	runner5.runnerToString();
}
```

<br></br>
## Swift's Implementation
```python
# this is the oldest and definitely 
#      not prettiest version of
#      singleton
# it's also outdated and no longer
#      used in Swift 3
'''class OldRunner{
    var name: String = ""
    var miles: Double = 0.0
    
    init(name: String, miles: Double){
        self.name = name
        self.miles = miles
    }
    
    class var sharedInstance: OldRunner{
        struct Static{
            static var name = "Dean Karnazes"
            static var miles  350.0
            static var onceToken = dispatch_once_t = 0
            static var instance: OldRunner? = nil
        }
        
        dispatch_once(&static.onceToken){
            Static.Instance = OldRunner(name: &Static.name, miles: &Static.miles)
        }
        
        return Static.instance!
    }
    
    func printName(){
        print("Runner: ", self.name)
    }
    func printMiles(){
        print("Runner: ", self.miles)
    }
    func oldRunnerToString(){
        print("Runner: ", self.name, " has run ", self.miles, " miles")
    }
}
'''

# let's move onto ways that DO work
#      and are supported
class StructRunner{
    var name: String = ""
    var miles: Double = 0.0
    
    init(name: String, miles: Double){
        self.name = name
        self.miles = miles
    }
    
    class var sharedInstance: StructRunner{
        struct Static{
            static var name = "Dean Karnazes"
            static var miles =  350.0
            static let instance = StructRunner(name: name, miles: miles)
        }
        
        return Static.instance
    }
    
    func printName(){
        print("\tRunner:", self.name)
    }
    func printMiles(){
        print("\tRunner:", self.miles)
    }
    func structRunnerToString(){
        print("\tRunner:", self.name, "has run", self.miles, "miles")
    }
}
let runner1 = StructRunner.sharedInstance
print("Singleton type1: struct: ")
runner1.printName()
runner1.printMiles()
runner1.structRunnerToString()
# Q4: what will the following code execute?
let runner2 = runner1
print("Q4: output: ")
runner2.printName()
runner2.printMiles()
runner2.structRunnerToString()


# let's move on to another kind of singleton
# global variable
class GlobalRunner{
    var name: String = ""
    var miles: Double = 0.0
    
    init(name: String, miles: Double){
        self.name = name
        self.miles = miles
    }
    
    class var sharedInstance: GlobalRunner{
        return runner3
    }
    
    func printName(){
        print("\tRunner:", self.name)
    }
    func printMiles(){
        print("\tRunner:", self.miles)
    }
    func globalRunnerToString(){
        print("\tRunner:", self.name, "has run", self.miles, "miles")
    }
}
private let runner3 = GlobalRunner(name: "Payton Hosna", miles: 2.5)
# typically we would name it something
#      more substantial, ex. sharedRunner,
#      sharedInstance, etc.
# runner3 needs to be in the same file as this
#      class, elsewise, since it's private,
#      it could not be used
# this is also the closest we come to having
#      a lazy singleton
print("\nSingelton type2: global variable (lazy-styled singleton):")
runner3.printName()
runner3.printMiles()
runner3.globalRunnerToString()
# Q5: what happens if we execute the following?
let runner4 = GlobalRunner.sharedInstance
print("Q5: output:")
runner4.printName()
runner4.printMiles()
runner4.globalRunnerToString()
# Q6: how will the following execute?
print("Q6: output:")
private let runner5 = GlobalRunner(name: "Forrest Gump", miles: 19024.0)
runner5.printName()
runner5.printMiles()
runner5.globalRunnerToString()
# why does this happen?
#      because we're not grabbing the
#      sharedInstance
# the class has no way of 'protecting'
#      itself to only have ONE object
#      as is the requirements for a 
#      singleton!!
# this is not safe!!

# okay, can we make this easier?
# why yes we can!
class SimpleRunner{
    var name: String = ""
    var miles: Double = 0.0
    static let sharedInstance = SimpleRunner(name: "Forrest Gump", miles: 19024.0)
    
    init(name: String, miles: Double){
        self.name = name
        self.miles = miles
    }
    
    func printName(){
        print("\tRunner:", self.name)
    }
    func printMiles(){
        print("\tRunner:", self.miles)
    }
    func simpleRunnerToString(){
        print("\tRunner:", self.name, "has run", self.miles, "miles")
    }
}
print("\nSingelton type3: one line sharedInstance:")
let runner6 = SimpleRunner.sharedInstance
runner6.printName()
runner6.printMiles()
runner6.simpleRunnerToString()


# thread safety?
# as we saw with type2, we could make another instance!
#      super not safe!
# how can we combat this?
#      change the init()!
class StructRunnerForcedSingleton{
    var name: String = ""
    var miles: Double = 0.0
    
    private init(name: String, miles: Double){
        self.name = name
        self.miles = miles
    }
    
    class var sharedInstance: StructRunnerForcedSingleton{
        struct Static{
            static var name = "Dean Karnazes"
            static var miles =  350.0
            static let instance = StructRunnerForcedSingleton(name: name, miles: miles)
        }
        
        return Static.instance
    }
    
    func printName(){
        print("\tRunner:", self.name)
    }
    func printMiles(){
        print("\tRunner:", self.miles)
    }
    func structRunnerForcedToString(){
        print("\tRunner:", self.name, "has run", self.miles, "miles")
    }
}
let runner7 = StructRunnerForcedSingleton.sharedInstance
print("\nSingleton type1: struct: forced, true singleton: ")
runner7.printName()
runner7.printMiles()
runner7.structRunnerForcedToString()
# Q7: what happens if we execute the following?
'''let runner8 = StructRunnerForcedSingleton(name: "Leslie Knope", miles: 0.0)
print("\nSingleton type1: struct: forced, true singleton: new object try: ")
runner8.printName()
runner8.printMiles()
runner8.structRunnerForcedToString()'''


# okay we solved types 1&3, but how do we solve
#      type2?
class GlobalRunnerForcedSingleton{
    var name: String = ""
    var miles: Double = 0.0
    static var sharedInstance: GlobalRunnerForcedSingleton? = nil
    # we cannot use let, as that does
    #      not allow for changes
    
    private init(name: String, miles: Double){
        self.name = name
        self.miles = miles
    }
    
    static func getInstance(name: String, miles: Double) -> GlobalRunnerForcedSingleton{
        if(sharedInstance == nil){
            sharedInstance = GlobalRunnerForcedSingleton(name: name, miles: miles)
            return sharedInstance!
        }
        else{
            return sharedInstance!
        }
    }
    
    func printName(){
        print("\tRunner:", self.name)
    }
    func printMiles(){
        print("\tRunner:", self.miles)
    }
    func globalRunnerForcedToString(){
        print("\tRunner:", self.name, "has run", self.miles, "miles")
    }
}
private let runner9 = GlobalRunnerForcedSingleton.getInstance(name: "Chris Traeger", miles: 65000.0)
print("\nSingelton type2: global variable (lazy-styled singleton): forced, true singleton:")
runner9.printName()
runner9.printMiles()
runner9.globalRunnerForcedToString()
let runner10 = GlobalRunnerForcedSingleton.getInstance(name: "Usain Bolt", miles: 0.06214)
print("Singelton type2: global variable (lazy-styled singleton): forced, true singleton: test:")
runner10.printName()
runner10.printMiles()
runner10.globalRunnerForcedToString()
# as far as I am aware, it's difficult to 
#      make this safe!! type3 is the best
#      and most often used singleton case
# unfortunately, as I am not a mac user,
#      the playground I am using to emulate
#      a swift coding environment, I cannot
#      test this
#      however, this SHOULD allow for a true
#      instantiation of a 'global'/ lazy
#      swift singleton
# edit: after much testing, type2 can work
#      if it's treated similar to java's
#      lazy singletons


# these instances are really more loopholes in
#      swift singletons that need to be fixed
# as far as talking about true thread-safety...
#      swift handles that for the most part
# the biggest issue is making sure only ONE
#      object is created for the singleton
#      (which, yes, would involve threads)
```


<br></br>
## Comparing
Swift and Java do things a little differently. It's much easier to create a thread-safe, lazy singleton in Java than Swift. However, in Swift, the only worry is to make sure only one object is created; thread-safety is handled and doesn't need to be explicitly addressed. In order to create a true Swift singleton, one must follow the syntax of the last couple examples in the Swift exmaple code (namely, the classes with 'ForcedSingleton' in the name).

As far as pure syntax, Java needs functions and an instance variable. Swift creates class variables, but it can use functions with variables. Each explicitly use 'static', as it stays the same throughout all new class instances (not that singletons will allow for multiple, *unique* instances). 

In the end, private constructor (init()'s) are *key*.





<br></br>
### Practice Your Knowledge!
To practice this new knowledge, can you solve the answers to Q1-3 in the Java sample code (and Q4-7 in the Swift example code)?
Try running the Java and Swift programs! (Hint: Q3 is outlined in the code following it, i.e. the thread-safe code example)

#### Q1 (Q4 swift)
```java
// Q1: what will the following functions print
//      out if we make a second runner?
System.out.println("Q1: These prints are the result of making a " 
		    +"runner2 of type Runner");
Runner runner2 = Runner.getInstance();
System.out.print("\t");
runner2.printName();
System.out.print("\t");
runner2.printMiles();
System.out.print("\t");
runner2.runnerToString();
```
Answer:

> It'll print out exactly what runner1 prints out! The instance is already made, so getInstance() will always return the one instance.

#### Q2 (Q5 and similar to Q6 swift)
```java
// Q2: what happens if we try to execute the following?
System.out.println("Q2: These prints are a result of making a new instance runner 4 of Forrest Gump: ");
LazyRunner runner4 = LazyRunner.getInstance("Forrest Gump", 19024.0);
System.out.print("\t");
runner4.printName();
System.out.print("\t");
runner4.printMiles();
System.out.print("\t");
runner4.runnerToString();

// runner4 is a lazy instance; the LazyRunner on instantiation 
//	allows for the creation of the object with a name
//	and miles sent to it
```
Answer:

> This will still print runner3's information. The static, and singular, instance was already created once runner3 was created. 


#### Q3
```java
// Q3: Do you see any issue with this?
//      Lazy allows for in time instantiation,
//      whereas regular is created in the moment,
//      and nothing else has any chance to make 
//      it different.
//      So, if lazy can create the object in the 
//      moment and send parameters, what could
//      be an issue with this?


// 'this' in the beginning is referencing using
//	lazy instantiation
```
Answers: 

> The issue is that if one thread tries to instantiate the lazy instance, it will sleep for a short period. Another thread could also access the instance near the same time. They could each be trying to create a new instance. Collision would happen, and a second instace could be created, which is the *exact* opposite of what a singleton is. Ways around this include regular singletons, i.e. Runner, or synchronizing the LazyRunner (i.e. LazyRunnerThreadSafe).

#### Q7
```pythom
# Q7: what happens if we execute the following?
'''let runner8 = StructRunnerForcedSingleton(name: "Leslie Knope", miles: 0.0)
print("\nSingleton type1: struct: forced, true singleton: new object try: ")
runner8.printName()
runner8.printMiles()
runner8.structRunnerForcedToString()'''
```
Answers: 

> This won't execute! The constructor or init() for StructRunnerForcedSingleton is private, adn therefore, nothing but its own class can have access to it.





