package chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class FindInPartiallySortedMatrix_4 {

	public static boolean Find(int target, int[][] array) {
		

		if (array==null || array.length==0|| array[0].length==0 || array[0][0] > target || array[array.length - 1][array[0].length - 1] < target)
			return false;
		
		if(array.length>0&&array[0].length>0)
		{
			int row = 0;
			int col = array[0].length - 1;

			while (row < array.length && col >= 0) {
				if (array[row][col] == target)
					return true;
				else if (array[row][col] > target)
					col--;
				else
					row++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		int m=sc.nextInt();
		int n=sc.nextInt();
		int[][] array=new int[m][n];
		
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				array[i][j]=sc.nextInt();
		
		sc.close();

		System.out.println(Find(target, array));
	}

}
