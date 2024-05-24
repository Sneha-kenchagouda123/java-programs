import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateProductTable
{
public static void main(String[] args)
{
String url="jdbc:mysql://localhost:3306/productdb";
String username="root";
String password="";
Connection connection=null;
Statement statement=null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
connection=DriverManager.getConnection(url,username,password);
statement=connection.createStatement();
String createTableSQL="CREATE TABLE product("
+"product_id INT NOT NULL,"
+"product_name VARCHAR(100) NOT NULL,"
+"price VARCHAR(15) NOT NULL,"
+"company VARCHAR(50) NOT NULL,"
+"expiry_year INT,"
+"PRIMARY KEY(product_id))";
statement.executeUpdate(createTableSQL);
System.out.println("Table 'product' created successfully.");
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