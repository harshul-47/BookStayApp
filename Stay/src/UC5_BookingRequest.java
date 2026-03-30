import java.util.Scanner;

public class UC5_BookingRequest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BookingQueue bookingQueue = new BookingQueue();

        int choice;

        do {
            System.out.println("\n=== Hotel Booking Request System ===");
            System.out.println("1. Submit Booking Request");
            System.out.println("2. View Pending Requests");
            System.out.println("3. Process Next Request (simulate allocation)");
            System.out.println("4. Exit");
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

                    Reservation reservation = new Reservation(name, type, nights);
                    bookingQueue.addRequest(reservation);
                    break;

                case 2:
                    bookingQueue.displayQueue();
                    break;

                case 3:
                    Reservation next = bookingQueue.processNext();
                    if (next != null) {
                        System.out.println("Processing booking request: " + next);
                        System.out.println("Note: Inventory not updated yet.");
                    } else {
                        System.out.println("No pending requests to process.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        scanner.close();
    }
}