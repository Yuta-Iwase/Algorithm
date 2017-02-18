// SpeedTest for sorters
// case of random Double array

package sort;

import java.util.Random;

public class SorterSpeedTest {
	final static int n = 30500; // data size

	enum Category {
		RANDOM, NEARLYSORTED// , SORTED, REVERSED
	}

	// select data category here:
	final static Category dataCategory = Category.RANDOM;
//	 final static Category dataCategory = Category.NEARLYSORTED;

	final static int k = 3; // times for averaging CPU time

	public static void main(String[] args) {
		Double a[] = new Double[n];

		Sorter[] sorters = { new BubbleSorter<Double>(),
				new SelectionSorter<Double>(), new InsertionSorter<Double>(),
				new HeapSorter<Double>(), new QuickSorter<Double>(),
				new MergeSorter<Double>() };

		String[] names = { "Bubble", "Selection", "Insertion", "Heap", "Quick",
				"Merge" };

		for (int ii = 0; ii < sorters.length; ii++) {
			System.out.println("*** " + names[ii] + " sorter ***");

			long msSum = 0;
			for (int i = 0; i < k; i++) {

				// make an input data array
				Random randomGenerator = new Random(i); // initialize random
														// number sequence by
														// seed i
				switch (dataCategory) {
				case RANDOM:
					for (int j = 0; j < n; j++) {
						a[j] = randomGenerator.nextDouble();
					}
					break;
				case NEARLYSORTED:
					for (int j = 0; j < n; j++) {
						a[j] = j / (double) n;
					}
					for (int j = 0; j < n / 100; j++) { // disturb 1% of data by
														// random swapping
						int k1 = randomGenerator.nextInt(n);
						int k2 = randomGenerator.nextInt(n);
						double tmp = a[k1];
						a[k1] = a[k2];
						a[k2] = tmp;
					}
					break;
				}

				long msBegin = System.currentTimeMillis(); // start timer

				// sort the array
				sorters[ii].sort(a);

				long msEnd = System.currentTimeMillis(); // stop timer

				long msElapsed = msEnd - msBegin;
				System.out.print("n=" + n + ", CPU time = " + msElapsed
						+ "(ms)");
				System.out.printf(
						", result=[%.8f, %.8f,　%.8f,..., %.8f, %.8f]\n", a[0],
						a[1], a[2], a[n - 2], a[n - 1]);

				msSum += msElapsed;
			}
			System.out.println("n=" + n + ", average(over last " + k
					+ " times) CPU time = " + msSum / k + "(ms)");
		}
	}
}