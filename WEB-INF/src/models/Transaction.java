package models;

import java.sql.*;

import java.util.Date;
import java.util.ArrayList;

public class Transaction{
	private Integer transactionId;
	private Deposit fromAccount;
	private Deposit toAccount;
	private double balance;
	private Timestamp time;
	private Account account;

///////////////////////////// Constructors ///////////////////////////////////////////////////////////

	public Transaction(){
	
	}

	public Transaction(Account account,double balance,Timestamp time){
		this.account = account;
		this.balance = balance;
		this.time = time;
	}

///////////////////////////// Methods ///////////////////////////////////////////////////////////

	public  ArrayList<Transaction> getAllTransaction(){
		ArrayList<Transaction> al = new ArrayList<Transaction>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "select a.account_number,t.balance,t.time from account as a inner join deposits as d inner join transactions as t where t.from_account=d.deposit_id";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				al.add(new Transaction(new Account(rs.getString(1)),rs.getDouble(2),rs.getTimestamp(3)));
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return al;
	}

	public void saveTransaction(int wdId,int dpstId,double money){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "insert into transactions(from_account,to_account,balance,time) value(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,wdId);
			pst.setInt(2,dpstId);
			pst.setDouble(3,money);
			pst.setTimestamp(4,new Timestamp(new Date().getTime()));
			pst.executeUpdate();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
	}


///////////////////////////// Setters and Getters ////////////////////////////////////////////////

	public void setTransactionId(Integer transactionId){
		this.transactionId = transactionId;
	}

	public Integer getTransactionId(){
		return transactionId;
	}

	public void setFromAccount(Deposit fromAccount){
		this.fromAccount = fromAccount;
	}

	public Deposit getFromAccount(){
		return fromAccount;
	}

	public void setToAccount(Deposit toAccount){
		this.toAccount = toAccount;
	}

	public Deposit getToAccount(){
		return toAccount; 
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

	public void setAccount(Account account){
		this.account = account;
	}

	public Account getAccount(){
		return account;
	}
}