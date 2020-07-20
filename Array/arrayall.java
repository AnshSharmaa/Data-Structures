import java.util.*; 
public class arrayall { 
	static Scanner s=new Scanner(System.in);
	static int i;
	public static void main(String[] args) 
	{ 
		int sel;
		System.out.println("Enter the length of array");
		int n = s.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the elements of array");
		for(i=0;i<n;i++){
			arr[i]=s.nextInt();
		}
		System.out.println("1-Insertion at a given position\n2- Insertion before a given number \n3- Insertion after a given number\n4-Deletion of a given val \n5-Deletion from a given position");
		sel=s.nextInt();
		switch (sel) { 
			case 1: 
				addbyp(n, arr); 
				break; 
			case 2: 
				addbyvbefore(n,arr);
				break;
			case 3:
				addbyvafter(n,arr);
				break; 
			case 4: 
				delbyp(n,arr);
				break; 
			case 5: 
				int g[]=delbyv(n,arr);
				break; 
		}
		s.close();
	} 
	static void printarr(int narr[]){
		System.out.println();
		for(i=0;i<narr.length;i++){
			System.out.print(narr[i]+" ");
		} 
	}
	
	
	static void addbyp(int n, int arr[]) 
	{ 
		int narr[] = new int[n + 1]; 
		System.out.println("Enter the position to insert at");
		int pos = s.nextInt();
		System.out.println("Enter the element");
		int val = s.nextInt();

		System.out.println("Before");
		for(i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		} 
		System.out.println();

		for (i = 0; i < n + 1; i++) { 
            if (i < pos - 1){
				narr[i] = arr[i];
			} 
            else if (i == pos - 1){ 
				narr[i] = val; 
			}
            else{
				narr[i] = arr[i - 1];
			} 
		}
		printarr(narr);
	}

	static void addbyvbefore(int n, int arr[]) {		
		int narr[] = new int[n + 1]; 
		System.out.println("Enter the number to be added before");
		int x = s.nextInt();
		System.out.println("Enter the element");
		int val = s.nextInt();
		int xp=-1;
		System.out.println("Before");
		for(i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		} 
		System.out.println();
		
		for (int i=0;i<n;i++){
            if (arr[i]==x) {
                xp=i;
            }
        }
        for (int i=0;i<xp;i++){
          narr[i]=arr[i];
        }
      narr[xp]=val;
        for (int i=xp+1;i<narr.length;i++){
          narr[i]=arr[i-1];
		}
		printarr(narr);
	}

	static void addbyvafter(int n, int arr[]){
		int narr[] = new int[n + 1]; 
		System.out.println("Enter the number to be added after");
		int x = s.nextInt();
		System.out.println("Enter the element");
		int val = s.nextInt();
		int xp=-1;
		System.out.println("Before");
		for(i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		} 
		System.out.println();

		for (int i=0;i<n;i++){
            if (arr[i]==x) {
                xp=i;
            }
        }
        for (int i=0;i<xp;i++){
          narr[i]=arr[i];
        }
      narr[xp+1]=val;
        for (int i=xp+2;i<narr.length;i++){
          narr[i]=arr[i-1];
		}
		printarr(narr);
		
	}

	static void delbyp(int n,int arr[]){
		int narr[] = new int[n - 1]; 
		System.out.println("Enter the position to delete");
		int pos = s.nextInt();
		System.out.println("Before");
		for(i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		} 
		System.out.println();

		for (i = 0; i < n-1; i++) { 
            if (i < pos - 1){
				narr[i] = arr[i];
			} 
            else if (i == pos - 1){ 
				narr[i] = arr[i+1];
			}
			else{
				narr[i] = arr[i +1];
			} 
		}
		//printarr(narr);
		System.out.println();
		for(i=0;i<n-1;i++){
			System.out.print(narr[i]+" ");
		} 
	}

	static int[] delbyv(int n,int arr[]){
		int narr[] = new int[n - 1]; 
		System.out.println("Enter the value to delete");
		int pos = s.nextInt();
		System.out.println("Enter the element");
		int val = s.nextInt();
		int xp=-1;
		System.out.println("Before");
		for(i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		} 
		System.out.println();

		for (int i=0;i<n;i++){
            if (arr[i]==val) {
                xp=i;
            }
        }
        if (xp!=-1) {
            for (int i=0;i<xp;i++){
                narr[i]=arr[i];
            }
            for (int i=xp;i<narr.length;i++){
                narr[i]=arr[i+1];
            }
            return delbyv(val,narr);   
        }
        else return arr;
	}
} 
