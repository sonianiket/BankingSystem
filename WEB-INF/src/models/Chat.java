package models;

import java.sql.*;

import java.util.Date;

public class Chat{
	private Integer chatId;
	private String receiveChat;
	private Timestamp receiveTime;
	private String sendChat;
	private Timestamp sendTime;

///////////////////////////// Methods ///////////////////////////////
	
	public void getMsg(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = "select chat_id,receive_chat,receive_time,send_chat,send_time from chats";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				this.chatId = rs.getInt(1);
				this.receiveChat = rs.getString(2);
				this.receiveTime = rs.getTimestamp(3);
				this.sendChat = rs.getString(4);
				this.sendTime = rs.getTimestamp(5);
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
	}


	public boolean saveMsg(String message,int id){
		boolean flag = false;
		System.out.println(id+"idddiddiddiddiddiddiddiddiddidd");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management?user=root&password=root");
			String query = null;
			if(id!=0){
				query = "insert into chats(receive_chat,receive_time) value(?,?)";
			}else{
				query = "update chats set send_chat=? and send_time=? where chat_id=1";	
			}
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,message);
			pst.setTimestamp(2,new Timestamp(new Date().getTime()));
			if(pst.executeUpdate()==1){
				flag = true;
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		return flag;
	}

///////////////////////////// Setters and Getters ///////////////////////////////

	public void setChatId(Integer chatId){
		this.chatId = chatId;
	}

	public Integer getChatId(){
		return chatId;	
	}

	public void setReceiveChat(String receiveChat){
		this.receiveChat = receiveChat;
	}

	public String getReceiveChat(){
		return receiveChat;
	}

	public void setReceiveTime(Timestamp receiveTime){
		this.receiveTime = receiveTime;
	}

	public Timestamp getReceiveTime(){
		return receiveTime;
	}

	public void setSendChat(String sendChat){
		this.sendChat = sendChat;
	}

	public String getSendChat(){
		return sendChat;
	}

	public void setSendTime(Timestamp sendTime){
		this.sendTime = sendTime;
	}

	public Timestamp getSendTime(){
		return sendTime;
	}
}