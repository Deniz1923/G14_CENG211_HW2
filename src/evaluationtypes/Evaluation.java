package evaluationtypes;

import core.Applicant;
import core.EvaluationResult;

public abstract class Evaluation {

    public void evaluate(Applicant applicant, EvaluationResult result)
    {
        if(!GeneralBasedEval.passesGeneralChecks(applicant, result)){
            return;
        }

        evaluateSpecific(applicant,result);
    }

    protected abstract void evaluateSpecific(Applicant applicant, EvaluationResult result);

    public abstract String getApplicationType();
}