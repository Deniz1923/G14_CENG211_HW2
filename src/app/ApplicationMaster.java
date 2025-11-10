package app;

import applicationtypes.Application;
import applicationtypes.AcademicApplication;
import applicationtypes.FinancialApplication;
import applicationtypes.ResearchApplication;
import core.Applicant;
import core.CourseGrade;
import core.Document;
import core.Publication;
import evaluationtypes.MeritBasedEval;
import evaluationtypes.NeedBasedEval;
import evaluationtypes.ResearchBasedEval;

import java.util.ArrayList;

public class ApplicationMaster {
    private final ArrayList<Applicant> applicants;

    public ApplicationMaster(ArrayList<ArrayList<String>> rawInput){
        this.applicants = new ArrayList<>();
        processRawInput(rawInput);
    }

    private Applicant findApplicantByID(String studentID){
        for (Applicant applicant : this.applicants){
            if(applicant.getStudentID().equals(studentID)){
                return applicant;
            }
        }
        return null;
    }

    private void processRawInput(ArrayList<ArrayList<String>> rawInput){
        // First pass: Create all Applicant objects from 'A' lines
        for(ArrayList<String> information: rawInput){
            String type = information.get(0);
            try {
                if (type.equals("A")) {
                    //A line : type,id,name,gpa,income
                    String id = information.get(1);
                    String name = information.get(2);
                    double income = Double.parseDouble(information.get(4));

                    Applicant applicant = new Applicant(id, name, income);
                    this.applicants.add(applicant);
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.err.println("Error processing 'A' line: " + String.join(", ", information));
            }
        }

        // Second pass: Process all other information
        for(ArrayList<String> information: rawInput){
            String type = information.get(0);

            if (type.equals("A")) {
                continue; // Already processed
            }

            String id = information.get(1);
            Applicant applicant = findApplicantByID(id);

            if(applicant == null) {
                continue;
            }

            try {
                switch (type) {
                    case "T":
                        // Transcript line: T, applicantID, transcriptStatus (Y/N)
                        // Note: GPA is in the A line, not T line
                        char status = information.get(2).charAt(0);
                        double gpa = 0;

                        // Get GPA from A line
                        for (ArrayList<String> aLine : rawInput) {
                            if (aLine.get(0).equals("A") && aLine.get(1).equals(id)) {
                                gpa = Double.parseDouble(aLine.get(3));
                                break;
                            }
                        }

                        applicant.setCourseGrade(new CourseGrade(status, gpa));
                        applicant.setTranscriptApproval(status == 'Y');
                        break;

                    case "I":
                        // Family info: I, applicantID, familyIncome, dependents
                        double familyIncome = Double.parseDouble(information.get(2));
                        int dependents = Integer.parseInt(information.get(3));

                        applicant.setFamilyIncome(familyIncome);
                        applicant.setDependents(dependents);
                        break;

                    case "D":
                        // Document: D, applicantID, documentType, durationInMonths
                        String docType = information.get(2);
                        int duration = Integer.parseInt(information.get(3));

                        Document doc = new Document(docType, duration);
                        applicant.addDocument(doc);
                        break;

                    case "P":
                        // Publication: P, applicantID, title, impactFactor
                        String title = information.get(2);
                        double impactFactor = Double.parseDouble(information.get(3));

                        Publication pub = new Publication(title, impactFactor);
                        applicant.addPublication(pub);
                        break;

                    default:
                        System.out.println("Unknown prefix for the system: " + type);
                }
            }
            catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.err.println("Error processing '" + type + "' line for ID " + id + ". Skipping.");
            }
        }
    }

    public ArrayList<Application> createApplications() {
        ArrayList<Application> applications = new ArrayList<>();

        for (Applicant applicant : applicants) {
            String id = applicant.getStudentID();
            Application app = null;

            // Determine application type based on ID prefix
            if (id.startsWith("11")) {
                // Merit-based scholarship
                app = new AcademicApplication(applicant, new MeritBasedEval());
            } else if (id.startsWith("22")) {
                // Need-based scholarship
                app = new FinancialApplication(applicant, new NeedBasedEval());
            } else if (id.startsWith("33")) {
                // Research grant
                app = new ResearchApplication(applicant, new ResearchBasedEval());
            }

            if (app != null) {
                applications.add(app);
            }
        }

        return applications;
    }
}