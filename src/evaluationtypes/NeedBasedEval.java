package evaluationtypes;

import app.EvaluationMaster;
import core.Applicant;
import core.EvaluationResult;

/**
 * Evaluates need-based scholarship applications.
 * Criteria:
 * - Monthly income <= 10,000 → Full Scholarship
 * - 10,000 < income <= 15,000 → Half Scholarship
 * - Income > 15,000 → Rejected
 * - If Savings Document (SAV) exists → thresholds increase by 20%
 * - If 3+ dependents → thresholds increase by additional 10%
 * - Duration: 1 year
 */
public class NeedBasedEval extends EvaluationMaster {

    /**
     * Evaluates a need-based scholarship application based on family income.
     *
     * @param applicant the applicant to evaluate
     * @param result the evaluation result object to update
     */
    protected void evaluateSpecific(Applicant applicant, EvaluationResult result) {
        // Calculate monthly income from yearly family income
        double monthlyIncome = applicant.getFamilyIncome() / 12.0;

        // Base thresholds
        double fullThreshold = 10000;
        double halfThreshold = 15000;

        // Adjust thresholds if savings document exists (20% increase)
        if (applicant.hasDocument("SAV")) {
            fullThreshold *= 1.20;
            halfThreshold *= 1.20;
        }

        // Adjust thresholds if 3 or more dependents (additional 10% increase)
        if (applicant.getDependents() >= 3) {
            fullThreshold *= 1.10;
            halfThreshold *= 1.10;
        }

        // Determine scholarship type based on adjusted income thresholds
        if (monthlyIncome <= fullThreshold) {
            result.setStatus("Accepted");
            result.setType("Full");
        } else if (monthlyIncome <= halfThreshold) {
            result.setStatus("Accepted");
            result.setType("Half");
        } else {
            result.setStatus("Rejected");
            result.setRejectionReason("Financial status unstable");
            return;
        }

        // Duration is always 1 year for need-based scholarships
        result.setDuration("1 year");
    }

    @Override
    public String getApplicationType() {
        return "Need";
    }
}