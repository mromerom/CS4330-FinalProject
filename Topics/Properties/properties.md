# Properties
#### *This document will go over setters and getters, backing variables, and compute properties.* 

<br></br>
## Properties
### Setters and Getters
Setters (also known as *mutators*) and getters (also known as *accessors*) are used to control changes to a variable. Setters and getters allow for finer control of access rights, and are instrumental in the property of encapsulation. As their names imply, a setter will set the data, and the getter will get the data (while protecting it from being accessed by external modules).
### Backing Variables
### Computed Properties
in Swift, a computed property is a property that has a getter and setter applied to it, and the computed property is not stand-alone; it has another variable(s) in the same struct or class that it uses to 'compute' itself (itself being the computed property/ a new property). In Java, the variable itself is set to private, and set and get functions are 'attached' to it, aka. writing functions called get<variable_name> and set<variable_name> (see the Java computed properties example).

<br></br>
## Java's Implementation
### Setters and Getters
```java
public class Student {
    private String name;

    public String getName() {
        return name;
    }

    
    public void setName(String newName) {
        name = newName;
    }
}
```
### Backing Variables
```java
```
### Computed Properties
```java
public class Cabbage {
    final String typeOfFood = "cabbage";
    String typeOfCabbage;
    double weight;
    private String fullTypeName;
    
    public Cabbage(double weight, String typeOfCabbage){
        this.weight = weight;
        this.typeOfCabbage = typeOfCabbage;
        fullTypeName = getFullTypeName();
    }
    
    public String getFullTypeName(){
        return typeOfCabbage + " " + typeOfFood;
    }
    public void setFullTypeName(String typeOfCabbage){
        this.typeOfCabbage = typeOfCabbage;
        fullTypeName = getFullTypeName();
    }
}

public class Strawberry {
    final String typeOfFood = "strawberry";
    String typeOfStrawberry;
    double weight;
    private String fullTypeName;
    
    public Strawberry(double weight, String typeOfStrawberry, String fullTypeName){
        this.weight = weight;
        this.typeOfStrawberry = typeOfStrawberry;
        this.fullTypeName = fullTypeName;
    }
    
    public String getFullTypeName(){
        return fullTypeName;
    }
    public void setFullTypeName(String typeOfStrawberry){
        this.typeOfStrawberry = typeOfStrawberry;
        fullTypeName = typeOfStrawberry + " " + typeOfFood;
    }
}

public static void main(String[] args) {
    String cName = "january king";
    String sFName = "strawberry";
    String sTName = "fragaria vesca";
    String sFTName = sFName + " " + sTName;
    Cabbage cabbage = new Cabbage(2, "january king");
    Strawberry strawb = new Strawberry(0.1, sTName, sFTName);


    System.out.println("Cabbage computed properties: get:");
    System.out.println("\tCabbage: food type: " + cabbage.typeOfFood);
    System.out.println("\tCabbage: cababge type: " + cabbage.typeOfCabbage);
    System.out.println("\tCabbage: full type: " + cabbage.getFullTypeName());
    System.out.println("Cabbage computed properties: set:");
    System.out.println("\tCabbage: food type: " + cabbage.typeOfFood);
    cabbage.setFullTypeName("bok choy");
    System.out.println("\tCabbage: cababge type: " + cabbage.typeOfCabbage);
    System.out.println("\tCabbage: full type: " + cabbage.getFullTypeName());
    // computed properties are private properties
    //      that are 'set' and 'gotten'('get')
    //      through methods
    // this is a means of protecting the roperty
    //      itself, so no direct access is
    //      allowed (aka. cabbage.fullTypeName)


    System.out.println("\nStrawberry computed properties: set in constructor:");
    System.out.println("\tStrawberry: food type: " + strawb.typeOfFood);
    System.out.println("\tStrawberry: Strawberry type: " + strawb.typeOfStrawberry);
    System.out.println("\tStrawberry: full type: " + strawb.getFullTypeName());
    System.out.println("Strawberry computed properties: set:");
    System.out.println("\tStrawberry: food type: " + strawb.typeOfFood);
    strawb.setFullTypeName("fragaria x ananassa");
    System.out.println("\tStrawberry: Strawberry type: " + strawb.typeOfStrawberry);
    System.out.println("\tStrawberry: full type: " + strawb.getFullTypeName());
    // note: in this case, it's probably better to 
    //      set and get through the functions alone
    //      instead of the constructor
}
```

<br></br>
## Swift's Implementation
### Setters and Getters
Contrary to Java, setters and getters in Swift do not need to be declared on publicly available variables. Additionally, setter and getter implementation can be overwritten in Swift for all types of variables, including private.
```
var variableName: dataType {
    get {
        //code to execute
        return someValue
    }
    set(newValue) {
        //code to execute
    }
}
```
### Backing Variables
```python
```
### Computed Properties
```python
class Cabbage{
    private var _name: String = "regular"
    var name: String {
        get{
            return _name
        }
        set(newName){
            _name = newName
        }
        # computed properties alter existing
        #      properties/ can be a combination
        #      of properties as with headsLeft,
        #      headsEaten, and numHeads
        #      (usually the latter)
    }
    var weight: Double = 0.0
    var numHeads: Int = 0
    var headsEaten: Int = 0
    var headsLeft: Int {
        get{
            return numHeads-headsEaten
        }
        set(moreEaten){
            headsEaten += moreEaten
        }
    }
    
    init(weight: Double, numHeads: Int){
        self.weight = weight
        self.numHeads = numHeads
    }
    
    func cabbageToString(){
        print("\tCabbge:",self.name,"weighs", self.weight,"lbs")
    }
    func cabbagesEaten(){
        print("\tCabbage:",self.name)
        print("\tNumber of heads:",self.numHeads)
        print("\tNumber of heads eaten:",self.headsEaten)
        print("\tNumber of heads left:",self.headsLeft)
    }
}

class Strawberry{
    private var _name: String = "regular"
    var name: String {
        get{
            return _name
        }
        set(newName){
            _name = newName
        }
    }
    var weight: Double = 0.0
    var numBerries: Int = 0
    var berriesEaten: Int = 0
    var berriesLeft: Int {
        get{
            return numBerries-berriesEaten
        }
        set(moreEaten){
            berriesEaten += moreEaten
        }
    }
    
    init(weight: Double, numBerries: Int, name: String, berriesEaten: Int, numBerriesLeft: Int){
        self.weight = weight
        self.numBerries = numBerries
        self.name = name
        self.berriesEaten = berriesEaten
        self.berriesLeft = numBerriesLeft
    }
    
    func strawberryToString(){
        print("\tStrawberry:",self.name,"weighs", self.weight,"lbs")
    }
    func strawberriesEaten(){
        print("\tStrawberry:",self.name)
        print("\tNumber of berries:",self.numBerries)
        print("\tNumber of berries eaten:",self.berriesEaten)
        print("\tNumber of berries left:",self.berriesLeft)
    }
}



print("Cabbage object with computed property: get: ")
let cabbage = Cabbage(weight: 2.0, numHeads: 20)
cabbage.cabbageToString()
cabbage.cabbagesEaten()
print("Cabbage object with computed property: set: ")
cabbage.name = "january king"
cabbage.headsLeft = 2
cabbage.cabbageToString()
cabbage.cabbagesEaten()
# the computed property can be changed
#      as many times as needed/ wanted

# computed properties can be 'set' in
#      the constructor (init()), even
#      though they already have a set 
#      property
print("\nStrawberry object with computed properties set in init(): ")
let strawberry = Strawberry(weight: 0.10, numBerries: 35, name: "Fragaria vesca", berriesEaten: 5, numBerriesLeft: 0)
strawberry.strawberryToString()
strawberry.strawberriesEaten()
# Q1: why do we set numBerriesLeft to 0? 
#      wouldn't it be 30?
print("Strawberry object with computed properties set: set on comp. prop.: ")
strawberry.name = "Fragaria x ananassa"
strawberry.berriesLeft = 7
strawberry.strawberryToString()
strawberry.strawberriesEaten()
```


<br></br>
## Comparing
### Setters and Getters
### Backing Variables
### Computed Properties




<br></br>
### Practice Your Knowledge!

#### Computed Properties: Q1 swift (no questions in Java)
```python
let strawberry = Strawberry(weight: 0.10, numBerries: 35, name: "Fragaria vesca", berriesEaten: 5, numBerriesLeft: 0)
strawberry.strawberryToString()
strawberry.strawberriesEaten()
# Q1: why do we set numBerriesLeft to 0? 
#      wouldn't it be 30?
```
Answer:

> We have to set it to 0, because when dealing with the berriesLeft variable, it increments the berriesEaten variable. This is so that when we 'get' berriesLeft, it's numBerries - berriesEaten. Since, eating something constantly decrements the original total, we have to keep track of berriesEaten, which affects berriesLeft. If we put 30, then berriesLeft would set berriesEaten +30, making it 35, and berriesLeft would be numBerries(35)-berriesEaten(35) = 0! 





