package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TrainDAO
{
	String driverClass="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/Train?autoReconnect=true&useSSL=false";
	String userName="root";
	String password="root";
	
	public Train findTrain(int trainNumber)
	{
		int id=trainNumber ;
		Train train=null;
			try
			{
				Class.forName(driverClass);
				System.out.println("class found");

				Connection con=DriverManager.getConnection(url,userName,password);
				System.out.println("connected");

				PreparedStatement p=con.prepareStatement("select * from trains where Train_No= ?");
				p.setInt(1, id);
				
				ResultSet r=p.executeQuery();
				
				while(r.next())
				{
					train=new Train(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getInt(5));
					
				}
				
				con.close();
			}
			catch(Exception e)
			{
			System.out.println("class not found");
			}
				return train;
	}
}