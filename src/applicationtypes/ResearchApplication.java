package applicationtypes;

import core.Applicant;
import core.EvaluationResult;
import evaluationtypes.Evaluation;

/**
 * Represents a research grant application.
 * Handles evaluation according to research-based criteria.
 */
public class ResearchApplication extends Application {

    private final Evaluation evaluationStrategy;

    /**
     * Constructs a research application with the specified applicant and evaluation strategy.
     * @param applicant The applicant for this application
     * @param strategy The evaluation strategy to use
     */
    public ResearchApplication(Applicant applicant, Evaluation strategy) {
        super(applicant);
        this.evaluationStrategy = strategy;
    }

    /** Evaluates the research application using the assigned evaluation strategy. */
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
