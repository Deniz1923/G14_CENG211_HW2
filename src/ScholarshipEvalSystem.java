import core.FileIO;
import app.ApplicationMaster;
import applicationtypes.Application;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/** Implements Scholarship Evaluation System according to Specifications in the PDF */
public class ScholarshipEvalSystem {
    public static void main(String[] args) throws IOException {

        // Relative path to the resources folder
        FileIO io = new FileIO("src/resources/ScholarshipApplications.csv");

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
        //zart
    }
}

