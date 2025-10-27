import java.util.*;

public class zeroInTheEnd {

	/**
	 * Move all zeros in the array to the end while preserving the order
	 * of non-zero elements. This runs in O(n) time and O(1) extra space
	 * (modifies the array in-place).
	 */
	public static void moveZerosToEnd(int[] a) {
		int n = a.length;
		int write = 0; // position to write the next non-zero
		for (int read = 0; read < n; read++) {
			if (a[read] != 0) {
				a[write++] = a[read];
			}
		}
		// fill remaining positions with zeros
		while (write < n) {
			a[write++] = 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			if (!sc.hasNextInt()) {
				// Demo fallback
				int[] demo = {0, 1, 0, 3, 12, 0, 5};
				System.out.println("No input detected — running demo: " + Arrays.toString(demo));
				moveZerosToEnd(demo);
				System.out.println(Arrays.toString(demo));
				return;
			}

			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				if (!sc.hasNextInt()) {
					System.err.println("Expected " + n + " integers but got fewer.");
					return;
				}
				a[i] = sc.nextInt();
			}

			moveZerosToEnd(a);

			// print result as space-separated values
			StringJoiner sj = new StringJoiner(" ");
			for (int v : a) sj.add(String.valueOf(v));
			System.out.println(sj.toString());
		} finally {
			sc.close();
		}
	}

}
