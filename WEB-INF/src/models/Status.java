package models;

public class Status{
	private Integer statusId;
	private String status;


///////////////////////////// Constructor /////////////////////////////////////////////

	public Status(){
	
	}

	public Status(String status){
		this.status = status;
	}



///////////////////////////// Setter and Getter ///////////////////////////////////////////

	public void setStatusId(Integer statusId){
		this.statusId = statusId;
	}

	public Integer getStatusId(){
		return statusId;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}