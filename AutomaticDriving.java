import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;
import lejos.robotics.filter.MeanFilter;
import lejos.utility.Delay;
public class AutomaticDriving {
	
	private static SensorModes sensor; // sensori
	
	public static void main(String[] args) {
       	
	LCD.clear();
        LCD.drawString("NUU NUU", 0, 5); //n‰yttˆˆn teksti
        
        Port port = LocalEV3.get().getPort("S1"); // portti instanssin haku
        
        sensor = new EV3IRSensor(port); // uusi sensori
        
        SampleProvider distance= sensor.getMode("Distance"); // hae kyseisen sensorin instanssi mittaus-muodossa !
        
        while (Button.ENTER.isUp()) { // kun painaa ENTER ohjelma loppuu -> muuten tulevat komennot ovat toiminnassa
        	
        	Delay.msDelay(2000);
        	
        	Motor.A.forward(); // ajaa eteenp‰in automaattisesti
    		Motor.B.forward();
        	
        	SampleProvider average = new MeanFilter(distance, 5); // kasataan filter sensorin p‰‰lle joka antaa viimeisimm‰n viiden n‰ytteen keskiarvon
        	float[] sample = new float[average.sampleSize()]; // alustetaan n‰yte-array
        	average.fetchSample(sample, 0); // haetaan n‰yte
        	
        	int dist = (int) sample[0]; // aloitus-n‰yte
        	
        	while (dist < 35 && Button.ENTER.isUp()) { // mik‰li et‰isyys on alle 40, ja ENTER nappulaa ei edelleenk‰‰n painettu, seuraavat kommenot tapahtuvat:
        		
        		Motor.C.rotate(120); // sakset kiinni
        		Motor.C.rotate(-120); // sakset auki
        		Motor.B.rotate(-360); // k‰‰ntyy
            	            	            	            	
            	average = new MeanFilter(distance, 5); // kasataan filter sensorin p‰‰lle taas
            	
            	sample = new float[average.sampleSize()]; // alustetaan n‰yte-array
            	
            	average.fetchSample(sample, 0); // haetaan n‰yte
            	            	            	
            	dist = (int) sample[0]; // aloitus-n‰yte
            	
            }
        }
	}
}