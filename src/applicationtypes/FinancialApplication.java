package applicationtypes;

import evaluationtypes.Evaluation;
import core.Applicant;
import core.EvaluationResult;

/**
 * Represents a financial need-based scholarship application.
 * Handles evaluation according to need-based criteria.
 */
public class FinancialApplication extends Application {

    private final Evaluation evaluationStrategy;

    /**
     * Constructs a financial application with the specified applicant and evaluation strategy.
     * @param applicant The applicant for this application
     * @param strategy The evaluation strategy to use
     */
    public FinancialApplication(Applicant applicant, Evaluation strategy) {
        super(applicant);
        this.evaluationStrategy = strategy;
    }

    /** Evaluates the financial application using the assigned evaluation strategy. */
    @Override
    public void evaluate() {
        // Create result object with basic information
        EvaluationResult result = new EvaluationResult(
                applicant.getStudentID(),
                applicant.getName(),
                evaluationStrategy.getApplicationType()
        );

        // Perform specific evaluation using strategy pattern
        evaluationStrategy.evaluate(applicant, result);
        this.result = result;
    }
}
