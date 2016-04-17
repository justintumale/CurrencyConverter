package com.p1;
import java.sql.*;
import java.util.*;

class AccessMySQL {

    public static Vector Execute(String query) {

	Vector<String> result = new Vector<String>();
	String resline = null;

	try {

	    Class.forName("com.mysql.jdbc.Driver").newInstance();

	    String url = "jdbc:mysql://localhost:3306/demo";
	    // Connection con = DriverManager.getConnection(url, "db-user-name", "db-user-password");
	    Connection con = DriverManager.getConnection(url, "demo", "demo");
	    Statement s = con.createStatement();

	    if( s.execute(query) ) {

               ResultSet r = s.getResultSet();
               ResultSetMetaData meta = r.getMetaData();
               int cols = meta.getColumnCount();
               int rownum = 0;

               while( r.next() ) {

                   rownum++;

		   resline = "";

                   for( int i=0; i < cols; i++ )

		       resline += r.getObject( i+1 ) + "\t";

		   result.addElement( resline );

               }

	       return result;
           }
           else {

               result.addElement( s.getUpdateCount() + " rows affected." );

           }

           s.close();
           con.close();

      }
      catch( Exception e ) {

	  result.addElement( e.toString() );

      }
      return result;
  }

}
    
