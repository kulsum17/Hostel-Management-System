package ui;

import dto.HostelDTO;
import service.HostelService;

import javax.swing.*;
import java.util.List;

public class HostelUI {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("Hostel Management System");

        frame.setSize(500, 400);
        frame.setLayout(null);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        HostelService service =
                new HostelService();

        JButton addBtn =
                new JButton("Add Student");

        addBtn.setBounds(150, 80, 200, 30);

        JButton viewBtn =
                new JButton("View Students");

        viewBtn.setBounds(150, 130, 200, 30);

        JButton deleteBtn =
                new JButton("Delete Student");

        deleteBtn.setBounds(150, 180, 200, 30);

        frame.add(addBtn);
        frame.add(viewBtn);
        frame.add(deleteBtn);

        frame.setVisible(true);

        addBtn.addActionListener(e -> {

            String name =
                    JOptionPane.showInputDialog(
                            "Student Name:"
                    );

            int room =
                    Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    "Room Number:"
                            )
                    );

            String block =
                    JOptionPane.showInputDialog(
                            "Block Name:"
                    );

            String status =
                    JOptionPane.showInputDialog(
                            "Status:"
                    );

            service.addStudent(
                    new HostelDTO(
                            0,
                            name,
                            room,
                            block,
                            status
                    )
            );

            JOptionPane.showMessageDialog(
                    null,
                    "Student Added!"
            );
        });

        viewBtn.addActionListener(e -> {

            List<HostelDTO> list =
                    service.getAllStudents();

            String[] cols = {
                    "ID",
                    "Student",
                    "Room",
                    "Block",
                    "Status"
            };

            String[][] data =
                    new String[list.size()][5];

            for (int i = 0; i < list.size(); i++) {

                HostelDTO s = list.get(i);

                data[i][0] =
                        String.valueOf(s.getId());

                data[i][1] =
                        s.getStudentName();

                data[i][2] =
                        String.valueOf(
                                s.getRoomNumber()
                        );

                data[i][3] =
                        s.getBlockName();

                data[i][4] =
                        s.getStatus();
            }

            JTable table =
                    new JTable(data, cols);

            JOptionPane.showMessageDialog(
                    null,
                    new JScrollPane(table)
            );
        });

        deleteBtn.addActionListener(e -> {

            int id =
                    Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    "Student ID:"
                            )
                    );

            service.deleteStudent(id);

            JOptionPane.showMessageDialog(
                    null,
                    "Deleted!"
            );
        });
    }
}
