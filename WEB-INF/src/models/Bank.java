package models;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bank{
	private Integer bankId;
	private String bankName;
	private String IFSCCode;

//////////////////////////// Constructors /////////////////////////////////////////////

	public Bank(){
	
	}

	public Bank(Integer bankId){
		this.bankId = bankId;
	}

	public Bank(String bankName){
		this.bankName = bankName;
	}

	public Bank(String bankName,String IFSCCode){
		this.bankName = bankName;
		this.IFSCCode = IFSCCode;
	}
	
	public Bank(Integer bankId,String bankName,String IFSCCode){
		this.bankId = bankId;
		this.bankName = bankName;
		this.IFSCCode = IFSCCode;
		System.out.println(bankId+ "##"+ bankName + "$$" + IFSCCode);
	}

//////////////////////////// Methods //////////////////////////////////////////////////
		
	public static ArrayList<Bank> GetDetails(){
		ArrayList<Bank> al = new ArrayList<Bank>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "select bank_id,bank_name,ifsc_code from banks";
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				al.add(new Bank(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		return al;
	}
	
	public static boolean saveBank(String bankName,String ifscCode){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "insert into banks(bank_name,ifsc_code) value(?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,bankName);
			pst.setString(2,ifscCode);

			if(pst.executeUpdate()==1){
				flag = true;
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		return flag;
	}

	public boolean getIFSCCode(int bankId){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "select ifsc_code from banks where bank_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,bankId);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				flag = true;
				IFSCCode = rs.getString(1);
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;
	}

	public boolean savePendingId(int pendingId,int bankId){
			boolean flag = false;
			try{
				System.out.println(pendingId + "@@@@@@@@@@@@@@@@@@@@@@@@@" + bankId);
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
				String query = "update banks set pending_id=? where bank_id=?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setInt(1,pendingId);
				pst.setInt(2,bankId);

				if(pst.executeUpdate()==1){
					flag = true;
				}
			}catch(ClassNotFoundException|SQLException e){
				e.printStackTrace();
			}
			return flag;
	}


	public static ArrayList<Bank> collectIFSCCode(){
		ArrayList al = new ArrayList();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "select bank_id,bank_name,ifsc_code from banks";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				al.add(new Bank(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}finally{try{ con.close(); }catch(SQLException s){ s.printStackTrace(); }}
		
		return al;
	}


////////////////////////////////////// Setter and Getter Methods ///////////////////////////////////////////

	public void setBankId(Integer bankId){
		this.bankId = bankId;
	}

	public Integer getBankId(){
		return bankId;
	}

	public void setBankName(String bankName){
		this.bankName = bankName;
	}

	

	public String getBankName(){
		return bankName;
	}

	public void setIFSCCode(String IFSCCode){
		this.IFSCCode = IFSCCode;
	}
	
	public String getIFSCCode(){
		return IFSCCode;
	}

	
}