package core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class FileIO {

    private String applicationsPath;
    private final ArrayList<ArrayList<String>> applicationsData;

    public FileIO(String applicationsPath) throws IOException {
        this.applicationsPath = applicationsPath;
        this.applicationsData = loadApplications(applicationsPath);
    }

    // Reading the applications file and writing it to an Arraylist Matrix as every row is not the same size
    private ArrayList<ArrayList<String>> loadApplications(String applicationsPath) throws IOException {
        //Delimiter set for split()
        String delimiter = ",";

        ArrayList<ArrayList<String>> listOfLists = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(applicationsPath)))) {
            String line;
            while((line = br.readLine()) != null){
                String[] fields = line.split(delimiter);
                ArrayList<String> insideTheRow = new ArrayList<>(Arrays.asList(fields));
                listOfLists.add(insideTheRow);
            }
        } catch (FileNotFoundException e) {
            throw new IOException("File not found: " + applicationsPath, e);
        } catch (IOException e) {
            throw new IOException("Error reading file: " + applicationsPath, e);
        }
        return listOfLists;
    }

    public ArrayList<ArrayList<String>> getApplicationsData(){
        return applicationsData;
    }

    public String getApplicationsPath() {
        return applicationsPath;
    }

    public void setApplicationsPath(String applicationsPath) {
        this.applicationsPath = applicationsPath;
    }
}
