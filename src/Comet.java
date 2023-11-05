/**
 * Comet
 */
public class Comet extends CelestialBody{

    private double semiMajorAxis;
    private double eccentricity;

    public Comet(SolarSystem solarSystem,double distance, double angle, double diameter, String col, double velocity, double semiMajorAxis, double eccentricity ) {
        super(solarSystem,distance, angle, diameter, col, velocity);
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        
    }

    @Override
    public void draw(){
        distance = semiMajorAxis * (1 - eccentricity * eccentricity) / (1 + eccentricity * Math.cos(Math.toRadians(angle)));
        solarSystem.drawSolarObject(distance, angle, diameter, col);       
    }
}