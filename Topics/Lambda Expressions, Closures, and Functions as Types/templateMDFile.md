# Lambda Expression, Closures, and Functions as Types
#### *This document will explain what lambda expressions/ closures are and how and why they're used.* 

<br></br>
## Lambda Expressions, Closures, and Functions as Types
A function type is what the function takes in as parameters and returns; functions do not have to receive or return anything. A lambda expression and closure are ways to implement functions. Lambda expressions are anonymous functions and can only be implemented with a function inside a functional interface; a functional interface is ADD HERE. These eliminate the need to create  ADD HERE. Closures can easily be created as functions and/ or stored into variables to easily call the function. Closures are much more versatile than lambda expressions and can access variables not in its parameter list.




<br></br>
## Java's Implementation
```java
public interface Vegetable {
    public void veggie();
}

public interface Fruit {
    public String fruity();
}

public interface Nut {
    public void nutty(String type, int amount);
}

public interface Bread {
    public String bready(String type);
}


public static void main(String[] args) {
    String vName = "cabbage";
    String fName = "strawberry";
    String nName = "almond";
    String bName = "brioche";
    int nAmount = 20;

    System.out.println("Normal version: ");
    // before lambda expressions
    Vegetable veggie1 = new Vegetable(){
        public void veggie(){
            System.out.println("Vegetable: " + vName);
        }
    };
    veggie1.veggie();
    // to call the method from the interface, we have to create
    //      a new object AND the function veggie()

    System.out.println("\nLambda version: ");
    // here's a lambda expression of this
    Vegetable veggie2 = ()->{
            System.out.println("Vegetable: " + vName);
    };
    // since the functional interface has only one abstract
    //      method, we don't need to specify the name of the function
    // the function type is ()->()
    //      it receives no parameters and returns nothing
    veggie2.veggie();
    // in this case, we eliminate the need to declare
    //      what kind of object veggie2 is, and we
    //      didn't need to specify what function we're replacing

    System.out.println("\nLambda return version: ");
    // let's see what else we can do
    // what if our function returns something?
    Fruit fruity = ()->{
        return "Fruit: " + fName;
    };
    System.out.println(fruity.fruity());

    // what if the function has parameters?
    System.out.println("\nLambda multiple parameter version: ");
    Nut nutty = (type, amount)->{
        System.out.println("Nut type: " + type 
                            + "\nNumber of pieces: " + amount);
    };
    nutty.nutty(nName, nAmount);
    // the function type is (String, it)->()
    //      it receives a String and an int and returns nothing

    // what if we have parameters and need to return something?
    System.out.println("\nLambda multiple parameter and return version: 1: ");
    Bread bready1 = (type)->{
        String str1 = "Bread: ";
        String str2 = str1 + type;
        return str2;
    };
    System.out.println(bready1.bready(bName));
    // lambda expressions can have multiple lines
    //      although in this case, it's slightly unnecessary 
    // the function type is (String)->(String)
    //      it receives a String and returns String

    System.out.println("\nLambda multiple parameter and return version: 2: ");
    Bread bready2 = (type)->("Bread: " + type);
    // it turns out, you don't need the {} or return keyword
    //      this is more suitable for simpler functions
    System.out.println(bready2.bready(bName));
    // the function type is (String)->(String)
    //      it receives a String and returns String

    // these lambda expressions act as 'quick' functions
    //      they can have multiple lines, ex. lines 63-67
    //      or they can be simple, like the rest of the examples
    // lambdas can only be made from functional interfaces
}
```

<br></br>
## Swift's Implementation
```python
var vName: String = "cabbage";
var fName: String = "strawberry";
var nName: String = "almond";
var bName: String = "brioche";
var nAmount: Int = 20;


var veggie: () -> (String) = {
    return "Vegetable: " + vName
}
# in swift, we can execute 'lambda expressions'
#      as functions in variables
# the function type of veggie() is:
#      () -> (String)
#      it takes no parameters, and returns a String
print(veggie())

var veggie2 = veggie
// we can also set those function variables into 
#      other variables
print(veggie2())

# the typical syntax for closures is:
#      {(params)-> return type IN statements}
#      {(params)-> () IN statements} --> if there is not return

func allFoods(veg: String, fruit: String, nut: String, bread: String) -> 
                (v: String, f: String, n: String, b: String){
    return ("veggie - \(veg)", "fruit - \(fruit)", 
            "nut - \(nut)", "bread - \(bread)")
}
# we can have multiple return types and call each of them
# the function type of allFoods() is:
#      (String, String, String, String) -> (String, String, String, String)
#      it takes 4 strings in, and returns all or one of the strings
print("\nClosures can allow for the return of multiple statements: ")
let allFoodies = allFoods(veg: vName, fruit: fName, nut: nName, bread: bName);
print("This is calling the function allFoodies: ")
print("\t",allFoodies)
print("This following are from calling allFoodies.? (? = v,f,n,b): ")
# calling each singular return value that allFoodies can return
print("\t",allFoodies.v)
print("\t",allFoodies.f)
print("\t",allFoodies.n)
print("\t",allFoodies.b)


# closures can have  a variable number of objects
func basketOfFruits (fruits: String...) -> (){
    print("Fruits: ")
    for fruit in fruits{
        print("\t\(fruit)")
    }
}
# the function type of basketOfFruits() is:
#      (String..) -> ()
#      it takes a variable number of strings in, 
#          and nothing
print("Closure that receives multiple arguments: 1: ")
basketOfFruits(fruits: "strawberry","kiwi")
print("Closure that receives multiple arguments: 2: ")
basketOfFruits(fruits: "guayaba","persimmon", "durian")


# closures can also 'keep' values and continue using them
# let's check it out
var breadString: String = bName
var on: String = " on "
var stacksOnStacks = {
    breadString += on + bName
}
var printStacksOnStacks = {
    print(breadString)
}
// function types for these functions would be () -> ()
//      they don't receive or return anything
print("\nI love bread like I love money: ")
printStacksOnStacks()
stacksOnStacks()
printStacksOnStacks()
stacksOnStacks()
printStacksOnStacks()
stacksOnStacks()
printStacksOnStacks()

# they can also keep those values withing the closure itself
func eatNuts(from start: Int, eat: Int) -> () -> Int{
    var i = start
    return {
        let curPiecesLeft = i
        i -= eat
        return curPiecesLeft
    }
}
print("\nI eat \(nName)s 7 at a time, and I have 20: ")
var eaterator = eatNuts(from: 20, eat: 7)
# ^^^ pun alert --> 'iterator'
print("\tBefore first snack: ",eaterator(), " pieces left")
print("\tAfter first snack: ",eaterator(), " pieces left")
print("\tAfter second snack: ",eaterator(), " pieces left")
print("I need to eat slower (2 pieces at a time) and enjoy those 20 almonds: ")
eaterator = eatNuts(from: 20, eat: 2)
print("\tBefore first snack: ",eaterator(), " pieces left")
print("\tAfter first snack: ",eaterator(), " pieces left")
print("\tAfter second snack: ",eaterator(), " pieces left")
print("\tAfter third snack: ",eaterator(), " pieces left")
# the eaterator holds onto the 'number of pieces left'
#      each call decrements that 'held' variable's value



# you can also return a function
func foodBasket () -> ((String, String)-> String){
    func foodOpinion(veggie: String, nut: String)->(String){
        return "I hate \(veggie)s, but I love \(nut)s"
    }
    return foodOpinion
}
let foodOpinion = foodBasket()
print("\n", foodOpinion(vName, nName))
# in this case, we wouldn't need to specify what variable
#      matches with which function variable (veggie or nut)


# implicit returns (not return specified!)
#      let's re-work the sorted function
var foods = [vName, fName, nName, bName]
print("\nBefore sort: ")
print("\t", foods)
var foodsSorted = foods.sorted(by: {f1, f2 in f1<f2})
print("After sort: ")
print("\t", foodsSorted)

# shorthand argument names
#      there's an easier was to sort that list
#      so that we don't have to specify how it works
foodsSorted = foods.sorted(by: {$0 > $1})
# the $0 and $1 refer to the strings in the
#      foods array, instead of f1 and f2
print("After reverse sort: ")
print("\t", foodsSorted)

# operator methods 
#      you can also change sorted to be 
#      purely a mathematical symbol
foodsSorted = foods.sorted(by: <)
# the $0 and $1 refer to the strings in the
#      foods array, instead of f1 and f2
print("After re-sorting alphabetically: ")
print("\t", foodsSorted)


# trailing closure
#      sometimes it's necessary to pass 
#      closures to a function
func fruitAndBread(fruit: String, bread: String, closure: () -> Void){
    closure()
}
print("Practice with trailing closures: ")
# calling it WITHOUT a trailing closure
fruitAndBread(fruit: fName, bread: bName, closure: {
    print(fName, bName, "bread sounds interesting")
})
# calling it WITH a trailing closure
fruitAndBread(fruit: fName, bread: bName){
    print(fName, bName, "bread sounds interesting")
}
# this way allows for the closure to be written
#      quickly and used
# lastly, this is how to create the closure
var fruitAndBreadClosure = {
    print(fName, bName, "bread sounds interesting")
}
#      and SEND the closure to the function
fruitAndBread(fruit: fName, bread: bName, closure: fruitAndBreadClosure)

# comments in swift are // and /*comment here*/
#   git does not support swift md so python is used
#   which is also why -> is highlighted in red
```


<br></br>
## Comparing
Java only allows for lambda expressions in a specific circustance. 










