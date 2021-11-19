
public class CircularToH {
	static void CTH(int n, char from_rod, char to_rod, char other_rod)
	{
		if (n == 1){
			System.out.println("Move disk 1 from rod "+from_rod+" to rod "+to_rod);
			return;
		}
		CTH(n - 1, from_rod, to_rod, other_rod);
		CTH(n - 1, to_rod, other_rod, from_rod);
		System.out.println("Move disk "+ n + " from rod " + from_rod +" to rod " + to_rod );
		CTH(n - 1, other_rod, from_rod, to_rod);
		CTH(n - 1, from_rod, to_rod, other_rod);
	}

//Driver code
public static void  main(String args[])
	{
	int n = 3; // Number of disks
	CTH(n, 'A', 'B', 'C'); // A, B and C are names of rods
	}
}
