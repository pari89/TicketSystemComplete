package Back;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin extends User{
	public boolean addAdmin(String Username, String Password) throws Exception
	{
		return super.register(Username, Password,"Admin",null);
	}
	public boolean addEndUser(String Username, String Password) throws Exception
	{
		return super.register(Username, Password,"EndUser",null);
	}
	public boolean addServiceEngineer(String Username, String Password, String setype) throws Exception
	{
		return super.register(Username, Password,"ServiceEngineer",setype);
	}
	public ResultSet viewUsers() throws Exception
	{
		Connection con = createCon();
		Statement st = con.createStatement();
		String query1 = "SELECT * from user";
		ResultSet rs = st.executeQuery(query1);
		return rs;
	}
}
