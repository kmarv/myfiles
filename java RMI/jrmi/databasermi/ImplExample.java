import java.sql.*; 
import java.util.*;  

// Implementing the remote interface 
public class ImplExample implements Hello {  
   
   // Implementing the interface method 
   public List<Student> getStudents() throws Exception {  
      List<Student> list = new ArrayList<Student>();   
    
      // JDBC driver name and database URL 
      String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
      String DB_URL = "jdbc:mysql://localhost:3306/test";  
      
      // Database credentials 
      String USER = "root"; 
      String PASS = "";  
      
      Connection conn = null; 
      Statement stmt = null;  
      
      //Register JDBC driver 
      Class.forName("com.mysql.jdbc.Driver");   
      
      //Open a connection
      System.out.println("Connecting to  database..."); 
      conn = DriverManager.getConnection(DB_URL, USER, PASS); 
      System.out.println("Connected database successfully...");  
      
      //Execute a query 
      System.out.println("Creating statement..."); 
      
      stmt = conn.createStatement();  
      String sql = "SELECT * FROM customers"; 
      ResultSet rs = stmt.executeQuery(sql);  
      
      //Extract data from result set 
      while(rs.next()) { 
         // Retrieve by column name 
         int id  = rs.getInt("ACC_NO"); 
         
         String fname = rs.getString("FIRSTNAME"); 
         String lname = rs.getString("LASTNAME"); 
         String email = rs.getString("EMAIL");

         int amount = rs.getInt("AMOUNT"); 
           
         
         // Setting the values 
         Student student = new Student(); 
         student.setAccno(id); 
         student.setFName(fname); 
         student.setLName(lname); 
         student.setAmount(amount); 
         student.setEmail(email); 
         list.add(student); 
      } 
      rs.close(); 
      return list;     
   }  
}