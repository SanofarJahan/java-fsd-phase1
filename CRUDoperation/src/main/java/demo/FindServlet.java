package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
@WebServlet("/find")
public class FindServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out= resp.getWriter();
		resp.setContentType("text/html");
		
		String param=req.getParameter("id");
		int id= Integer.parseInt(param);
		
Properties  props= new Properties();
		
		InputStream in=getServletContext().getResourceAsStream("/WEB-INF/application.properties");
		props.load(in);
		
		
		Connection conn= DBConfig.getConnection(props);
		
		
		if(conn!=null) {
			
			
			try {
				PreparedStatement stmt=conn.prepareStatement("select * from eproduct where id=?");
				stmt.setInt(1, id);
				
				ResultSet rs=stmt.executeQuery();
				out.print("<center><table border=1 cellpadding=10 cell spacing=0> <thead style='background-color: #D6EEEE;'><tr>");
				out.print("<th>ID</th><th>NAME</th><th>PRICE</th>");
				out.print("<tr></thead>");
				out.print("<tbody>");
				
				while(rs.next()) {
					
					out.print("<tr>");
					//out.print(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getBigDecimal(3)+" "+rs.getTimestamp(4)+"<br>");
					out.print("<td>'"+rs.getInt(1)+"'</td><td><b>'"+rs.getString(2)+"'</b></td><td>'"+rs.getBigDecimal(3)+"'</td><td>'"+rs.getTimestamp(4)+"'</td>");
					
					out.print("</tr>");
					
					//out.print("</tbody></table>");
				}
			}

catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


}
else {

out.print("Error While Connecting Connections");
}
	}


@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(req, resp);
}







				}
			

