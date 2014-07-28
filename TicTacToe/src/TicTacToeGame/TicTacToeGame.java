package TicTacToeGame;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Math.min;
import Game.Game;

public class TicTacToeGame implements Game{
	private int min_winning_length;
	TicTacToePlayer[] players;
	private int turn_count;
	TicTacToeBoard board;
	int[] position = new int[2];
	public TicTacToeGame()
	{
		int total_columns,total_rows,number_of_players,i;
		String player_name;
		System.out.println("Enter total number of columns : ");
		total_columns=GetSize();
		System.out.println("Enter total number of rows : ");
		total_rows=GetSize();
		board = new TicTacToeBoard(total_columns,total_rows);
		System.out.println("Enter minimum winnig length : ");
		min_winning_length=GetWinningLength(board.GetTotalColumns(),board.GetTotalRows());
		System.out.println("Enter number of players : ");
		number_of_players=GetNumberOfPlayers(board.GetTotalColumns(),board.GetTotalRows());
		players = new TicTacToePlayer[number_of_players];
		i=0;
		while(i<number_of_players)
		{
			System.out.println("Enter player "+(i+1)+" name : ");
			player_name=GetStringInput();
			players[i] = new TicTacToePlayer(player_name,i);
			i++;
		}
		turn_count=0;
	}
	private int GetNumberOfPlayers(int total_columns,int total_rows)
	{
		int number_of_players=-1;
		while(true)
		{	
			number_of_players=GetIntegerInput();
			if(number_of_players>=2&&((total_rows*total_columns)/(number_of_players))>=min_winning_length)
				break;	
			System.out.println("Incorrect number of players. Enter again : ");
		}
		return number_of_players;
	}
	private int GetWinningLength(int total_columns,int total_rows)
	{
		int length=-1;
		while(true)
		{	
			length=GetIntegerInput();
			if((length<=min(total_rows,total_columns)) && length>=3)
				break;	
			System.out.println("Incorrect winning length. Enter again : ");
		}
		return length;
	}
	@SuppressWarnings("finally")
	private String GetStringInput()
	{
		String input_value="";
		try
		{
			
			BufferedReader input  = new BufferedReader (new InputStreamReader(System.in));
			input_value=input.readLine();
		}
		catch(Exception e)
		{
			System.err.println(e);
			System.out.println("Enter again : ");
			input_value=GetStringInput();
		}
		finally
		{
			return input_value;
		}
	}
	@SuppressWarnings("finally")
	private int GetIntegerInput()
	{
		int input_value=-1;
		try
		{
			BufferedReader input  = new BufferedReader (new InputStreamReader(System.in));
			input_value=Integer.parseInt(input.readLine());
		}
		catch(Exception e)
		{
			System.err.println(e);
			System.out.println("Enter again : ");
			input_value=GetIntegerInput();
		}
		finally
		{
			return input_value;
		}
	}
	private int GetSize()
	{
		int size=-1;
		while(true)
		{	
			size=GetIntegerInput();
			if(size>=3)
				break;	
			System.out.println("Size is too small enter again : ");
		}
		return size;
	}
	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
		game.StartPlay();
	}
	private Boolean CheckHorizontal(int cur_row_no,int cur_column_no,int cur_player_id)
	{
		int similar_count=1,temp_row_no,temp_column_no;
		temp_column_no=cur_column_no-1;
		temp_row_no=cur_row_no;
		while(temp_column_no>=0)
		{
			if(cur_player_id!=board.GetValueAtPos(temp_row_no, temp_column_no))
				break;
			similar_count++;
			temp_column_no--;
		}
		temp_column_no=cur_column_no+1;
		while(temp_column_no<board.GetTotalColumns())
		{
			if(cur_player_id!= board.GetValueAtPos(temp_row_no, temp_column_no))
				break;
			similar_count++;
			temp_column_no++;
		}
		if(similar_count >= min_winning_length)
			return true;
		return false;
	}
	private Boolean CheckVertical(int cur_row_no,int cur_column_no,int cur_player_id)
	{	
		int similar_count=1,temp_row_no,temp_column_no;
		temp_column_no=cur_column_no;
		temp_row_no=cur_row_no-1;
		while(temp_row_no>=0)
		{
			if(cur_player_id!=board.GetValueAtPos(temp_row_no, temp_column_no))
				break;
			similar_count++;
			temp_row_no--;
		}
		cur_row_no=cur_row_no+1;
		while(temp_row_no<board.GetTotalColumns())
		{
			if(cur_player_id!=board.GetValueAtPos(temp_row_no, temp_column_no))
				break;
			similar_count++;
			temp_row_no++;
		}
		if(similar_count >= min_winning_length)
			return true;
		return false;
	}
	private Boolean CheckMainDiagonal(int cur_row_no,int cur_column_no,int cur_player_id)
	{
		int similar_count=1,temp_row_no,temp_column_no;
		temp_column_no=cur_column_no-1;
		temp_row_no=cur_row_no-1;
		while(temp_column_no>=0 && temp_row_no>=0)
		{
			if(cur_player_id!=board.GetValueAtPos(temp_row_no, temp_column_no))
				break;
			similar_count++;
			temp_column_no--;
			temp_row_no--;
		}
		temp_column_no=cur_column_no+1;
		temp_row_no=cur_row_no+1;
		while(temp_column_no<board.GetTotalColumns() && temp_row_no<board.GetTotalRows())
		{
			if(cur_player_id!=board.GetValueAtPos(temp_row_no, temp_column_no))
				break;
			similar_count++;
			temp_column_no++;
			temp_row_no++;
		}
		if(similar_count >= min_winning_length)
			return true;
		return false;
	}
	private Boolean CheckOtherDiagonal(int cur_row_no,int cur_column_no,int cur_player_id)
	{
		int similar_count=1,temp_row_no,temp_column_no;
		temp_column_no=cur_column_no+1;
		temp_row_no=cur_row_no-1;
		while(temp_column_no<board.GetTotalColumns() && temp_row_no>=0)
		{
			if(cur_player_id!=board.GetValueAtPos(temp_row_no, temp_column_no))
				break;
			similar_count++;
			temp_column_no++;
			temp_row_no--;
		}
		temp_column_no=cur_column_no-11;
		temp_row_no=cur_row_no+1;
		while(temp_column_no>=0 && temp_row_no<board.GetTotalColumns())
		{
			if(cur_player_id!=board.GetValueAtPos(temp_row_no, temp_column_no))
				break;
			similar_count++;
			temp_column_no--;
			temp_row_no++;
		}
		if(similar_count >= min_winning_length)
			return true;
		return false;
	}
	
	@Override
	public Boolean CheckWin() {
		// TODO Auto-generated method stub
		int cur_player_id = GetPlayingPlayer().GetPlayerId();
		int cur_row_no=position[0];
		int cur_column_no=position[1];
		if(turn_count<(min_winning_length*players.length-players.length-1))
			return false;
		if(CheckHorizontal(cur_row_no,cur_column_no,cur_player_id))
			return true;
		if(CheckVertical(cur_row_no,cur_column_no,cur_player_id))
			return true;
		if(CheckMainDiagonal(cur_row_no,cur_column_no,cur_player_id))
			return true;
		if(CheckOtherDiagonal(cur_row_no,cur_column_no,cur_player_id))
			return true;
		return false;
	}
	public Boolean CheckDraw() {
		// TODO Auto-generated method stub
		return turn_count>=(board.GetTotalColumns()*board.GetTotalRows());
	}
	public TicTacToePlayer GetPlayingPlayer()
	{
		int player_index;
		player_index=turn_count%players.length;
		return players[player_index];
	}
	@Override
	public void StartPlay() {
		// TODO Auto-generated method stub
		Boolean correct_position=false;
		TicTacToePlayer playing_player;
		do
		{
			correct_position=false;
			board.Display();
			playing_player=GetPlayingPlayer();
			while(!correct_position)
			{
				position=playing_player.Play();
				if(board.IsPositionEmpty(position[0], position[1]))
				{
					board.FillPosition(position[0], position[1], playing_player.GetPlayerId());
					correct_position=true;
				}
				else
					System.out.println("You entered wrong position. Please enter Again.");
			}
			if(CheckWin())
			{
				System.out.println(playing_player.GetPlayerName() + " Won!");
				break;
			}
			turn_count++;
			if(CheckDraw())
			{
				System.out.println("Game Draw!");
				break;
			}
		}while(true);
	}
}
