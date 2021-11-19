
public class AllTop {
	
	static int a, b, c, d = 0; 
	
	static void count(int n) {
		switch (n) {
		case 1: a+=1; break;
		case 2: b+=1; break;
		case 3: c+=1; break;
		case 4: d+=1; break;
		}
			
	}
	
	static void RTH(int n, char from_rod, char to_rod, char other_rod)
	{
		if (n == 1)
		{System.out.println("Move disk 1 from rod "+from_rod+" to rod "+to_rod); return;}
		RTH(n - 1, from_rod, other_rod, to_rod);
		System.out.println("Move disk "+ n + " from rod " + from_rod +" to rod " + other_rod );
		System.out.println("Move disk "+ n + " from rod " + other_rod +" to rod " + to_rod );
		RTH(n - 1, other_rod, to_rod, from_rod);
	}

	//Driver code
	public static void  main(String args[])
	{
		int n = 4; // Number of disks
		RTH(n, 'A', 'B', 'C'); // A, B and C are names of rods
		System.out.println("1 fliped " + a);
		System.out.println("2 fliped " + b);
		System.out.println("3 fliped " + c);
		System.out.println("4 fliped " + d);
	}

}
