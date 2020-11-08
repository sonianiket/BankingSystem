package models;

import java.sql.*;

import org.jasypt.util.password.StrongPasswordEncryptor;

import java.util.ArrayList;

public class User{
	private Integer userId;
	private Bank bank;
	private String accountName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobile;
	private String address;
	private String dob;
	private String gender;
	private String fileName;
	private Status status;
	private Account account;

	static StrongPasswordEncryptor spe = new StrongPasswordEncryptor();

/////////////////////////////////// Constructors /////////////////////////////////////////////////////////////////
	
	public User(){
	
	}

	public User(int userId){
		this.userId = userId;
	}

	public User(String email,String password){
		this.email = email;
		this.password = password;
	}
	
	public User(String email,String password,String firstName){
		this.email = email;
		this.password = password;
		this.firstName = firstName;
	}

	public User(String email,String password,String firstName,Integer userId,Bank bank,String accountName,String lastName,String mobile,String address,String dob,String gender,Status status){
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.userId = userId;
		this.bank = bank;
		this.accountName = accountName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.status = status;
	}

	public User(String email,String password,String firstName,Integer userId,Bank bank,String accountName,String lastName,String mobile,String address,String dob,String gender,Status status,Account account){
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.userId = userId;
		this.bank = bank;
		this.accountName = accountName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.status = status;
		this.account = account;
	}

/////////////////////////////////// Methods /////////////////////////////////////////////////////////////////

	/*public void saveAccountId(int accountId,String activationCode){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "update users set account_id=? where activation_code=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,accountId);
			pst.setString(2,activationCode);

			pst.executeUpdate();
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
	}*/
	
	public static boolean changePassword(String email,String password){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "update users set password=? where email=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,spe.encryptPassword(password));
			pst.setString(2,email);
			if(pst.executeUpdate()==1){
				flag = true;
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static boolean deleteUser(int userId){
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "delete from users where user_id=?";
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
	
	public static ArrayList<User> getInactiveUsers(){
		ArrayList<User> al = new ArrayList<User>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "select email,password,first_name,u.user_id,b.bank_name,account_name,last_name,mobile,address,DOB,gender,s.status from users as u inner join banks as b inner join status as s  where u.status_id=2 and b.bank_id=u.bank_id and s.status_id=u.status_id";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				al.add(new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),new Bank(rs.getString(5)),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),new Status(rs.getString(12))));
			}

		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return al;
	}
	
	public boolean userLogin(){
		System.out.println("UserLogin Method");
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			System.out.println("After Connection");
			String query = "select first_name,last_name,u.user_id,b.bank_name,b.ifsc_code,account_name,email,mobile,address,DOB,gender,file_name,a.account_number from users as u inner join banks as b inner join account as a  where email=? and password=? and b.bank_id=u.bank_id";
			PreparedStatement pst = con.prepareStatement(query);
			System.out.println(email+"      emapasss            "+ password);
			pst.setString(1,email);
			pst.setString(2,password);
			System.out.println("After pst");
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				flag = true;
				firstName = rs.getString(1);
				lastName = rs.getString(2);
				userId = rs.getInt(3);
				bank = new Bank(rs.getString(4),rs.getString(5));
				accountName = rs.getString(6);
				email = rs.getString(7);
				mobile = rs.getString(8);
				address = rs.getString(9);
				dob = rs.getString(10);
				gender = rs.getString(11);
				fileName = rs.getString(12);
				account = new Account(rs.getString(13));
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		System.out.println(flag+"ABCGDJJBSDHBFHBSHBFSBJBJBZZZZZZZZZZZZZZZZZZZZZZ");
		return flag;
	}

	public static ArrayList<User> getEmailPassword(){
		ArrayList<User> al = new ArrayList<User>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			//String query = " select email,password,first_name,user_id,b.bank_name,b.ifsc_code,account_name,last_name,mobile,address,DOB,gender,s.status from users as u inner join banks as b inner join status as s where u.bank_id=b.bank_id and s.status_id=u.status_id";
			String query = "select email,password,first_name,u.user_id,b.bank_name,b.ifsc_code,account_name,last_name,mobile,address,DOB,gender,s.status,a.account_number,a.account_id from users as u inner join banks as b inner join status as s inner join account as a where u.bank_id=b.bank_id and s.status_id=u.status_id";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				al.add(new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),new Bank(rs.getString(5),rs.getString(6)),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),new Status(rs.getString(13)),new Account(rs.getString(14),rs.getInt(15))));
			}

		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return al;
	}

	public static boolean updateStatus(String email,String activationCode){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "update users set status_id=1 where email=? and activation_code=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,email);
			pst.setString(2,activationCode);

			if(pst.executeUpdate()==1){
				flag = true;
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;
	}
	

	public boolean saveUser(String activationCode){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "insert into users (bank_id,account_name,first_name,last_name,email,password,mobile,address,DOB,gender,file_name,activation_code) value(?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1,bank.getBankId());
			pst.setString(2,accountName);
			pst.setString(3,firstName);
			pst.setString(4,lastName);
			pst.setString(5,email);
			pst.setString(6,spe.encryptPassword(password));
			pst.setString(7,mobile);
			pst.setString(8,address);
			pst.setString(9,dob);
			pst.setString(10,gender);
			pst.setString(11,fileName);
			pst.setString(12,activationCode);

			if(pst.executeUpdate()==1){
				flag = true;
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()){
					this.userId = rs.getInt(1);
				}
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		return flag;
	}


/////////////////////////////////// Setters and Getters //////////////////////////////////////////////////////

	 public void setUserId(Integer userId){
        this.userId = userId;
    }

    public void setBank(Bank bank){
        this.bank = bank;
    }

    public void setAccountName(String accountName){
        this.accountName = accountName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setDOB(String dob){
        this.dob = dob;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

	public void setStatus(Status status){
		this.status = status;
	}

	public void setAccount(Account account){
		this.account = account;
	}

    public Integer getUserId(){
        return userId;
    }

    public Bank getBank(){
        return bank;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getMobile(){
        return mobile;
    }

    public String getAddress(){
        return address;
    }

    public String getDOB(){
        return dob;
    }

    public String getGender(){
        return gender;
    }

    public String getFileName(){
        return fileName;
    }

	public Status getStatus(){
		return status;
	}

	public Account getAccount(){
		return account;
	}
	
}