import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ReadProductRecords
{
public static void main(String[] args)
{
String url="jdbc:mysql://localhost:3306/productdb";
String username="root";
String password="";
Connection connection=null;
Statement statement=null;
ResultSet resultSet=null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
connection=DriverManager.getConnection(url,username,password);
statement=connection.createStatement();
//SQL: query to read data from the product table
String query="SELECT * FROM product";
//Execute the query
resultSet=statement.executeQuery(query);
//Process and display the result set
while(resultSet.next())
{
int product_id=resultSet.getInt("product_id");
String product_name=resultSet.getString("product_name");
int price=resultSet.getInt("price");
String company=resultSet.getString("company");
int expiry_year=resultSet.getInt("expiry_year");
System.out.println("Product ID:"+product_id);
System.out.println("Product_Name:"+product_name);
System.out.println("Price in rs:"+price);
System.out.println("company name:"+company);
System.out.println("Expiry year:"+expiry_year);
System.out.println();
}
}
catch(ClassNotFoundException e)
{
e.printStackTrace();
}
catch(SQLException e)
{
e.printStackTrace();
}
finally
{
try
{
if(resultSet!=null)
resultSet.close();
if(statement!=null)
statement.close();
if(connection!=null)
connection.close();
}
catch(SQLException e)
{
e.printStackTrace();
}
}
}
}