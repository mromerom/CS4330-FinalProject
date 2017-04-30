class Vegetable{
  private var kindOfFood: String = "Vegetable";
  var weight: Double = 0;
  
  init(weight: Double){
    self.weight = weight;
  }
  
  func printWeight(){
        print(weight);
  } 
  
  func printKind(){
      print("Vegtable Class kindOfFood: " + kindOfFood)
  }
  
}
class Cabbage: Vegetable{
    var kindOfFood: String = "Cabbage";
    var fresh: Bool = true;
  
    init(weight: Double, fresh: Bool){
        super.init(weight: weight)
        self.fresh = fresh;
    }
  
    override func printKind(){
        print("Cabbage Class kindOfFood: " + kindOfFood)
    }
    
    func printFresh(){
        print("Cabbage Class fresh: " + String(fresh));
    }
  
    static func == (lhs: Cabbage, rhs: Cabbage) -> Bool{
        return lhs.weight == rhs.weight && lhs.fresh == rhs.fresh
    }
    
}
var cabbage1 = Cabbage(weight: 3.3, fresh: true);
var cabbage2 = Cabbage(weight: 3.4, fresh: false);
var cabbage3 = Cabbage(weight: 3.3, fresh: true);
var cabbage4 = Cabbage(weight: 3.3, fresh: false);

var str1: String = "Hi"
var str2: String = "Hello"
var str3: String = "Hi"

var i: Int = 3
var j: Int = 3
var k: Int = 4
print("'Primitive' Comparisons with ==: ")
print("i = " + String(i) + ", j = " + String(j) + ", k = " + String(k))
print("i == j: " + String(i == j))
print("i == k: " + String(i == k))
print("j == k: " + String(j == k))

print("\nString Comparisons with ==: ")
print("str1 = " + str1 + ", str2 = " + str2 + ", str3 = " + str3)
print("str1 == str3: " + String(str1 == str3))
print("str1 == str2: " + String(str1 == str2))
print("str2 == str3: " + String(str2 == str3))
// now this is definitely different from java
//  == in swift will compare 'what's expected'
//  we know what to expect when we compare words
//      numbers, booleans, etc. we DON'T know how
//      to compare 'custom' objects

// let's see what happens when we compare the
//  cabbage objects with ==
print("\nCustom Object Comparisons with ==: ")
print("cabbage1: weight = " + String(cabbage1.weight) + ", fresh = " + String(cabbage1.fresh))
print("cabbage2: weight = " + String(cabbage2.weight) + ", fresh = " + String(cabbage2.fresh))
print("cabbage3: weight = " + String(cabbage3.weight) + ", fresh = " + String(cabbage3.fresh))
print("cabbage4: weight = " + String(cabbage4.weight) + ", fresh = " + String(cabbage4.fresh))
// turns out, objects can't == at all!
// but swift has another version: ===
//      let's try that
print("\nCustom Object Comparisons with ===: ")
print("cabbage1 === cabbage3: " + String(cabbage1 === cabbage3))
print("cabbage1 === cabbage2: " + String(cabbage1 === cabbage2))
print("cabbage1 === cabbage4: " + String(cabbage1 === cabbage4))
print("cabbage2 === cabbage3: " + String(cabbage2 === cabbage3))
print("cabbage2 === cabbage4: " + String(cabbage2 === cabbage4))
print("cabbage3 === cabbage4: " + String(cabbage3 === cabbage4))
// now we're getting the same issue with java
// === acts like == in java, when comparing custom objects
// which means it's testing if the objects point to the same address
//      aka. referencing the same object, the objects have 
//              the same 'identity'
print("\nCustom Object Comparisons with ===: ")
print("var cabbage5 = cabbage2")
var cabbage5 = cabbage2
print("cabbage2 === cabbage5: " + String(cabbage2 === cabbage5))
// Q5: what will this output? why?
cabbage5.weight = 5
print("cabbage5.weight = " + String(cabbage5.weight))
print("cabbage2.weight = " + String(cabbage2.weight))
print("cabbage2.weight == cabbage5.weight: " + String(cabbage2.weight == cabbage5.weight))
// Q6: based on your conclusion from Q5, what will 
//      these lines output 

// now, java was able to override the equals() method,
//      which means the equivalent *should* be available
//      in swift
// we COULD create an isEqual func to emulate java's
//      but we can actually override == and ===
print("\nCustom Object Comparisons with custom == func: ")
print("cabbage1 == cabbage3: " + String(cabbage1 == cabbage3))
print("cabbage1 == cabbage2: " + String(cabbage1 == cabbage2))
print("cabbage1 == cabbage4: " + String(cabbage1 == cabbage4))
print("cabbage2 == cabbage3: " + String(cabbage2 == cabbage3))
print("cabbage2 == cabbage4: " + String(cabbage2 == cabbage4))
print("cabbage3 == cabbage4: " + String(cabbage3 == cabbage4))
print("cabbage2 == cabbage5: " + String(cabbage2 == cabbage5))
// Q7: what will cabbage2 == cabbage5 output?

// bonus round
// Q8: what will the following lines output
print("'Primitive' and String comparisons with ===:")
print("i = " + String(i) + ", j = " + String(j) + ", k = " + String(k))
/*print("i === j: " + String(i === j))
print("i === k: " + String(i === k))
print("j === k: " + String(j === k))*/
print("str1 = " + str1 + ", str2 = " + str2 + ", str3 = " + str3)
/*print("str1 === str3: " + String(str1 === str3))
print("str1 === str2: " + String(str1 === str2))
print("str2 === str3: " + String(str2 === str3))*/
// hint: === tests for same reference or 'identity'
























