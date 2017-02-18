package sort;

public class BubbleSorter<T extends Comparable<T>> extends Sorter<T> {

    public void sort(T[] aa) {
         data = aa;
         int n = data.length;

         for (int k = 1; k <= n - 1; k++) { // kは走査の回数
              for (int i = 0; i <= n - k - 1; i++) { // data[0 : n-k]が走査範囲
                   if (data[i].compareTo(data[i+1]) >0) {
                        swap(i, i + 1);
                   }
              }
         }
    }
    
    public static void main(String[] args) {
          Integer[] sample = { 58, 12, 39, 90, 49, 26, 68, 47, 15, 39};

          Sorter<Integer> mySorter = new BubbleSorter<Integer>();
          mySorter.sort(sample);
          for (int i : sample) {
               System.out.print(i + " ");
          }

     }
}