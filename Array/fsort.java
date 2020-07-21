import java.util.Scanner;

public class fsort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of array ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array (keep the elements >100)");
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        fsortarr(arr);
        System.out.println("Frequency sorted array ");
        prarr(arr);
        sc.close();
    }

    static int maxindex(int[] a){
        int max=-1;
        int maxindex=0;
        for (int i=0;i<a.length;i++){
            if (a[i]>max){
                max=a[i];
                maxindex = i;
            }
        }
        return maxindex;
    }
   
    static void fsortarr(int[] arr){
        int[] freqa = new int[100];
        int[] freqb = new int[100];
        int[] temp = new int[arr.length];
        int mpi,mni,mi,m,pos;
        int x=0;
        for (int i=0;i<50;i++){
            freqb[i]=0;
            freqa[i]=0;
        }
        for (int i=0;i<arr.length;i++){
            if (arr[i]<0){
                freqb[0-arr[i]]+=1;
            } else {
                freqa[arr[i]]+=1;
            }
        }
        
        
        for (int i=20;i>=0;i--){
            mpi = maxindex(freqa);
            mni = maxindex(freqb);
            if (freqa[mpi]>freqb[mni]){
                mi = mpi;
                m = 1;
                pos = freqa[mi];
            } else {
                mi = mni;
                m = -1;
                pos = freqb[mi];
            }
            if (freqb[mni]==0&&freqa[mpi]==0){
                break;
            }
            
            for (int j=0;j<pos;j++){
                temp[x]=m*mi;
                x++;
            }


            if (m==1){
                freqa[maxindex(freqa)]=0;
            } else {
                freqb[maxindex(freqb)]=0;
            }
            
        }
            for (int i=0;i<arr.length;i++){
                arr[i]=temp[i];
            }
    }

    static void prarr(int[] arr) {
        for (int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " "); 
    }
   
}
