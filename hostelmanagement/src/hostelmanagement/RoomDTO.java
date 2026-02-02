package hostelmanagement;


	public class RoomDTO {

	    private int roomId;
	    private String roomType;
	    private int capacity;
	    private int occupied;

	    public int getRoomId() {
	        return roomId;
	    }
	    public void setRoomId(int roomId) {
	        this.roomId = roomId;
	    }

	    public String getRoomType() {
	        return roomType;
	    }
	    public void setRoomType(String roomType) {
	        this.roomType = roomType;
	    }

	    public int getCapacity() {
	        return capacity;
	    }
	    public void setCapacity(int capacity) {
	        this.capacity = capacity;
	    }

	    public int getOccupied() {
	        return occupied;
	    }
	    public void setOccupied(int occupied) {
	        this.occupied = occupied;
	    }
	

}
