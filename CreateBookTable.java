import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateBookTable
{
public static void main(String[] args)
{
String url="jdbc:mysql://localhost:3306/bookdb";
String username="root";
String password="";
Connection connection=null;
Statement statement=null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
connection=DriverManager.getConnection(url,username,password);
statement=connection.createStatement();
String createTableSQL="CREATE TABLE book("
+"book_id INT NOT NULL,"
+"book_name VARCHAR(100) NOT NULL,"
+"price VARCHAR(15) NOT NULL,"
+"author_name VARCHAR(50) NOT NULL,"
+"publication_date VARCHAR(30),"
+"PRIMARY KEY(book_id))";
statement.executeUpdate(createTableSQL);
System.out.println("Table 'book' created successfully.");
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