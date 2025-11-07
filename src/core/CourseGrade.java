package core;

public class CourseGrade {
    private char transcriptStatus;
    private double gpa;

    public CourseGrade(char transcriptStatus, double gpa){
        this.transcriptStatus = transcriptStatus;
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public double getTranscriptStatus(){
        return transcriptStatus;
    }

}
