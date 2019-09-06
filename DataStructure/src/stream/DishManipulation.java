package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class DishManipulation {

	public static void main(String[] args) {
		List<Dish> dishes = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT), 
				new Dish("beef", false, 700, Dish.Type.MEAT), 
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", false, 530, Dish.Type.OTHER), 
				new Dish("rice", false, 350, Dish.Type.OTHER), 
				new Dish("season fruit", false, 120, Dish.Type.OTHER), 
				new Dish("pizza", false, 550, Dish.Type.OTHER), 
				new Dish("prawns", false, 300, Dish.Type.FISH), 
				new Dish("salmon", false, 450, Dish.Type.FISH) );

    
		List<String> threeHighCalorieDishes = dishes.stream().filter( d -> d.getCalories() > 300)
				               .map(Dish::getName).limit(3).collect(toList());
		
		System.out.println(threeHighCalorieDishes);
		
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(3,4);
		
		List<int[]> pairs = list1.stream()
				              .flatMap(i -> list2.stream().map(j -> new int[] {i,j})).collect(toList());
		
		for(int[] pair : pairs) {
			System.out.print(Arrays.toString(pair)+" ");
		}
		System.out.println();
		
		Optional<Dish> d = dishes.stream().filter(Dish::isVegetarian)
				     .findAny();
		System.out.println(d);
		
		List<Integer> listNumbers = Arrays.asList(1,2,3,4,5);
		
		int sum = listNumbers.stream().reduce(0, (a,b) -> a+b);
		System.out.println(sum);
		
		int product = listNumbers.stream().reduce(1, (a,b) -> a*b);
		System.out.println(product);
  }

}
