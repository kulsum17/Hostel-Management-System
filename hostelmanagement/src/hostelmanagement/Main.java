package hostelmanagement;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HostelController controller = new HostelController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add Room  2.View Rooms  3.Allocate Student");
            System.out.println("4.Vacate Room  5.Raise Complaint  6.View Complaints");
            System.out.println("7.Close Complaint  8.Exit");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    RoomDTO r = new RoomDTO();
                    System.out.print("Room Type: ");
                    r.setRoomType(sc.next());
                    System.out.print("Capacity: ");
                    r.setCapacity(sc.nextInt());
                    controller.addRoom(r);
                    break;

                case 2:
                    controller.getRooms().forEach(room ->
                        System.out.println(room.getRoomId() + " "
                                + room.getRoomType() + " "
                                + room.getOccupied() + "/"
                                + room.getCapacity()));
                    break;

                case 3:
                    System.out.print("Room ID: ");
                    controller.allocateStudent(sc.nextInt(), sc.next());
                    break;

                case 4:
                    controller.vacateRoom(sc.nextInt());
                    break;

                case 5:
                    MaintenanceDTO m = new MaintenanceDTO();
                    System.out.print("Room ID: ");
                    m.setRoomId(sc.nextInt());
                    System.out.print("Issue: ");
                    m.setIssue(sc.next());
                    controller.raiseComplaint(m);
                    break;

                case 6:
                    controller.getComplaints().forEach(c ->
                        System.out.println(c.getComplaintId() + " "
                                + c.getRoomId() + " "
                                + c.getIssue() + " "
                                + c.getStatus()));
                    break;

                case 7:
                    controller.closeComplaint(sc.nextInt());
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}
