package evaluationtypes;

import core.Applicant;
import core.EvaluationResult;

/**
 * Evaluates merit-based scholarship applications. Criteria: - GPA >= 3.20 → Full Scholarship - 3.00
 * <= GPA < 3.20 → Half Scholarship - GPA < 3.00 → Rejected - If Recommendation Letter (REC) exists
 * → 2 years, otherwise 1 year
 */
public class MeritBasedEval extends Evaluation {

  /**
   * Evaluates a merit-based scholarship application based on GPA.
   *
   * @param applicant the applicant to evaluate
   * @param result the evaluation result object to update
   */
  protected void evaluateSpecific(Applicant applicant, EvaluationResult result) {
    double gpa = applicant.getCourseGrade().getGpa();

    // Determine scholarship type based on GPA
    if (gpa >= 3.20) {
      result.setStatus("Accepted");
      result.setType("Full");
    } else if (gpa >= 3.00) {
      result.setStatus("Accepted");
      result.setType("Half");
    } else {
      result.setStatus("Rejected");
      result.setRejectionReason("GPA below 3.0");
      return;
    }

    // Determine duration based on recommendation letter
    if (applicant.hasDocument("REC")) {
      result.setDuration("2 years");
    } else {
      result.setDuration("1 year");
    }
  }

  @Override
  public String getApplicationType() {
    return "Merit";
  }
}
