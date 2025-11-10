package app;

import core.Applicant;
import core.EvaluationResult;
import evaluationtypes.GeneralBasedEval;

public abstract class EvaluationMaster {

    public final void evaluate(Applicant applicant, EvaluationResult result)
    {
        if(!GeneralBasedEval.passesGeneralChecks(applicant, result)){
            return;
        }

        evaluate(applicant,result);
    }

    protected abstract void evaluateSpecific(Applicant applicant, EvaluationResult result);
}