import java.util.*;
public class ttt { 
	public static void main(String[] args) 
	{ 
		char[][] arr = { { '&', '&', '&' }, { '&', '&', '&'}, { '&', '&', '&'}}; 
		int i;
		char u1='X';
		char u2='0';
		int flg=0;
		System.out.println("User 1 is 'X' and User 2 is '0'");
		System.out.println("Input address of element to take turn i.e 0 0 will be the top left corner");
		for(i=0;i<9;i++){	
			if(i%2==0){
				System.out.println("Turn for user 1");

				uip(u1,arr);
				flg=chk(arr,u1);
					if(flg==1){
						System.out.println("User 1 wins");
						prar(arr);
						break;
					}
					if(flg==-1){
						System.out.println("Draw");
						break;
					}
			}
			else{
				System.out.println("Turn for user 2");
				uip(u2,arr);
				flg=chk(arr,u2);
					if(flg==1){
						System.out.println("User 2 wins");
						prar(arr);
						break;
					}
					if(flg==-1){
						System.out.println("Draw");
						break;
					}
			}
			prar(arr);
		}
	} 

	static int chk(char ck[][],char id){
		int flag=0;
		
	//main diag
		for (int l1 = 0; l1 < 3; l1++) { 
            for (int l2 = 0; l2 < 3; l2++) { 
                if (l1 == l2) { 
                    if(ck[l1][l2]==id) {
						flag++;
					}
				}
			} 
           
		}
		if(flag==3){
			return 1;
		}
		else flag=0;

	//rev diag
		for (int l1 = 0; l1 < 3; l1++) { 
            for (int l2 = 0; l2 < 3; l2++) { 
                if ((l1 + l2) == (3 - 1)) { 
                    if(ck[l1][l2]==id) {
						flag++;
					}
				}
			} 
           
		}
		if(flag==3){
			return 1;
		}
		else flag=0;

	//c1
		for (int l1 = 0; l1 < 3; l1++) { 
                    if(ck[l1][0]==id) {
						flag++;
				} 
		}
		if(flag==3){
			return 1;
		}
		else flag=0;
	
	//c2
		for (int l1 = 0; l1 < 3; l1++) { 
                    if(ck[l1][1]==id) {
						flag++;
				} 
		}
		if(flag==3){
			return 1;
		}
		else flag=0;

	//c3
		for (int l1 = 0; l1 < 3; l1++) { 
			if(ck[l1][2]==id) {
				flag++;
			} 
		}
		if(flag==3){
		return 1;
		}
		else flag=0;

	//r1
		for (int l1 = 0; l1 < 3; l1++) { 
			if(ck[0][l1]==id) {
				flag++;
			} 
		}
		if(flag==3){
		return 1;
		}
		else flag=0;
		
	//r2
		for (int l1 = 0; l1 < 3; l1++) { 
			if(ck[1][l1]==id) {
				flag++;
			} 
		}
		if(flag==3){
		return 1;
		}
		else flag=0;
		
	//r3
		for (int l1 = 0; l1 < 3; l1++) { 
			if(ck[2][l1]==id) {
				flag++;
			} 
		}
		if(flag==3){
		return 1;
		}
		else return 0;
	}

	static void prar(char arr[][]){
		for (int j = 0; j < 3; j++) { 
			System.out.println();
			for (int k = 0; k < 3; k++) { 
				System.out.print(arr[j][k] + "  "); 
			} 
			System.out.println(); 
		}
	}

	static void uip(char u,char arr[][]){
		Scanner s=new Scanner(System.in);
		int a,b;
		a=s.nextInt();
		b=s.nextInt();
		arr[a][b]=u;
	}
} 
