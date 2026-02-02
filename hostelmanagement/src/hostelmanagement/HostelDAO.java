package hostelmanagement;



import java.util.List;

public interface HostelDAO {

    void addRoom(RoomDTO room);
    List<RoomDTO> getRooms();
    RoomDTO getRoomById(int roomId);

    void allocateStudent(int roomId, String studentName);
    void vacateRoom(int roomId);

    void raiseComplaint(MaintenanceDTO m);
    List<MaintenanceDTO> getComplaints();
    void closeComplaint(int complaintId);
}
