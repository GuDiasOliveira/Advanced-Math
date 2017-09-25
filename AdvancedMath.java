
public class AdvancedMath {
	
	public static double root(double a, double index) {
		return Math.pow(a, 1 / index);
	}
	
	public static double log(double a, double base) {
		return Math.log(a) / Math.log(base);
	}
	
	public static long fat(int n) {
		if (n < 0)
			throw new ArithmeticException("n! n must not be negative");
		long res = 1;
		for (int i = 2; i <= n; i++)
			res *= i;
		return res;
	}
	
	public static long array(int n, int p) {
		if (p > n)
			throw new ArithmeticException("A(n,p) p must be less or equal to n");
		if (p < 0)
			throw new ArithmeticException("A(n,p) p must not be negative");
		long res = 1L;
		for (int i = 0; i < p; i++)
			res *= n - i;
		return res;
	}
	
	public static long combination(int n, int r) {
		if (r > n)
			throw new ArithmeticException("C(n,r) r must be less or equal to n");
		if (r < 0)
			throw new ArithmeticException("C(n,r) r must not be negative");
		return array(n, r) / fat(r);
	}
	
	public static long permutation(int n, int... n_) {
		long res = fat(n);
		int n_sum = 0;
		for (int ni : n_) {
			n_sum += ni;
			if (ni <= 0)
				throw new ArithmeticException("In permutation, repetitions must be 1 or greater");
			if (ni > n)
				throw new ArithmeticException("In permutation, repetitions must not be greater than n");
			if (n_sum > n)
				throw new ArithmeticException("In permutation, total repetitions must not be greater than n");
			res /= fat(ni);
		}
		return res;
	}
	
	/**
	 * Count what is the precision (number of decimal places) of the <code>num</code>
	 * @param num the number to be counted the precision
	 * @return How many decimal places does the number have
	 */
	public static int decimalPlaces(double num) {
		int decimalPlaces = 0;
		while (num - ((int) num) != 0) {
			decimalPlaces++;
			num *= 10;
		}
		return decimalPlaces;
	}
	
	public static double round(double n, int decimalPlaces) {
		double base10 = 1;
		for (int i = 0; i < decimalPlaces; i++)
			base10 *= 10;
        return Math.round(n * base10) / base10;
    }
}