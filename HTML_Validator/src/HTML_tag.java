
public class HTML_tag {
	private String tag_name;
	private String parent_name;
	private Boolean is_selfclosing;
	private Boolean can_ignore;
	HTML_tag(String tag_name,String parent_name,Boolean is_selfclosing,Boolean can_ignore)
	{
		set_properties(tag_name,parent_name,is_selfclosing,can_ignore);
	}
	HTML_tag(String tag_name)
	{
		set_properties(tag_name,"",false,false);
	}
	HTML_tag(String tag_name,String parent_name)
	{
		set_properties(tag_name,parent_name,false,false);
	}
	HTML_tag(String tag_name,String parent_name,Boolean is_selfclosing)
	{
		set_properties(tag_name,parent_name,is_selfclosing,false);
	}
	private void set_properties(String tag_name,String parent_name,Boolean is_selfclosing,Boolean can_ignore)
	{
		this.tag_name=tag_name;
		this.parent_name=parent_name;
		this.is_selfclosing=is_selfclosing;
		this.can_ignore=can_ignore;
	}
	public String get_tag_name()
	{
		return tag_name;
	}
	public String get_parent_name()
	{
		return parent_name;
	}
	public Boolean is_selfclosing()
	{
		return is_selfclosing;
	}
	public Boolean can_ignore()
	{
		return can_ignore;
	}
	
}
