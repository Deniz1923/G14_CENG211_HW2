package applicationtypes;

import evaluationtypes.Evaluation;
import core.Applicant;
import core.EvaluationResult;

/**
 * Represents an academic (merit-based) scholarship application.
 * Handle evaluation according to merit-based criteria.
 */
public class AcademicApplication extends Application {

    private final Evaluation evaluationStrategy;

    /**
     * Constructs an academic application with the specified applicant and evaluation strategy.
     * @param applicant The applicant for this application
     * @param strategy The evaluation strategy to use
     */
    public AcademicApplication(Applicant applicant, Evaluation strategy) {
        super(applicant);
        this.evaluationStrategy = strategy;
    }

    /** Evaluates the academic application using the assigned evaluation strategy. */
    @Override
    public void evaluate() {
        // Create result object with basic information
        EvaluationResult result = new EvaluationResult(applicant.getStudentID(),
                applicant.getName(), evaluationStrategy.getApplicationType());

        // Perform specific evaluation using strategy pattern
        evaluationStrategy.evaluate(applicant, result);
        this.result = result;
    }
}
