

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class menu
 */
@WebServlet("/menu")
public class menu extends HttpServlet {
	Connection con=null;
    PreparedStatement ps=null;
	ResultSet rs=null;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menu() {
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
		String s=request.getParameter("rest");
		out.println(s);
		String reginsert2 = "select itemname,price "
				+" from tpj_mnu mn, tpj_fod fd "
				+" where (LTRIM(mn.restid) = ? or RTRIM(mn.restid)= ?)"
				+ " and fd.itemcode = mn.itemcode";
		try
		{
			StringBuffer data=null;
			con.setAutoCommit(false); 
			
			ps = con.prepareStatement(reginsert2);
			ps.setString(1,s);
			ps.setString(2,s);
			rs=ps.executeQuery();
			String str="<table><tr><th>menu</th><th>price</th></tr>";
			out.print(str);
			while(rs.next())
			{
				String str1=("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td></tr>");
				out.print(str1);	
			}
			
			
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}
	}



