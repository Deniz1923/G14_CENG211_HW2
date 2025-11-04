import java.lang.reflect.Array;
import java.util.ArrayList;

public class ApplicationMaster {
    private final ArrayList<Applicant> applicants;
    public ApplicationMaster(ArrayList<ArrayList<String>> rawInput){
        this.applicants = new ArrayList<>();
        processRawInput(rawInput);
    }

    private void processRawInput(ArrayList<ArrayList<String>> rawInput){
        //First string value
        for(ArrayList<String> list : rawInput){
            String id = list.get(1);
        }
    }
}
