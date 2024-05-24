import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ReadStaffRecords
{
public static void main(String[] args)
{
String url="jdbc:mysql://localhost:3306/staffdb";
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
//SQL: query to read data from the staff table
String query="SELECT * FROM staff";
//Execute the query
resultSet=statement.executeQuery(query);
//Process and display the result set
while(resultSet.next())
{
int staff_id=resultSet.getInt("staff_id");
String staff_name=resultSet.getString("staff_name");
String dept=resultSet.getString("dept");
String email=resultSet.getString("email");
String phone=resultSet.getString("phone");
System.out.println("Staff_ID:"+staff_id);
System.out.println("Staff_Name:"+staff_name);
System.out.println("Department:"+dept);
System.out.println("Email:"+email);
System.out.println("Phone number:"+phone);
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