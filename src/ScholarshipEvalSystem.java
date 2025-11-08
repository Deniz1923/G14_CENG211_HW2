import core.FileIO;
import app.ApplicationMaster;
import applicationtypes.Application;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ScholarshipEvalSystem {
    public static void main(String[] args) throws IOException {
        // TODO: 1. Read CSV file
        FileIO io = new FileIO("ScholarshipApplications.csv");

        // TODO: 2. Process data into Applicant objects
        ApplicationMaster master = new ApplicationMaster(io.getApplicationsData());

        // TODO: 3. Create Application objects (Merit/Need/Research)
        ArrayList<Application> applications = master.createApplications();

        // TODO: 4. Evaluate each application
        for (Application app : applications) {
            app.evaluate();
        }

        // TODO: 5. Sort by Applicant ID
        Collections.sort(applications, new Comparator<Application>() {
            @Override
            public int compare(Application a1, Application a2) {
                return a1.getResult().getApplicantID().compareTo(a2.getResult().getApplicantID());
            }
        });

        // TODO: 6. Print results
        for (Application app : applications) {
            System.out.println(app.toString());
        }
    }
}