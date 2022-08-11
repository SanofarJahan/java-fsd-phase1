package demo;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddProduct")

public class Main extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ProductName=req.getParameter("name");
		String Category=req.getParameter("Category");
		String Price=req.getParameter("price");
		String Quantity=req.getParameter("Quantity");
		
		
		System.out.println(ProductName);
		
		StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata= new MetadataSources(registry).getMetadataBuilder().build();

		//connection pool

		SessionFactory factory= metadata.getSessionFactoryBuilder().build();

		//let's take database connection to do transaction

		//prepare one database in mysql with name Student before executing below command

		Session session= factory.openSession();

		AddProduct s1=new AddProduct(ProductName,Category,Price,Quantity);
		session.save(s1);
		///* s1.setId(1); */

		
		Transaction tx=session.beginTransaction();

		session.save(s1);

		tx.commit();

		//automatically table created in db and data inserted in the same

		session.close();

		factory.close();

		System.out.println("Data Inserted Successfully");
		
		PrintWriter out=resp.getWriter();
		out.print("<h1> Product Data is inserted in the database successfully.<h1>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
	
	

}
