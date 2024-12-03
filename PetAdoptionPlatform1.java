import java.util.ArrayList;
import java.util.Scanner;

// Main class
public class PetAdoptionPlatform1 {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Pet> pets = new ArrayList<>();
    static ArrayList<AdoptionApplication> applications = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Pet Adoption Platform!");

        // Admin, Shelter Adopter 
        users.add(new User("admin", "admin@example.com", "Admin"));
        users.add(new User("shelter", "shelter@example.com", "Shelter"));
        users.add(new User("adopter", "adopter@example.com", "Adopter"));

        boolean running = true;
        while (running) {
            System.out.println("\n1. Login\n2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Goodbye!");
    }

    // Login method
    public static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        User user = findUserByUsername(username);

        if (user != null) {
            if (user.role.equalsIgnoreCase("Admin")) {
                adminDashboard();
            } else if (user.role.equalsIgnoreCase("Shelter")) {
                shelterDashboard();
            } else if (user.role.equalsIgnoreCase("Adopter")) {
                adopterDashboard();
            } else {
                System.out.println("Invalid role.");
            }
        } else {
            System.out.println("User not found.");
        }
    }

    // Admin Dashboard
    public static void adminDashboard() {
        System.out.println("\n--- Admin Dashboard ---");
        boolean running = true;
        while (running) {
            System.out.println("\n1. Manage Users\n2. Manage Pet Listings\n3. System Settings\n4. View Analytics\n5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    manageUsers();
                    break;
                case 2:
                    managePetListings();
                    break;
                case 3:
                    systemSettings();
                    break;
                case 4:
                    viewAnalytics();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Shelter Dashboard
    public static void shelterDashboard() {
        System.out.println("\n--- Shelter Dashboard ---");
        boolean running = true;
        while (running) {
            System.out.println("\n1. List Pet\n2. Manage Applications\n3. Communicate with Adopters\n4. View Adoption Statistics\n5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listPet();
                    break;
                case 2:
                    manageApplications();
                    break;
                case 3:
                    communicateWithAdopters();
                    break;
                case 4:
                    viewAdoptionStatistics();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Adopter Dashboard
    public static void adopterDashboard() {
        System.out.println("\n--- Adopter Dashboard ---");
        boolean running = true;
        while (running) {
            System.out.println("\n1. Browse Pets\n2. Apply for Adoption\n3. Track Application Status\n4. Manage Profile\n5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    browsePets();
                    break;
                case 2:
                    applyForAdoption();
                    break;
                case 3:
                    trackApplicationStatus();
                    break;
                case 4:
                    manageProfile();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Admin functionalities
    public static void manageUsers() {
        System.out.println("Managing users... (functionality to be implemented)");
        // Example of adding a user
        System.out.print("Enter new user name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter role (Admin/Shelter/Adopter): ");
        String role = scanner.nextLine();
        users.add(new User(name, email, role));
        System.out.println("User added successfully.");
    }

    public static void managePetListings() {
        System.out.println("Managing pet listings... (functionality to be implemented)");
    }

    public static void systemSettings() {
        System.out.println("Updating system settings... (functionality to be implemented)");
    }

    public static void viewAnalytics() {
        System.out.println("Viewing analytics... (functionality to be implemented)");
    }

    // Shelter functionalities
    public static void listPet() {
        System.out.println("Listing a pet... (functionality to be implemented)");
    }

    public static void manageApplications() {
        System.out.println("Managing applications... (functionality to be implemented)");
    }

    public static void communicateWithAdopters() {
        System.out.println("Communicating with adopters... (functionality to be implemented)");
    }

    public static void viewAdoptionStatistics() {
        System.out.println("Viewing adoption statistics... (functionality to be implemented)");
    }

    // Adopter functionalities
    public static void browsePets() {
        System.out.println("Browsing pets... (functionality to be implemented)");
    }

    public static void applyForAdoption() {
        System.out.println("Applying for adoption... (functionality to be implemented)");
    }

    public static void trackApplicationStatus() {
        System.out.println("Tracking application status... (functionality to be implemented)");
    }

    public static void manageProfile() {
        System.out.println("Managing profile... (functionality to be implemented)");
    }

    // Helper method 
    public static User findUserByUsername(String username) {
        for (User user : users) {
            if (user.username.equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }
}

// User class
class User {
    String username;
    String email;
    String role;

    User(String username, String email, String role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }
}

// Pet class
class Pet {
    String name;
    String type;
    String description;
    String status;

    Pet(String name, String type, String description, String status) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.status = status;
    }
}

// AdoptionApplication class
class AdoptionApplication {
    String adopterName;
    String petName;
    String status;

    AdoptionApplication(String adopterName, String petName, String status) {
        this.adopterName = adopterName;
        this.petName = petName;
        this.status = status;
    }
}
