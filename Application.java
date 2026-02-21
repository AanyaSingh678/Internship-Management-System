import java.io.Serializable;
import java.util.Date;

public class Application implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int applicationId;
    private int studentId;
    private int internshipId;
    private Date applicationDate;
    private String status; // Pending, Shortlisted, Rejected, Selected
    private String coverLetter;
    private Date interviewDate;
    private String interviewFeedback;
    
    public Application() {}
    
    public Application(int applicationId, int studentId, int internshipId, 
                      Date applicationDate, String status, String coverLetter) {
        this.applicationId = applicationId;
        this.studentId = studentId;
        this.internshipId = internshipId;
        this.applicationDate = applicationDate;
        this.status = status;
        this.coverLetter = coverLetter;
    }
    
    // Getters and Setters
    public int getApplicationId() { return applicationId; }
    public void setApplicationId(int applicationId) { this.applicationId = applicationId; }
    
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    
    public int getInternshipId() { return internshipId; }
    public void setInternshipId(int internshipId) { this.internshipId = internshipId; }
    
    public Date getApplicationDate() { return applicationDate; }
    public void setApplicationDate(Date applicationDate) { 
        this.applicationDate = applicationDate; 
    }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getCoverLetter() { return coverLetter; }
    public void setCoverLetter(String coverLetter) { this.coverLetter = coverLetter; }
    
    public Date getInterviewDate() { return interviewDate; }
    public void setInterviewDate(Date interviewDate) { this.interviewDate = interviewDate; }
    
    public String getInterviewFeedback() { return interviewFeedback; }
    public void setInterviewFeedback(String interviewFeedback) { 
        this.interviewFeedback = interviewFeedback; 
    }
    
    @Override
    public String toString() {
        return "Application{" +
                "applicationId=" + applicationId +
                ", studentId=" + studentId +
                ", internshipId=" + internshipId +
                ", applicationDate=" + applicationDate +
                ", status='" + status + '\'' +
                '}';
    }
}
