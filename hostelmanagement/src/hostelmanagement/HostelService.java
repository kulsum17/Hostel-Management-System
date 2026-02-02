package hostelmanagement;


import java.util.List;

public class HostelService {

    private HostelDAO dao = new HostelDAOImpl();

    public void addRoom(RoomDTO r) {
        dao.addRoom(r);
    }

    public List<RoomDTO> getRooms() {
        return dao.getRooms();
    }

    public void allocateStudent(int roomId, String name) {

        RoomDTO r = dao.getRoomById(roomId);

        if (r == null) {
            System.out.println("Room not found");
            return;
        }

        if (r.getOccupied() >= r.getCapacity()) {
            System.out.println("Room is already full!");
            return;
        }

        dao.allocateStudent(roomId, name);
        System.out.println("Student allocated successfully");
    }

    public void vacateRoom(int roomId) {
        dao.vacateRoom(roomId);
    }

    public void raiseComplaint(MaintenanceDTO m) {
        dao.raiseComplaint(m);
    }

    public List<MaintenanceDTO> getComplaints() {
        return dao.getComplaints();
    }

    public void closeComplaint(int id) {
        dao.closeComplaint(id);
    }
}
