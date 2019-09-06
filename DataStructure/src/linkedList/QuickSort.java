package linkedList;


public class QuickSort {

	public static void solution(int[] array, int begin, int end) {

		if (begin < end) {
			int pivot = partition(array, begin, end);
			solution(array, begin, pivot - 1);
			solution(array, pivot + 1, end);
		}
	}

	private static int partition(int[] array, int begin, int end) {
		int pivot = array[end];
		int i = begin - 1;

		for (int j = begin; j < end; j++) {
			if (array[j] <= pivot) {
				// increment i
				i++;
				// swap
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}

		int temp = array[i + 1];
		array[i + 1] = array[end];
		array[end] = temp;
		return i + 1;
	}

	public static void main(String[] args) {
      int[] input = {45,33,11,8,21,12,1};
      int begin = 0;
      int end = input.length-1;
      
      QuickSort.solution(input, begin, end);
      for(int i: input) {
    	  System.out.print(i+" ");
      }
	}

}
