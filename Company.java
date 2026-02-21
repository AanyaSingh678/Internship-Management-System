import java.io.Serializable;

public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int companyId;
    private String companyName;
    private String location;
    private String industry;
    private String email;
    private String phone;
    private String website;
    private String description;
    
    public Company() {}
    
    public Company(int companyId, String companyName, String location, 
                   String industry, String email, String phone, 
                   String website, String description) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.location = location;
        this.industry = industry;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.description = description;
    }
    
    // Getters and Setters
    public int getCompanyId() { return companyId; }
    public void setCompanyId(int companyId) { this.companyId = companyId; }
    
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                ", industry='" + industry + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
