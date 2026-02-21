import java.util.*;
import java.util.stream.Collectors;

public class PlacementManager {
    private List<Student> students;
    private List<Company> companies;
    private List<Internship> internships;
    private List<Application> applications;
    private List<Placement> placements;
    
    public PlacementManager() {
        loadAllData();
    }
    
    private void loadAllData() {
        students = FileManager.loadStudents();
        companies = FileManager.loadCompanies();
        internships = FileManager.loadInternships();
        applications = FileManager.loadApplications();
        placements = FileManager.loadPlacements();
    }
    
    private void saveAllData() {
        FileManager.saveStudents(students);
        FileManager.saveCompanies(companies);
        FileManager.saveInternships(internships);
        FileManager.saveApplications(applications);
        FileManager.savePlacements(placements);
    }
    
    // Student Operations
    public boolean addStudent(Student student) {
        if (findStudentById(student.getStudentId()) != null) {
            return false;
        }
        students.add(student);
        FileManager.saveStudents(students);
        return true;
    }
    
    public Student findStudentById(int studentId) {
        return students.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst()
                .orElse(null);
    }
    
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
    
    public boolean updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == student.getStudentId()) {
                students.set(i, student);
                FileManager.saveStudents(students);
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteStudent(int studentId) {
        boolean removed = students.removeIf(s -> s.getStudentId() == studentId);
        if (removed) {
            FileManager.saveStudents(students);
        }
        return removed;
    }
    
    // Company Operations
    public boolean addCompany(Company company) {
        if (findCompanyById(company.getCompanyId()) != null) {
            return false;
        }
        companies.add(company);
        FileManager.saveCompanies(companies);
        return true;
    }
    
    public Company findCompanyById(int companyId) {
        return companies.stream()
                .filter(c -> c.getCompanyId() == companyId)
                .findFirst()
                .orElse(null);
    }
    
    public List<Company> getAllCompanies() {
        return new ArrayList<>(companies);
    }
    
    // Internship Operations
    public boolean addInternship(Internship internship) {
        if (findInternshipById(internship.getInternshipId()) != null) {
            return false;
        }
        internships.add(internship);
        FileManager.saveInternships(internships);
        return true;
    }
    
    public Internship findInternshipById(int internshipId) {
        return internships.stream()
                .filter(i -> i.getInternshipId() == internshipId)
                .findFirst()
                .orElse(null);
    }
    
    public List<Internship> getAllInternships() {
        return new ArrayList<>(internships);
    }
    
    public List<Internship> getActiveInternships() {
        return internships.stream()
                .filter(i -> "Active".equals(i.getStatus()))
                .collect(Collectors.toList());
    }
    
    public List<Internship> getInternshipsByCompany(int companyId) {
        return internships.stream()
                .filter(i -> i.getCompanyId() == companyId)
                .collect(Collectors.toList());
    }
    
    // Application Operations
    public boolean applyForInternship(Application application) {
        // Check if student already applied
        boolean alreadyApplied = applications.stream()
                .anyMatch(a -> a.getStudentId() == application.getStudentId() 
                        && a.getInternshipId() == application.getInternshipId());
        
        if (alreadyApplied) {
            return false;
        }
        
        applications.add(application);
        FileManager.saveApplications(applications);
        return true;
    }
    
    public List<Application> getApplicationsByStudent(int studentId) {
        return applications.stream()
                .filter(a -> a.getStudentId() == studentId)
                .collect(Collectors.toList());
    }
    
    public List<Application> getApplicationsByInternship(int internshipId) {
        return applications.stream()
                .filter(a -> a.getInternshipId() == internshipId)
                .collect(Collectors.toList());
    }
    
    public boolean updateApplicationStatus(int applicationId, String status) {
        for (Application app : applications) {
            if (app.getApplicationId() == applicationId) {
                app.setStatus(status);
                FileManager.saveApplications(applications);
                return true;
            }
        }
        return false;
    }
    
    // Placement Operations
    public boolean addPlacement(Placement placement) {
        placements.add(placement);
        FileManager.savePlacements(placements);
        return true;
    }
    
    public List<Placement> getPlacementsByStudent(int studentId) {
        return placements.stream()
                .filter(p -> p.getStudentId() == studentId)
                .collect(Collectors.toList());
    }
    
    public List<Placement> getPlacementsByCompany(int companyId) {
        return placements.stream()
                .filter(p -> p.getCompanyId() == companyId)
                .collect(Collectors.toList());
    }
    
    public List<Placement> getAllPlacements() {
        return new ArrayList<>(placements);
    }
    
    // Statistics
    public Map<String, Integer> getPlacementStatistics() {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("totalStudents", students.size());
        stats.put("totalCompanies", companies.size());
        stats.put("totalInternships", internships.size());
        stats.put("activeInternships", (int) internships.stream()
                .filter(i -> "Active".equals(i.getStatus())).count());
        stats.put("totalApplications", applications.size());
        stats.put("totalPlacements", placements.size());
        return stats;
    }
    
    public int getNextStudentId() {
        return students.stream()
                .mapToInt(Student::getStudentId)
                .max()
                .orElse(0) + 1;
    }
    
    public int getNextCompanyId() {
        return companies.stream()
                .mapToInt(Company::getCompanyId)
                .max()
                .orElse(0) + 1;
    }
    
    public int getNextInternshipId() {
        return internships.stream()
                .mapToInt(Internship::getInternshipId)
                .max()
                .orElse(0) + 1;
    }
    
    public int getNextApplicationId() {
        return applications.stream()
                .mapToInt(Application::getApplicationId)
                .max()
                .orElse(0) + 1;
    }
    
    public int getNextPlacementId() {
        return placements.stream()
                .mapToInt(Placement::getPlacementId)
                .max()
                .orElse(0) + 1;
    }
}
