package six.e36;

import java.util.EnumSet;

enum Times {
	Twice {
		@Override
		public int apply(int n) {
			return n * 2;
		}
	} , 
	Thrice {
		@Override
		public int apply(int n) {
			return n * 3;
		}
	},
	Quadruple {
		@Override
		public int apply(int n) {
			return n * 4;
		}
	}
	;
	public abstract int apply(int n);
}

public class E36 {
	public static void main(String[] args) {
		EnumSet<Times> timesSet = EnumSet.of(Times.Quadruple, Times.Twice);
		int result = applyTimes(2, timesSet);
		System.out.println(result);
		EnumSet<Times> justThrice = EnumSet.of(Times.Thrice);
		int resultAgain = applyTimes(2, justThrice);
		System.out.println(resultAgain);
	}
	
	private static int applyTimes(int n, EnumSet<Times> timesSet) {
		int result = 1;
		for(Times times: timesSet) {
			result = times.apply(result);
		}
		return result;
	}
	
}
