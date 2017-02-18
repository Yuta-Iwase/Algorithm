package sort;

public class QuickSorter<T extends Comparable<T>> extends Sorter<T> {

	public void sort(T[] aa) {
		data = aa;
		quicksort(0, data.length - 1);
	}

	// quick-sort a[low..high] (recursive method)
	private void quicksort(int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			T x = data[mid];
			int i = low;
			int j = high;
			while (i <= j) {

				while(data[i].compareTo(x) < 0) i=i+1;
				while(data[j].compareTo(x) > 0) j=j-1;
				if(i<=j) swap(i++,j--);

			}
			
//			// show partition
//			if (j < low) {
//				System.out.print("|");
//			}
//			for (int ii = low; ii <= high; ii++) {
//				System.out.print(data[ii] + " ");
//				if (ii == j) {
//					System.out.print("|");
//				}
//				if (ii == i - 1) {
//					System.out.print("|");
//				}
//			}
//			if (i > high) {
//				System.out.print("|");
//			}
//			System.out.println();
			quicksort(low, j);
			quicksort(i, high);
		}
	}

	public static void main(String[] args) {
		Integer[] sample = { 58, 12, 39, 90, 49, 26, 68, 47, 15, 39};
		Sorter<Integer> mySorter = new QuickSorter<Integer>();
		mySorter.sort(sample);
		for (int i : sample) {
			System.out.print(i + " ");
		}

	}

}