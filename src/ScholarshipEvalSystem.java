import core.FileIO;
import app.ApplicationMaster;
import applicationtypes.Application;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/** Implements Scholarship Evaluation System according to Specifications in the PDF */
public class ScholarshipEvalSystem {
    public static void main(String[] args){

        try {
            String csvPath = "src/resources/ScholarshipApplications.csv";

            FileIO io = new FileIO(csvPath);

            ApplicationMaster master = new ApplicationMaster(io.getApplicationsData());

            ArrayList<Application> applications = master.createApplications();
            for (Application app : applications) {
                app.evaluate();
            }

            // Sorting the applicants by ID
            applications.sort(Comparator.comparing(a -> a.getResult().getApplicantID()));

            for (Application app : applications) {
                System.out.println(app.toString());
            }

        } catch (IOException e) {
            System.err.println("Failed to load application data: " + e.getMessage());
            e.printStackTrace();
        }

    }
}