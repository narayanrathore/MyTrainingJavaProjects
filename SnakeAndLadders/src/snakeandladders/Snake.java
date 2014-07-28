package snakeandladders;

public class Snake {
	private int mouth_pos;
	private int tail_pos;
	public void SetMouthPos(int mouth_pos)
	{
		this.mouth_pos=mouth_pos;
	}
	public void SetTailPos(int tail_pos)
	{
		this.tail_pos=tail_pos;
	}
	public int GetMouthPos()
	{
		return mouth_pos;
	}
	public int GetTailPos()
	{
		return tail_pos;
	}

}
