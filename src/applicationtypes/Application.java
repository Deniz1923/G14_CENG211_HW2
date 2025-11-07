package applicationtypes;

import core.Applicant;
import core.EvaluationResult;

abstract public class Application {
    protected Applicant applicant;
    protected EvaluationResult result;

    public Application(Applicant applicant) {
        this.applicant = applicant;
    }

    abstract void evaluate();

    protected boolean passesGeneralChecks() {
        // Check ENR document
        // Check transcript approval
        // Check GPA >= 2.5
    }

    @Override
    public String toString() {
        return result.toString();
    }
}