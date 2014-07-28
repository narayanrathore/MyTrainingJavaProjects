package Game;

public abstract class GridBoard {
	protected int total_rows;
	protected int total_columns;
	public abstract void Display();
	public void SetTotalRows(int total_rows)
	{
		this.total_rows=total_rows;
	}
	public void SetTotalColumns(int total_columns)
	{
		this.total_columns=total_columns;
	}
	public int GetTotalRows()
	{
		return total_rows;
	}
	public int GetTotalColumns()
	{
		return total_columns;
	}
}
