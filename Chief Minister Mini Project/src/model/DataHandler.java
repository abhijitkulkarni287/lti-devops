package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CLASS FOR JDBC OPERATIONS
public class DataHandler 
{
	//Class variables
	static Connection connection=null;
	static PreparedStatement ps=null;
	
	//open connection method
	public void openConnection()
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	//close connection method
	public void closeConnection()
	{
		try 
		{
			connection.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	//METHOD TO ENTER CM DETAILS
	public void registerCM(ChiefMinister cm)
	{
		try 
		{
		openConnection();
		String insertQuery="insert into chief values(?,?,?,?,?,?)";
		ps=connection.prepareStatement(insertQuery);
		ps.setInt(1, cm.getCid());
		ps.setString(2, cm.getCname());
		ps.setString(3, cm.getQualification());
		ps.setString(4, cm.getState());
		ps.setString(5, cm.getEndDate());
		ps.setString(6, cm.getParty());
		
		ps.executeUpdate();
		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
	}
	
	//Method to display chief minister details
	public List<ChiefMinister> displayCM()
	{
		//local variable
		List<ChiefMinister> clist=null;
		
		try 
		{
			openConnection();
			String displayQuery="select * from chief";
			ps=connection.prepareStatement(displayQuery);
			ResultSet result = ps.executeQuery();
			clist=new ArrayList<ChiefMinister>();
			while(result.next())
			{
				int cid=result.getInt(1);
				String cname=result.getString(2);
				String qualification=result.getString(3);
				String state=result.getString(4);
				String endDate=result.getString(5);
				String party=result.getString(6);
				ChiefMinister cm = new ChiefMinister(cid, cname, qualification, state, endDate, party);
				clist.add(cm);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		return clist;
	}
	
	//Method to delete a record based on state name
	public void deleteCM(String state)
	{
		try
		{
			openConnection();
			String deleteQuery="delete from chief where stateName='"+state+"'";
			ps=connection.prepareStatement(deleteQuery);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			closeConnection();
		}
	}
	
	
	
	//TEMPORARY MAIN METHOD
	
	public static void main(String[] args) {
		DataHandler dh = new DataHandler();
		//dh.registerCM();
//		List<ChiefMinister> list = dh.displayCM();
//		for(ChiefMinister cm:list)
//		{
//			System.out.println(cm.getCname());
//		}
//		dh.deleteCM("gujarat");
		
	}
}
