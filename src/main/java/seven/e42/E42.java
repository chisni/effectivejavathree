package seven.e42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class E42 {
	public static void main(String[] args) {
		List<String> words = new ArrayList<>(
				Arrays.asList("Apple" , "Dream" , "Ball", "Car"));
		anonymousClassAsFunctionObject(words);
		
		for(String word : words) {
			System.out.print(word + " ");
		}
	}
	
	private static void anonymousClassAsFunctionObject(List<String> words) {
		Collections.sort(words, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
	}
}
