import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UC4_RoomSearch {

    public static void main(String[] args) {

        // Room domain objects (from UC2)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        List<Room> rooms = Arrays.asList(single, doubleRoom, suite);

        // Centralized inventory (from UC3)
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom(single.getRoomType(), 5);
        inventory.addRoom(doubleRoom.getRoomType(), 0); // simulate zero availability
        inventory.addRoom(suite.getRoomType(), 2);

        // Search service
        RoomSearchService searchService = new RoomSearchService(inventory);

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Guest Room Search ===");
        System.out.println("Press Enter to view available rooms...");
        scanner.nextLine();

        searchService.displayAvailableRooms(rooms);

        scanner.close();
    }
}