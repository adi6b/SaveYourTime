

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class restuarant
 */
@WebServlet("/restuarant")
public class restuarant extends HttpServlet {
	Connection con=null;
    PreparedStatement ps=null;
	ResultSet rs=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public restuarant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		con= dbutil.createConnection();
		PrintWriter out=response.getWriter();
		String s=request.getParameter("Search");
		//out.println(s);
		String reginsert2 = "select restid,name,address from termproject.tpj_rst where LTRIM(city)= ?";
		try
		{
			StringBuffer data=null;
			con.setAutoCommit(false); 
			
			ps = con.prepareStatement(reginsert2);
			ps.setString(1, s);
			rs=ps.executeQuery();
			String str="<table><tr><th>id</th><th>name</th><th>address</th></tr>";
			out.print(str);
			while(rs.next())
			{
			
				String str1=("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
				out.print(str1);
				
			}
			
			
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}

}
