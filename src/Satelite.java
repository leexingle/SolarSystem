public class Satelite extends CelestialBody{

    protected double centreOfRotationDistance;
    protected double centreOfRotationAngle;
    protected Planet planet;

    public Satelite(SolarSystem solarSystem,double distance, double angle, double diameter, String col, double centreOfRotationDistance, double centreOfRotationAngle, Planet planet, double velocity) {
        super(solarSystem,distance, angle, diameter, col, velocity);
        this.centreOfRotationDistance = centreOfRotationDistance;
        this.centreOfRotationAngle = centreOfRotationAngle;
        this.planet = planet;
    }

    @Override
    public void draw(){
        solarSystem.drawSolarObjectAbout(distance, angle, diameter, col,centreOfRotationDistance,centreOfRotationAngle);
    }

    public void changeCentreRotationAngle(){
        centreOfRotationAngle = planet.angle;
    }
    
}