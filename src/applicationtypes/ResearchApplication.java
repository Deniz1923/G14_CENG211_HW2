package applicationtypes;

import evaluationtypes.Evaluation;
import core.Applicant;
import core.EvaluationResult;

public class ResearchApplication extends Application {

    private final Evaluation evaluationStrategy;
    public ResearchApplication(Applicant applicant, Evaluation strategy) {
        super(applicant);
        this.evaluationStrategy = strategy;
    }

    @Override
    public void evaluate() {
        EvaluationResult result = new EvaluationResult(applicant.getStudentID(),
                applicant.getName(), evaluationStrategy.getApplicationType());
        // Then perform research-specific evaluation
        evaluationStrategy.evaluate(applicant, result);
        this.result = result;
    }
}