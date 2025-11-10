package applicationtypes;

import com.sun.source.tree.MemberReferenceTree;
import core.Applicant;
import core.EvaluationResult;
import evaluationtypes.MeritBasedEval;

public class AcademicApplication extends Application {
    MeritBasedEval evaluationStrategy;
    public AcademicApplication(Applicant applicant) {
        super(applicant);
        this.result = new EvaluationResult(applicant.getStudentID(), applicant.getName(), "Merit");
        this.evaluationStrategy = new MeritBasedEval();
    }

    @Override
    public void evaluate() {
        // First check general requirements
        if (!passesGeneralChecks()) {
            return;
        }

        // Then perform merit-specific evaluation
        evaluationStrategy.evaluate(applicant, result);
    }
}