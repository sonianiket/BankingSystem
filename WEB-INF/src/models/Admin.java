package models;

import java.sql.*;

public class Admin{
	private Integer adminId;
	private String email;
	private String password;

//////////////////////////////// Constructor ///////////////////////////////////////////////

	public Admin(){
	
	}

	public Admin(String email,String password){
		this.email = email;
		this.password = password;
	}

//////////////////////////////// Methods ////////////////////////////////////////////////

	public boolean adminLogin(){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "select email,password,admin_id from admin where email=? and password=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,email);
			pst.setString(2,password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				this.email = rs.getString(1);
				this.password = rs.getString(2);
				this.adminId = rs.getInt(3);
				flag = true;
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}

		return flag;
	}


//////////////////////////////// Setter and Getter /////////////////////////////////////////

	public void setAdminId(Integer adminId){
		this.adminId = adminId;
	}

	public Integer getAdminId(){
		return adminId;
	}
	
	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}
}