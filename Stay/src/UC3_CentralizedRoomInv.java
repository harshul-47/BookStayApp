import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Centralized Inventory Class
class RoomInventory {

    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    public void addRoom(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int change) {
        int current = inventory.getOrDefault(roomType, 0);

        if (current + change < 0) {
            System.out.println("Not enough rooms available!");
        } else {
            inventory.put(roomType, current + change);
        }
    }

    public void displayInventory() {
        System.out.println("\n=== Current Room Inventory ===");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " Rooms Available: " + entry.getValue());
        }
    }
}

// Main Class for UC3
public class UC3_CentralizedRoomInv {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Using Room classes defined elsewhere (in UC2)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();

        // Initialize inventory with room counts
        inventory.addRoom(single.getRoomType(), 5);
        inventory.addRoom(doubleRoom.getRoomType(), 3);
        inventory.addRoom(suite.getRoomType(), 2);

        int choice;

        do {
            System.out.println("\n=== Hotel Inventory System ===");
            System.out.println("1. View Room Details");
            System.out.println("2. Check Availability");
            System.out.println("3. Book Room");
            System.out.println("4. View All Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n1. Single\n2. Double\n3. Suite");
                    int typeChoice = scanner.nextInt();

                    Room selectedRoom = null;

                    if (typeChoice == 1) selectedRoom = single;
                    else if (typeChoice == 2) selectedRoom = doubleRoom;
                    else if (typeChoice == 3) selectedRoom = suite;

                    if (selectedRoom != null) {
                        selectedRoom.displayRoomDetails();
                        selectedRoom.roomFeatures();
                    } else {
                        System.out.println("Invalid selection!");
                    }
                    break;

                case 2:
                    System.out.print("Enter room type (Single/Double/Suite): ");
                    String checkType = scanner.next();
                    System.out.println("Available: " + inventory.getAvailability(checkType));
                    break;

                case 3:
                    System.out.print("Enter room type to book: ");
                    String bookType = scanner.next();
                    inventory.updateAvailability(bookType, -1);
                    System.out.println("Booking attempted.");
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