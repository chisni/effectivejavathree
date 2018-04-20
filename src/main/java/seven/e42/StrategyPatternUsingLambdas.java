package seven.e42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

interface SortStrategyWithLambda {
	public abstract void sort(List<Integer> numbers);
}

class TensFirstWithLambda implements SortStrategyWithLambda {
	public void sort(List<Integer> numbers) {
		Collections.sort(numbers, (o1, o2) -> {
			if (o1 % 10 == 0) {
				return -1;
			} else {
				return o1.compareTo(o2);
			}
		});
	}
}

class FivesFirstWithLambda implements SortStrategyWithLambda {
	@Override
	public void sort(List<Integer> numbers) {
		Collections.sort(numbers, (o1, o2) -> {
			if (o1 % 5 == 0) {
				return -1;
			} else {
				return o1.compareTo(o2);
			}
		});
	}
}

class ThreesFirstWithLambda implements SortStrategyWithLambda {
	@Override
	public void sort(List<Integer> numbers) {
		Collections.sort(numbers, (o1, o2) -> {
			if (o1 % 3 == 0) {
				return -1;
			} else {
				return o1.compareTo(o2);
			}
		});
	}
}

public class StrategyPatternUsingLambdas {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, 5, 10, 15, 20, 24, 30, 100));
		SortStrategyWithLambda sortStrategy = chooseSortStrategy();
		sortStrategy.sort(numbers);
		System.out.println("Numbers after sort.. ");
		for (Integer number : numbers) {
			System.out.println(number);
		}
	}

	private static SortStrategyWithLambda chooseSortStrategy() {
		int randomInt = new Random().nextInt(3);
		final SortStrategyWithLambda tensFirst = new TensFirstWithLambda();
		final SortStrategyWithLambda fivesFirst = new FivesFirstWithLambda();
		final SortStrategyWithLambda threesFirst = new ThreesFirstWithLambda();
		switch (randomInt) {
		case 0:
			return tensFirst;
		case 1:
			return fivesFirst;
		case 2:
			return threesFirst;
		}
		return threesFirst;
	}
}
