package core;

public class Document {
    private final String documentType;
    private final int durationInMonths;

    public Document(String documentType, int durationInMonths){
        this.documentType = documentType;
        this.durationInMonths = durationInMonths;
    }

    //String is immutable and int is primitive(returned by value) so no security leaks
    public String getDocumentType(){
        return documentType;
    }

    public int getDurationInMonths(){
        return durationInMonths;
    }

}
