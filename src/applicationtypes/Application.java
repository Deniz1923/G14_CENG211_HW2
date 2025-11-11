package applicationtypes;

import core.Applicant;
import core.EvaluationResult;

/**
 * Abstract base class for all application types.
 * Provides common functionality for evaluating different scholarship applications.
 */
abstract public class Application {
    protected final Applicant applicant;
    protected EvaluationResult result;

    /**
     * Constructs an application with the given applicant.
     * @param applicant The applicant associated with this application
     */
    public Application(Applicant applicant) {
        this.applicant = applicant;
    }

    /**
     * Evaluates the application according to its specific type.
     * This method should be implemented by subclasses.
     */
    public abstract void evaluate();

    /**
     * Returns string representation of the evaluation result.
     * @return String representation of the evaluation result
     */
    @Override
    public String toString() {
        return result.toString();
    }

    /**
     * Gets the evaluation result for this application.
     * @return The evaluation result
     */
    public EvaluationResult getResult() {
        return result;
    }
}
