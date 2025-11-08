package core;

import java.util.ArrayList;

public class Applicant {
    private final String studentID;
    private final String name;
    private final double initialIncome;
    private double familyIncome;
    private boolean transcriptApproval;
    private int dependents;
    private CourseGrade courseGrade;
    ArrayList<Document> documents;
    ArrayList<Publication> publications;

    public Applicant(String studentID, String name, double initialIncome) {
        this.studentID = studentID;
        this.name = name;
        this.initialIncome = initialIncome;
        this.documents = new ArrayList<>();
        this.publications = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public double getInitialIncome() {
        return initialIncome;
    }

    public double getFamilyIncome() {
        return familyIncome;
    }

    public boolean isTranscriptApproved() {
        return transcriptApproval;
    }

    public int getDependents() {
        return dependents;
    }

    public CourseGrade getCourseGrade() {
        return courseGrade;
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public ArrayList<Publication> getPublications() {
        return publications;
    }

    public void setCourseGrade(CourseGrade courseGrade) {
        this.courseGrade = courseGrade;
    }

    public void setFamilyIncome(double familyIncome) {
        this.familyIncome = familyIncome;
    }

    public void setDependents(int dependents) {
        this.dependents = dependents;
    }

    public void setTranscriptApproval(boolean transcriptApproval) {
        this.transcriptApproval = transcriptApproval;
    }

    public void addDocument(Document doc) {
        this.documents.add(doc);
    }

    public void addPublication(Publication pub) {
        this.publications.add(pub);
    }

    public boolean hasDocument(String documentType) {
        for (Document doc : documents) {
            if (doc.getDocumentType().equals(documentType)) {
                return true;
            }
        }
        return false;
    }

}