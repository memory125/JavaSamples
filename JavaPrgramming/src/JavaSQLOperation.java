import java.sql.*;

public class JavaSQLOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String _strSQLName = "jdbc:sqlite:.\\test.db";
		
		CreateSQLTable(_strSQLName);
		
		InsertSQLTableData(_strSQLName);
		
		SelectSQLFromTable(_strSQLName);
		UpdateSQLTableData(_strSQLName);
		DeleteSQLTableData(_strSQLName);
		
		try{  
			//连接SQLite的JDBC  
			Class.forName("org.sqlite.JDBC");  
			//建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之  
			Connection conn =DriverManager.getConnection("jdbc:sqlite:.\\zieckey.db");  
			Statement stat = conn.createStatement();  
			stat.executeUpdate("drop table if exists tbl1");
			stat.executeUpdate("create table tbl1 (name varchar(20), salary int);");//创建一个表，两列  
			stat.executeUpdate("insert into tbl1 values('ZhangSan', 8000);");//插入数据  
			stat.executeUpdate("insert into tbl1 values('LiSi', 7800);");  
			stat.executeUpdate("insert into tbl1 values('WangWu', 5800);");  
			stat.executeUpdate("insert into tbl1 values('ZhaoLiu', 9100);");  
			ResultSet rs = stat.executeQuery("select * from tbl1;");//查询数据  
			while(rs.next()){//将查询到的数据打印出来  
			System.out.print("name = "+ rs.getString("name")+" ");//列属性一  
			System.out.println("salary = "+ rs.getString("salary"));//列属性二  
			}  
			rs.close();  
			conn.close();//结束数据库的连接  
			}  
			catch(Exception e ){  
			e.printStackTrace();  
			}  
	

	}
	
	// Create Table
	public static void CreateSQLTable(String dbName)
	{
		Connection _connection = null;
		Statement _statement = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      _connection = DriverManager.getConnection(dbName);
	      
	      // Get database information
          DatabaseMetaData dbMetaData = _connection.getMetaData();
          System.out.println("Database product name: " + dbMetaData.getDatabaseProductName());
          System.out.println("Database version : " + dbMetaData.getDatabaseMajorVersion() + " Product version: " + dbMetaData.getDatabaseProductVersion());
          System.out.println("Database driver name : " + dbMetaData.getDriverName());
          System.out.println("Database user name: " + dbMetaData.getUserName());
	      
	      _statement = _connection.createStatement();
	      String sql = "CREATE TABLE COMPANY " +
	                   "(ID INT PRIMARY KEY     NOT NULL," +
	                   " NAME           TEXT    NOT NULL, " + 
	                   " AGE            INT     NOT NULL, " + 
	                   " ADDRESS        CHAR(50), " + 
	                   " SALARY         REAL)"; 
	      _statement.executeUpdate("drop table if exists COMPANY");
	      _statement.executeUpdate(sql);      
	      
	      
	      _statement.close();
	      _connection.close();
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Table created successfully");
	}
	
	// Insert Operation
	public static void InsertSQLTableData(String dbName)
	{
		Connection _connection = null;
	    Statement _statement = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      _connection = DriverManager.getConnection(dbName);
	      _connection.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      _statement = _connection.createStatement();
	      String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	                   "VALUES (1, 'Paul', 32, 'California', 20000.00 );"; 
	      _statement.executeUpdate(sql);

	      sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	            "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );"; 
	      _statement.executeUpdate(sql);

	      sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	            "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );"; 
	      _statement.executeUpdate(sql);

	      sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	            "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
	      _statement.executeUpdate(sql);

	      _statement.close();
	      _connection.commit();
	      _connection.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Records created successfully");
	}
	
	// Select Operation
	public static void SelectSQLFromTable(String dbName)
	{
		 Connection _connection = null;
		 Statement _statement = null;
		 try {
		      Class.forName("org.sqlite.JDBC");
		      _connection = DriverManager.getConnection(dbName);
		      _connection.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      _statement = _connection.createStatement();
		      ResultSet rs = _statement.executeQuery( "SELECT * FROM COMPANY;" );
		      while ( rs.next() ) {
		         int id = rs.getInt("id");
		         String  name = rs.getString("name");
		         int age  = rs.getInt("age");
		         String  address = rs.getString("address");
		         float salary = rs.getFloat("salary");
		         System.out.println( "ID = " + id );
		         System.out.println( "NAME = " + name );
		         System.out.println( "AGE = " + age );
		         System.out.println( "ADDRESS = " + address );
		         System.out.println( "SALARY = " + salary );
		         System.out.println();
		      }
		      rs.close();
		      _statement.close();
		      _connection.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Operation done successfully");
	}
	
	// Update Data
	public static void UpdateSQLTableData(String dbName)
	{
		Connection _connection = null;
	    Statement _statement = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      _connection = DriverManager.getConnection(dbName);
	      _connection.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      _statement = _connection.createStatement();
	      String sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
	      _statement.executeUpdate(sql);
	      _connection.commit();

	      ResultSet rs = _statement.executeQuery( "SELECT * FROM COMPANY;" );
	      while ( rs.next() ) {
	         int id = rs.getInt("id");
	         String  name = rs.getString("name");
	         int age  = rs.getInt("age");
	         String  address = rs.getString("address");
	         float salary = rs.getFloat("salary");
	         System.out.println( "ID = " + id );
	         System.out.println( "NAME = " + name );
	         System.out.println( "AGE = " + age );
	         System.out.println( "ADDRESS = " + address );
	         System.out.println( "SALARY = " + salary );
	         System.out.println();
	      }
	      rs.close();
	      _statement.close();
	      _connection.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
	}
	
	// Delete Data
	public static void DeleteSQLTableData(String dbName)
	{
		Connection _connection = null;
	    Statement _statement = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      _connection = DriverManager.getConnection(dbName);
	      _connection.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      _statement = _connection.createStatement();
	      String sql = "DELETE from COMPANY where ID=2;";
	      _statement.executeUpdate(sql);
	      _connection.commit();

	      ResultSet rs = _statement.executeQuery( "SELECT * FROM COMPANY;" );
	      while ( rs.next() ) {
	         int id = rs.getInt("id");
	         String  name = rs.getString("name");
	         int age  = rs.getInt("age");
	         String  address = rs.getString("address");
	         float salary = rs.getFloat("salary");
	         System.out.println( "ID = " + id );
	         System.out.println( "NAME = " + name );
	         System.out.println( "AGE = " + age );
	         System.out.println( "ADDRESS = " + address );
	         System.out.println( "SALARY = " + salary );
	         System.out.println();
	      }
	      rs.close();
	      _statement.close();
	      _connection.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
	}
}
