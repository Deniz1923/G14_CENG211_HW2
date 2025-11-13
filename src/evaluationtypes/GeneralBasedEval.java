package evaluationtypes;

import core.Applicant;
import core.EvaluationResult;

/**
 * Handles general eligibility checks that apply to all scholarship types.
 * These checks must pass before specific scholarship criteria are evaluated.
 */
public class GeneralBasedEval extends Evaluation{

    /**
     * Performs general eligibility checks for any scholarship application.
     * Priority order for rejection reasons:
     * 1. Missing Enrollment Certificate
     * 2. Missing Transcript
     * 3. GPA below 2.5
     * 4. Transcript not approved
     *
     * @param applicant the applicant to evaluate
     * @param result the evaluation result object to update
     * @return true if all general checks pass, false otherwise
     */
    public static boolean passesGeneralChecks(Applicant applicant, EvaluationResult result) {
        // Priority 1: Missing Enrollment Certificate
        if (!applicant.hasDocument("ENR")) {
            result.setStatus("Rejected");
            result.setRejectionReason("Missing Enrollment Certificate");
            return false;
        }

        // Priority 2: Missing Transcript
        if (applicant.getCourseGrade() == null) {
            result.setStatus("Rejected");
            result.setRejectionReason("Missing Transcript");
            return false;
        }

        // Priority 3: GPA below 2.5
        if (applicant.getCourseGrade().getGpa() < 2.50) {
            result.setStatus("Rejected");
            result.setRejectionReason("GPA below 2.5");
            return false;
        }

        // Check transcript approval (Y/N status)
        if (!applicant.isTranscriptApproved()) {
            result.setStatus("Rejected");
            result.setRejectionReason("Transcript not approved");
            return false;
        }

        return true;
    }

    @Override
    protected void evaluateSpecific(Applicant applicant, EvaluationResult result) {
        passesGeneralChecks(applicant,result);
    }

    @Override
    public String getApplicationType() {
        return "General";
    }
}