package hostelmanagement;



import java.sql.*;
import java.util.*;

public class HostelDAOImpl implements HostelDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/hostel";
    private static final String USER = "root";
    private static final String PASS = "#Kulsum786";

    public void addRoom(RoomDTO r) {
        String sql = "INSERT INTO rooms(room_type, capacity, occupied) VALUES(?,?,0)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, r.getRoomType());
            pst.setInt(2, r.getCapacity());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<RoomDTO> getRooms() {
        List<RoomDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM rooms";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                RoomDTO r = new RoomDTO();
                r.setRoomId(rs.getInt("room_id"));
                r.setRoomType(rs.getString("room_type"));
                r.setCapacity(rs.getInt("capacity"));
                r.setOccupied(rs.getInt("occupied"));
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public RoomDTO getRoomById(int roomId) {
        RoomDTO r = null;
        String sql = "SELECT * FROM rooms WHERE room_id=?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, roomId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                r = new RoomDTO();
                r.setRoomId(rs.getInt("room_id"));
                r.setCapacity(rs.getInt("capacity"));
                r.setOccupied(rs.getInt("occupied"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public void allocateStudent(int roomId, String name) {
        String insert = "INSERT INTO allocations(student_name, room_id) VALUES(?,?)";
        String update = "UPDATE rooms SET occupied = occupied + 1 WHERE room_id=?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            PreparedStatement pst1 = con.prepareStatement(insert);
            pst1.setString(1, name);
            pst1.setInt(2, roomId);
            pst1.executeUpdate();

            PreparedStatement pst2 = con.prepareStatement(update);
            pst2.setInt(1, roomId);
            pst2.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void vacateRoom(int roomId) {
        String update = "UPDATE rooms SET occupied = occupied - 1 WHERE room_id=?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(update)) {

            pst.setInt(1, roomId);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void raiseComplaint(MaintenanceDTO m) {
        String sql = "INSERT INTO maintenance(room_id, issue, status) VALUES(?, ?, 'OPEN')";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, m.getRoomId());
            pst.setString(2, m.getIssue());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MaintenanceDTO> getComplaints() {
        List<MaintenanceDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM maintenance";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                MaintenanceDTO m = new MaintenanceDTO();
                m.setComplaintId(rs.getInt("complaint_id"));
                m.setRoomId(rs.getInt("room_id"));
                m.setIssue(rs.getString("issue"));
                m.setStatus(rs.getString("status"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void closeComplaint(int id) {
        String sql = "UPDATE maintenance SET status='CLOSED' WHERE complaint_id=?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
