package applicationtypes;

import core.Applicant;
import core.EvaluationResult;
import evaluationtypes.MeritBasedEval;

public class AcademicApplication extends Application {

    public AcademicApplication(Applicant applicant) {
        super(applicant);
        this.result = new EvaluationResult(applicant.getStudentID(), applicant.getName(), "Merit");
    }

    @Override
    public void evaluate() {
        // First check general requirements
        if (!passesGeneralChecks()) {
            return;
        }

        // Then perform merit-specific evaluation
        MeritBasedEval.evaluate(applicant, result);
    }
}