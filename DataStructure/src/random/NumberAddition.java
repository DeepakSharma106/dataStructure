package random;

public class NumberAddition {

	public static int addition(int number) {
		int remainder = 0;
		int result = 0;
		while(number != 0) {
			remainder = number % 10;
			number = number / 10;
			result += remainder;
		}
		
		return result;
	}
	public static void main(String[] args) {
		System.out.println(NumberAddition.addition(123456));

	}

}
