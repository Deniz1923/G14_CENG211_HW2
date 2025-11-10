package evaluationtypes;

import core.Applicant;
import core.EvaluationResult;

/**
 * Abstract base class for all evaluation strategies.
 * Provides common functionality for evaluating different types of applications.
 */
public abstract class Evaluation{

    /**
     * Evaluates an applicant using general checks followed by specific criteria.
     *
     * @param applicant The applicant to evaluate
     * @param result The evaluation result object to update
     */
    public void evaluate(Applicant applicant, EvaluationResult result) {
        // First perform general eligibility checks
        if (!GeneralBasedEval.passesGeneralChecks(applicant, result)) {
            return;
        }

        // Then perform specific evaluation for this type of application
        evaluateSpecific(applicant, result);
    }

    /**
     * Performs the specific evaluation logic for a particular application type.
     * This method should be implemented by subclasses.
     * @param applicant The applicant to evaluate
     * @param result The evaluation result object to update
     */
    protected abstract void evaluateSpecific(Applicant applicant, EvaluationResult result);

    /**
     * Gets the application type for this evaluation strategy.
     * @return The application type as a string
     */
    public abstract String getApplicationType();
}
