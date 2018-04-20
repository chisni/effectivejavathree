package seven.e42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

interface SortStrategy {
	public abstract void sort(List<Integer> numbers);
}

class TensFirst implements SortStrategyWithLambda {
	public void sort(List<Integer> numbers) {
		Collections.sort(numbers, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 % 10 == 0) {
					return -1;
				} else {
					return o1.compareTo(o2);
				}
			}
		});
	}
}

class FivesFirst implements SortStrategyWithLambda {

	@Override
	public void sort(List<Integer> numbers) {
		Collections.sort(numbers, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 % 5 == 0) {
					return -1; 
				} else {
					return o1.compareTo(o2);
				}
			}
		});
	}
}

class ThreesFirst implements SortStrategyWithLambda {

	@Override
	public void sort(List<Integer> numbers) {
		Collections.sort(numbers, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				if( o1 % 3 == 0) {
					return -1;
				} else {
					return o1.compareTo(o2);
				}
			}
			
		});
	
	}
	
}

public class StrategyPattern {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1,3,5,10,15,20,24,30,100));
		SortStrategyWithLambda sortStrategy = chooseSortStrategy();
		sortStrategy.sort(numbers);
		System.out.println("Numbers after sort.. ");
		for (Integer number : numbers) {
			System.out.println(number);
		}
	}
	
	private static SortStrategyWithLambda chooseSortStrategy() {
		int randomInt = new Random().nextInt(3);
        // TODO There is no need to instantiate every time.
		switch ( randomInt ) {
			case 0 : return new TensFirst();
			case 1:  return new FivesFirst();
			case 2:  return new ThreesFirst();
		}
		return new ThreesFirst();
	}
}
