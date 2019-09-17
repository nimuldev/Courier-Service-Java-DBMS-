
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {

    
        Connection con;
    Statement st;
    Properties prop = new Properties();
    InputStream input = null;
        
    public Database()
    {
        try
        {     
          String filePath = new File("").getAbsolutePath();
          filePath="jdbc:ucanaccess://"+filePath+"\\Courier.accdb";
          con=DriverManager.getConnection(filePath);
          st=con.createStatement();
          
          System.out.println("Got it");
        } 

        catch (Exception e) 
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    public void insert(String sql)
    {
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(String sql)
    {
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(String sql)
    {
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet select(String sql)
    {
        ResultSet rs = null;
        try {
            rs=st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
   
}
