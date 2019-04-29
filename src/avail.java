

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
 * Servlet implementation class avail
 */
@WebServlet("/avail")
public class avail extends HttpServlet {
	Connection con=null;
    PreparedStatement ps=null;
	ResultSet rs=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public avail() {
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
		String s1=request.getParameter("seat");
		out.println(s);
		String reginsert2 = "select available "
				+" from tpj_rst_lot "
				+" where (LTRIM(restid) = ? or RTRIM(restid)= ?)"
				+ " and typofseat =?";
		try
		{
			StringBuffer data=null;
			con.setAutoCommit(false); 
			
			ps = con.prepareStatement(reginsert2);
			ps.setString(1,s);
			ps.setString(2,s);
			ps.setString(3,s1);
			rs=ps.executeQuery();
			String str="<table><tr><th>Seat available</th></tr>";
			out.print(str);
			while(rs.next())
			{
				//out.print("testing");
				/*String name,restid,address;
				name=rs.getString(2);
				restid=rs.getString(1);
				address=rs.getString(3);
				rest r=new rest();
				r.setRestId(restid);
				r.setRestName(name);
				r.setRestAdd(address);
				data=new StringBuffer();
				data.append(restid);
				data.append(name);
				data.append(address);*/
				String str1=("<tr><td>"+rs.getString(1)+"</td></tr>");
				out.print(str1);
				
			}
		//	request.setAttribute("data",data);
			//request.getRequestDispatcher("resturant.jsp").forward(request, response);
			
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	
	}

}
