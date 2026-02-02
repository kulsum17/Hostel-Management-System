package hostelmanagement;


import java.util.List;

public class HostelController {

    private HostelService service = new HostelService();

    public void addRoom(RoomDTO r) {
        service.addRoom(r);
    }

    public List<RoomDTO> getRooms() {
        return service.getRooms();
    }

    public void allocateStudent(int roomId, String name) {
        service.allocateStudent(roomId, name);
    }

    public void vacateRoom(int roomId) {
        service.vacateRoom(roomId);
    }

    public void raiseComplaint(MaintenanceDTO m) {
        service.raiseComplaint(m);
    }

    public List<MaintenanceDTO> getComplaints() {
        return service.getComplaints();
    }

    public void closeComplaint(int id) {
        service.closeComplaint(id);
    }
}
