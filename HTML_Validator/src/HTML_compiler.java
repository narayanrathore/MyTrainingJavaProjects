import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;


public class HTML_compiler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader file_reader=null;
		Connection conn;
		Statement st;
		ResultSet rs;
		Stack_String stack=new Stack_String(20);
		int index_of_parent,error_count=0;
		String parent_name;
		String top_value_of_stack;
		String tag_name="";
		conn=ODBCconn.createConnection();
		Boolean is_closing_tag,is_self_closing;
		try
		{
			st= conn.createStatement();
			int ascii_code;
			
			char cur_char_of_file,prev_char;
			BufferedReader input  = new BufferedReader (new InputStreamReader(System.in));
			String file_name = input.readLine();
			System.out.println(file_name);
			file_reader  = new BufferedReader (new FileReader(file_name));
			
			while((ascii_code=file_reader.read())!=-1)
			{
				cur_char_of_file=(char)ascii_code;
				if(cur_char_of_file=='<')
				{
					//start reading tag name
					tag_name="";
					is_closing_tag=false;
					is_self_closing=false;
					cur_char_of_file=(char)file_reader.read();
					if(cur_char_of_file=='/')
					{
						is_closing_tag=true;
					}
					else
					{
						tag_name+=cur_char_of_file;
					}
					cur_char_of_file=(char)file_reader.read();
					while(cur_char_of_file!=' ' && cur_char_of_file!='>' && cur_char_of_file!='/')
					{
						tag_name+=cur_char_of_file;
						cur_char_of_file=(char)file_reader.read();
					}
					if(cur_char_of_file!='>')
					{
						if(cur_char_of_file=='/')
						{
							is_self_closing=true;
						}
						else
						{
							prev_char=' ';
							while((cur_char_of_file=(char)file_reader.read())!='>')
							{
								prev_char=cur_char_of_file;
							}
							if(prev_char=='/')
							{
								is_self_closing=true;
							}
						}
					}
					//System.out.println(tag_name);
					rs=st.executeQuery("Select tag_name,parent_name,is_self_closing,can_ignore from HTML_tag_info where tag_name='"+tag_name+"'");
					if(rs.next())
					{
						parent_name=rs.getString("parent_name");
						if(!rs.getBoolean("can_ignore"))
						{
							if((parent_name!=null) && (!(is_closing_tag)))
							{
								index_of_parent=stack.get_top_index();
								while((stack.get_value_by_index(index_of_parent)).equals("div"))
								{
									index_of_parent--;
								}
								if(!parent_name.equals(stack.get_value_by_index(index_of_parent)))
								{
									error_count++;
									System.out.println(error_count +". \""+tag_name +"\""+ " tag is not a child of proper parent.");
									
								}
							}
							if(is_closing_tag)
							{
								top_value_of_stack=stack.pop();
								if(!(top_value_of_stack.equals(tag_name)))
								{
									error_count++;
									System.out.println(error_count +". Opening tag missing for "+"\""+tag_name +"\""+ " tag");
									stack.push(top_value_of_stack);
									
								}
								//System.out.println(" is a closing tag");
							}
							else if(is_self_closing)
							{
								if(!(rs.getBoolean("is_self_closing")))
								{
									error_count++;
									System.out.println(error_count +". you can not self close "+"\""+tag_name +"\""+" tag.");
									
								}
							//System.out.println(" is a self closing tag");
							}
							else
							{
								stack.push(tag_name);
							
							}
						}
					}
					else
					{	
						error_count++;
						System.out.println(error_count +". \""+tag_name +"\""+ " is not a tag or if it is a tag you must include it in your database");
					}
				}
			}
		}
		catch(IOException exception)
		{
			System.out.println("Unable to read");
			System.out.println(exception.getMessage());
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		finally
		{
			try
			{
				while(!stack.is_empty())
				{
					error_count++;
					tag_name=stack.pop();
					System.out.println(error_count +". \""+tag_name+"\" closing tag is missing");
				}
				System.out.println("Total Errors : "+error_count);
				file_reader.close();
			}
			catch(Exception e)
			{
				System.out.println("Unable to close");
			}
		}
	}

}
