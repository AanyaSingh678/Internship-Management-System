import java.io.Serializable;
import java.util.Date;

public class Placement implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int placementId;
    private int studentId;
    private int internshipId;
    private int companyId;
    private Date placementDate;
    private Date joiningDate;
    private Date completionDate;
    private String feedback;
    private double rating;
    private String certificate;
    
    public Placement() {}
    
    public Placement(int placementId, int studentId, int internshipId, 
                    int companyId, Date placementDate, Date joiningDate) {
        this.placementId = placementId;
        this.studentId = studentId;
        this.internshipId = internshipId;
        this.companyId = companyId;
        this.placementDate = placementDate;
        this.joiningDate = joiningDate;
    }
    
    // Getters and Setters
    public int getPlacementId() { return placementId; }
    public void setPlacementId(int placementId) { this.placementId = placementId; }
    
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    
    public int getInternshipId() { return internshipId; }
    public void setInternshipId(int internshipId) { this.internshipId = internshipId; }
    
    public int getCompanyId() { return companyId; }
    public void setCompanyId(int companyId) { this.companyId = companyId; }
    
    public Date getPlacementDate() { return placementDate; }
    public void setPlacementDate(Date placementDate) { this.placementDate = placementDate; }
    
    public Date getJoiningDate() { return joiningDate; }
    public void setJoiningDate(Date joiningDate) { this.joiningDate = joiningDate; }
    
    public Date getCompletionDate() { return completionDate; }
    public void setCompletionDate(Date completionDate) { this.completionDate = completionDate; }
    
    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
    
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    
    public String getCertificate() { return certificate; }
    public void setCertificate(String certificate) { this.certificate = certificate; }
    
    @Override
    public String toString() {
        return "Placement{" +
                "placementId=" + placementId +
                ", studentId=" + studentId +
                ", internshipId=" + internshipId +
                ", companyId=" + companyId +
                ", placementDate=" + placementDate +
                ", joiningDate=" + joiningDate +
                ", rating=" + rating +
                '}';
    }
}
