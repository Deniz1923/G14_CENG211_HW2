package core;

public class EvaluationResult {

    private final String applicantID;     // XXXXXXXX
    private final String name;
    private final String scholarshipType; // Merit, Need, Research
    private String status;                // Accepted, Rejected
    private String type;                  // Full, Half
    private String duration;              // "2 years", "1 year", "6 months"
    private String rejectionReason;

    public EvaluationResult(String applicantID, String name, String scholarshipType) {
        this.applicantID = applicantID;
        this.name = name;
        this.scholarshipType = scholarshipType;
    }

    /**
     * Creates a deep copy of another EvaluationResult object.
     * @param other The EvaluationResult to copy.
     */
    public EvaluationResult(EvaluationResult other) {
        this.name = other.name;
        this.scholarshipType = other.scholarshipType;
        this.applicantID = other.applicantID;
        this.status = other.status;
        this.type = other.type;
        this.duration = other.duration;
        this.rejectionReason = other.rejectionReason;
    }

    // Getters

    public String getApplicantID() {
        return applicantID;
    }

    public String getName() {
        return name;
    }

    public String getScholarshipType() {
        return scholarshipType;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getDuration() {
        return duration;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }


    // Setters

    public void setStatus(String status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    /** Used for the Final Output String, Important ! */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Applicant ID: ").append(applicantID)
                .append(", Name: ").append(name)
                .append(", Scholarship: ").append(scholarshipType)
                .append(", Status: ").append(status);

        if (status.equals("Accepted")) {
            result.append(", Type: ").append(type)
                    .append(", Duration: ").append(duration);
        } else {
            result.append(", Reason: ").append(rejectionReason);
        }

        return result.toString();
    }
}