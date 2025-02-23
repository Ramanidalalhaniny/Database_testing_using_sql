import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sql_test_cases {
	WebDriver dirver = new ChromeDriver();
	Connection con;
	ResultSet rs;
    Statement stmt;	
	
	
	@BeforeTest
    public void setup() throws SQLException {

	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","rama");
	
	}

    @Test(priority=1)
    public void add_data_to_my_database()  throws SQLException {

    String query="INSERT INTO customers (customerNumber,customerName, contactLastName, contactFirstName, phone, addressLine1, city, country) \r\n"
    		+ "VALUES (6647,'TechCorp', 'Doe', 'John', '+1-555-1234567', '123 Tech Ave', 'Silicon Valley', 'USA');\r\n";
   
    stmt=con.createStatement();
    int rowEffected = stmt.executeUpdate(query);
    System.out.println(rowEffected);
    
    
    }
    @Test(priority=2)
    public void apdate_data() throws SQLException {
    	String query="update customers set contactFirstName='sawsan' where customerNumber=6647";
       
        stmt=con.createStatement();
        int rowEffected = stmt.executeUpdate(query);
        System.out.println(rowEffected);
    	
    	
    	
    }
    
    @Test(priority=4)
    public void delete_data() throws SQLException {
    	String query="delete from customers where customerNumber=6647";
       
        stmt=con.createStatement();
        int rowEffected = stmt.executeUpdate(query);
        System.out.println(rowEffected);
    	
    	
    	
    }
    @Test(priority=3)
    public void read_data() throws SQLException {
    	String query="select*from customers where customerNumber=6647\r\n";
       
        stmt=con.createStatement();
        rs=stmt.executeQuery(query);
        while(rs.next()) {
        	String costumernumberindatabase=rs.getString("customerNumber");
        	String costomernameindatabase=rs.getString("contactLastName");
            System.out.println(costumernumberindatabase);
            System.out.println(costomernameindatabase);

        }
}
}