package dao;

import dto.HostelDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HostelDAOImpl implements HostelDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/rnsitdb";

    private static final String USER = "root";
    private static final String PASS = "YOUR_PASSWORD";

    @Override
    public void addStudent(HostelDTO student) {

        try {

            Connection con =
                    DriverManager.getConnection(URL, USER, PASS);

            String sql =
                    "INSERT INTO hostel_students(student_name, room_number, block_name, status) VALUES (?, ?, ?, ?)";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setString(1, student.getStudentName());
            pst.setInt(2, student.getRoomNumber());
            pst.setString(3, student.getBlockName());
            pst.setString(4, student.getStatus());

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public HostelDTO getStudentById(int id) {

        HostelDTO student = null;

        try {

            Connection con =
                    DriverManager.getConnection(URL, USER, PASS);

            String sql =
                    "SELECT * FROM hostel_students WHERE id=?";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                student = new HostelDTO(
                        rs.getInt("id"),
                        rs.getString("student_name"),
                        rs.getInt("room_number"),
                        rs.getString("block_name"),
                        rs.getString("status")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public List<HostelDTO> getAllStudents() {

        List<HostelDTO> list = new ArrayList<>();

        try {

            Connection con =
                    DriverManager.getConnection(URL, USER, PASS);

            String sql =
                    "SELECT * FROM hostel_students";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                list.add(
                        new HostelDTO(
                                rs.getInt("id"),
                                rs.getString("student_name"),
                                rs.getInt("room_number"),
                                rs.getString("block_name"),
                                rs.getString("status")
                        )
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void updateStudent(HostelDTO student) {

        try {

            Connection con =
                    DriverManager.getConnection(URL, USER, PASS);

            String sql =
                    "UPDATE hostel_students SET student_name=?, room_number=?, block_name=?, status=? WHERE id=?";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setString(1, student.getStudentName());
            pst.setInt(2, student.getRoomNumber());
            pst.setString(3, student.getBlockName());
            pst.setString(4, student.getStatus());
            pst.setInt(5, student.getId());

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {

        try {

            Connection con =
                    DriverManager.getConnection(URL, USER, PASS);

            String sql =
                    "DELETE FROM hostel_students WHERE id=?";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setInt(1, id);

            pst.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
