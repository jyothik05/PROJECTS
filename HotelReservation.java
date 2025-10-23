import java.util.*;

class Room {
    int roomNo;
    boolean isBooked;
    String customerName;

    Room(int roomNo) {
        this.roomNo = roomNo;
        this.isBooked = false;
        this.customerName = "";
    }
}

public class HotelReservation {
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) rooms.add(new Room(i));
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- HOTEL RESERVATION SYSTEM ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Show All Rooms");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> viewAvailable();
                case 2 -> bookRoom(sc);
                case 3 -> cancelRoom(sc);
                case 4 -> showAll();
                case 5 -> System.out.println("Thank you for using our system!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void viewAvailable() {
        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms)
            if (!r.isBooked) System.out.println("Room " + r.roomNo);
    }

    static void bookRoom(Scanner sc) {
        System.out.print("Enter room number to book: ");
        int num = sc.nextInt();
        for (Room r : rooms) {
            if (r.roomNo == num && !r.isBooked) {
                System.out.print("Enter your name: ");
                r.customerName = sc.next();
                r.isBooked = true;
                System.out.println("Room booked successfully!");
                return;
            }
        }
        System.out.println("Room not available or already booked!");
    }

    static void cancelRoom(Scanner sc) {
        System.out.print("Enter room number to cancel: ");
        int num = sc.nextInt();
        for (Room r : rooms) {
            if (r.roomNo == num && r.isBooked) {
                r.isBooked = false;
                r.customerName = "";
                System.out.println("Booking cancelled successfully!");
                return;
            }
        }
        System.out.println("No booking found for that room!");
    }

    static void showAll() {
        System.out.println("\nRoom Status:");
        for (Room r : rooms) {
            System.out.println("Room " + r.roomNo + " - " +
                    (r.isBooked ? "Booked by " + r.customerName : "Available"));
        }
    }
}
