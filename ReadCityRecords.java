import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ReadCityRecords
{
public static void main(String[] args)
{
String url="jdbc:mysql://localhost:3306/citydb";
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
//SQL: query to read data from the city table
String query="SELECT * FROM city";
//Execute the query
resultSet=statement.executeQuery(query);
//Process and display the result set
while(resultSet.next())
{
int city_code=resultSet.getInt("city_code");
String city_name=resultSet.getString("city_name");
String state=resultSet.getString("state");

System.out.println("City code:"+city_code);
System.out.println("City_Name:"+city_name);
System.out.println("state:"+state);

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