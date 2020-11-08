package models;

import java.sql.*;

import java.util.ArrayList;


public class Pending {
    private Bank bank;
	private Integer pendingId;
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
	private String activationCode;

	private String bankName;
	private String IFSCCode;
	private Integer id;

///////////////////////// Constructors //////////////////////////////////////////////////////

	public Pending(){
	
	}

	public Pending(Integer pendingId){
		this.pendingId = pendingId;
	}

	public Pending(Bank bank){
		this.bank = bank;
	}

	public Pending(Bank bank,Integer pendingId,String accountName,String firstName,String lastName,String email,String password,String mobile,String address,String dob,String gender){
		this.bank = bank;
		this.pendingId = pendingId;
		this.accountName = accountName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
	}




////////////////////////// Methods ///////////////////////////////////////////////////////////

	public static boolean delete(int pendingId){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "delete from pendings where pending_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,pendingId);
			if(pst.executeUpdate()==1){
				flag = true;
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}

		return flag;
	} 


	public boolean getUser(Integer bankId,String email){
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "select b.bank_id,b.bank_name,b.ifsc_code,account_name,first_name,last_name,password,mobile,address,DOB,gender,file_name,pending_id,activation_code from pendings as p inner join banks as b where b.bank_id=p.bank_id and email=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,email);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				flag = true;
				System.out.println(rs.getString(1)+"#####################");
				System.out.println(rs.getString(2)+"#####################");
				System.out.println(rs.getString(3)+"#####################");
				//new Pending().setBank(new Bank(rs.getInt(1),rs.getString(2),rs.getString(3)));
				//new Pending().setBank(new Bank(rs.getInt(1)));
				id = rs.getInt(1);
				bankName = rs.getString(2);
				IFSCCode = rs.getString(3);
				accountName = rs.getString(4);
				firstName = rs.getString(5);
				lastName = rs.getString(6);
				this.email = email;
				password = rs.getString(7);
				mobile = rs.getString(8);
				address = rs.getString(9);
				dob = rs.getString(10);
				gender = rs.getString(11);
				fileName = rs.getString(12);
				pendingId = rs.getInt(13);
				activationCode = rs.getString(14);
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;
	}


	public static ArrayList getAllUsers(){
		ArrayList al = new ArrayList();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "select p.bank_id,b.bank_name,b.ifsc_code,pending_id,account_name,first_name,last_name,email,password,mobile,address,DOB,gender from pendings as p inner "+
				"join banks as b where p.bank_id=b.bank_id";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				al.add(new Pending(new Bank(rs.getInt(1),rs.getString(2),rs.getString(3)),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)));
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}

		return al;
	}

	public boolean saveData(String activationCode){
		boolean flag = false;
		int id = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "insert into pendings(bank_id,account_name,first_name,last_name,email,password,mobile,address,gender,DOB,file_name,activation_code) value(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1,bank.getBankId());
			pst.setString(2,accountName);
			pst.setString(3,firstName);
			pst.setString(4,lastName);
			pst.setString(5,email);
			pst.setString(6,password);
			pst.setString(7,mobile);
			pst.setString(8,address);
			pst.setString(9,gender);
			pst.setString(10,dob);
			pst.setString(11,fileName);
			pst.setString(12,activationCode);
			int i = pst.executeUpdate();
			if(i==1){
				flag = true;
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()){
					System.out.println(rs.getInt(1)+ "############");
					id = rs.getInt(1);
				}
				
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;
	}


/////////////////////////// Setters and Getters //////////////////////////////////////////////////

    public void setBank(Bank bank) {
        this.bank = bank;
    }

	public void setPendingId(Integer pendingId){
		this.pendingId = pendingId;
	}

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	public void setDOB(String dob){
		this.dob = dob;
	}

    public void setGender(String gender) {
        this.gender = gender;
    }

	public void setBankName(String bankName){
		this.bankName = bankName;
	}

	public void setFileName(String fileName){
		this.fileName = fileName;
	}

	public void setIFSCCode(String IFSCCode){
		this.IFSCCode = IFSCCode;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public void setActivationCode(String activationCode){
		this.activationCode = activationCode;
	}

    public Bank getBank() {
        return bank;
    }

	public Integer getPendingId(){
		return pendingId;
	}

    public String getAccountName() {
        return accountName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

	public String getDOB(){
		return dob;
	}

    public String getGender() {
        return gender;
    }

	public String getBankName(){
		return bankName;
	}

	public String getFileName(){
		return fileName;
	}

	public String getIFSCCode(){
		return IFSCCode;
	}

	public Integer getId(){
		return id;
	}

	public String getActivationCode(){
		return activationCode;
	}

   
}
