package core;

public class CourseGrade {
    private final char transcriptStatus;
    private final double gpa;

    public CourseGrade(char transcriptStatus, double gpa){
        this.transcriptStatus = transcriptStatus;
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public char getTranscriptStatus(){
        return transcriptStatus;
    }
}