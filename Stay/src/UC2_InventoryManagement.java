public class UC2_InventoryManagement {

    public static void main(String[] args) {

        // Create rooms
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Hardcoded availability variables for each room type (static availability)
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display info
        System.out.println("=== Hotel Room Types & Availability ===\n");

        single.displayRoomDetails();
        System.out.println("Available Rooms: " + singleAvailable);
        single.roomFeatures();

        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleAvailable);
        doubleRoom.roomFeatures();

        System.out.println();

        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteAvailable);
        suite.roomFeatures();

        System.out.println("\n=== End of Inventory ===");
    }
}