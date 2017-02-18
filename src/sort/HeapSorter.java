package sort;

// selection sort
public class HeapSorter<T extends Comparable<T>> extends Sorter<T> {

	private static int parent(int i) {
		return (i - 1) / 2;
	}

	private static int leftChild(int i) {
		return 2 * i + 1;
	}

	public void sort(T[] aa) {
		data = aa;
		int n = data.length;

		// 参考:p.94, ただし、配列のインデクスを0:n-1に変更している
		// iの親=(i-1)/2, iの子=2i+1,2i+2
		for (int k = parent(n - 1); k >= 0; k--) { // 新たにdata[k]を根とするヒープを形成
			int i = k;
			int j = leftChild(i);
			T x = data[i];
			while (j <= n - 1) {
				if (j <= n - 2 && data[j + 1].compareTo(data[j]) > 0) {
					j++;
				}
				if (x.compareTo(data[j]) < 0) {
					data[i] = data[j];
					i = j;
					j = leftChild(i);
				} else {
					break;
				}
			}
			data[i] = x;
		}
		for (int k = n - 2; k >= 0; k--) { // 最大値を取り出し、ヒープをdata[0:k]に縮小する
			T x = data[k + 1];
			data[k + 1] = data[0];
			int i = 0;
			int j = leftChild(i);
			while (j <= k) {
				if (j < k && data[j + 1].compareTo(data[j]) > 0) {
					j++;
				}
				if (x.compareTo(data[j]) < 0) {
					data[i] = data[j];
					i = j;
					j = leftChild(i);
				} else {
					break;
				}
			}
			data[i] = x;
		}
	}

	public static void main(String[] args) {
		Integer[] sample = { 58, 12, 39, 90, 49, 26, 68, 47, 15, 39 };

		Sorter<Integer> mySorter = new HeapSorter<Integer>();
		mySorter.sort(sample);
		for (int i : sample) {
			System.out.print(i + " ");
		}

	}
}