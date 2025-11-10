package applicationtypes;

import core.Applicant;
import core.EvaluationResult;
import evaluationtypes.ResearchBasedEval;

public class ResearchApplication extends Application {

    private final ResearchBasedEval evaluationStrategy;
    public ResearchApplication(Applicant applicant) {
        super(applicant);
        this.result = new EvaluationResult(applicant.getStudentID(), applicant.getName(), "Research");
        this.evaluationStrategy = new ResearchBasedEval();
    }

    @Override
    public void evaluate() {
        // First check general requirements
        if (!passesGeneralChecks()) {
            return;
        }

        // Then perform research-specific evaluation
        evaluationStrategy.evaluate(applicant, result);
    }
}