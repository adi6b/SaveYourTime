

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {

Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
Statement stmt = null;

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
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
		doGet(request, response);
		//response.sendRedirect("/Term_project/jsp/billing.jsp");
		con= dbutil.createConnection();

		PrintWriter out=response.getWriter();
		out.print(con);
		String st="";
		Random rand = new Random();
		int customerid=rand.nextInt(100000);
		String name=request.getParameter("name");
		String contact_no=request.getParameter("contact_no");
		String age=request.getParameter("age");
		String datetimepicker=request.getParameter("datetimepicker");
		String gender=request.getParameter("gender");
		//String city=request.getParameter("city");
		//String []hb=request.getParameterValues("hobbies");
		/*for(int i=0;i<hb.length;i++)
		{
			st=st+hb[i]+",";
		}*/
		
		
			
	//	String logininsert="insert into logindetails values(?,?,?)";
		String reginsert2 = "insert into tpj_cst(customerId,name,dob,age,gender,mobnumber)values(?,?,?,?,?,?)";
		try
		{
			con.setAutoCommit(false); 
		/*	ps=(PreparedStatement) con.prepareStatement(logininsert);
			ps.setString(1,rb.getUserid());
			ps.setString(2,rb.getUserpass());
			ps.setString(3,"user");
			System.out.println(pslogin);
			int rw=ps.executeUpdate();
		    */
			
			ps =con.prepareStatement(reginsert2);
		    ps.setLong(1,customerid);
		    ps.setString(2,name);
		    ps.setString(3,datetimepicker);
		    ps.setString(4,age);
		    ps.setString(5,gender);
		    ps.setString(6,contact_no);
		   // ps.setString(7,rb.getCity());
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
