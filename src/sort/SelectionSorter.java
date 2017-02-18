package sort;

// selection sort
public class SelectionSorter<T extends Comparable<T>> extends Sorter<T> {
    public void sort(T[] aa) {
         data = aa;
         int n = data.length;

//         showData();
         for (int k = n - 1; k >= 1; k--) { // data[0 : k]が未確定部分
              // data[0 : k]の最大値data[m]を求める。
              int m = 0;
              
              for(int i=1 ; i<=k ; i++){
            	  if(data[i].compareTo(data[m]) >0) m=i;
              }

              swap(m, k);
//              showData();
         }
    }

    public static void main(String[] args) {
         Integer[] sample = { 58, 12, 39, 90, 49, 26, 68, 47, 15, 39 };

         Sorter<Integer> mySorter = new SelectionSorter<Integer>();
         mySorter.sort(sample);
         for (int i : sample) {
              System.out.print(i + " ");
         }

    }
}