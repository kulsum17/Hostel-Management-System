package hostelmanagement;


	public class MaintenanceDTO {

	    private int complaintId;
	    private int roomId;
	    private String issue;
	    private String status;

	    public int getComplaintId() {
	        return complaintId;
	    }
	    public void setComplaintId(int complaintId) {
	        this.complaintId = complaintId;
	    }

	    public int getRoomId() {
	        return roomId;
	    }
	    public void setRoomId(int roomId) {
	        this.roomId = roomId;
	    }

	    public String getIssue() {
	        return issue;
	    }
	    public void setIssue(String issue) {
	        this.issue = issue;
	    }

	    public String getStatus() {
	        return status;
	    }
	    public void setStatus(String status) {
	        this.status = status;
	    }
	
}
