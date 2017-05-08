# Properties
#### *This document will go over setters and getters, backing variables, and compute properties.* 

<br></br>
## Properties
### Setters and Getters
### Backing Variables
### Computed Properties
in Swift, a computed property is a property that has a getter and setter applied to it. In Java, 

<br></br>
## Java's Implementation
### Setters and Getters
```java
```
### Backing Variables
```java
```
### Computed Properties
```java
```

<br></br>
## Swift's Implementation
### Setters and Getters
```python
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

#### Q1 (Q? swift)
```java
```
Answer:

> 





