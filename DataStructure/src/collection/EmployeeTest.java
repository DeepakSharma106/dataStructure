package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Employee {
	private int id;
	private String name;
	
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name + this.id;
	}
	
	public boolean equals(Object o1) {
		if(this == o1)
			return true;
		if( o1 == null)
			return false;
		if(this.getClass() == o1.getClass())
			return true;
		Employee e1 = (Employee)o1;
		if(e1.getId() == this.getId())
			return true;
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}*/
	
}

class NameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}

class IdComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if( o1.getId() > o2.getId()) {
			return 1;
		} else if (o1.getId() < o2.getId())
			return -1;
		return 0;
	}
	
}


public class EmployeeTest {
	
	public static <T> List<T> filterAnything(List<T> inputList, Predicate<T> predicate){
		List<T> result = new ArrayList<>();
		for(T t: inputList) {
			if(predicate.test(t)) {
				result.add(t);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Employee e1 = new Employee(10, "Z");
		Employee e2 = new Employee(21, "B");
		Employee e3 = new Employee(3, "K");
		Employee e4 = new Employee(17, "A");
		
		
		List<Employee> employeeList = Arrays.asList(e1,e2,e3,e4);
		
		System.out.println("before sorting "+employeeList);
		
    //    employeeList.sort(new NameComparator());
    //    System.out.println("after sorting by name "+employeeList);
      
        /*employeeList.sort( new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				if( o1.getId() > o2.getId()) {
					return 1;
				} else if (o1.getId() < o2.getId())
					return -1;
				return 0;
			}
        });*/
		
		employeeList.sort((o1,  o2) -> {
			if(o1.getId() > o2.getId())
				return -1;
			else if(o1.getId() < o2.getId())
				return 1;
			else
				return 0;
		});
        
        //employeeList.sort(new IdComparator());
        
        System.out.println("after sorting with id"+employeeList);
        
        Employee e10 = new Employee(10, "vijay");
        Employee e11 = new Employee(10, "vijay");
        
        Set<Employee> empSet = new HashSet<>();
        
        empSet.add(e10);
        empSet.add(e11);
        System.out.println(empSet);
        
        
        //filter the employee list having id greater than 11
        
        Predicate<Employee> predicate = (Employee e) -> e.getId() > 11;
        System.out.println(employeeList);
        List<Employee> finalList = filterAnything(employeeList, e -> e.getId() > 3);
        System.out.println(finalList);
        
        
        List<String> stringList = Arrays.asList("spring in action","spring in new", "i am autumn","can not digest");
        
        List<String> outputList = filterAnything(stringList, s -> !s.contains("spring"));
        System.out.println(outputList);
        
        List<Integer> intList = Arrays.asList(11,12,13,14,15,16);
        
        List<Integer> list2 =  intList.stream().map(i -> i +5).filter(j -> !(j % 2 == 0)).collect(Collectors.toList());
        System.out.println(list2);
        List<Integer> evenList = filterAnything(intList, i -> i % 2 == 0);
        System.out.println(evenList);
        
	}

}
