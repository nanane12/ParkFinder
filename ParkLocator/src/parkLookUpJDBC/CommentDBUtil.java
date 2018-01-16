package parkLookUpJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class CommentDBUtil {

		private static DataSource dataSource;
		
		public CommentDBUtil(DataSource theDataSource){
			dataSource = theDataSource;
		}
		
		public static void addComment(Comments theComment) {
			
			List<Comments>comments=new ArrayList<>();
			Connection conn=null;
			Statement stmt=null;
			ResultSet rs=null;
			PreparedStatement pst=null;
			
			try{
			
			//get a connection
			conn = dataSource.getConnection();
			//create Sql statement
			String sql="insert into comments"
					+ "(ChildAge, rating, freeText, park_id)"
					+"values (?,?,?,?)";
			
			pst=conn.prepareStatement(sql);
			
			
			pst.setString(1,theComment.getChildAge());
			pst.setString(2,theComment.getRating());
			pst.setString(3,theComment.getFreeText());
			pst.setInt(4,theComment.getPark_id());
			
			pst.executeUpdate();
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

		
		public static List<Comments> showComment(int parkId) throws Exception{
	
			List<Comments>comments=new ArrayList<>();
			Connection conn=null;
			Statement stmt=null;
			ResultSet rs=null;
			PreparedStatement pst=null;
			
			try{
				
			//get a connection
			conn = dataSource.getConnection();
			//create Sql statement
			String sql="SELECT * FROM comments WHERE park_id =?";
			
			pst=conn.prepareStatement(sql);
			
			pst.setInt(1, parkId);
			
			 rs=pst.executeQuery();
			//process result set
			 while (rs.next()){
						int id=rs.getInt("commentId");
						String ChildAge=rs.getString("ChildAge");
						String rating=rs.getString ("rating");
						String freeText=rs.getString("freeText");
						int park_id=rs.getInt("park_id");
				//create new Park object
					Comments tempComment=new Comments(id,ChildAge,rating, freeText, park_id);
				//add it to the list of parks
					comments.add(tempComment);
			 }
				
			 return comments;
			}
			finally{
				//close JDBC objects
				closeConn(conn, stmt,rs);
			}
			
			
		}

		private static void closeConn(Connection conn, Statement stmt, ResultSet rs) {
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
		

