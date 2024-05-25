import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertBookRecords
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
String[] insertQueries={
"INSERT INTO book(book_id,book_name,price,author_name,publication_date)VALUES(21,'Horror','400','levis',2002)",

"INSERT INTO book(book_id,book_name,price,author_name,publication_date)VALUES(25,'godess','500','kuvempu',2000)",

"INSERT INTO book(book_id,book_name,price,author_name,publication_date)VALUES(28,'flower','600','tagore',2001)",

"INSERT INTO book(book_id,book_name,price,author_name,publication_date)VALUES(30,'fairytail','400','shakespear',1998)",

"INSERT INTO book(book_id,book_name,price,author_name,publication_date)VALUES(32,'juliet','560','william',1900)",


};
//execute each insert query
for(String query:insertQueries)
{
statement.executeUpdate(query);
}
System.out.println("Inserted 5 records into the 'book' table.");
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