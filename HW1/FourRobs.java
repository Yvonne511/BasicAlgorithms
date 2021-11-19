
public class FourRobs {
	
	//public static int[][] initial = {{1,2,3,4,5,6},{0,0,0,0,0},{0,0,0,0,0},{0}};

	static void ToH(int n, char from_rod, char to_rod, char other_rod, char one_ring)
	{
		if (n == 1)
		{
			System.out.println("Move disk 1 from rod "+from_rod+" to rod "+to_rod);
			return;
		}
		else if (n == 2)
		{
			System.out.println("Move disk 1 from rod "+from_rod+" to rod "+other_rod);
			System.out.println("Move disk 2 from rod "+from_rod+" to rod "+to_rod);
			System.out.println("Move disk 1 from rod "+other_rod+" to rod "+to_rod);
			return;
		}
		
		ToH(n - 2, from_rod, other_rod, to_rod, one_ring);
		System.out.println("Move disk "+ (n-1) + " from rod " + from_rod +" to rod " + one_ring );
		System.out.println("Move disk "+ n + " from rod " + from_rod +" to rod " + to_rod );
		System.out.println("Move disk "+ (n-1) + " from rod " + one_ring +" to rod " + to_rod );
		ToH(n - 2, other_rod, to_rod, from_rod, one_ring);
	}

	//Driver code
	public static void  main(String args[])
	{
		int n = 4; // Number of disks
		ToH(n, 'A', 'B', 'C', 'D'); // A, B and C are names of rods
	}

}
