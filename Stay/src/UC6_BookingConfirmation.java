import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UC6_BookingConfirmation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Initialize inventory (from UC3)
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Single", 5);
        inventory.addRoom("Double", 3);
        inventory.addRoom("Suite", 2);

        // Booking queue (from UC5)
        Queue<Reservation> bookingQueue = new LinkedList<>();

        // Booking service
        BookingService bookingService = new BookingService(inventory);

        int choice;
        do {
            System.out.println("\n=== Booking Confirmation System ===");
            System.out.println("1. Submit Booking Request");
            System.out.println("2. Process Next Booking");
            System.out.println("3. View Allocated Rooms");
            System.out.println("4. View Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Guest Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Room Type (Single/Double/Suite): ");
                    String type = scanner.nextLine();
                    System.out.print("Number of Nights: ");
                    int nights = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    bookingQueue.offer(new Reservation(name, type, nights));
                    System.out.println("Booking request queued for " + name);
                    break;

                case 2:
                    if (!bookingQueue.isEmpty()) {
                        Reservation next = bookingQueue.poll();
                        bookingService.confirmBooking(next);
                    } else {
                        System.out.println("No pending booking requests.");
                    }
                    break;

                case 3:
                    bookingService.displayAllocatedRooms();
                    break;

                case 4:
                    inventory.displayInventory();
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        scanner.close();
    }
}