

/************************************************************************************
 * Database connectivity
 * 
 * @author Anant Tripathi
 * @since 06-21-2018
 * @version 1.0
 *
 * @return
 */
import java.sql.*;
import com.mysql.cj.jdbc.*;


public class dbutil {
private static Connection con=null;
	
	
	public static Connection createConnection()
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:33066/termproject", "root", "Helloanant@12");			
		if(con!=null)
		{
			System.out.println("Connected");
		}
		else
		{
			System.out.println("Not Connected");
		}
		
		}
		catch(ClassNotFoundException | SQLException cse)
		{
			System.out.println(cse);
		}
		return con;
	}
	
}
