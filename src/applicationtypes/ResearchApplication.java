package applicationtypes;

import core.Applicant;
import core.EvaluationResult;
import evaluationtypes.ResearchBasedEval;

public class ResearchApplication extends Application {

    public ResearchApplication(Applicant applicant) {
        super(applicant);
        this.result = new EvaluationResult(applicant.getStudentID(), applicant.getName(), "Research");
    }

    @Override
    public void evaluate() {
        // First check general requirements
        if (!passesGeneralChecks()) {
            return;
        }

        // Then perform research-specific evaluation
        ResearchBasedEval.evaluate(applicant, result);
    }
}