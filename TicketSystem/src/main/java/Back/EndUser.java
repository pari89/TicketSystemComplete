package Back;
import java.sql.*;

public class EndUser extends User{
	public ResultSet viewTickets(String userName) throws Exception
	{
		Connection con = super.createCon();
		Statement st = con.createStatement();
		String query1 = "select * from ticket where enduser=\""+userName+"\"";
		ResultSet rs = st.executeQuery(query1);
		return rs;
	}
	public ResultSet viewTicketsC(String userName) throws Exception
	{
		Connection con = super.createCon();
		Statement st = con.createStatement();
		String query1 = "select * from ticket where enduser=\""+userName+"\" and ticketstatus!=\"close\"";
		ResultSet rs = st.executeQuery(query1);
		return rs;
	}
	public void closeTicket(String ticketName) throws Exception
	{
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
			String query2 = "update ticket set ticketstatus=? where ticketname=?";
			PreparedStatement ps = con.prepareStatement(query2);
			ps.setString(1, "close");
			ps.setString(2,ticketName);
			ps.executeUpdate();
			String seName = rs.getString(4);
			String query3 = "SELECT EXISTS(SELECT * from user WHERE username=\""+seName+"\")";
			ResultSet rs1 = st.executeQuery(query3);
			rs1.next();
			if(rs1.getBoolean(1))
			{
				query3="update user set availabilty=1 where username=?";
				PreparedStatement ps1 = con.prepareStatement(query3);
				ps1.setString(1,seName);
				ps1.executeUpdate();
			}
		}
	}
	public int raiseTicket(String userName,String ticketName, String ticketType, String ticketDes) throws Exception
	{
		Connection con = super.createCon();
		Statement st = con.createStatement();
		String query1 = "SELECT EXISTS(SELECT * from ticket WHERE ticketname=\""+ticketName+"\")";
		ResultSet rs = st.executeQuery(query1);
		rs.next();
		int i = 3;
		if(!rs.getBoolean(1))
		{
			String query2 = "SELECT EXISTS(SELECT * from user WHERE setype=\""+ticketType+"\")";
			rs = st.executeQuery(query2);
			rs.next();
			String query3 = "insert into ticket values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query3);
			ps.setString(1, ticketName);
			ps.setString(2, ticketType);
			ps.setString(3, userName);
			ps.setString(6, ticketDes);
			if(rs.getBoolean(1))
			{
				query2 = "select * from user where setype=\""+ticketType+"\"";
				rs = st.executeQuery(query2);
				boolean availability = false;
				while(rs.next())
				{
					if(rs.getBoolean(6))
					{
						availability = true;
						ps.setString(4,rs.getString(2));
						ps.setString(5, "open");
						i=1;
						String query4 = "update user set availabilty = 0 where username = ?";
						PreparedStatement ps2 = con.prepareStatement(query4);
						ps2.setString(1, rs.getString(2));
						ps2.executeUpdate();
						break;
					}
				}
				if(!availability)
				{
					ps.setString(4, null);
					ps.setString(5, "not assigned");
					i=2;
				}
			}
			else
			{
				ps.setString(4, null);
				ps.setString(5, "not assigned");
				i=2;
			}
			ps.executeUpdate();
		}
		else
		{
			i=3;
		}
		return i;
	}
}
