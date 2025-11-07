public class Publication {
    private String name;
    private double impactFactor;

    public Publication(String name, double impactFactor){
        this.name = name;
        this.impactFactor = impactFactor;
    }

    public String getName(){
        return name;
    }

    public double getImpactFactor() {
        return impactFactor;
    }
}
