import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String STUDENTS_FILE = "students.dat";
    private static final String COMPANIES_FILE = "companies.dat";
    private static final String INTERNSHIPS_FILE = "internships.dat";
    private static final String APPLICATIONS_FILE = "applications.dat";
    private static final String PLACEMENTS_FILE = "placements.dat";
    
    // Student Operations
    public static void saveStudents(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(STUDENTS_FILE))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static List<Student> loadStudents() {
        File file = new File(STUDENTS_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(STUDENTS_FILE))) {
            return (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading students: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    // Company Operations
    public static void saveCompanies(List<Company> companies) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(COMPANIES_FILE))) {
            oos.writeObject(companies);
        } catch (IOException e) {
            System.out.println("Error saving companies: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static List<Company> loadCompanies() {
        File file = new File(COMPANIES_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(COMPANIES_FILE))) {
            return (List<Company>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading companies: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    // Internship Operations
    public static void saveInternships(List<Internship> internships) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(INTERNSHIPS_FILE))) {
            oos.writeObject(internships);
        } catch (IOException e) {
            System.out.println("Error saving internships: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static List<Internship> loadInternships() {
        File file = new File(INTERNSHIPS_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(INTERNSHIPS_FILE))) {
            return (List<Internship>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading internships: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    // Application Operations
    public static void saveApplications(List<Application> applications) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(APPLICATIONS_FILE))) {
            oos.writeObject(applications);
        } catch (IOException e) {
            System.out.println("Error saving applications: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static List<Application> loadApplications() {
        File file = new File(APPLICATIONS_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(APPLICATIONS_FILE))) {
            return (List<Application>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading applications: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    // Placement Operations
    public static void savePlacements(List<Placement> placements) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(PLACEMENTS_FILE))) {
            oos.writeObject(placements);
        } catch (IOException e) {
            System.out.println("Error saving placements: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static List<Placement> loadPlacements() {
        File file = new File(PLACEMENTS_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(PLACEMENTS_FILE))) {
            return (List<Placement>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading placements: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
