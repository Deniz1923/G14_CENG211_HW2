package core;

import java.util.ArrayList;

public class Applicant {
    private String studentID;
    private String name;
    private double initialIncome;
    private double familyIncome;
    private boolean transcriptApproval;
    private int dependents;

    private CourseGrade courseGrade;
    ArrayList<Document> documents;
    ArrayList<Publication> publications;
    public Applicant(String studentID, String name, double initialIncome){
        this.studentID = studentID;
        this.name = name;
        this.initialIncome = initialIncome;
        this.documents = new ArrayList<>();
        this.publications = new ArrayList<>();
    }
    public String getStudentID() { return studentID; }
    public String getName() { return name; }
    public CourseGrade getCourseGrade() { return courseGrade; }
    public ArrayList<Document> getDocuments() { return documents; }
    public ArrayList<Publication> getPublications() { return publications; }

    public void setCourseGrade(CourseGrade courseGrade){
        this.courseGrade = courseGrade;
    }

    /** Sets the specific family income from the 'I' line. */
    public void setFamilyIncome(double familyIncome) {
        this.familyIncome = familyIncome;
    }

    /** Sets the number of dependents from the 'I' line. */
    public void setDependents(int dependents) {
        this.dependents = dependents;
    }

    /** Adds a misc.Document object to the list. */
    public void addDocument(Document doc) {
        this.documents.add(doc);
    }

    /** Adds a misc.Publication object to the list. */
    public void addPublication(Publication pub) {
        this.publications.add(pub);
    }

    public void setTranscriptApproval(boolean transcriptApproval){
        this.transcriptApproval = transcriptApproval;
    }

}
