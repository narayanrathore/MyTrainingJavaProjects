package snakeandladders;

public class Ladder {
	private int start_pos;
	private int end_pos;
	public void SetStartPos(int start_pos)
	{
		this.start_pos=start_pos;
	}
	public void SetEndPos(int end_pos)
	{
		this.end_pos=end_pos;
	}
	public int GetStartPos()
	{
		return start_pos;
	}
	public int GetEndPos()
	{
		return end_pos;
	}
}
