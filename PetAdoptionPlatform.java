import java.sql.*;
import java.util.Scanner;

public class PetAdoptionPlatform {
    private static final String URL = "jdbc:mysql://localhost:3306/pet_adoption";
    private static final String USER = "root"; // MySQL username
    private static final String PASSWORD = "your_password"; // MySQL password

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(conn);
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to the Pet Adoption Platform!");
            System.out.println("1. Add Pet");
            System.out.println("2. View All Pets");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                addPet(conn, scanner);
            } else if (choice == 2) {
                viewAllPets(conn);
            } else {
                System.out.println("Invalid choice!");
            }
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Pets ("
                              + "id INT PRIMARY KEY AUTO_INCREMENT, "
                              + "name VARCHAR(50), "
                              + "breed VARCHAR(50), "
                              + "age INT, "
                              + "isAvailable BOOLEAN DEFAULT true)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Pets table is ready.");
        }
    }

    private static void addPet(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter pet name: ");
        String name = scanner.next();
        System.out.print("Enter pet breed: ");
        String breed = scanner.next();
        System.out.print("Enter pet age: ");
        int age = scanner.nextInt();
        System.out.print("Is the pet available for adoption? (true/false): ");
        boolean isAvailable = scanner.nextBoolean();

        String insertSQL = "INSERT INTO Pets (name, breed, age, isAvailable) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, name);
            pstmt.setString(2, breed);
            pstmt.setInt(3, age);
            pstmt.setBoolean(4, isAvailable);
            pstmt.executeUpdate();
            System.out.println("Pet added successfully.");
        }
    }

    private static void viewAllPets(Connection conn) throws SQLException {
        String selectSQL = "SELECT * FROM Pets";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(selectSQL)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                                 + ", Name: " + rs.getString("name")
                                 + ", Breed: " + rs.getString("breed")
                                 + ", Age: " + rs.getInt("age")
                                 + ", Available: " + rs.getBoolean("isAvailable"));
            }
        }
    }
}
