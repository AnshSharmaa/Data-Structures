import java.util.*;
public class ttt { 
	static char[][] arr = { { '&', '&', '&' }, { '&', '&', '&'}, { '&', '&', '&'}}; 
	static int i;
	static int flg=0;
	static int a,b;
	static int bt=0;
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) 
	{ 	
		int fin=0;
		System.out.println("1-Player vs Player\n2-Player vs Bot");
		int choice=s.nextInt();
		if(choice==1){
			fin=pvp();
		}
		else {
			fin=pvb();
		}

		if(fin==-1){
			System.out.println("Draw");
		}
	} 

	static int pvp(){
		char u1='X';
		char u2='0';
		System.out.println("User 1 is 'X' and User 2 is '0'");
		System.out.println("Input address of element to take turn i.e 0 0 will be the top left corner");
		for(i=0;i<9;i++){	
			if(i%2==0){
				System.out.println("Turn for user 1");

				uip(u1);
				flg=chk(arr,u1);
					if(flg==1){
						System.out.println("User 1 wins");
						prar(arr);
						return 1;
					}
			}
			else{
				System.out.println("Turn for user 2");
				uip(u2);
				flg=chk(arr,u2);
					if(flg==1){
						System.out.println("User 2 wins");
						prar(arr);
						return 1;
					}
			}
			prar(arr);
		}
		return -1;
	}

	static int pvb(){
		char u1='X';
		char u2='0';
		System.out.println("User 1 is 'X' and Bot is '0'");
		System.out.println("Input address of element to take turn i.e 0 0 will be the top left corner");
		for(i=0;i<9;i++){	
			if(i%2==0){
				System.out.println("Turn for user 1");

				uip(u1);
				flg=chk(arr,u1);
					if(flg==1){
						System.out.println("User 1 wins");
						prar(arr);
						return 1;
					}
			}
			else{
				System.out.println("Turn for Bot");
				bot();
				flg=chk(arr,u2);
					if(flg==1){
						System.out.println("Bot wins");
						prar(arr);
						return 1;
					}
			}
			prar(arr);
		}
		return -1;
	}
	static void bot(){
		bt=1;
		a=(int)(Math.random() * 3);
		b=(int)(Math.random() * 3);
		if(checkBlank(a,b,bt)){
		arr[a][b]='0';
		bt=0;
		}
		else{
			bot();
		}
	}

	static boolean checkBlank(int a, int b,int bt) {
        if (arr[a][b]!='X'&&arr[a][b]!='0'){
            return true;
        } else {
			if(bt==0){
			System.out.println("Space already taken, try again.");
			return false;
			}
			else return false;
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

	static void uip(char u){
		a=s.nextInt();
		b=s.nextInt();
		if(checkBlank(a,b,bt)){
			arr[a][b]=u;
			}
			else{
				uip(u);
			}
	}
} 
