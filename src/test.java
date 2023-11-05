import java.util.ArrayList;

public class test {

    public static void main(String[] args) {

        ArrayList<CelestialBody> celestialBody = new ArrayList<>();
        
        SolarSystem solarSystem = new SolarSystem(2000,1000);

        Sun sun = new Sun(solarSystem,0,0,80,"YELLOW",0);
        celestialBody.add(sun);
        
        Planet mercury = new Planet(solarSystem, 58.05, 90, 7.66, "GREY",1.59);
        celestialBody.add(mercury);

        Planet venus = new Planet(solarSystem,108.45, 45, 18.98,"WHITE", 1.18);
        celestialBody.add(venus);

        Planet earth = new Planet(solarSystem,150,0,20,"BLUE", 1);
        celestialBody.add(earth);

        Satelite moon = new Satelite(solarSystem, 18, 0, 5.448, "GREY", earth.distance,earth.angle, earth, 0.0343);
        celestialBody.add(moon);

        Planet mars = new Planet(solarSystem,200,35,10.64,"RED", 0.808);
        celestialBody.add(mars);
                
        Planet jupyter = new Planet(solarSystem, 300, 135, 50, "ORANGE",0.439);
        celestialBody.add(jupyter);

        Satelite io = new Satelite(solarSystem, 30, 0, 5.3, "ORANGE", jupyter.distance, jupyter.angle, jupyter,0.3);
        celestialBody.add(io);

        Satelite europa = new Satelite(solarSystem, 30, 60, 5.3, "ORANGE", jupyter.distance, jupyter.angle, jupyter,0.3);
        celestialBody.add(europa);

        Satelite ganymede = new Satelite(solarSystem, 30, 180, 5.3, "ORANGE", jupyter.distance, jupyter.angle, jupyter,0.3);
        celestialBody.add(ganymede);

        Satelite callisto = new Satelite(solarSystem, 30, 300, 5.3, "ORANGE", jupyter.distance, jupyter.angle, jupyter,0.3);
        celestialBody.add(callisto);

        Planet saturn = new Planet(solarSystem, 385, 90, 45, "YELLOW",0.325);
        celestialBody.add(saturn);

        Satelite[] saturnRing = new Satelite[360];
        for (int k=0; k<360; k++){
            saturnRing[k] = new Satelite(solarSystem, 30, k, 1, "YELLOW", saturn.distance, saturn.angle, saturn, 0);
        }
        
        Planet uranus = new Planet(solarSystem, 460, 360, 30, "GREEN",0.228);
        celestialBody.add(uranus);

        Planet neptune = new Planet(solarSystem, 520, 270, 28, "BLUE",0.182);
        celestialBody.add(neptune);

        Comet halley = new Comet(solarSystem, 0, 90, 5, "RED", 1, 1600, 0.97);
        celestialBody.add(halley);

        //create aesteroids
        Aesteroids[] aList1 = new Aesteroids[300];
        Aesteroids[] aList2 = new Aesteroids[300];

        double aInitialAngle1 = 0;
        double aInitialAngle2 = 0;

        //create aesteroid for list 1
        for (int i=0; i < 120; i++){
            
            double adiameter = (Math.random() * (8.0-3.0) + 3.0);
            double adistance = (Math.random() * (240.0-235.0) + 235.0);
            aList1[i] = new Aesteroids(solarSystem,adistance, aInitialAngle1,adiameter,"GREY",0.1);
            double randomIncreaseAngle = (Math.random() * (4.0-3.0) + 3.0);
            aInitialAngle1 += randomIncreaseAngle;
            
        }

        // create aesteroids for list 2
        for (int i=0; i < 120; i++){
            
            double adiameter = (Math.random() * (8.0-3.0) + 3.0);
            double adistance = (Math.random() * (245.0-239.0) + 239.0);
            aList2[i] = new Aesteroids(solarSystem,adistance, aInitialAngle2,adiameter,"GREY",0.1);
            double randomIncreaseAngle = (Math.random() * (4.0-3.0) + 3.0);
            aInitialAngle2 += randomIncreaseAngle;
            
        }
        



        // draw celestial bodies
        for (int i=0; i<1000; i++){

            //draw sun n planets
            for (CelestialBody c: celestialBody){
                if (c instanceof Satelite ){
                    ((Satelite)c).changeCentreRotationAngle();
                }
                c.draw();
            }

            //draw aesteroids
            for (int j=0; j < 120; j++){
                aList1[j].draw();
                aList2[j].draw();
            }

            //draw saturn ring
            for (int j=0; j < 360; j++){
                saturnRing[j].changeCentreRotationAngle();
                saturnRing[j].draw();   
            }

            solarSystem.finishedDrawing();

            //change planet angle
            for (CelestialBody c: celestialBody){
                c.velocity();
            }
            //change aesteroids angle
            for (int j=0; j < 120; j++){
                aList1[j].velocity();
                aList2[j].velocity();
            }

        }        
    }
}