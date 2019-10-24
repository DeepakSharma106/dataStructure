package recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	private static Map<Long, Long> map = new HashMap<>();
	
	public static long fib(long n) {
		
		
		if( n < 0 )
			throw new IllegalArgumentException();
		
		//base case
		
		if( n==0 || n==1) {
			return n;
		}
		
		if(map.containsKey(n)) {
			return map.get(n);
		}
		
		long result = fib(n-1)+fib(n-2);
		
		map.put(n, result);
		return result;
		
	}
	public static void main(String[] args) {
		long result = Fibonacci.fib(50);
        System.out.println(result);
	}

}
