import java.io.Serializable;
import java.util.Date;

public class Internship implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int internshipId;
    private int companyId;
    private String title;
    private String description;
    private String duration;
    private String location;
    private double stipend;
    private String eligibilityCriteria;
    private String requiredSkills;
    private Date startDate;
    private Date endDate;
    private Date applicationDeadline;
    private int vacancies;
    private String status; // Active, Closed, Cancelled
    
    public Internship() {}
    
    public Internship(int internshipId, int companyId, String title, 
                      String description, String duration, String location, 
                      double stipend, String eligibilityCriteria, 
                      String requiredSkills, Date startDate, Date endDate, 
                      Date applicationDeadline, int vacancies, String status) {
        this.internshipId = internshipId;
        this.companyId = companyId;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.location = location;
        this.stipend = stipend;
        this.eligibilityCriteria = eligibilityCriteria;
        this.requiredSkills = requiredSkills;
        this.startDate = startDate;
        this.endDate = endDate;
        this.applicationDeadline = applicationDeadline;
        this.vacancies = vacancies;
        this.status = status;
    }
    
    // Getters and Setters
    public int getInternshipId() { return internshipId; }
    public void setInternshipId(int internshipId) { this.internshipId = internshipId; }
    
    public int getCompanyId() { return companyId; }
    public void setCompanyId(int companyId) { this.companyId = companyId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public double getStipend() { return stipend; }
    public void setStipend(double stipend) { this.stipend = stipend; }
    
    public String getEligibilityCriteria() { return eligibilityCriteria; }
    public void setEligibilityCriteria(String eligibilityCriteria) { 
        this.eligibilityCriteria = eligibilityCriteria; 
    }
    
    public String getRequiredSkills() { return requiredSkills; }
    public void setRequiredSkills(String requiredSkills) { 
        this.requiredSkills = requiredSkills; 
    }
    
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    
    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    
    public Date getApplicationDeadline() { return applicationDeadline; }
    public void setApplicationDeadline(Date applicationDeadline) { 
        this.applicationDeadline = applicationDeadline; 
    }
    
    public int getVacancies() { return vacancies; }
    public void setVacancies(int vacancies) { this.vacancies = vacancies; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    @Override
    public String toString() {
        return "Internship{" +
                "internshipId=" + internshipId +
                ", companyId=" + companyId +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", stipend=" + stipend +
                ", duration='" + duration + '\'' +
                ", vacancies=" + vacancies +
                ", status='" + status + '\'' +
                '}';
    }
}
