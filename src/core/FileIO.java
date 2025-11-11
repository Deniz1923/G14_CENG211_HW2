package core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Reads a CSV file that is packaged on the class‑path (e.g. under src/resources)
 * and exposes its content as an {@link ArrayList} of rows.
 */
public class FileIO {

    private final String applicationsPath;

    /**
     * Parsed CSV data – each inner list represents one row.
     * The outer list is immutable after construction.
     */
    private final ArrayList<ArrayList<String>> applicationsData;

    /**
     * Loads the CSV file from the class‑path.
     * @param applicationsPath relative path on the class‑path
     * @throws IOException if the resource is missing or unreadable
     */
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

    /**
     * @return a shallow copy of the parsed data. The outer list is new,
     * but inner lists remain mutable (no external code modifies them in this project).
     */
    public ArrayList<ArrayList<String>> getApplicationsData() {
        return new ArrayList<>(applicationsData);
    }

    /** @return the original path supplied to the constructor. */
    public String getApplicationsPath() {
        return applicationsPath;
    }

}
