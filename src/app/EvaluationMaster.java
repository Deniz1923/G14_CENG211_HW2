package app;

import core.Applicant;
import core.EvaluationResult;
import evaluationtypes.GeneralBasedEval;
import evaluationtypes.MeritBasedEval;
import evaluationtypes.NeedBasedEval;
import evaluationtypes.ResearchBasedEval;

/**
 * Centralized evaluation manager that coordinates different evaluation types.
 * This class can be used to evaluate applicants based on their scholarship type.
 */
public class EvaluationMaster {

    /**
     * Evaluates a merit-based scholarship application.
     *
     * @param applicant the applicant to evaluate
     * @return the evaluation result
     */
    public static EvaluationResult evaluateMeritApplication(Applicant applicant) {
        EvaluationResult result = new EvaluationResult(
                applicant.getStudentID(),
                applicant.getName(),
                "Merit"
        );

        // First check general requirements
        if (!GeneralBasedEval.passesGeneralChecks(applicant, result)) {
            return result;
        }

        // Then perform merit-specific evaluation
        MeritBasedEval.evaluate(applicant, result);
        return result;
    }

    /**
     * Evaluates a need-based scholarship application.
     *
     * @param applicant the applicant to evaluate
     * @return the evaluation result
     */
    public static EvaluationResult evaluateNeedApplication(Applicant applicant) {
        EvaluationResult result = new EvaluationResult(
                applicant.getStudentID(),
                applicant.getName(),
                "Need"
        );

        // First check general requirements
        if (!GeneralBasedEval.passesGeneralChecks(applicant, result)) {
            return result;
        }

        // Then perform need-specific evaluation
        NeedBasedEval.evaluate(applicant, result);
        return result;
    }

    /**
     * Evaluates a research grant application.
     *
     * @param applicant the applicant to evaluate
     * @return the evaluation result
     */
    public static EvaluationResult evaluateResearchApplication(Applicant applicant) {
        EvaluationResult result = new EvaluationResult(
                applicant.getStudentID(),
                applicant.getName(),
                "Research"
        );

        // First check general requirements
        if (!GeneralBasedEval.passesGeneralChecks(applicant, result)) {
            return result;
        }

        // Then perform research-specific evaluation
        ResearchBasedEval.evaluate(applicant, result);
        return result;
    }
}