package core;

public class Publication {
    private final String name;
    private final double impactFactor;

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
