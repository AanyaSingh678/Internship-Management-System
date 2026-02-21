import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int studentId;
    private String name;
    private String email;
    private String phone;
    private String department;
    private String course;
    private int semester;
    private double cgpa;
    private String skills;
    private String resume;
    
    public Student() {}
    
    public Student(int studentId, String name, String email, String phone, 
                   String department, String course, int semester, double cgpa, 
                   String skills, String resume) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.course = course;
        this.semester = semester;
        this.cgpa = cgpa;
        this.skills = skills;
        this.resume = resume;
    }
    
    // Getters and Setters
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    
    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }
    
    public double getCgpa() { return cgpa; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }
    
    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }
    
    public String getResume() { return resume; }
    public void setResume(String resume) { this.resume = resume; }
    
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", department='" + department + '\'' +
                ", course='" + course + '\'' +
                ", semester=" + semester +
                ", cgpa=" + cgpa +
                ", skills='" + skills + '\'' +
                '}';
    }
}
