// NOTE: the change in color is due to GitHub's incomplete Java code blocking compatibility.
// Option 1
double a = -16.00;
double b = 100.00;
double c = 6.00

double determinant = b*-4*a*c;
if(d < 0){
   print("Imaginary number");
}
else{
   double ans1 = (-b + sqrt(determinant))/(2*a);
   double ans2 = (-b + sqrt(determinant))/(2*a);
   print("x = " + ans1 + " or " x = " + ans2 );
}

// Option 2
quadraticEquation(a, b, c);

public void quadraticEquation(double a, double b, double c)
{
   double determinant = b*-4*a*c;
   if(d < 0)
      System.out.println("Answer is imaginary.");
   else{
      double ans1 = (-b + sqrt(determinant))/(2*a);
      double ans2 = (-b + sqrt(determinant))/(2*a);
      System.out.println("x = " + ans1 + " or " x = " + ans2 );
   }
}
 
/* 
   option 1 (lines 1-11) is fine when you're not using the quadratic equation multiple times
   but imagine many different people needing to use this; wouldn't it be easier to
   make a copy of the option 1 where people just send their numbers in and don't have to
   worry about creating the code themselves or taking this one and re-writing the
   input
   it would be much easier to call a function that does it for you
   option 2 (lines 14-25) is much better and wastes less time, as it is easily
      used by those who can know the name of the function and its parameters
      (what to send the function)
*/
