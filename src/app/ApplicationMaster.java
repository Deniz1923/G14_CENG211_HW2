package app;

import applicationtypes.Application;
import core.Applicant;

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
        //Looking for 'A' values to generate misc.Applicant object for each applicant
        //otherwise the system will not work for a non-existent applicant object

        for(ArrayList<String> information: rawInput){
            //Type means the type of information in the line, A P D T I
            String type = information.get(0);
            try {
                if (type.equals("A")) {
                    //A line : type,id,name,gpa,income
                    String id = information.get(1);
                    String name = information.get(2);
                    //using parse to be returned the primitive types(double,int)
                    //value of for Object types (Double,Integer)
                    double gpa = Double.parseDouble(information.get(3));
                    int income = Integer.parseInt(information.get(4));

                    Applicant applicant = new Applicant(id, name, income);
                    this.applicants.add(applicant);
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.err.println("Error processing 'A' line: " + String.join(", ", information));
            }
        }

        for(ArrayList<String> information: rawInput){
            String type = information.get(0);
            String id = information.get(1);
            Applicant applicant = findApplicantByID(id);
            if(applicant == null) {
                continue;
            }
            try {
                switch (type) {
                    case "T":
                        // findApplicantByID(id) gets id of the applicant and returns the applicant

                        if (information.get(2).equals("Y")) {
                            applicant.setTranscriptApproval(true);//convert string "Y" to boolean True
                        } else if (information.get(2).equals("N")) {
                            applicant.setTranscriptApproval(false);
                        } else {
                            System.out.println("There is a problem with the applicant:" + applicant.getName() + "'s Y/N approval.");
                        }
                        break;

                    case "I":
                        applicant.setFamilyIncome(Double.parseDouble(information.get(2)));
                        applicant.setDependents(Integer.parseInt(information.get(3)));
                    break;

                    case "D":
                        break;

                    case "P":
                        break;
                    //Empty since we already processed.
                    case "A":
                        break;
                    default:
                        System.out.println("Unknown prefix for the system.");
                }
            }
            catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.err.println("Error processing '" + type + "' line for ID " + id + ". Skipping.");
            }
        }
    }

    public ArrayList<Application> createApplications() {
        return null;
    }
}
