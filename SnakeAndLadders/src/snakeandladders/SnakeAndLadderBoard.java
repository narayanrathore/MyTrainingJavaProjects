package snakeandladders;
import java.util.*;
import Game.GridBoard;
public class SnakeAndLadderBoard extends GridBoard{
	int grid[][];
	private Snake snakes[];
	private Ladder ladders[];
	public SnakeAndLadderBoard (int total_rows,int total_columns)
	{
		SetTotalRows(total_rows);
		SetTotalColumns(total_columns);
		grid = new int[total_rows][total_columns];
		CreateSnakesAndLadders(10,10);
		for (int[] row : grid)
		    Arrays.fill(row, -1);
	}
	
	private void CreateSnakesAndLadders(int ladder_count,int snake_count)
	{
		int random_number,i;
		snakes = new Snake[snake_count];
		ladders = new Ladder[ladder_count];
		i=0;
		while(i<snake_count)
		{
			random_number=GenerateRandomNumber(1,100);
		}
	}
	
	private int GenerateRandomNumber(int from,int to)
	{
		Random random_number = new Random();
		int number;
		int range=to-from +1;
		number=random_number.nextInt()%range;
		number=from+number;
		return number;
	}
	
	@Override
	public void Display() {
		// TODO Auto-generated method stub
		
	}
	
}
