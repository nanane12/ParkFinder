package parkLookUpJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ParkDBUtil {

	
	private static DataSource dataSource;
	
	public ParkDBUtil(DataSource theDataSource){
		dataSource = theDataSource;
	}
	
	public static List<Park> locatePark(String zip) throws Exception{
		
		List<Park>parks=new ArrayList<>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		PreparedStatement pst=null;
		
		try{
			
		//get a connection
		conn = dataSource.getConnection();
		//create Sql statement
		String sql="SELECT * FROM parks WHERE zipCode =?";
		
		pst=conn.prepareStatement(sql);
		
		pst.setString(1, zip);
		
		 rs=pst.executeQuery();
		//process result set
		 while (rs.next()){
					int id=rs.getInt("id");
					String name=rs.getString("nameOfPark");
					String address=rs.getString ("addressOfPark");
					String ZIPcode=rs.getString("zipCode");
					String web=rs.getString("website");
			//create new Park object
				Park tempPark=new Park(id,name,address, ZIPcode, web);
			//add it to the list of parks
				parks.add(tempPark);
		 }
			
		 return parks;
		}
		finally{
			//close JDBC objects
			close(conn, stmt,rs);
		}
		
		
	}

	private static void close(Connection conn, Statement stmt, ResultSet rs) {
		try{
			if (rs !=null){
				rs.close();
			}
			if (stmt !=null){
				stmt.close();
			}
			if (conn !=null){
				conn.close();
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}

	
		
	}

