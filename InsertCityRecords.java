import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertCityRecords
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
String[] insertQueries={
"INSERT INTO city(city_code,city_name,state)VALUES(591287,'chikodi','karnataka')",

"INSERT INTO city(city_code,city_name,state)VALUES(591345,'nipani','maharashtra')",
"INSERT INTO city(city_code,city_name,state)VALUES(591987,'bengalur','karnataka')",
"INSERT INTO city(city_code,city_name,state)VALUES(591098,'belagavi','karnataka')",

};
//execute each insert query
for(String query:insertQueries)
{
statement.executeUpdate(query);
}
System.out.println("Inserted 4 records into the 'city' table.");
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