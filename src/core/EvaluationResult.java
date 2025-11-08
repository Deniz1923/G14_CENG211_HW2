package core;

public class EvaluationResult {
    private final String applicantID;
    private final String name;
    private final String scholarshipType; // Merit, Need, Research
    private String status; // Accepted, Rejected
    private String type; // Full, Half
    private String duration; // "2 years", "1 year", "6 months"
    private String rejectionReason;

    public EvaluationResult(String applicantID, String name, String scholarshipType) {
        this.applicantID = applicantID;
        this.name = name;
        this.scholarshipType = scholarshipType;
    }

    public String getApplicantID() {
        return applicantID;
    }

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