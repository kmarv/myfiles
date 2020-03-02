public class Student implements java.io.Serializable {   
    private int id, amount;   
    private String fname, lname, email;    
   
    public int getAccno() { 
       return id; 
    } 
    public String getFName() { 
       return fname; 
    } 
    public String getLName() { 
       return lname; 
    } 
    public int getAmount() { 
       return amount; 
    } 
    public String getEmail() { 
       return email; 
    } 
    public void setAccno(int id) { 
       this.id = id; 
    } 
    public void setFName(String fname) { 
       this.fname = fname; 
    } 
    public void setLName(String lname) { 
       this.lname = lname; 
    } 
    public void setAmount(int amount) { 
       this.amount = amount; 
    } 
    public void setEmail(String email) { 
       this.email = email; 
    } 
 }