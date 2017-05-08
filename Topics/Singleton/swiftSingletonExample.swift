// this is the oldest and definitely 
//      not prettiest version of
//      singleton
// it's also outdated and no longer
//      used in Swift 3
/*
class OldRunner{
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
*/

// let's move onto ways that DO work
//      and are supported
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
// Q4: what will the following code execute?
let runner2 = runner1
print("Q4: output: ")
runner2.printName()
runner2.printMiles()
runner2.structRunnerToString()


// let's move on to another kind of singleton
// global variable
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
// typically we would name it something
//      more substantial, ex. sharedRunner,
//      sharedInstance, etc.
// runner3 needs to be in the same file as this
//      class, elsewise, since it's private,
//      it could not be used
// this is also the closest we come to having
//      a lazy singleton
print("\nSingelton type2: global variable (lazy-styled singleton):")
runner3.printName()
runner3.printMiles()
runner3.globalRunnerToString()
// Q5: what happens if we execute the following?
let runner4 = GlobalRunner.sharedInstance
print("Q5: output:")
runner4.printName()
runner4.printMiles()
runner4.globalRunnerToString()
// Q6: how will the following execute?
print("Q6: output:")
private let runner5 = GlobalRunner(name: "Forrest Gump", miles: 19024.0)
runner5.printName()
runner5.printMiles()
runner5.globalRunnerToString()
// why does this happen?
//      because we're not grabbing the
//      sharedInstance
// the class has no way of 'protecting'
//      itself to only have ONE object
//      as is the requirements for a 
//      singleton!!
// this is not safe!!

// okay, can we make this easier?
// why yes we can!
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


// thread safety?
// as we saw with type2, we could make another instance!
//      super not safe!
// how can we combat this?
//      change the init()!
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
// Q7: what happens if we execute the following?
/*let runner8 = StructRunnerForcedSingleton(name: "Leslie Knope", miles: 0.0)
print("\nSingleton type1: struct: forced, true singleton: new object try: ")
runner8.printName()
runner8.printMiles()
runner8.structRunnerForcedToString()*/



// okay we solved types 1&3, but how do we solve
//      type2?
class GlobalRunnerForcedSingleton{
    var name: String = ""
    var miles: Double = 0.0
    static var sharedInstance: GlobalRunnerForcedSingleton? = nil
    // we cannot use let, as that does
    //      not allow for changes
    
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
// as far as I am aware, it's difficult to 
//      make this safe!! type3 is the best
//      and most often used singleton case
// unfortunately, as I am not a mac user,
//      the playground I am using to emulate
//      a swift coding environment, I cannot
//      test this
//      however, this SHOULD allow for a true
//      instantiation of a 'global'/ lazy
//      swift singleton
// edit: after much testing, type2 can work
//      if it's treated similar to java's
//      lazy singletons


// these instances are really more loopholes in
//      swift singletons that need to be fixed
// as far as talking about true thread-safety...
//      swift handles that for the most part
// the biggest issue is making sure only ONE
//      object is created for the singleton
//      (which, yes, would involve threads)





