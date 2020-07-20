import java.util.Scanner;
import java.util.Arrays;

public class mlar {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of array ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of array ");
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the m largest element to find");
        int m = sc.nextInt();
        int[] narr = remdup(arr);
        int num = findMth(narr, m);
        System.out.println(m + "th largest number in array is: " + num);
    }

    static int[] delete(int[] arr, int tar) {
        int n = arr.length;
        int[] narr = new int[n-1];
        int tarpos = -1;
        for (int i=0;i<n;i++){
            if (arr[i]==tar) {
                tarpos=i;
            }
        }
        if (tarpos!=-1) {
            for (int i=0;i<tarpos;i++){
                narr[i]=arr[i];
            }
            for (int i=tarpos;i<narr.length;i++){
                narr[i]=arr[i+1];
            }
            return delete(narr, tar);   
        }
        else return arr;
    }
    static int[] remdup(int[] arr){
        int[] tempo = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            if (find(tempo, arr[i])){
                continue;
            } else {
                tempo[i]=arr[i];
            }
        }
        tempo = delete(tempo, 0);

        return tempo;
    }
    static boolean find(int [] arr, int x){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==x){
                return true;
            }
        }
        return false;
    }
    static int findMth(int[] arr, int m){
        Arrays.sort(arr);
        return arr[arr.length-m];
    }
}
