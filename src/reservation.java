

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class reservation
 */
@WebServlet("/reservation")
public class reservation extends HttpServlet {
	Connection con=null;
    PreparedStatement ps=null;
	ResultSet rs=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservation() {
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
		String name=request.getParameter("name");
		String rest=request.getParameter("rest");
		String seat=request.getParameter("seat");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		
		String reginsert1="Select customerid from tpj_cst where LTRIM(name)= ?";
		
		String reginsert2 = "insert into tpj_rsv "
				+" (custid,restid,numberofpeople,timeofrsvtn,dateofrsvtn)"
				+" values (?,?,?,?,? )";
		
		try
		{
			//StringBuffer data=null;
			con.setAutoCommit(false);
			ps = con.prepareStatement(reginsert1);
			ps.setString(1,name);
			int id = 0;
			rs=ps.executeQuery();
			while(rs.next()){
			id=Integer.parseInt(rs.getString(1));
			}
			ps = con.prepareStatement(reginsert2);
			ps.setLong(1,id);
			ps.setString(2,rest);
			ps.setString(3,seat);
			ps.setString(4,time);
			ps.setString(5,date);
			
			//rs=ps.executeUpdate();
			System.out.println(ps);
		    int ra=ps.executeUpdate();
		    
		    
		    
			if( ra>0)
			{
				con.setAutoCommit(true);
				response.sendRedirect("/project_term/html/home.html");
			}
			
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}
	}


