package testers;

import java.math.BigInteger;

import classes.Pair;

public class FibonacciTester {

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		BigInteger first = BigInteger.valueOf(fib(10));
		System.out.println("First Method value of fib(50): " + first.toString());
		long endTime = System.nanoTime();
		long elapsed1 = endTime - startTime;
		System.out.println("Time elapsed on the first method: " + elapsed1);
		
		long startTime2 = System.nanoTime();
		BigInteger second = fibPair(10).first();
		System.out.println("\nSecond Method value of fibPair(50): " + second.toString());
		long endTime2 = System.nanoTime();
		long elapsed2 = endTime2 - startTime2;
		System.out.println("Time elapsed on the second method: " +	 elapsed2);
	}

	public static long fib(int n) { 
		if(n == 0) return 0;
		if (n == 1) return 1; 
		else return fib(n-1) + fib(n-2); 
	} 

	public static Pair<BigInteger> fibPair(int n) {
		if(n < 0) throw new IllegalArgumentException("n cannot be a negative number");
		if(n == 0) return new Pair<BigInteger>(BigInteger.ZERO, BigInteger.ZERO);
		if(n == 1) return new Pair<BigInteger>(BigInteger.ONE, BigInteger.ZERO); 
		
		Pair<BigInteger> p = fibPair(n-1); 
		return new Pair<BigInteger>(p.first().add(p.second()), p.first());

	}

}
