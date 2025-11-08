package applicationtypes;

import core.Applicant;
import core.EvaluationResult;

abstract public class Application {
    protected Applicant applicant;
    protected EvaluationResult result;

    public Application(Applicant applicant) {
        this.applicant = applicant;
    }

    public abstract void evaluate();

    protected boolean passesGeneralChecks() {
        // Priority order for rejection reasons:
        // 1. Missing Enrollment Certificate
        if (!applicant.hasDocument("ENR")) {
            result.setStatus("Rejected");
            result.setRejectionReason("Missing Enrollment Certificate");
            return false;
        }

        // 2. Missing Transcript
        if (applicant.getCourseGrade() == null) {
            result.setStatus("Rejected");
            result.setRejectionReason("Missing Transcript");
            return false;
        }

        // 3. GPA below 2.5
        if (applicant.getCourseGrade().getGpa() < 2.50) {
            result.setStatus("Rejected");
            result.setRejectionReason("GPA below 2.5");
            return false;
        }

        // Check transcript approval
        if (!applicant.isTranscriptApproved()) {
            result.setStatus("Rejected");
            result.setRejectionReason("Transcript not approved");
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return result.toString();
    }

    public EvaluationResult getResult() {
        return result;
    }
}