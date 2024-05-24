import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertProductRecords
{
public static void main(String[] args)
{
String url="jdbc:mysql://localhost:3306/productdb";
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
"INSERT INTO product(product_id,product_name,price,company,expiry_year)VALUES(11,'soap','40','Pairs',2024)",
"INSERT INTO product(product_id,product_name,price,company,expiry_year)VALUES(13,'chocolate','80','dairymilk',2025)",
"INSERT INTO product(product_id,product_name,price,company,expiry_year)VALUES(15,'Milk','60','Nandini',2024)",
"INSERT INTO product(product_id,product_name,price,company,expiry_year)VALUES(18,'biscuit','100','Burbon',2026)",
"INSERT INTO product(product_id,product_name,price,company,expiry_year)VALUES(21,'chips','25','lays',2025)",

};
//execute each insert query
for(String query:insertQueries)
{
statement.executeUpdate(query);
}
System.out.println("Inserted 5 records into the 'product' table.");
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