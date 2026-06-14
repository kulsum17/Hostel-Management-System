import dto.HostelDTO;
import service.HostelService;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        HostelService service =
                new HostelService();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1.Add Student");
            System.out.println("2.Get Student");
            System.out.println("3.View All");
            System.out.println("4.Update");
            System.out.println("5.Delete");
            System.out.println("6.Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Name: ");
                    String name = sc.next();

                    System.out.print("Room: ");
                    int room = sc.nextInt();

                    System.out.print("Block: ");
                    String block = sc.next();

                    System.out.print("Status: ");
                    String status = sc.next();

                    service.addStudent(
                            new HostelDTO(
                                    0,
                                    name,
                                    room,
                                    block,
                                    status
                            )
                    );

                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
