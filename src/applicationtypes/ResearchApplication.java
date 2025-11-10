package applicationtypes;

import app.EvaluationMaster;
import core.Applicant;
import core.EvaluationResult;
import evaluationtypes.ResearchBasedEval;

public class ResearchApplication extends Application {

    private final EvaluationMaster evaluationStrategy;
    public ResearchApplication(Applicant applicant, EvaluationMaster strategy) {
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