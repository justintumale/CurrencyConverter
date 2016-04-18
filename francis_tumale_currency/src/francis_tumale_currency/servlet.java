package francis_tumale_currency;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;


public class servlet extends HttpServlet{
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{

		try{
			String url = "jdbc:mysql://localhost:3306/currency";
			String user = "demo";
			String password = "demo";
			Connection myConn = DriverManager.getConnection(url, user, password);
			Statement myStmt = myConn.createStatement();

			PrintWriter out;
			response.setContentType("text/html");
			out = response.getWriter();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Title</title>");
			out.println("</head>");
			out.println("<body>");

			String stramount = request.getParameter("amount");
			double amount = Double.parseDouble(stramount);

			String currency = request.getParameter("currency");
			String convertto = request.getParameter("convertto");

			ResultSet myRs = myStmt.executeQuery("SELECT dollarValue FROM currency WHERE currname = '" + currency +"' ;");
			myRs.next();
			double temp = myRs.getDouble("dollarValue");
			double usValue = amount / temp;

			ResultSet myRs2 = myStmt.executeQuery("SELECT dollarValue FROM currency WHERE currname = '" + convertto +"' ;");
			myRs2.next();
			temp = myRs2.getDouble("dollarValue");
			double convertedValue = usValue * temp;

			out.println("Converted value: " + convertedValue);


			/*
			out.println("<p> amount: " + amount + "</p>");

			out.println("<p> currency: " + currency + ": </p>" );
			myRs.next();
			out.println("<p> result: " + myRs.getString("dollarValue") + "</p>");

			out.println("<p> convert to: " + convertto + "</p>");

			out.println("</body>");
			out.println("</html>");
			*/

			/*
			while (myRs.next()){
				out.println(myRs.getString("id") + ", " + myRs.getString("currsymbol") + ", " + myRs.getString("currname") + ", " +
					myRs.getString("dollarValue"));
			}
			*/
			myStmt.close();
			myConn.close();


		}

		catch(Exception exc){
			exc.printStackTrace();
		}
		
		//toAdd
		/*
		String stramount = request.getParameter("amount");
		float amount = Float.parseFloat(stramount);
		String currency = request.getParameter("currency");
		String convertto = request.getParameter("convertto");
		String ip = request.getRemoteAddr();
		float result = 0;
		*/

		/*
	    String q1 = "select dollarvalue from " + currency + ";";
		Vector <String> v1 = AccessMySQL.Execute(q1);
		q1 = v1.get(0);
	    float USVALUE = amount / ( Float.parseFloat(q1));
		
	    String q2 = "select dollarvalue from " + convertto + ";";
		Vector <String> v2 = AccessMySQL.Execute(q2);
		q2 = v2.get(0);
		float RESULT = Float.parseFloat(q2) * USVALUE;
		*/

		

		/*
		PrintWriter out;
		response.setContentType("text/html");
		out = response.getWriter();


		//String spoof = request.getParameter("username");
		//String spoof2 = request.getParameter("email");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Title</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("The converted amount is ");

		//out.print(RESULT);

		//out.println(convertto);
		out.println("</body>");
		out.println("</html>");
		*/
}


}