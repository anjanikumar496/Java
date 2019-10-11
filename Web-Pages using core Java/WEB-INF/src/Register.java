import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Register extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String f=request.getParameter("firstName");  
String l=request.getParameter("lastName");  
String u=request.getParameter("userId");  
String p=request.getParameter("password");
String e=request.getParameter("emailId"); 
          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/sample","root","");
PreparedStatement ps=con.prepareStatement("insert into sampletable4 values(?,?,?,?,?)");  
  
ps.setString(1,f);  
ps.setString(2,l);  
ps.setString(3,u);  
ps.setString(4,p);
ps.setString(5,e);
          
int i=ps.executeUpdate();  
if(i>0) { 
out.print("You are successfully registered...");  
      }else{ out.print("not done...");  
      }
          
}catch (SQLException e2) {System.out.println(e2);}  
          
out.close();  
}  
public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      doGet(request, response);
   }
  
}  