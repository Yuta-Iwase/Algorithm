package sort;

public class InsertionSorter<T extends Comparable<T>> extends Sorter<T> {

    public void sort(T[] a) {
         data = a;
         int n = data.length;

//         showData();
         for (int i = 1; i <= n - 1; i++) { 
              // data[i]をdata[0:i]の適切な箇所に挿入する
              T x = data[i];
              int j = i; // jは挿入位置の候補
              while (j >= 1 && data[j - 1].compareTo(x) > 0) {
                   data[j] = data[j - 1];
                   j--;
              }
              data[j] = x;
//              showData();
         }
    }

    public static void main(String[] args) {
         Integer[] sample = { 58, 12, 39, 90, 49, 26, 68, 47, 15, 39 };

         Sorter<Integer> mySorter = new InsertionSorter<Integer>();
         mySorter.sort(sample);
         for (int i : sample) {
              System.out.print(i + " ");
         }

    }
}