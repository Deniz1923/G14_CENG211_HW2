package core;

import java.util.ArrayList;

/**
 * Represents a scholarship applicant with their personal information,
 * academic records, documents, and publications.<p>
 * This class serves as the base data model for all types of scholarship
 * applications (Merit-based, Need-based, and Research Grant).
 */
public class Applicant {
    /** Unique identifier for the student (e.g., "1101", "2201", "3301") */
    private final String studentID;

    /** Full name of the applicant */
    private final String name;

    /** Initial income value from the applicant info line (A line) */
    private final double initialIncome;

    /** Specific family income from the family info line (I line) */
    private double familyIncome;

    /** Whether the transcript has been approved (Y/N status) */
    private boolean transcriptApproval;

    /** Number of family dependents */
    private int dependents;

    /** Academic grade information including GPA */
    private CourseGrade courseGrade;

    /** List of all documents submitted by the applicant */
    ArrayList<Document> documents;

    /** List of all publications submitted by the applicant */
    ArrayList<Publication> publications;

    /**
     * Constructs a new Applicant with basic information.
     * Initializes empty lists for documents and publications.
     *
     * @param studentID the unique student identifier
     * @param name the full name of the applicant
     * @param initialIncome the initial income value from applicant info
     */
    public Applicant(String studentID, String name, double initialIncome) {
        this.studentID = studentID;
        this.name = name;
        this.initialIncome = initialIncome;
        this.documents = new ArrayList<>();
        this.publications = new ArrayList<>();
    }

    /**
     * Gets the student's unique identifier.
     *
     * @return the student ID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Gets the applicant's full name.
     *
     * @return the name of the applicant
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the initial income value from the applicant info line.
     *
     * @return the initial income
     */
    public double getInitialIncome() {
        return initialIncome;
    }

    /**
     * Gets the specific family income from the family info line.
     *
     * @return the family income
     */
    public double getFamilyIncome() {
        return familyIncome;
    }

    /**
     * Gets the transcript approval status.
     *
     * @return true if transcript is approved, false otherwise
     */
    public boolean isTranscriptApproved() {
        return transcriptApproval;
    }

    /**
     * Gets the number of family dependents.
     *
     * @return the number of dependents
     */
    public int getDependents() {
        return dependents;
    }

    /**
     * Gets the course grade information containing GPA.
     *
     * @return the CourseGrade object, or null if not set
     */
    public CourseGrade getCourseGrade() {
        return courseGrade;
    }

    /**
     * Gets the list of all submitted documents.
     *
     * @return ArrayList of Document objects
     */
    public ArrayList<Document> getDocuments() {
        return documents;
    }

    /**
     * Gets the list of all submitted publications.
     *
     * @return ArrayList of Publication objects
     */
    public ArrayList<Publication> getPublications() {
        return publications;
    }

    /**
     * Sets the course grade information for this applicant.
     *
     * @param courseGrade the CourseGrade object containing GPA information
     */
    public void setCourseGrade(CourseGrade courseGrade) {
        this.courseGrade = courseGrade;
    }

    /**
     * Sets the specific family income from the family info line (I line).
     *
     * @param familyIncome the family income value
     */
    public void setFamilyIncome(double familyIncome) {
        this.familyIncome = familyIncome;
    }

    /**
     * Sets the number of dependents from the family info line (I line).
     *
     * @param dependents the number of family dependents
     */
    public void setDependents(int dependents) {
        this.dependents = dependents;
    }

    /**
     * Sets the transcript approval status.
     *
     * @param transcriptApproval true if transcript is approved (Y), false if not (N)
     */
    public void setTranscriptApproval(boolean transcriptApproval) {
        this.transcriptApproval = transcriptApproval;
    }

    /**
     * Adds a document to the applicant's document list.
     *
     * @param doc the Document object to add
     */
    public void addDocument(Document doc) {
        this.documents.add(doc);
    }

    /**
     * Adds a publication to the applicant's publication list.
     *
     * @param pub the Publication object to add
     */
    public void addPublication(Publication pub) {
        this.publications.add(pub);
    }

    /**
     * Checks if the applicant has a specific document type.
     *
     * @param documentType the document type code (e.g., "ENR", "REC", "SAV")
     * @return true if the document exists, false otherwise
     */
    public boolean hasDocument(String documentType) {
        for (Document doc : documents) {
            if (doc.getDocumentType().equals(documentType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets a specific document by type.
     *
     * @param documentType the document type code to search for
     * @return the Document object if found, null otherwise
     */
    public Document getDocument(String documentType) {
        for (Document doc : documents) {
            if (doc.getDocumentType().equals(documentType)) {
                return doc;
            }
        }
        return null;
    }
}


// OLD VERSION
//package core;
//
//import java.util.ArrayList;
//
//public class Applicant {
//    private final String studentID;
//    private final String name;
//    private double initialIncome;
//    private double familyIncome;
//    private boolean transcriptApproval;
//    private int dependents;
//
//    private CourseGrade courseGrade;
//    ArrayList<Document> documents;
//    ArrayList<Publication> publications;
//    public Applicant(String studentID, String name, double initialIncome){
//        this.studentID = studentID;
//        this.name = name;
//        this.initialIncome = initialIncome;
//        this.documents = new ArrayList<>();
//        this.publications = new ArrayList<>();
//    }
//    public String getStudentID() { return studentID; }
//    public String getName() { return name; }
//    public CourseGrade getCourseGrade() { return courseGrade; }
//    public ArrayList<Document> getDocuments() { return documents; }
//    public ArrayList<Publication> getPublications() { return publications; }
//
//    public void setCourseGrade(CourseGrade courseGrade){
//        this.courseGrade = courseGrade;
//    }
//
//    /** Sets the specific family income from the 'I' line. */
//    public void setFamilyIncome(double familyIncome) {
//        this.familyIncome = familyIncome;
//    }
//
//    /** Sets the number of dependents from the 'I' line. */
//    public void setDependents(int dependents) {
//        this.dependents = dependents;
//    }
//
//    /** Adds a misc.Document object to the list. */
//    public void addDocument(Document doc) {
//        this.documents.add(doc);
//    }
//
//    /** Adds a misc.Publication object to the list. */
//    public void addPublication(Publication pub) {
//        this.publications.add(pub);
//    }
//
//    public void setTranscriptApproval(boolean transcriptApproval){
//        this.transcriptApproval = transcriptApproval;
//    }
//
//}
