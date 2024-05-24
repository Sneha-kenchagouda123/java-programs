import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteProductRecords
{
public static void main(String[] args)
{
String url="jdbc:mysql://localhost:3306/productdb";
String username="root";
String password="";
int productidToDelete=15;
Connection connection=null;
Statement statement=null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
connection=DriverManager.getConnection(url,username,password);
statement=connection.createStatement();
String deleteSQL="DELETE FROM product WHERE product_id="+productidToDelete;
//Execute the delete query
int rowsAffected=statement.executeUpdate(deleteSQL);
if(rowsAffected>0)
{
System.out.println("Record with ProductId "+productidToDelete+" was deleted successfully.");
}
else
{
System.out.println("No records found with Product id"+productidToDelete);
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