package models;

import java.sql.*;

import java.util.ArrayList;

import utils.AccountNumberGenerator;

public  class Account{
	private Integer accountId;
	private User userId;
	private Bank bankId;
	private String accountNumber;
	private double balance;
	private Timestamp time;

///////////////////////////// Constructors //////////////////////////////////////////////////////////

	public Account(){
	
	}

	public Account(String accountNumber){
		this.accountNumber = accountNumber;
	}

	public Account(String accountNumber,Integer accountId){
		this.accountNumber = accountNumber;
		this.accountId = accountId;
	}

	public Account(User userId,String accountNumber,Integer accountId){
		this.userId = userId;
		this.accountNumber = accountNumber;
		this.accountId = accountId;
	}


///////////////////////////// Methods ///////////////////////////////////////////////////////////////
	
	public static boolean delete(int userId){
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "delete from account where user_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			if(pst.executeUpdate()==1){
				flag = true;
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;
	}

	public static ArrayList<Account> getAccountNumber(String firstChar){
		ArrayList<Account> al = new ArrayList<Account>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "select user_id,account_number,account_id from account where account_number like'"+firstChar+"%'";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				al.add(new Account(new User(rs.getInt(1)),rs.getString(2),rs.getInt(3)));
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return al;
	}
	
	
	public boolean getDetails(int userId){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "select account_number,account_id from account where user_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				flag = true;
				accountNumber = rs.getString(1);
				accountId = rs.getInt(2);
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;
	}


	public static void saveAccount(Integer bankId,Integer userId){
		String accNo = AccountNumberGenerator.getaccountNumber();
		double bal = 0.0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "insert into account(user_id,bank_id,account_number,balance) value(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1,userId);
			pst.setInt(2,bankId);
			pst.setString(3,accNo);
			pst.setDouble(4,bal);

			pst.executeUpdate();
			/*ResultSet rs = pst.getGeneratedKeys();
			if(rs.next()){
				this.accountId = rs.getInt(1);
			}*/

		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
	}


///////////////////////////// Setter and Getter /////////////////////////////////////////////////////

	public void setAccountId(Integer accountId){
		this.accountId = accountId;
	}

	public Integer getAccountId(){
		return accountId;
	}

	public void setUserId(User userId){
		this.userId = userId;
	}

	public User getUserId(){
		return userId;
	}

	public void setBankId(Bank bankId){
		this.bankId = bankId;
	}

	public Bank getBankId(){
		return bankId;
	}

	public void setAccountNumber(String accountNumber){
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber(){
		return accountNumber;
	} 
	
	public void setBalance(double balance){
		this.balance = balance;
	}

	public double getBalance(){
		return balance;
	}

	public void setTime(Timestamp time){
		this.time = time;
	}

	public Timestamp getTime(){
		return time;
	}
}