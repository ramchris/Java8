package com.company.arrays;

public class TwoDimensionalArrayOperations
{

	public static int[][] reshape(int[][] matrix, int newRow, int newColumn)
	{
		int rows = 0, columns=0;
		if( matrix != null)
		{
			rows = matrix.length;
			columns = matrix[0].length;
		}

		if ( rows*columns != newRow*newColumn)
			throw new RuntimeException("number of rows and columns won't match for new matrix");
		int[][] newArray= new int[newRow][newColumn];

		for (int i=0;i<newRow;i++)
		{

		}
		return matrix;
	}

	public static void main(String[] args)
	{
		int[][] matrix = new int[][] {{1,2}, {3,4}};
		System.out.println("[");
		for(int i = 0; i<matrix.length;i++)
		{
			for(int j = 0; j<matrix.length;j++)
			{
				if(j == 0) System.out.print("[");
				System.out.print(matrix[i][j]);
				if(j == matrix.length-1) System.out.print("]");
				else System.out.print(",");
			}
			System.out.println(",");
		}
		System.out.println("]");
		reshape(matrix,4,1);
	}
}
