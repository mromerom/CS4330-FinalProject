/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacomparevalueexamples;

/**
 *
 * @author MUST-2
 */
public class JavaCompareValueExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cabbage cabbage1 = new Cabbage(3.3, true);
        Cabbage cabbage2 = new Cabbage(3.4, false);
        Cabbage cabbage3 = new Cabbage(3.3, true);
        Cabbage cabbage4 = new Cabbage(3.3, false);
        
        String str1 = "Hi";
        String str2 = "Hello";
        String str3 = "Hi";
        
        int i = 3;
        int j = 3;
        int k = 2;
        System.out.println("Primitive Comparisons:");
        System.out.println("i = " + i + ", j = " + j + ", k = " + k);
        System.out.println("i == j: " + (i == j));
        System.out.println("i == k: " + (i == k));
        
        System.out.println("\nObject Comparisons:");
        System.out.println("Cabbage1: ");
            System.out.println("\tweight: " + cabbage1.weight);
            System.out.println("\tfresh: " + cabbage1.fresh);
        System.out.println("Cabbage2: ");
            System.out.println("\tweight: " + cabbage2.weight);
            System.out.println("\tfresh: " + cabbage2.fresh);
        System.out.println("Cabbage3: ");
            System.out.println("\tweight: " + cabbage3.weight);
            System.out.println("\tfresh: " + cabbage3.fresh);
        System.out.println("Cabbage4: ");
            System.out.println("\tweight: " + cabbage4.weight);
            System.out.println("\tfresh: " + cabbage4.fresh);
        // we can see from the declarations and these prints that
        //      only cabbage1 and cabbage3 are truly 'equal' or the same
        // let's compare them with ==
        System.out.println("\nComparing objects with ==: ");
        System.out.println("cabbage1 == cabbage 3: " + (cabbage1 == cabbage3));
        System.out.println("cabbage1 == cabbage 2: " + (cabbage1 == cabbage2));
        System.out.println("cabbage1 == cabbage 4: " + (cabbage1 == cabbage4));
        System.out.println("cabbage2 == cabbage 3: " + (cabbage2 == cabbage3));
        System.out.println("cabbage2 == cabbage 4: " + (cabbage2 == cabbage4));
        System.out.println("cabbage3 == cabbage 4: " + (cabbage3 == cabbage4));
        // why are none of these correct??
        // with objects, == checks to see if the variables are pointing to
        //      the same object
        System.out.println("\nComparing objects with == (fixed): ");
        System.out.println("Cabbage cabbage5 = cabbage2;");
        Cabbage cabbage5 = cabbage2;
        System.out.println("cabbage2 == cabbage 5: " + (cabbage2 == cabbage5));
        // what does this mean? any edits or changes to cabbage5 show up in 
        //      cabbage2 and vice versa
        System.out.println("cabbage5.weight = 5;");
        cabbage5.weight = 5;
        System.out.println("cabbage5.weight = " + cabbage5.weight);
        System.out.println("cabbage2.weight = " + cabbage2.weight);
        System.out.println("cabbage2.weight == cabbage5.weight: " + (cabbage2.weight == cabbage5.weight));
        
        // now let's backtrack
        // we know that cabbage1 and cabbage3 are the same, how do we compare them?
        // now let's backtrack
        // we know that cabbage1 and cabbage3 are the same, how do we compare them?
        // let's learn about .equals()
        System.out.println("\nComparing Strings with str1.equals(str2): ");
        System.out.println("str1 = " + str1 + ", str2 = " + str2 + ", str3 = " + str3);
        System.out.println("str1.equals(str3): " + (str1.equals(str3)));
        System.out.println("str1.equals(str2): " + (str1.equals(str2)));
        System.out.println("str2.equals(str3): " + (str2.equals(str3)));
        // this is a special function developed for String objects
        // all objects have this function, actually, but it doesn't
        //      always work as expected 
        //          --> .equals() is only true when: cabbage2.equals(cabbage5)
        //      fortunately we can use our knowledge of overriding
        //      to make this function do what we want it too
        System.out.println("\nComparing Objects with overidden .equals(): ");
        System.out.println("cabbage1.equals(cabbage3): " + (cabbage1.equals(cabbage3)));
        System.out.println("cabbage1.equals(cabbage2): " + (cabbage1.equals(cabbage2)));
        System.out.println("cabbage1.equals(cabbage4): " + (cabbage1.equals(cabbage4)));
        System.out.println("cabbage2.equals(cabbage3): " + (cabbage2.equals(cabbage3)));
        System.out.println("cabbage2.equals(cabbage4): " + (cabbage2.equals(cabbage4)));
        System.out.println("cabbage3.equals(cabbage4): " + (cabbage3.equals(cabbage4)));
        System.out.println("cabbage2.equals(cabbage5): " + (cabbage2.equals(cabbage5)));
        // now this can be a hassle trying to compare every aspect of an object
        //      it can be very useful for finding duplicate information
        // however, most programming suggests to have a 'primary key' that
        //      makes objects unqiue; then, one would compare those keys
        // in addition to all these different comparisons, it is possible to use
        //      == on primitive variables of an object (see cabbage5 == cabbage2 example)
       
}
