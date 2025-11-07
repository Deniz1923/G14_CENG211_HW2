import java.util.ArrayList;

public class ApplicationMaster {
    private final ArrayList<Applicant> applicants;

    public ApplicationMaster(ArrayList<ArrayList<String>> rawInput){
        this.applicants = new ArrayList<>();
        processRawInput(rawInput);
    }

    private void processRawInput(ArrayList<ArrayList<String>> rawInput){
        //Looking for 'A' values to generate Applicant object for each applicant

        for(ArrayList<String>  information: rawInput){
            //Type means the type of information in the line, A P D T I
            String type = information.get(0);
            if(type.equals("A")){
                //A line : type,id,name,gpa,income
                String id = information.get(1);
                String name = information.get(2);
                //using parse to be returned the primitive types(double,int)
                //value of for Object types (Double,Integer)
                double gpa = Double.parseDouble(information.get(3));
                int income = Integer.parseInt(information.get(4));

                Applicant applicant = new Applicant(id,name,gpa,income);
                this.applicants.add(applicant);
            } else if (type.equals("B")) {

            }

        }
    }








}
