package TicTacToeGame;
import java.util.Arrays;

import Game.GridBoard;
public class TicTacToeBoard extends GridBoard{
	
	private int grid[][];
	
	public TicTacToeBoard(int total_columns,int total_rows)
	{
		SetTotalRows(total_rows);
		SetTotalColumns(total_columns);
		grid = new int[total_rows][total_columns];
		for (int[] row : grid)
		    Arrays.fill(row, -1);
	}
	public int GetValueAtPos(int row_no,int column_no)
	{
		return grid[row_no][column_no];
	}
	public Boolean IsPositionEmpty(int row_no,int column_no)
	{	
		if(row_no<total_rows && column_no<total_columns)
			if(grid[row_no][column_no]==-1)
				return true;
		return false;
	}
	public void FillPosition(int row_no,int column_no,int value)
	{
		if(IsPositionEmpty(row_no,column_no))
			grid[row_no][column_no]=value;
	}
	@Override
	public void Display() {
		// TODO Auto-generated method stub
		int i,j,k;
		System.out.println("\n ---column--->");
		System.out.print("\nR ");
		for(i=0;i<total_columns;i++)
			System.out.print("  "+i);
		for(i=0;i<total_rows;i++)
		{
			
			if(i>0)
			{
				System.out.print("\n   ");
				for(k=0;k<total_columns;k++)
					System.out.print("---");
				System.out.print("\n");
			}
			System.out.print("\n  "+i);
			for(j=0;j<total_columns;j++)
			{
				if(j>0)
					System.out.print(" |");
				if(grid[i][j]!=-1)
					System.out.print(grid[i][j]);
				else
					System.out.print(" ");
			}
		}
		System.out.print("\n");
		
	}

}
