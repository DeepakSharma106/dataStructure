package recursion;

public class ArraySorted {

	public static int isArraySorted(int[] A, int index) {
		if (index == 1)
			return 1;
		else
			return (A[index - 1] < A[index - 2]) ? 0 : isArraySorted(A, index - 1);
	}

	public static void main(String[] args) {

		int[] A = { 6, 2, 3, 4, 5 };

		int result = isArraySorted(A, 5);
		if (result == 1)
			System.out.println("array is sorted");
		else
			System.out.println("its not sorted");
	}

}
