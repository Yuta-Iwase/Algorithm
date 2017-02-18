package sort;

// 分割統治法に基づく
public class MergeSorter<T extends Comparable<T>> extends Sorter<T>{

	private Object[] b;

	public void sort(T[] aa) {
		data = aa;
		b = new Object[data.length];
		mergesort(0, data.length - 1);
	}
	
	// merge-sort a[left..right] (recursive method)
	private void mergesort(int low, int high){
		if (low < high){
			int mid = (low + high)/2;
			mergesort(low, mid);
			mergesort(mid + 1, high);
			
			// merge a[left:half] & a[half+1:right] and store into b[left:right] 
			merge(low, mid, high);
			
			// copy b[left:right] to a[left:right]
			for (int i = low; i <= high; i++){
				data[i] = (T) b[i];
			}
		}
	}
	
	// merge a[left:half] & a[half+1:right] and store into b[left:right] 
	private void merge(int low, int mid, int high){
		int i = low;
		int j = mid + 1;
		for (int k = low; k <= high; k++){
			if (j == high + 1 || i <= mid && data[i].compareTo(data[j]) < 0){
				b[k] = data[i];
				i++;
			} else {
				b[k] = data[j];
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
 		Integer[] sample = { 58, 12, 39, 90, 49, 26, 68, 47, 15, 39};

 		Sorter<Integer> mySorter = new MergeSorter<Integer>();
 		mySorter.sort(sample);
 		for (int i : sample) {
 			System.out.print(i + " ");
 		}

 	}

	
	
}