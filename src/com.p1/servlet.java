package com.p1;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet") 
public class servlet extends HttpServlet{
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
	
	/*
	String stramount = request.getParameter("amount");
	float amount = Float.parseFloat(stramount);
	String currency = request.getParameter("currency");
	String convertto = request.getParameter("convertto");
	String ip = request.getRemoteAddr();
	float result = 0;


        String q1 = "select dollarvalue from " + currency + ";";
	Vector <String> v1 = AccessMySQL.Execute(q1);
	q1 = v1.get(0);
        float USVALUE = amount / ( Float.parseFloat(q1));
	
        String q2 = "select dollarvalue from " + convertto + ";";
	Vector <String> v2 = AccessMySQL.Execute(q2);
	q2 = v2.get(0);
	float RESULT = Float.parseFloat(q2) * USVALUE;
	*/
	String spoof = request.getParameter("username");
	String spoof2 = request.getParameter("email");
	response.getWriter().println("<html>");
	response.getWriter().println("<head>");
	response.getWriter().println("<title>Title</title>");
	response.getWriter().println("</head>");
	response.getWriter().println("<body>");
	response.getWriter().println("The converted amount is ");
	//response.getWriter().print(RESULT);
	//response.getWriter().print(convertto);
	response.getWriter().println(5);
	response.getWriter().println("</body>");
	response.getWriter().println("</html>");
}


}