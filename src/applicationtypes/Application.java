package applicationtypes;

import app.EvaluationMaster;
import core.Applicant;
import core.EvaluationResult;

abstract public class Application {
    protected Applicant applicant;
    protected EvaluationResult result;

    public Application(Applicant applicant) {
        this.applicant = applicant;
    }

    public abstract void evaluate() ;

    @Override
    public String toString() {
        return result.toString();
    }

    public EvaluationResult getResult() {
        return result;
    }
}