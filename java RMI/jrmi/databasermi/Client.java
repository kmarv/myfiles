import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.util.*;  

public class Client {  
   private Client() {}  
   public static void main(String[] args)throws Exception {  
      try { 
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry(null); 
    
         // Looking up the registry for the remote object 
         Hello stub = (Hello) registry.lookup("Hello"); 
    
         // Calling the remote method using the obtained object 
         List<Student> list = (List)stub.getStudents(); 
         for (Student s:list) { 
            
            // System.out.println("bc "+s.getBranch()); 
            System.out.println("Accout number: " + s.getAccno()); 
            System.out.println("first name: " + s.getFName()); 
            System.out.println("last name: " + s.getLName()); 
            System.out.println("amount: " + s.getAmount()); 
            System.out.println("email: " + s.getEmail()); 
         }  
      // System.out.println(list); 
      } catch (Exception e) { 
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}