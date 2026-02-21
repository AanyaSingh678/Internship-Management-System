import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class InternshipPlacementSystem {
    private static PlacementManager manager = new PlacementManager();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║   INTERNSHIP PLACEMENT MANAGEMENT SYSTEM          ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        
        while (true) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    companyMenu();
                    break;
                case 3:
                    internshipMenu();
                    break;
                case 4:
                    applicationMenu();
                    break;
                case 5:
                    placementMenu();
                    break;
                case 6:
                    displayStatistics();
                    break;
                case 0:
                    System.out.println("\nThank you for using the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("\n❌ Invalid choice! Please try again.");
            }
        }
    }
    
    private static void displayMainMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                  MAIN MENU");
        System.out.println("=".repeat(50));
        System.out.println("1. Student Management");
        System.out.println("2. Company Management");
        System.out.println("3. Internship Management");
        System.out.println("4. Application Management");
        System.out.println("5. Placement Management");
        System.out.println("6. View Statistics");
        System.out.println("0. Exit");
        System.out.println("=".repeat(50));
    }
    
    // ==================== STUDENT MENU ====================
    private static void studentMenu() {
        while (true) {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("              STUDENT MANAGEMENT");
            System.out.println("-".repeat(50));
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("0. Back to Main Menu");
            System.out.println("-".repeat(50));
            
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("\n❌ Invalid choice!");
            }
        }
    }
    
    private static void addStudent() {
        System.out.println("\n--- ADD NEW STUDENT ---");
        
        int id = manager.getNextStudentId();
        System.out.println("Student ID (Auto-generated): " + id);
        
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        
        System.out.print("Department: ");
        String department = scanner.nextLine();
        
        System.out.print("Course: ");
        String course = scanner.nextLine();
        
        int semester = getIntInput("Semester: ");
        
        System.out.print("CGPA: ");
        double cgpa = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        
        System.out.print("Skills (comma-separated): ");
        String skills = scanner.nextLine();
        
        System.out.print("Resume Path: ");
        String resume = scanner.nextLine();
        
        Student student = new Student(id, name, email, phone, department, 
                                     course, semester, cgpa, skills, resume);
        
        if (manager.addStudent(student)) {
            System.out.println("\n✅ Student added successfully! ID: " + id);
        } else {
            System.out.println("\n❌ Failed to add student!");
        }
    }
    
    private static void viewAllStudents() {
        List<Student> students = manager.getAllStudents();
        
        if (students.isEmpty()) {
            System.out.println("\n⚠️  No students found!");
            return;
        }
        
        System.out.println("\n" + "=".repeat(120));
        System.out.printf("%-5s %-20s %-25s %-15s %-15s %-10s %-6s %-6s%n",
                "ID", "Name", "Email", "Phone", "Department", "Course", "Sem", "CGPA");
        System.out.println("=".repeat(120));
        
        for (Student s : students) {
            System.out.printf("%-5d %-20s %-25s %-15s %-15s %-10s %-6d %.2f%n",
                    s.getStudentId(), s.getName(), s.getEmail(), s.getPhone(),
                    s.getDepartment(), s.getCourse(), s.getSemester(), s.getCgpa());
        }
        System.out.println("=".repeat(120));
    }
    
    private static void searchStudent() {
        int id = getIntInput("\nEnter Student ID: ");
        Student student = manager.findStudentById(id);
        
        if (student == null) {
            System.out.println("\n❌ Student not found!");
            return;
        }
        
        System.out.println("\n" + "-".repeat(50));
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Phone: " + student.getPhone());
        System.out.println("Department: " + student.getDepartment());
        System.out.println("Course: " + student.getCourse());
        System.out.println("Semester: " + student.getSemester());
        System.out.println("CGPA: " + student.getCgpa());
        System.out.println("Skills: " + student.getSkills());
        System.out.println("Resume: " + student.getResume());
        System.out.println("-".repeat(50));
    }
    
    private static void updateStudent() {
        int id = getIntInput("\nEnter Student ID to update: ");
        Student student = manager.findStudentById(id);
        
        if (student == null) {
            System.out.println("\n❌ Student not found!");
            return;
        }
        
        System.out.println("\nLeave blank to keep current value");
        
        System.out.print("Name [" + student.getName() + "]: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) student.setName(name);
        
        System.out.print("Email [" + student.getEmail() + "]: ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) student.setEmail(email);
        
        System.out.print("Phone [" + student.getPhone() + "]: ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) student.setPhone(phone);
        
        if (manager.updateStudent(student)) {
            System.out.println("\n✅ Student updated successfully!");
        } else {
            System.out.println("\n❌ Failed to update student!");
        }
    }
    
    private static void deleteStudent() {
        int id = getIntInput("\nEnter Student ID to delete: ");
        
        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("yes")) {
            if (manager.deleteStudent(id)) {
                System.out.println("\n✅ Student deleted successfully!");
            } else {
                System.out.println("\n❌ Student not found!");
            }
        } else {
            System.out.println("\n⚠️  Deletion cancelled.");
        }
    }
    
    // ==================== COMPANY MENU ====================
    private static void companyMenu() {
        while (true) {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("              COMPANY MANAGEMENT");
            System.out.println("-".repeat(50));
            System.out.println("1. Add New Company");
            System.out.println("2. View All Companies");
            System.out.println("3. Search Company by ID");
            System.out.println("0. Back to Main Menu");
            System.out.println("-".repeat(50));
            
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addCompany();
                    break;
                case 2:
                    viewAllCompanies();
                    break;
                case 3:
                    searchCompany();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("\n❌ Invalid choice!");
            }
        }
    }
    
    private static void addCompany() {
        System.out.println("\n--- ADD NEW COMPANY ---");
        
        int id = manager.getNextCompanyId();
        System.out.println("Company ID (Auto-generated): " + id);
        
        System.out.print("Company Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Location: ");
        String location = scanner.nextLine();
        
        System.out.print("Industry: ");
        String industry = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        
        System.out.print("Website: ");
        String website = scanner.nextLine();
        
        System.out.print("Description: ");
        String description = scanner.nextLine();
        
        Company company = new Company(id, name, location, industry, 
                                      email, phone, website, description);
        
        if (manager.addCompany(company)) {
            System.out.println("\n✅ Company added successfully! ID: " + id);
        } else {
            System.out.println("\n❌ Failed to add company!");
        }
    }
    
    private static void viewAllCompanies() {
        List<Company> companies = manager.getAllCompanies();
        
        if (companies.isEmpty()) {
            System.out.println("\n⚠️  No companies found!");
            return;
        }
        
        System.out.println("\n" + "=".repeat(100));
        System.out.printf("%-5s %-25s %-20s %-20s %-25s%n",
                "ID", "Company Name", "Location", "Industry", "Email");
        System.out.println("=".repeat(100));
        
        for (Company c : companies) {
            System.out.printf("%-5d %-25s %-20s %-20s %-25s%n",
                    c.getCompanyId(), c.getCompanyName(), c.getLocation(),
                    c.getIndustry(), c.getEmail());
        }
        System.out.println("=".repeat(100));
    }
    
    private static void searchCompany() {
        int id = getIntInput("\nEnter Company ID: ");
        Company company = manager.findCompanyById(id);
        
        if (company == null) {
            System.out.println("\n❌ Company not found!");
            return;
        }
        
        System.out.println("\n" + "-".repeat(50));
        System.out.println("Company ID: " + company.getCompanyId());
        System.out.println("Name: " + company.getCompanyName());
        System.out.println("Location: " + company.getLocation());
        System.out.println("Industry: " + company.getIndustry());
        System.out.println("Email: " + company.getEmail());
        System.out.println("Phone: " + company.getPhone());
        System.out.println("Website: " + company.getWebsite());
        System.out.println("Description: " + company.getDescription());
        System.out.println("-".repeat(50));
    }
    
    // ==================== INTERNSHIP MENU ====================
    private static void internshipMenu() {
        while (true) {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("              INTERNSHIP MANAGEMENT");
            System.out.println("-".repeat(50));
            System.out.println("1. Add New Internship");
            System.out.println("2. View All Internships");
            System.out.println("3. View Active Internships");
            System.out.println("4. Search Internship by ID");
            System.out.println("0. Back to Main Menu");
            System.out.println("-".repeat(50));
            
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addInternship();
                    break;
                case 2:
                    viewAllInternships();
                    break;
                case 3:
                    viewActiveInternships();
                    break;
                case 4:
                    searchInternship();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("\n❌ Invalid choice!");
            }
        }
    }
    
    private static void addInternship() {
        System.out.println("\n--- ADD NEW INTERNSHIP ---");
        
        int id = manager.getNextInternshipId();
        System.out.println("Internship ID (Auto-generated): " + id);
        
        int companyId = getIntInput("Company ID: ");
        Company company = manager.findCompanyById(companyId);
        if (company == null) {
            System.out.println("\n❌ Company not found!");
            return;
        }
        
        System.out.print("Title: ");
        String title = scanner.nextLine();
        
        System.out.print("Description: ");
        String description = scanner.nextLine();
        
        System.out.print("Duration (e.g., 3 months): ");
        String duration = scanner.nextLine();
        
        System.out.print("Location: ");
        String location = scanner.nextLine();
        
        System.out.print("Stipend: ");
        double stipend = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Eligibility Criteria: ");
        String eligibility = scanner.nextLine();
        
        System.out.print("Required Skills: ");
        String skills = scanner.nextLine();
        
        Date startDate = getDateInput("Start Date (dd-MM-yyyy): ");
        Date endDate = getDateInput("End Date (dd-MM-yyyy): ");
        Date deadline = getDateInput("Application Deadline (dd-MM-yyyy): ");
        
        int vacancies = getIntInput("Number of Vacancies: ");
        
        Internship internship = new Internship(id, companyId, title, description,
                duration, location, stipend, eligibility, skills,
                startDate, endDate, deadline, vacancies, "Active");
        
        if (manager.addInternship(internship)) {
            System.out.println("\n✅ Internship added successfully! ID: " + id);
        } else {
            System.out.println("\n❌ Failed to add internship!");
        }
    }
    
    private static void viewAllInternships() {
        List<Internship> internships = manager.getAllInternships();
        displayInternships(internships, "ALL INTERNSHIPS");
    }
    
    private static void viewActiveInternships() {
        List<Internship> internships = manager.getActiveInternships();
        displayInternships(internships, "ACTIVE INTERNSHIPS");
    }
    
    private static void displayInternships(List<Internship> internships, String title) {
        if (internships.isEmpty()) {
            System.out.println("\n⚠️  No internships found!");
            return;
        }
        
        System.out.println("\n" + "=".repeat(120));
        System.out.println("                          " + title);
        System.out.println("=".repeat(120));
        System.out.printf("%-5s %-30s %-20s %-15s %-10s %-10s %-10s%n",
                "ID", "Title", "Location", "Duration", "Stipend", "Vacancies", "Status");
        System.out.println("=".repeat(120));
        
        for (Internship i : internships) {
            Company company = manager.findCompanyById(i.getCompanyId());
            String companyName = company != null ? company.getCompanyName() : "Unknown";
            
            System.out.printf("%-5d %-30s %-20s %-15s ₹%-9.0f %-10d %-10s%n",
                    i.getInternshipId(), i.getTitle(), i.getLocation(),
                    i.getDuration(), i.getStipend(), i.getVacancies(), i.getStatus());
            System.out.println("      Company: " + companyName);
            System.out.println("      Skills: " + i.getRequiredSkills());
            System.out.println("      Deadline: " + dateFormat.format(i.getApplicationDeadline()));
            System.out.println("      " + "-".repeat(110));
        }
        System.out.println("=".repeat(120));
    }
    
    private static void searchInternship() {
        int id = getIntInput("\nEnter Internship ID: ");
        Internship internship = manager.findInternshipById(id);
        
        if (internship == null) {
            System.out.println("\n❌ Internship not found!");
            return;
        }
        
        Company company = manager.findCompanyById(internship.getCompanyId());
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Internship ID: " + internship.getInternshipId());
        System.out.println("Title: " + internship.getTitle());
        System.out.println("Company: " + (company != null ? company.getCompanyName() : "Unknown"));
        System.out.println("Description: " + internship.getDescription());
        System.out.println("Location: " + internship.getLocation());
        System.out.println("Duration: " + internship.getDuration());
        System.out.println("Stipend: ₹" + internship.getStipend());
        System.out.println("Eligibility: " + internship.getEligibilityCriteria());
        System.out.println("Required Skills: " + internship.getRequiredSkills());
        System.out.println("Start Date: " + dateFormat.format(internship.getStartDate()));
        System.out.println("End Date: " + dateFormat.format(internship.getEndDate()));
        System.out.println("Application Deadline: " + dateFormat.format(internship.getApplicationDeadline()));
        System.out.println("Vacancies: " + internship.getVacancies());
        System.out.println("Status: " + internship.getStatus());
        System.out.println("=".repeat(60));
    }
    
    // ==================== APPLICATION MENU ====================
    private static void applicationMenu() {
        while (true) {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("              APPLICATION MANAGEMENT");
            System.out.println("-".repeat(50));
            System.out.println("1. Apply for Internship");
            System.out.println("2. View Student Applications");
            System.out.println("3. View Internship Applications");
            System.out.println("4. Update Application Status");
            System.out.println("0. Back to Main Menu");
            System.out.println("-".repeat(50));
            
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    applyForInternship();
                    break;
                case 2:
                    viewStudentApplications();
                    break;
                case 3:
                    viewInternshipApplications();
                    break;
                case 4:
                    updateApplicationStatus();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("\n❌ Invalid choice!");
            }
        }
    }
    
    private static void applyForInternship() {
        System.out.println("\n--- APPLY FOR INTERNSHIP ---");
        
        int studentId = getIntInput("Student ID: ");
        Student student = manager.findStudentById(studentId);
        if (student == null) {
            System.out.println("\n❌ Student not found!");
            return;
        }
        
        int internshipId = getIntInput("Internship ID: ");
        Internship internship = manager.findInternshipById(internshipId);
        if (internship == null) {
            System.out.println("\n❌ Internship not found!");
            return;
        }
        
        System.out.print("Cover Letter: ");
        String coverLetter = scanner.nextLine();
        
        int appId = manager.getNextApplicationId();
        Application application = new Application(appId, studentId, internshipId,
                new Date(), "Pending", coverLetter);
        
        if (manager.applyForInternship(application)) {
            System.out.println("\n✅ Application submitted successfully! ID: " + appId);
        } else {
            System.out.println("\n❌ Already applied for this internship!");
        }
    }
    
    private static void viewStudentApplications() {
        int studentId = getIntInput("\nEnter Student ID: ");
        List<Application> applications = manager.getApplicationsByStudent(studentId);
        
        if (applications.isEmpty()) {
            System.out.println("\n⚠️  No applications found!");
            return;
        }
        
        System.out.println("\n" + "=".repeat(100));
        System.out.printf("%-8s %-30s %-20s %-15s%n",
                "App ID", "Internship", "Applied Date", "Status");
        System.out.println("=".repeat(100));
        
        for (Application app : applications) {
            Internship internship = manager.findInternshipById(app.getInternshipId());
            String title = internship != null ? internship.getTitle() : "Unknown";
            
            System.out.printf("%-8d %-30s %-20s %-15s%n",
                    app.getApplicationId(), title,
                    dateFormat.format(app.getApplicationDate()),
                    app.getStatus());
        }
        System.out.println("=".repeat(100));
    }
    
    private static void viewInternshipApplications() {
        int internshipId = getIntInput("\nEnter Internship ID: ");
        List<Application> applications = manager.getApplicationsByInternship(internshipId);
        
        if (applications.isEmpty()) {
            System.out.println("\n⚠️  No applications found!");
            return;
        }
        
        System.out.println("\n" + "=".repeat(100));
        System.out.printf("%-8s %-20s %-25s %-20s %-15s%n",
                "App ID", "Student Name", "Email", "Applied Date", "Status");
        System.out.println("=".repeat(100));
        
        for (Application app : applications) {
            Student student = manager.findStudentById(app.getStudentId());
            String name = student != null ? student.getName() : "Unknown";
            String email = student != null ? student.getEmail() : "Unknown";
            
            System.out.printf("%-8d %-20s %-25s %-20s %-15s%n",
                    app.getApplicationId(), name, email,
                    dateFormat.format(app.getApplicationDate()),
                    app.getStatus());
        }
        System.out.println("=".repeat(100));
    }
    
    private static void updateApplicationStatus() {
        int appId = getIntInput("\nEnter Application ID: ");
        
        System.out.println("\nStatus Options:");
        System.out.println("1. Pending");
        System.out.println("2. Shortlisted");
        System.out.println("3. Rejected");
        System.out.println("4. Selected");
        
        int statusChoice = getIntInput("Select status: ");
        String status = switch (statusChoice) {
            case 1 -> "Pending";
            case 2 -> "Shortlisted";
            case 3 -> "Rejected";
            case 4 -> "Selected";
            default -> "Pending";
        };
        
        if (manager.updateApplicationStatus(appId, status)) {
            System.out.println("\n✅ Application status updated to: " + status);
        } else {
            System.out.println("\n❌ Application not found!");
        }
    }
    
    // ==================== PLACEMENT MENU ====================
    private static void placementMenu() {
        while (true) {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("              PLACEMENT MANAGEMENT");
            System.out.println("-".repeat(50));
            System.out.println("1. Add Placement Record");
            System.out.println("2. View All Placements");
            System.out.println("3. View Student Placements");
            System.out.println("4. View Company Placements");
            System.out.println("0. Back to Main Menu");
            System.out.println("-".repeat(50));
            
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addPlacement();
                    break;
                case 2:
                    viewAllPlacements();
                    break;
                case 3:
                    viewStudentPlacements();
                    break;
                case 4:
                    viewCompanyPlacements();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("\n❌ Invalid choice!");
            }
        }
    }
    
    private static void addPlacement() {
        System.out.println("\n--- ADD PLACEMENT RECORD ---");
        
        int studentId = getIntInput("Student ID: ");
        Student student = manager.findStudentById(studentId);
        if (student == null) {
            System.out.println("\n❌ Student not found!");
            return;
        }
        
        int internshipId = getIntInput("Internship ID: ");
        Internship internship = manager.findInternshipById(internshipId);
        if (internship == null) {
            System.out.println("\n❌ Internship not found!");
            return;
        }
        
        Date joiningDate = getDateInput("Joining Date (dd-MM-yyyy): ");
        
        int placementId = manager.getNextPlacementId();
        Placement placement = new Placement(placementId, studentId, internshipId,
                internship.getCompanyId(), new Date(), joiningDate);
        
        if (manager.addPlacement(placement)) {
            System.out.println("\n✅ Placement record added successfully! ID: " + placementId);
        } else {
            System.out.println("\n❌ Failed to add placement!");
        }
    }
    
    private static void viewAllPlacements() {
        List<Placement> placements = manager.getAllPlacements();
        
        if (placements.isEmpty()) {
            System.out.println("\n⚠️  No placements found!");
            return;
        }
        
        System.out.println("\n" + "=".repeat(110));
        System.out.printf("%-8s %-20s %-25s %-30s %-20s%n",
                "ID", "Student", "Company", "Internship", "Joining Date");
        System.out.println("=".repeat(110));
        
        for (Placement p : placements) {
            Student student = manager.findStudentById(p.getStudentId());
            Company company = manager.findCompanyById(p.getCompanyId());
            Internship internship = manager.findInternshipById(p.getInternshipId());
            
            String studentName = student != null ? student.getName() : "Unknown";
            String companyName = company != null ? company.getCompanyName() : "Unknown";
            String internshipTitle = internship != null ? internship.getTitle() : "Unknown";
            
            System.out.printf("%-8d %-20s %-25s %-30s %-20s%n",
                    p.getPlacementId(), studentName, companyName, internshipTitle,
                    dateFormat.format(p.getJoiningDate()));
        }
        System.out.println("=".repeat(110));
    }
    
    private static void viewStudentPlacements() {
        int studentId = getIntInput("\nEnter Student ID: ");
        List<Placement> placements = manager.getPlacementsByStudent(studentId);
        
        if (placements.isEmpty()) {
            System.out.println("\n⚠️  No placements found for this student!");
            return;
        }
        
        Student student = manager.findStudentById(studentId);
        System.out.println("\nPlacements for: " + (student != null ? student.getName() : "Unknown"));
        
        for (Placement p : placements) {
            Company company = manager.findCompanyById(p.getCompanyId());
            Internship internship = manager.findInternshipById(p.getInternshipId());
            
            System.out.println("\n" + "-".repeat(60));
            System.out.println("Placement ID: " + p.getPlacementId());
            System.out.println("Company: " + (company != null ? company.getCompanyName() : "Unknown"));
            System.out.println("Internship: " + (internship != null ? internship.getTitle() : "Unknown"));
            System.out.println("Joining Date: " + dateFormat.format(p.getJoiningDate()));
            System.out.println("-".repeat(60));
        }
    }
    
    private static void viewCompanyPlacements() {
        int companyId = getIntInput("\nEnter Company ID: ");
        List<Placement> placements = manager.getPlacementsByCompany(companyId);
        
        if (placements.isEmpty()) {
            System.out.println("\n⚠️  No placements found for this company!");
            return;
        }
        
        Company company = manager.findCompanyById(companyId);
        System.out.println("\nPlacements at: " + (company != null ? company.getCompanyName() : "Unknown"));
        
        System.out.println("\n" + "=".repeat(80));
        System.out.printf("%-8s %-25s %-30s %-20s%n",
                "ID", "Student", "Internship", "Joining Date");
        System.out.println("=".repeat(80));
        
        for (Placement p : placements) {
            Student student = manager.findStudentById(p.getStudentId());
            Internship internship = manager.findInternshipById(p.getInternshipId());
            
            String studentName = student != null ? student.getName() : "Unknown";
            String internshipTitle = internship != null ? internship.getTitle() : "Unknown";
            
            System.out.printf("%-8d %-25s %-30s %-20s%n",
                    p.getPlacementId(), studentName, internshipTitle,
                    dateFormat.format(p.getJoiningDate()));
        }
        System.out.println("=".repeat(80));
    }
    
    // ==================== STATISTICS ====================
    private static void displayStatistics() {
        Map<String, Integer> stats = manager.getPlacementStatistics();
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("              SYSTEM STATISTICS");
        System.out.println("=".repeat(50));
        System.out.println("Total Students: " + stats.get("totalStudents"));
        System.out.println("Total Companies: " + stats.get("totalCompanies"));
        System.out.println("Total Internships: " + stats.get("totalInternships"));
        System.out.println("Active Internships: " + stats.get("activeInternships"));
        System.out.println("Total Applications: " + stats.get("totalApplications"));
        System.out.println("Total Placements: " + stats.get("totalPlacements"));
        System.out.println("=".repeat(50));
        
        if (stats.get("totalStudents") > 0) {
            double placementRate = (stats.get("totalPlacements") * 100.0) / stats.get("totalStudents");
            System.out.printf("Placement Rate: %.2f%%%n", placementRate);
        }
        System.out.println("=".repeat(50));
    }
    
    // ==================== UTILITY METHODS ====================
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine(); // consume newline
                return value;
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter a number.");
                scanner.nextLine(); // clear buffer
            }
        }
    }
    
    private static Date getDateInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String dateStr = scanner.nextLine();
                return dateFormat.parse(dateStr);
            } catch (ParseException e) {
                System.out.println("❌ Invalid date format! Use dd-MM-yyyy");
            }
        }
    }
}
