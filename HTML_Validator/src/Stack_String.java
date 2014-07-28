
public class Stack_String {
	private String values[];
	private int top_of_stack;
	private int size_of_stack;
	public Stack_String(int size_of_stack)
	{
		this.size_of_stack=size_of_stack;
		top_of_stack=-1;
		values = new String[size_of_stack];
	}
	public String pop()
	{
		if(is_empty())
		{
			System.out.println("Stack is empty. First push some value in stack");
			return null;
		}
		return values[top_of_stack--];
	}
	public boolean is_empty()
	{
		if(top_of_stack==-1)
			return true;
		return false;
	}
	public void push(String value)
	{
		if(is_full())
		{
			expand_stack();
		}
		values[++top_of_stack]=value;
	}
	private void expand_stack()
	{
		String temp[];
		temp=values;
		values=new String[size_of_stack*2];
		System.arraycopy(temp, 0, values, 0, size_of_stack);
		temp=null;
		size_of_stack*=2;
	}
	public boolean is_full()
	{
		if(top_of_stack==size_of_stack)
		{
			return true;
		}
		return false;
	}
	public int get_top_index()
	{
		return top_of_stack;
	}
	public String get_value_by_index(int index)
	{
		return values[index];
	}
}
