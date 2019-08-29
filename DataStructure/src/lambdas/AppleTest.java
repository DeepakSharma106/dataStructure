package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Apple {
	private int weight;
	private String color;
	
	public Apple(int weight) {
		this.weight = weight;
	}
	
	public Apple(int weight, String color) {
		this.weight = weight;
		this.color = color;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		return this.color+" "+this.weight;
	}
	
}

public class AppleTest {

	public static List<Apple> filterApples(List<Apple> appleList, Predicate<Apple> predicate){
		List<Apple> result = new ArrayList<>();
		
		for(Apple a : appleList) {
			if(predicate.test(a)) {
				result.add(a);
			}
		}
		return result;
		
	}
	
	public static void forEachIterator(List<Apple> appleList, Consumer<Apple> consumer) {
		for(Apple a : appleList) {
			consumer.accept(a);
		}
	}
	
	public static <T,R> List<R> map(List<T> inputList, Function<T,R> function){
		List<R> result = new ArrayList<>();
		
		for(T t : inputList) {
			result.add(function.apply(t));
		}
		return result;
	}
	
	public static void main(String[] args) {
	
		List<Apple> appleList = Arrays.asList(new Apple(12,"red"), new Apple(12,"black"), new Apple(31,"white"),new Apple(16,"pink"),new Apple(15,"green"));
	    System.out.println(appleList);
	    
	    //sort the apple list by their color
	    appleList.sort((a1, a2) -> a1.getColor().compareTo(a2.getColor()));
	    System.out.println("sort by color: "+appleList);
	    
	    //sort the list by their weight
	    appleList.sort((a1, a2) -> {
	    	return a1.getWeight() > a2.getWeight() ? 1 : -1;
	    });
	    
	    System.out.println("using method reference");
	    appleList.sort(Comparator.comparing(Apple::getWeight));
	    
	    System.out.println("sort by weight: "+appleList);
	    //filtering apples based on their color 
	    
	    List<Apple> filteredList = filterApples(appleList, (Apple a) -> !a.getColor().equalsIgnoreCase("white"));
	    
	    System.out.println("filtering white apple: "+filteredList);
	    
	    //using for each iterator
	     System.out.println("below iteration is using functional consumer iterface");
	    forEachIterator(filteredList, (Apple a) -> System.out.print(a+" "));
	    System.out.println();
	    //using map method to return length of color of apple 
	    List<Integer> appleColorLength = map(appleList, (Apple a) -> a.getColor().length());
	    
	    System.out.println("length of the color name of apples: "+appleColorLength);
	    
	    List<String> stringList = Arrays.asList("a","b","A","z","k");
	    stringList.sort(String::compareTo);
	    System.out.println("using method reference to sort the alphabets "+stringList);
	    
	    // (String s1, String s2) -> s1.compareTo(s2) ====== String::compareTo
	    
	    Function<Integer, Apple> f1 = weight -> new Apple(weight);
	    Apple apple = f1.apply(2);
	    
	    System.out.println("apple weight is "+apple.getWeight());
	    
	    Function<Integer, Apple> f2 = Apple :: new;
	    
	    Apple a = f2.apply(22);
	    System.out.println(a.getWeight());
	    
	    appleList.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getColor));
	    System.out.println(appleList);
	    
	    appleList.sort(Comparator.comparing(Apple::getWeight).reversed());
	    System.out.println("reverse order using reversed() method "+appleList);
	}


}
