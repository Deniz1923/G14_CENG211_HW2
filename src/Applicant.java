import java.util.ArrayList;

public class Applicant {
    private String studentID;
    private String name;
    private double gpa;
    private int familyIncome;
    private boolean transcriptApproval;

    ArrayList<Document> documents;
    ArrayList<Publication> publications;
    ArrayList<CourseGrade> courses;
    public Applicant(String studentID, String name, double gpa, int familyIncome){
        this.studentID = studentID;
        this.name = name;
        this.gpa = gpa;
        this.familyIncome = familyIncome;
    }

}
