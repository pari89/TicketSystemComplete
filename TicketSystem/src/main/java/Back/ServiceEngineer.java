package Back;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceEngineer extends User {
	public ResultSet viewTickets(String userName) throws Exception
	{
		Connection con = super.createCon();
		Statement st = con.createStatement();
		String query1 = "select * from ticket where serviceeng=\""+userName+"\"";
		ResultSet rs = st.executeQuery(query1);
		return rs;
	}
	public List<String> Status(String tN) throws Exception
	{
		List<String>status1 = new ArrayList<>();
		Connection con = super.createCon();
		Statement st = con.createStatement();
		String query1 = "select * from ticket where ticketname=\""+tN+"\"";
		ResultSet rs = st.executeQuery(query1);
		rs.next();
		String st1 = rs.getString(5);
		if(st1.equalsIgnoreCase("close"))
		{
			status1.add("open");
			status1.add("hold");
			status1.add("not assigned");
		}
		else if(st1.equalsIgnoreCase("open"))
		{
			status1.add("close");
			status1.add("hold");
			status1.add("not assigned");
		}
		else if(st1.equalsIgnoreCase("hold"))
		{
			status1.add("close");
			status1.add("open");
			status1.add("not assigned");
		}
		else if(st1.equalsIgnoreCase("not assigned"))
		{
			status1.add("close");
			status1.add("hold");
			status1.add("open");
		}
		return status1;
	}
	public ResultSet viewTicketsC(String userName) throws Exception
	{
		Connection con = super.createCon();
		Statement st = con.createStatement();
		String query1 = "select * from ticket where serviceeng=\""+userName+"\" and ticketstatus=\"open\"";
		ResultSet rs = st.executeQuery(query1);
		return rs;
	}
	public ResultSet getType(String n) throws Exception
	{
		Connection con = super.createCon();
		Statement st = con.createStatement();
		String query1 = "select * from ticket where ticketname=\""+n+"\"";
		ResultSet rs = st.executeQuery(query1);
		return rs;
	}
	public ResultSet viewTicketsL(String ticketType) throws Exception
	{
		User u = new User();
		Connection con = u.createCon();
		Statement st = con.createStatement();
		String query5 = "select exists(select * from ticket where tickettype=\""+ticketType+"\" and serviceeng is null)";
		ResultSet rs2 = st.executeQuery(query5);
		rs2.next();
		if(rs2.getBoolean(1))
		{
			query5 = "select * from ticket where tickettype=\""+ticketType+"\" and serviceeng is null";
			rs2 = st.executeQuery(query5);
		}
		return rs2;
	}
	public void closeTicket(String ticketName) throws Exception
	{
		ServiceEngineer t = new ServiceEngineer();
		t.changeStatus(ticketName, "close");
		
	}
	public void pickTicket (String seName,String tN) throws Exception
	{
		User u = new User();
		Connection con = u.createCon();
		Statement st = con.createStatement();
		String query5;
		ResultSet rs2;
		query5 = "select exists(select * from ticket where ticketname=\""+tN+"\")";
		rs2 = st.executeQuery(query5);
		rs2.next();
		if(rs2.getBoolean(1))
		{
			query5 = "update ticket set serviceeng=?,ticketstatus='open' where ticketname=?";
			String query6 = "update user set availabilty=0 where username=?";
			PreparedStatement ps2 = con.prepareStatement(query5);
			ps2.setString(1, seName);
			ps2.setString(2, tN);
			ps2.executeUpdate();
			PreparedStatement ps3 = con.prepareStatement(query6);
			ps3.setString(1,seName);
			ps3.executeUpdate();
		}
		
	}
	public boolean changeStatus(String ticketName,String changeStatusTo) throws Exception
	{
		@SuppressWarnings({ "resource", "unused" })
		Scanner sc = new Scanner(System.in);
		User u = new User();
		Connection con = u.createCon();
		Statement st = con.createStatement();
		String query1 = "SELECT EXISTS(SELECT * from ticket WHERE ticketname=\""+ticketName+"\")";
		ResultSet rs = st.executeQuery(query1);
		rs.next();
		if(rs.getBoolean(1))
		{
			query1 = "select * from ticket where ticketname=\""+ticketName+"\"";
			rs = st.executeQuery(query1);
			rs.next();
			String seName = rs.getString(4);
			String query3 = "SELECT EXISTS(SELECT * from user WHERE username=\""+seName+"\")";
			ResultSet rs1 = st.executeQuery(query3);
			rs1.next();
			if(changeStatusTo.equalsIgnoreCase("close")||changeStatusTo.equalsIgnoreCase("hold")||changeStatusTo.equalsIgnoreCase("not assigned") )
			{
				if(rs1.getBoolean(1))
				{
					String query2 = "update ticket set ticketstatus=? where ticketname=?";
					PreparedStatement ps = con.prepareStatement(query2);
					ps.setString(1, changeStatusTo);
					ps.setString(2,ticketName);
					ps.executeUpdate();
					query3="update user set availabilty=1 where username=?";
					PreparedStatement ps1 = con.prepareStatement(query3);
					ps1.setString(1,seName);
					ps1.executeUpdate();
					return true;
				}
			}
			else if(changeStatusTo.equalsIgnoreCase("open"))
			{
				if(rs1.getBoolean(1))
				{
					query3 = "select availabilty from user where username=\""+seName+"\"";
					rs1 = st.executeQuery(query3);
					rs1.next();
					if(rs1.getBoolean(1))
					{
						String query2 = "update ticket set ticketstatus=? where ticketname=?";
						PreparedStatement ps = con.prepareStatement(query2);
						ps.setString(1, changeStatusTo);
						ps.setString(2,ticketName);
						ps.executeUpdate();
						query3="update user set availabilty=0 where username=?";
						PreparedStatement ps1 = con.prepareStatement(query3);
						ps1.setString(1,seName);
						ps1.executeUpdate();
						return true;
					}
					else
					{
						return false;
					}
				}
			}
			else
			{
				return true;
			}
		}
		else
		{
			return false;
		}
		return false;
	}
	
}
