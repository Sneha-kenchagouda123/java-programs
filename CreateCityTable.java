import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateCityTable
{
public static void main(String[] args)
{
String url="jdbc:mysql://localhost:3306/citydb";
String username="root";
String password="";
Connection connection=null;
Statement statement=null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
connection=DriverManager.getConnection(url,username,password);
statement=connection.createStatement();
String createTableSQL="CREATE TABLE city("
+"city_code INT NOT NULL,"
+"city_name VARCHAR(100) NOT NULL,"
+"state VARCHAR(15) NOT NULL,"

+"PRIMARY KEY(city_code))";
statement.executeUpdate(createTableSQL);
System.out.println("Table 'city' created successfully.");
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