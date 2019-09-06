package linkedList;

public class BinarySearchTest {

	public static int solution(int[] list, int number, int low, int high) {
		int index = -1;
		
		while(low <= high) {
			int mid = (low+high)/2;
			
			if(list[mid] > number) {
				high = mid-1;
			} else if (list[mid] < number) {
				low = mid+1;
			} else if (list[mid] == number) {
				index = mid;
				break;
			}
		}
		
		return index;
		
	}
	
	public static int solutionRecursive(int[] list, int number, int low, int high) {
		int mid = (low+high)/2;
		
		if(high < low) {
			return -1;
		}
		
		if(list[mid] == number) {
			return mid;
		}
		
		if(list[mid] < number) {
			return solutionRecursive(list, number, mid+1, high);
		} else {
			return solutionRecursive(list, number, low, mid-1);
		}
	}

	public static void main(String[] args) {
       int[] input = {1,2,3,4,5,6};
       
       int result = solutionRecursive(input, 5, 0, 5);
       
       if(result != -1) {
    	   System.out.println("number has been found at index "+result);   
       } else
    	   System.out.println("number does not exist");
    }

}
