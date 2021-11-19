
public class DTHwH {
	
		//public static int[][] initial = {{1,0,3,0},{0,0,0,0},{0,2,0,4}};
		//public static int[][] initial = {{0,0,0,0},{1,2,3,4},{0,0,0,0}};
		public static int[][] initial = {{1,2,0,0},{0,0,3,0},{0,0,0,4}};
		//public static int[][] initial = {{1,2,3,4},{0,0,0,0},{0,0,0,0}};
		
		public static void printInitial() {
			for (int i: initial[0]) {
		    	System.out.print(i);
		    }
			System.out.print(" ");
			for (int i: initial[1]) {
		    	System.out.print(i);
		    }
			System.out.print(" ");
			for (int i: initial[2]) {
		    	System.out.print(i);
		    }
			System.out.print(" ");
			System.out.println();
		}
		
		public static Boolean IsItThere(int n, int rod) {
			Boolean have = false;
			switch(rod) {
			case 11: 
				for (int i: initial[0]) {
					if (i==n) have =true;
				}
				break;
			case 22: 
				for (int i: initial[1]) {
					if (i==n) have =true;
				}
				break;
			case 33: 
				for (int i: initial[2]) {
					if (i==n) have =true;
				}
				break;
			}
			return have;
		}
		
		static void ToH(int n, int from_rod, int to_rod, int other_rod)
		{
			if (n == 1)
			{System.out.println("Move disk 1 from rod "+from_rod+" to rod "+to_rod); 
			initial[from_rod/10-1][0] = 0;
			initial[to_rod/10-1][0] = 1;
			return;}
			ToH(n - 1, from_rod, other_rod, to_rod);
			System.out.println("Move disk "+ n + " from rod " + from_rod +" to rod " + to_rod );
			initial[from_rod/10-1][n-1] = 0;
			initial[to_rod/10-1][n-1] = n;
			ToH(n - 1, other_rod, to_rod, from_rod);
		}
		
		public static void DTH(int n, int from_rod, int to_rod, int other_rod) {
			if (n==1) {
				if (IsItThere(n, from_rod)) {
					//move 1 from A to B
					System.out.println("Move disk 1 from rod "+from_rod+" to rod "+to_rod);
					ToH(1, from_rod, to_rod, other_rod);
				}
				else if (IsItThere(n, to_rod)) {
					//do not move
					System.out.println("not move");
				}
				else {
					// move 1 from C to B
					System.out.println("Move disk 1 from rod "+other_rod+" to rod "+to_rod);
					ToH(1, other_rod, to_rod, from_rod);
				}
			}
			else {
				DTH(n-1, from_rod, to_rod, other_rod);
				if (IsItThere(n, from_rod)) {
					ToH(n-1, to_rod, other_rod, from_rod);
					System.out.println("Move disk "+ n +" from rod "+from_rod+" to rod "+to_rod);
					initial[from_rod/10-1][n-1] = 0;
					initial[to_rod/10-1][n-1] = n;
					ToH(n-1, other_rod, to_rod, from_rod);
				}
				else if (IsItThere(n, to_rod)) {
					//do not move
					System.out.println("not move");
				}
				else {
					ToH(n-1, to_rod, from_rod, other_rod);
					System.out.println("Move disk "+ n +" from rod "+other_rod+" to rod "+to_rod);
					initial[other_rod/10-1][n-1] = 0;
					initial[to_rod/10-1][n-1] = n;
					ToH(n-1, from_rod, to_rod, other_rod);
				}
			}
		}
		
		public static void main(String args[]){
	    int n = 4; // Number of disks
	    //DTH(n, 11, 22, 33); // A, B and C are names of rods
	    DTH(n, 11, 22, 33);
	    printInitial();
		}
}
