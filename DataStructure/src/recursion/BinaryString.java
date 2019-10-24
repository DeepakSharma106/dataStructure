package recursion;

import java.util.Arrays;

public class BinaryString {

	private int[] A = new int[5];
	
	public void binary(int n) {
		if( n < 1) {
			System.out.println(Arrays.toString(A));
		} else {
			A[n-1] = 0;
			binary(n-1);
			A[n-1] = 1;
			binary(n-1);
		}
	}
	public static void main(String[] args) {
		BinaryString bs = new BinaryString();
		
		bs.binary(5);

	}

}
