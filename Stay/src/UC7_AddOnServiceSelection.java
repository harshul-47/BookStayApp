import java.util.Scanner;

public class UC7_AddOnServiceSelection {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddOnServiceManager serviceManager = new AddOnServiceManager();

        // Example services
        Service breakfast = new Service("Breakfast", 500);
        Service spa = new Service("Spa Access", 1500);
        Service airport = new Service("Airport Pickup", 800);

        String[] availableServices = {"Breakfast", "Spa Access", "Airport Pickup"};

        int choice;
        do {
            System.out.println("\n=== Add-On Service Selection ===");
            System.out.println("1. Add Service to Reservation");
            System.out.println("2. View Services for Reservation");
            System.out.println("3. View All Services");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Reservation ID: ");
                    String resID = scanner.nextLine();

                    System.out.println("Select Service:");
                    System.out.println("1. Breakfast (₹500)");
                    System.out.println("2. Spa Access (₹1500)");
                    System.out.println("3. Airport Pickup (₹800)");
                    int serviceChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    Service selectedService = null;
                    if (serviceChoice == 1) selectedService = breakfast;
                    else if (serviceChoice == 2) selectedService = spa;
                    else if (serviceChoice == 3) selectedService = airport;

                    if (selectedService != null) {
                        serviceManager.addService(resID, selectedService);
                    } else {
                        System.out.println("Invalid service choice!");
                    }
                    break;

                case 2:
                    System.out.print("Reservation ID: ");
                    String viewResID = scanner.nextLine();
                    System.out.println("Services: " + serviceManager.getServices(viewResID));
                    System.out.println("Total Add-On Cost: ₹" + serviceManager.getTotalCost(viewResID));
                    break;

                case 3:
                    serviceManager.displayAllServices();
                    break;

                case 4:
                    System.out.println("Exiting add-on service selection...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        scanner.close();
    }
}