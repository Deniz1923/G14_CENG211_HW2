package core;

public class Publication {
  private final String name;
  private final double impactFactor;

  public Publication(String name, double impactFactor) {
    this.name = name;
    this.impactFactor = impactFactor;
  }

  /**
   * Creates a deep copy of another Publication object.
   *
   * @param other The Publication to copy.
   */
  public Publication(Publication other) {
    this.name = other.name;
    this.impactFactor = other.impactFactor;
  }

  public String getName() {
    return name;
  }

  public double getImpactFactor() {
    return impactFactor;
  }
}
