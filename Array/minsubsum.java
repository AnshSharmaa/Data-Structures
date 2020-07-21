import java.util.Scanner;
import java.util.*;

public class minsubsum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of array");
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] set = remdup(arr);
        boolean[] bool = new boolean[set.length];
        Arrays.sort(set);
        System.out.println(Arrays.toString(set));
        System.out.print("size of subset");
        int k = sc.nextInt();
        int sum = 0;
        for (int i=0;i<k;i++){
            sum+=set[i];
        }
        System.out.println("Minimum sum of a subset for " + Arrays.toString(set) + " is: " + sum);
    }

    static int[] remdup(int[] arr){
        int[] temp = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            if (duplicate(temp, arr[i])){
                continue;
            } else {
                temp[i]=arr[i];
            }
        }
        temp = remove(temp, 0);

        return temp;
    }

    static int[] remove(int[] arr, int target) {
        int n = arr.length;
        int[] narr = new int[n-1];
        int targetindex = -1;
        for (int i=0;i<n;i++){
            if (arr[i]==target) {
                targetindex=i;
            }
        }
        if (targetindex!=-1) {
            for (int i=0;i<targetindex;i++){
                narr[i]=arr[i];
            }
            for (int i=targetindex;i<narr.length;i++){
                narr[i]=arr[i+1];
            }
            return remove(narr, target);   
        }
        else return arr;
    }
    
    static boolean duplicate(int [] arr, int x){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==x){
                return true;
            }
        }
        return false;
    }
    
}
