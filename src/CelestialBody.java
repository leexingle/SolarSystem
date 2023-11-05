/**
 * CelestialBody
 */
public abstract class CelestialBody {

    protected SolarSystem solarSystem;
    protected double distance;
    protected double angle;
    protected double diameter;
    protected String col;
    protected double velocity;
    
    public CelestialBody(SolarSystem solarSystem,double distance, double angle, double diameter, String col, double velocity) {
        this.solarSystem = solarSystem;
        this.distance = distance;
        this.angle = angle;
        this.diameter = diameter;
        this.col = col;
        this.velocity = velocity;
    }

    public void draw(){
        solarSystem.drawSolarObject(distance, angle, diameter, col);       
    }

    //update angle
    public void velocity(){
        angle += velocity;
    } 
    
}