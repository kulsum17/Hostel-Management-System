package dto;

public class HostelDTO {

    private int id;
    private String studentName;
    private int roomNumber;
    private String blockName;
    private String status;

    public HostelDTO() {}

    public HostelDTO(int id, String studentName,
                     int roomNumber,
                     String blockName,
                     String status) {

        this.id = id;
        this.studentName = studentName;
        this.roomNumber = roomNumber;
        this.blockName = blockName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }


    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
