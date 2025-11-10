package applicationtypes;

import app.EvaluationMaster;
import core.Applicant;
import core.EvaluationResult;

public class AcademicApplication extends Application {

    private final EvaluationMaster evaluationStrategy;

    public AcademicApplication(Applicant applicant, EvaluationMaster strategy) {
        super(applicant);
        this.evaluationStrategy = strategy;
    }

    @Override
    public void evaluate() {
        EvaluationResult result = new EvaluationResult(applicant.getStudentID(),
                applicant.getName(), evaluationStrategy.getApplicationType());

        // Then perform merit-specific evaluation
        evaluationStrategy.evaluate(applicant, result);
        this.result = result;
    }
}