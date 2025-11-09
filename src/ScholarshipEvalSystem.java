import core.FileIO;
import app.ApplicationMaster;
import applicationtypes.Application;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/** Implements Scholarship Evaluation System according to Specifications in the PDF */
public class ScholarshipEvalSystem {
    public static void main(String[] args) throws IOException {
        FileIO io = new FileIO("ScholarshipApplications.csv");

        ApplicationMaster master = new ApplicationMaster(io.getApplicationsData());

        ArrayList<Application> applications = master.createApplications();
        for (Application app : applications) {
            app.evaluate();
        }

        applications.sort(new Comparator<>() {
            @Override
            public int compare(Application a1, Application a2) {
                return a1.getResult().getApplicantID().compareTo(a2.getResult().getApplicantID());
            }
        });

        for (Application app : applications) {
            System.out.println(app.toString());
        }
    }
}