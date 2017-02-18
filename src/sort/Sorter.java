package sort;

public abstract class Sorter<T>{
    protected T[] data; // enable to access array a in this class 

    public abstract void sort(T[] a);

    protected void showData(){
         for (T x : data){
              System.out.print(x + " ");
         }
         System.out.println();
    }
    
    protected void swap(int x, int y) {
         T temp = data[x];
         data[x] = data[y];
         data[y] = temp;
    }
}