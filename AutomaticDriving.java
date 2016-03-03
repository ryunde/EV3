import toiminnot.Attack;
import toiminnot.Movement;
import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;
import lejos.robotics.filter.MeanFilter;
import lejos.utility.Delay;
import toiminnot.Beep;

public class AutomaticDriving {
	
	private static SensorModes sensor; // sensori
	
	public static void main(String[] args) {
       	
		LCD.drawString("NUU NUU", 0, 5); //näyttöön teksti
		Beep.aani(); //ääni
        
        
        Port port = LocalEV3.get().getPort("S1"); // portti instanssin haku
        
        sensor = new EV3IRSensor(port); // uusi sensori
        
        SampleProvider distance= sensor.getMode("Distance"); // hae kyseisen sensorin instanssi mittaus-muodossa !
        
        while (Button.ENTER.isUp()) { // kun painaa ENTER ohjelma loppuu -> muuten tulevat komennot ovat toiminnassa
        	
        	Delay.msDelay(2000);
        	
        	Movement.eteenpain(); // ajaa eteenpäin automaattisesti
        	
        	SampleProvider average = new MeanFilter(distance, 2); // kasataan filter sensorin päälle joka antaa viimeisimmän kahden näytteen keskiarvon
        	float[] sample = new float[average.sampleSize()]; // alustetaan näyte-array
        	average.fetchSample(sample, 0); // haetaan näyte
        	
        	int dist = (int) sample[0]; // aloitus-näyte
        	
        	while (dist < 35 && Button.ENTER.isUp()) { // mikäli etäisyys on alle 35, ja ENTER nappulaa ei edelleenkään painettu, seuraavat kommenot tapahtuvat:
        		
        		Movement.pysahtyy(); // pysähtyy
        		Attack.saksetin(); // sakset kiinni
        		Attack.saksetout(); // sakset auki
        		Movement.kaantyy(); // kääntyy
            	            	            	            	
            	average = new MeanFilter(distance, 2); // kasataan filter sensorin päälle taas
            	
            	sample = new float[average.sampleSize()]; // alustetaan näyte-array
            	
            	average.fetchSample(sample, 0); // haetaan näyte
            	            	            	
            	dist = (int) sample[0]; // aloitus-näyte
            	
            }
        }
	}
}
