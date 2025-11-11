package core;

import java.util.ArrayList;

/** Represents an applicant in the scholarship evaluation system. */
public class Applicant {

    private final String studentID;
    private final String name;
    private final double initialIncome;

    private double familyIncome;
    private boolean transcriptApproval;
    private int dependents;
    private CourseGrade courseGrade;

    private final ArrayList<Document> documents;
    private final ArrayList<Publication> publications;


    /**
     * Creates an {@code Applicant} with only the mandatory fields.
     *
     * @param studentID      unique identifier (e.g., “11263216”)
     * @param name           full name of the applicant
     * @param initialIncome  GPA‑based income value from the CSV
     */
    public Applicant(String studentID, String name, double initialIncome) {
        this.studentID = studentID;
        this.name = name;
        this.initialIncome = initialIncome;

        this.documents = new ArrayList<>();
        this.publications = new ArrayList<>();
    }

    public String getStudentID() { return studentID; }
    public String getName() { return name; }
    public double getInitialIncome() { return initialIncome; }
    public double getFamilyIncome() { return familyIncome; }
    public boolean isTranscriptApproved() { return transcriptApproval; }
    public int getDependents() { return dependents; }
    public CourseGrade getCourseGrade() { return courseGrade; }

    /** Returns a copy of the documents list */
    public ArrayList<Document> getDocuments() { return new ArrayList<>(documents); }

    /** Returns a copy of the publications list */
    public ArrayList<Publication> getPublications() { return new ArrayList<>(publications); }

    public void setCourseGrade(CourseGrade courseGrade) { this.courseGrade = courseGrade; }

    public void setTranscriptApproval(boolean transcriptApproval) { this.transcriptApproval = transcriptApproval; }


    public void setFamilyIncome(double familyIncome) {
        if (familyIncome < 0) {
            throw new IllegalArgumentException("Family income cannot be negative");
        }
        this.familyIncome = familyIncome;
    }

    public void setDependents(int dependents) {
        if (dependents < 0) {
            throw new IllegalArgumentException("Number of dependents cannot be negative");
        }
        this.dependents = dependents;
    }


    /**
     * Adds a supporting document.
     * @param doc must not be {@code null}
     */
    public void addDocument(Document doc) {
        if (doc == null) {
            throw new IllegalArgumentException("Document cannot be null");
        }
        documents.add(doc);
    }

    /**
     * Adds a publication.
     * @param pub must not be {@code null}
     */
    public void addPublication(Publication pub) {
        if (pub == null) {
            throw new IllegalArgumentException("Publication cannot be null");
        }
        publications.add(pub);
    }

    /**
     * Checks whether a document of the given type is attached.
     *
     * @param documentType which are “ENR”, “REC”, “SAV”, "RSV", "GRP"
     * @return {@code true} if at least one matching document exists
     */
    public boolean hasDocument(String documentType) {
        for (Document d : documents) {
            if (d.getDocumentType().equals(documentType)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
