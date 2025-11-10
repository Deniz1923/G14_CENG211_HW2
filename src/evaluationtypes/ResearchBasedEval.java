package evaluationtypes;

import app.EvaluationMaster;
import core.Applicant;
import core.EvaluationResult;
import core.Publication;

/**
 * Evaluates research grant applications.
 * Criteria:
 * - At least one Publication (P) or Grant Proposal (GRP) required
 * - Average impact factor >= 1.50 → Full Scholarship
 * - 1.00 <= avg impact < 1.50 → Half Scholarship
 * - avg impact < 1.00 → Rejected
 * - If Research Supervisor Approval (RSV) exists → +1 year extension
 * - Base duration: Full → 1 year, Half → 6 months
 */
public class ResearchBasedEval extends EvaluationMaster {

    /**
     * Evaluates a research grant application based on publications and impact factor.
     *
     * @param applicant the applicant to evaluate
     * @param result the evaluation result object to update
     */
    protected void evaluateSpecific(Applicant applicant, EvaluationResult result) {
        // Check if at least one publication or grant proposal exists
        boolean hasPublication = !applicant.getPublications().isEmpty();
        boolean hasGrantProposal = applicant.hasDocument("GRP");

        if (!hasPublication && !hasGrantProposal) {
            result.setStatus("Rejected");
            result.setRejectionReason("Missing publication or proposal");
            return;
        }

        // Calculate average impact factor of publications
        double totalImpact = 0;
        int publicationCount = applicant.getPublications().size();

        for (Publication pub : applicant.getPublications()) {
            totalImpact += pub.getImpactFactor();
        }

        // If no publications but has GRP, treat as impact factor 0
        double avgImpact = (publicationCount > 0) ? (totalImpact / publicationCount) : 0;

        // Determine scholarship type based on average impact factor
        int baseDurationMonths;
        if (avgImpact >= 1.50) {
            result.setStatus("Accepted");
            result.setType("Full");
            baseDurationMonths = 12; // 1 year
        } else if (avgImpact >= 1.00) {
            result.setStatus("Accepted");
            result.setType("Half");
            baseDurationMonths = 6; // 6 months
        } else {
            result.setStatus("Rejected");
            result.setRejectionReason("Publication impact too low");
            return;
        }

        // Extend duration by 1 year if Research Supervisor Approval exists
        if (applicant.hasDocument("RSV")) {
            baseDurationMonths += 12;
        }

        // Convert months to years/months format
        if (baseDurationMonths >= 12) {
            int years = baseDurationMonths / 12;
            int months = baseDurationMonths % 12;
            if (months == 0) {
                result.setDuration(years + (years == 1 ? " year" : " years"));
            } else {
                result.setDuration(years + (years == 1 ? " year " : " years ") + months + " months");
            }
        } else {
            result.setDuration(baseDurationMonths + " months");
        }
    }

    @Override
    public String getApplicationType() {
        return "Research";
    }
}