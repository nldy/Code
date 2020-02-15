package data_structure;

public class QuickSort {
    public static <T extends Comparable<? super T>> void sort(T[] arr){
        sort(arr,0,arr.length-1);
    }
    public static <T extends Comparable<? super T>> void sort(T[] arr,int left,int right){
        if(left>=right) return;
        int p=partition(arr,left,right);
        sort(arr,left,p-1);
        sort(arr,p+1,right);
    }
    private static <T extends Comparable<? super T>> int partition(T[] arr,int left,int right){
        swap(arr,left,(int)(Math.random()*(right-left+1)+left));
        T base=arr[left];
        int j=left;
        for(int i=left+1;i<=right;i++){
            if(base.compareTo(arr[i])>0){
                j++;
                swap(arr,j,i);
            }
        }
        swap(arr,left,j);
        return j;
    }
    public static void swap(Object[] arr,int i,int j){
        if(i!=j){
            Object temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
    private static void printArr(Object[] arr){
        for(Object obj:arr){
            System.out.print(obj);
            System.out.print("\t");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Integer[] arr={3,62,4,7,14,56,867,256,234,54,8,0};
        printArr(arr);
        sort(arr);
        System.out.println("after sort");
        printArr(arr);
    }
}
