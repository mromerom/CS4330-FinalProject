class Vegetable{
  private var kindOfFood: String = "Vegetable";
  var weight: Double = 0;
  
  init(weight: Double){
    self.weight = weight;
    // java uses 'this' and swift uses 'self'
    //  this will be covered in a later topic,
    //  under self-referencing
  }
  
  func printWeight(){
        print(weight);
  } 
  
  func printKind(){
      print("Vegtable Class kindOfFood: " + kindOfFood)
      // see the comment under this same class's function in Java
  }
  
}
class Cabbage: Vegetable{
    var kindOfFood: String = "Cabbage";
    // since Vegetable's kindOfFood variable was private,
    //      Cabbage doesn't 'have' one
    var fresh: Bool = true;
  
    init(weight: Double, fresh: Bool){
        super.init(weight: weight)
        self.fresh = fresh;
    }
  
    // no need to add printWeight() as the parent class 
    //    provides it
  
    override func printKind(){
        print("Cabbage Class kindOfFood: " + kindOfFood)
        // Q6: if this function weren't here, what would an object of
        //      class Cabbage print instead?
    }
    
    func printFresh(){
        print("Cabbage Class fresh: " + String(fresh));
    }
  
}
class January_King: Cabbage{
    var region: String = "southwest";
  
    init(weight: Double, fresh: Bool, region: String){
        super.init(weight: weight, fresh: fresh)
        self.region = region;
    }
  
    // no need to add printWeight() as the parent class 
    //    provides it
  
    /*
    override func printKind(){
        print("January_King Class kindOfFood: " + kindOfFood)
    }
    Q7: Which kindOfFood do you think this would print if it were active (uncommented)?
    */
    
    // no need to add printFresh() as the parent class 
    //      provides it
    
    func printRegion(){
        print("January_King class region: " + region)
    }
  
}

var veggie = Vegetable(weight: 3.2);
var cabbage = Cabbage(weight: 3.3, fresh: true);
var jking = January_King(weight: 3.4, fresh: false, region: "northwest");


print("veggie, cabbage, jking");
veggie.printWeight();
cabbage.printWeight();
jking.printWeight();

print("\nveggie, cabbage, jking");
veggie.printKind(); // output = Vegetable Class kindOfFood: Vegetable
cabbage.printKind(); // output = Cabbage Class kindOfFood: Cabbage
jking.printKind(); // Q8: output = ?

print("\ncabbage, jking");
cabbage.printFresh(); // output = true
jking.printFresh(); // output = false

print("\njking");
jking.printRegion(); // output = northwest

print("\nveggie = jking");
veggie = jking;
veggie.printWeight(); // Q9: output = ?
veggie.printKind(); // Q10: output = ?





