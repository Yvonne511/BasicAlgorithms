
// Sorting III

import java.util.Arrays;

public class AllSortingMethod {
	
	//Bubble Sort Non-Recursive
	public static void bubblenon(int[] a, int n) {
		if (n <= 0)
			return;
		else {
			for (int i = 0; i<n; i++) {
				for (int j = 0; j<n-1; j++) {
					if (a[j]>a[j+1]) {
						int temp = a[j];
						a[j] = a[j+1];
						a[j+1] = temp;
					}
				}
			}
		}
	}
	
	//Bubble Sort Recursive
	public static void bubble(int[] a, int n) {
		if (n <= 0)
			return;
		else {
			for (int i = 0; i<n-1; i++) {
				if (a[i]>a[i+1]) {
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
			bubble(a, n-1);
		}
	}
	
	//Selection Sort (Non-recursive)
	public static void selection(int[] a, int n) {
		for (int i = 0; i<n; i++) {
			
			//Identify the smallest value and its index
			int[] min = {Integer.MAX_VALUE, 0};
			for (int j = i; j< n; j++ ) {
				if(a[j]<min[0]) {
					min[0] = a[j]; min[1] = j;
				}
			}
			//Swap
			int temp = a[i];
			a[i] = min[0];
			a[min[1]] = temp;
		}
	}

	//Insertion Sort (Non-recursive) 
	public static void insertion(int[] a, int n) {
		for (int i = 0; i<n; i++) {
			int position = i;
			for (int j = i-1; j>=0; j--) {
				if (a[j]>a[i]) position--;
			}
			int temp = a[i];
			for (int k = i; k>position; k--) {
				System.out.println(Arrays.toString(a));
				a[k] = a[k-1];
			}
			a[position] = temp;
		}
	}
	
	//Merge Sort (Recursive)
	//This method will merge two sorted arrays
	public static void merge(int[] a, int start, int mid, int end) {
		//System.out.println(Arrays.toString(a));
		int length1 = mid-start+1;
		int[] left = new int[length1];
		int length2 = end-mid;
		int[] right = new int[length2];
		
		for (int i = 0; i< length1; i++) {
			left[i] = a[i+start];
		}
		for (int j = 0; j< length2; j++) {
			right[j] = a[j+mid+1];
		}
		
		int l = 0;
		int r = 0;
		int k = start;
		while (l<length1 && r<length2) {
			if (left[l]<=right[r]) {
				a[k] = left[l];
				l++; k++;
			} else {
				a[k] = right[r];
				r++; k++;
			}
		}
		
		while (l<length1) {
			a[k] = left[l];
			l++; k++;
		}
		while (r<length2) {
			a[k] = right[r];
			r++; k++;
		}
	}
	
	public static void mergeSort(int[] a, int start, int end) {
		if (start<end) {
			int mid = (start + end)/2;
			//This will divide arrays into individual value that is sorted since there is only one number to consider
			mergeSort(a, start, mid);
			mergeSort(a, mid+1, end);
			merge(a, start, mid, end);
		}
	}
	
	//Quick Sort (Recursive) 
	//This method will put smaller value in front of the target value and put target value after all the small values
	public static int quick(int[] a, int begin, int end) {
		System.out.println(Arrays.toString(a));
		int reference = a[end];
		for (int i = begin; i< end; i++) {
			if (a[i] < reference) { 
				int temp = a[begin];
				a[begin] = a[i];
				a[i] = temp;
				System.out.println(Arrays.toString(a));
				begin++;
			}
		}
		int temp = a[begin];
        a[begin] = reference;
        a[end] = temp;
        System.out.println(Arrays.toString(a));
        return begin;
	}
	
	public static void quickSort(int[] a, int begin, int end) {
		int reference = quick(a, begin, end);
		if (reference-1>begin) quickSort(a, begin, reference-1);
		if (reference+1<end) quickSort(a, reference+1, end);
	}

	public static void main(String[] args) {
		int[] a = {82, 16, 95, 89, 87, 78, 12, 88};
		//int[] a = {88, 12, 78, 87, 89, 95, 16, 82};
		//bubblenon(a, a.length);
		//bubble(a, a.length);
		//selection(a, a.length);
		//insertion(a, a.length);
		//mergeSort(a, 0, a.length-1);
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));

	}

}
