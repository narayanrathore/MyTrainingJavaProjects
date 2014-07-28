package TicTacToeGame;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import Game.Player;
public class TicTacToePlayer extends Player{
	public TicTacToePlayer(String player_name,int player_id)
	{
		this.player_name=player_name;
		this.player_id=player_id;
	}
	
	@SuppressWarnings("finally")
	public int[] Play()
	{
		int position[] = new int[2];
		position[0]=-1;
		position[1]=-1;
		try
		{
			BufferedReader input  = new BufferedReader (new InputStreamReader(System.in));
			
			System.out.println("\n"+player_name +" give your move.");
			System.out.println("Row_no: ");
			position[0]=Integer.parseInt(input.readLine());
			System.out.println("column_no: ");
			position[1]=Integer.parseInt(input.readLine());
		
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		finally
		{
			return position;
		}
	}
}
