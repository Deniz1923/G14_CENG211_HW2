package applicationtypes;

import core.Applicant;
import core.EvaluationResult;
import evaluationtypes.NeedBasedEval;

public class FinancialApplication extends Application {
    private final NeedBasedEval evaluationStrategy;
    public FinancialApplication(Applicant applicant) {
        super(applicant);
        this.result = new EvaluationResult(applicant.getStudentID(), applicant.getName(), "Need");
        evaluationStrategy = new NeedBasedEval();
        }

    @Override
    public void evaluate() {
        // First check general requirements
        if (!passesGeneralChecks()) {
            return;
        }

        // Then perform need-specific evaluation
        evaluationStrategy.evaluate(applicant, result);
    }
}