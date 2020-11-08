package models;

import java.sql.*;

import java.util.Date;
import java.util.ArrayList;

public class Deposit{
	private Integer depositId;
	private Account account;
	private double deposit;
	private double withdrawl;
	private double balance; 
	private Timestamp time; 


/////////////////// Constructors /////////////////////////////////////////

	public Deposit(){
		
	}

	public Deposit(double balance){
		this.balance = balance;
	}

	public Deposit(double balance,double deposit,double withdrawl,Timestamp time,Integer depositId){
		this.balance = balance;
		this.deposit = deposit;
		this.withdrawl = withdrawl;
		this.time = time;
		this.depositId = depositId;
	}

	public Deposit(Account account,double withdrawl,double deposit,Timestamp time){
		this.account = account;
		this.withdrawl = withdrawl;
		this.deposit = deposit;
		this.time = time;
	}

//////////////////// Methods ///////////////////////////////////////////

	/*public ArrayList<Deposit> getTransactionHistory(int wdId,int dpstId){
		ArrayList<Deposit> al = new ArrayList<Deposit>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "select a.account_number,d.withdrawl,deposit,d.time from deposits as d inner join account as a where d.account_id=a.account_id and d.deposit_id between ? and ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,wdId);
			pst.setInt(2,dpstId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				al.add(new Deposit(new Account(rs.getString(1)),rs.getDouble(2),rs.getDouble(3),rs.getTimestamp(4)));
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return al;
	}*/

	public static ArrayList<Deposit> getHistory(int accountId){
		ArrayList<Deposit> al = new ArrayList<Deposit>();
		try{
			System.out.println("Account Id = "+ accountId);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			//String query = "select balance from deposits where account_id=?";
			String query = "select balance,deposit,withdrawl,time,deposit_id from deposits where account_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,accountId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				al.add(new Deposit(rs.getDouble(1),rs.getDouble(2),rs.getDouble(3),rs.getTimestamp(4),rs.getInt(5)));
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return al;
	}

	public static Deposit getBalance(int accountId){
		Deposit d = new Deposit();
		try{
			System.out.println("Account Id = "+ accountId);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			//String query = "select balance from deposits where account_id=?";
			String query = "select balance from deposits where account_id=? order by deposit_id desc";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,accountId);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				d.balance = rs.getInt(1);
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return d;
	}
	
	
	
	synchronized public boolean withdrawlMoney(int accountId,double withdrawl,double balance){
		boolean flag = false;
		System.out.println("WithDrawl =  " + withdrawl + "Balance = " + balance);	
		if(withdrawl<balance){
				balance = balance - withdrawl;
				System.out.println("Final Balance after withDrawl = "+balance);
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
				String query = "insert into deposits(account_id,withdrawl,balance,time) value(?,?,?,?)";
				PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				pst.setInt(1,accountId);
				pst.setDouble(2,withdrawl);
				pst.setDouble(3,balance);
				pst.setTimestamp(4,new Timestamp(new Date().getTime()));

				if(pst.executeUpdate()==1){
					flag = true;
					ResultSet rs = pst.getGeneratedKeys();
					if(rs.next()){
						depositId = rs.getInt(1);
					}
				}
			}catch(ClassNotFoundException|SQLException e){
				e.printStackTrace();
			}
		}else{
			System.out.println("Not WithDrawl");
		}
		return flag;
	}
	

	synchronized public double depositMoney(int accountId,double deposit,double balance){
	
		System.out.println("Deposit =  "+deposit + "Balance = " + balance);	
		balance = balance + deposit;
		System.out.println("Final Balance after Deposit = "+balance);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "insert into deposits (account_id,deposit,balance,time) value(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1,accountId);
			pst.setDouble(2,deposit);
			pst.setDouble(3,balance);
			pst.setTimestamp(4,new Timestamp(new Date().getTime()));

			if(pst.executeUpdate()==1){
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()){
					depositId = rs.getInt(1);
				}
			}
			
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return balance;
	}


//////////////////// Setter and Getter ///////////////////////////////////

	public void setDepositId(Integer depositId){
		this.depositId = depositId;
	}

	public Integer getDepositId(){
		return depositId;
	}

	public void setAccount(Account account){
		this.account = account;
	}

	public Account getAccount(){
		return account;
	}

	public void setDeposit(double deposit){
		this.deposit = deposit;
	}

	public double getDeposit(){
		return deposit;
	}

	public void setWithDrawl(double withdrawl){
		this.withdrawl = withdrawl;
	}

	public double getWithDrawl(){
		return withdrawl;
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