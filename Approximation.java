/* Angelica Smith-Evans
 * Calc 2 Extra Credit
 * 6/26/2016
 * 
 * This program approximates the area of the function
 * f(x) = sin(x^3) on the interval [0,1] using Simpson's
 * and Trapezoidal Approximations.
 */

public class Approximation
{
	public static void main (String []args)
	{
		double a = 0.0;
		double b = 1.0;
		int n = 0;
		System.out.println ("n\t Simpson's Approx.\tTrapeziod Approx.");
		while (n <= 20) //creates a table showing approximations from n=2 to n=20
		{
			n = n+2;	//makes approximations by increasing the partitions by 2
			System.out.print("n = " + n + "\t");
			System.out.print(" " + SimpsonsRule(a,b,n)+"\t");
			System.out.println(TrapezoidRule(a,b,n));
		}
	} // end main
	
	//this method approximates using Simpson's Rule
	public static double SimpsonsRule(double a, double b, int n)
	{	
		double simpson, //this will output the approximation
			x, 			// Value for evaluation of function
			sum4, 		// Value of 4x terms
			sum2; 		// Value of 2x terms
		simpson = Function(a) + Function(b); //initializes sum by evaluating at endpoints
		double h = (b - a) / n; //width of the subintervals
		sum4 = 0.0; 			//initialized to 0.0 for calculation purposes
		for(int i = 1; i < n; i += 2) 	//this will hold the values for every term 
			{								//which will be multiplied by 4
			x = a + i * h; 			//identifies the subinterval, x
			sum4 += Function(x); 	// evaluates the function at x, which is stored in sum4
			} // end for
		sum2 = 0.0;				//initialized to 0.0 for calculation purposes
		for(int i = 2; i < n-1; i += 2) //like the previous forloop, this will hold the sum
			{									//values for the 2*terms
			x = a + i * h;
			sum2 += Function(x);
			} // end for
		//the approximation is evaluated by the formula for Simpson's Rule
		simpson = (h / 3.0) * (simpson + 4 * sum4 + 2 * sum2);
		return simpson;
	} // end SimpsonsRule()
	
	//this method approximates using Trapezoid Rule
	public static double TrapezoidRule(double a, double b, int n)
	{	
		double trapezoid, //this will output the approximation
			x, 			  // Value for evaluation of function
			sum2;		  // Value of 2x terms
			trapezoid = Function(a) + Function(b); //initializes sum by evaluating at endpoints
		double h = (b - a) / n;		 //width of the subintervals
		sum2 = 0.0;					 //initialized to 0.0 for calculation purposes
		for(int i = 1; i < n; i ++) 	//this will hold the sum
			{							//values for the 2*terms
			x = a + i * h;
			sum2 += Function(x);
			} // end for
		//the approximation is evaluated by the formula for Trapezoid Rule
		trapezoid = (h / 2.0) * (trapezoid  + 2 * sum2);
		return trapezoid;
	} // end TrapezoidRule()
	
	//This is the method which evaluates the function at the subinterval, x
	public static double Function (double x)
	{
		x = Math.sin(Math.pow(x, 3)); //represents f(x) = sin(x^3)
		return x;
	}//end Function()
}//end class