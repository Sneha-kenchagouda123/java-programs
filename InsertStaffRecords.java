import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStaffRecords
{
public static void main(String[] args)
{
String url="jdbc:mysql://localhost:3306/staffdb";
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
"INSERT INTO staff(staff_id,staff_name,dept,email,phone)VALUES(101,'sneha','chemistry','sneha@gmail.com','8197912345')",
"INSERT INTO staff(staff_id,staff_name,dept,email,phone)VALUES(102,'savita','physics','savita@gmail.com','6758912345')",
"INSERT INTO staff(staff_id,staff_name,dept,email,phone)VALUES(114,'akshata','maths','akshata@gmail.com','9192912345')",
"INSERT INTO staff(staff_id,staff_name,dept,email,phone)VALUES(123,'shweta','biology','shweta@gmail.com','9807912345')",
"INSERT INTO staff(staff_id,staff_name,dept,email,phone)VALUES(118,'sarita','botany','sarita@gmail.com','81098653745')"
};
//execute each insert query
for(String query:insertQueries)
{
statement.executeUpdate(query);
}
System.out.println("Inserted 5 records into the 'staff' table.");
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