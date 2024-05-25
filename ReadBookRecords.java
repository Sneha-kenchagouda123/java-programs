import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ReadBookRecords
{
public static void main(String[] args)
{
String url="jdbc:mysql://localhost:3306/bookdb";
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
//SQL: query to read data from the book table
String query="SELECT * FROM book";
//Execute the query
resultSet=statement.executeQuery(query);
//Process and display the result set
while(resultSet.next())
{
int book_id=resultSet.getInt("book_id");
String book_name=resultSet.getString("book_name");
String price=resultSet.getString("price");
String author_name=resultSet.getString("author_name");
String publication_date=resultSet.getString("publication_date");
System.out.println("Book ID:"+book_id);
System.out.println("Book_Name:"+book_name);
System.out.println("Price in rs:"+price);
System.out.println("Author name:"+author_name);
System.out.println("Publication date:"+publication_date);
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