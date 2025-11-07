import java.util.ArrayList;

public class Applicant {
    private String studentID;
    private String name;
    private double gpa;
    private int familyIncome;
    private boolean transcriptApproval;

    private CourseGrade courseGrade;
    ArrayList<Document> documents;
    ArrayList<Publication> publications;
    public Applicant(String studentID, String name, double gpa, int familyIncome){
        this.studentID = studentID;
        this.name = name;
        this.gpa = gpa;
        this.familyIncome = familyIncome;
        this.documents = new ArrayList<>();
        this.publications = new ArrayList<>();
    }

    public void setCourseGrade(CourseGrade courseGrade){
        this.courseGrade = (courseGrade);
    }

}
