import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteBookRecords
{
public static void main(String[] args)
{
String url="jdbc:mysql://localhost:3306/bookdb";
String username="root";
String password="";
int bookidToDelete=32;
Connection connection=null;
Statement statement=null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
connection=DriverManager.getConnection(url,username,password);
statement=connection.createStatement();
String deleteSQL="DELETE FROM book WHERE book_id="+bookidToDelete;
//Execute the delete query
int rowsAffected=statement.executeUpdate(deleteSQL);
if(rowsAffected>0)
{
System.out.println("Record with Bookid "+bookidToDelete+" was deleted successfully.");
}
else
{
System.out.println("No records found with Book id"+bookidToDelete);
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