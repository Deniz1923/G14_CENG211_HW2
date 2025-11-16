package core;

import java.util.ArrayList;

/** Represents an applicant in the scholarship evaluation system. */
public class Applicant {

  private final String studentID;
  private final String name;
  private final double initialIncome;
  private final ArrayList<Document> documents;
  private final ArrayList<Publication> publications;
  private double familyIncome;
  private boolean transcriptApproval;
  private int dependents;
  private CourseGrade courseGrade;

  /**
   * Creates an {@code Applicant} with only the mandatory fields.
   *
   * @param studentID unique identifier (e.g., “11263216”)
   * @param name full name of the applicant
   * @param initialIncome GPA‑based income value from the CSV
   */
  public Applicant(String studentID, String name, double initialIncome) {
    this.studentID = studentID;
    this.name = name;
    this.initialIncome = initialIncome;

    this.documents = new ArrayList<>();
    this.publications = new ArrayList<>();
  }

  /** Creates a deep copy of another Applicant. Used for defensive copying by other classes. */
  public Applicant(Applicant other) {
    // Copy all primitive and immutable fields
    this.studentID = other.studentID;
    this.name = other.name;
    this.initialIncome = other.initialIncome;
    this.familyIncome = other.familyIncome;
    this.transcriptApproval = other.transcriptApproval;
    this.dependents = other.dependents;

    // No new is needed since CourseGrade is immutable
    this.courseGrade = other.courseGrade;

    // Create new lists and deep copy the contents
    this.documents = new ArrayList<>();
    for (Document doc : other.documents) {
      this.documents.add(new Document(doc));
    }

    this.publications = new ArrayList<>();
    for (Publication pub : other.publications) {
      this.publications.add(new Publication(pub));
    }
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

  public void setFamilyIncome(double familyIncome) {
    if (familyIncome < 0) {
      throw new IllegalArgumentException("Family income cannot be negative");
    }
    this.familyIncome = familyIncome;
  }

  public boolean isTranscriptApproved() {
    return transcriptApproval;
  }

  public int getDependents() {
    return dependents;
  }

  public void setDependents(int dependents) {
    if (dependents < 0) {
      throw new IllegalArgumentException("Number of dependents cannot be negative");
    }
    this.dependents = dependents;
  }

  public CourseGrade getCourseGrade() {
    return courseGrade;
  }

  public void setCourseGrade(CourseGrade courseGrade) {
    this.courseGrade = courseGrade;
  }

  /** Returns a deep copy of the documents list */
  public ArrayList<Document> getDocuments() {
    // Create the new list to be returned
    ArrayList<Document> deepCopy = new ArrayList<>();

    // Iterate and add new, copied Document objects
    for (Document document : this.documents) {
      // Using the copy constructor
      deepCopy.add(new Document(document));
    }
    return deepCopy;
  }

  /** Returns a deep copy of the publications list */
  public ArrayList<Publication> getPublications() {
    // Create the new list to be returned
    ArrayList<Publication> deepCopy = new ArrayList<>();

    // Iterate and add new, copied Publication objects
    for (Publication publication : this.publications) {
      // Use the copy constructor
      deepCopy.add(new Publication(publication));
    }
    return deepCopy;
  }

  public void setTranscriptApproval(boolean transcriptApproval) {
    this.transcriptApproval = transcriptApproval;
  }

  /**
   * Adds a supporting document.
   *
   * @param doc must not be {@code null}
   */
  public void addDocument(Document doc) {
    if (doc == null) {
      throw new IllegalArgumentException("Document cannot be null");
    }
    // defensive copy
    documents.add(new Document(doc));
  }

  /**
   * Adds a publication.
   *
   * @param pub must not be {@code null}
   */
  public void addPublication(Publication pub) {
    if (pub == null) {
      throw new IllegalArgumentException("Publication cannot be null");
    }
    // defensive copy
    publications.add(new Publication(pub));
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
    return "Applicant{" + "studentID='" + studentID + '\'' + ", name='" + name + '\'' + '}';
  }
}
