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
	private static SensorModes sensor;
	public static void main(String[] args) {
       	
	LCD.clear();
        LCD.drawString("NUU NUU", 0, 5);

        Port port = LocalEV3.get().getPort("S1");
        
        sensor = new EV3IRSensor(port);
        
        SampleProvider distance= sensor.getMode("Distance");
        
        while (Button.ENTER.isUp()) {
        	
        	Delay.msDelay(2000);
        	
        	Motor.A.forward();
    		Motor.B.forward();
        	
        	SampleProvider average = new MeanFilter(distance, 5);

        	float[] sample = new float[average.sampleSize()];

        	average.fetchSample(sample, 0);
        	
        	int dist = (int) sample[0];
        	
        	while (dist < 35 && Button.ENTER.isUp()) {
        		Motor.A.backward();
        		Motor.B.backward();
            	            	            	            	

            	average = new MeanFilter(distance, 5);
            	

            	sample = new float[average.sampleSize()];
            	

            	average.fetchSample(sample, 0);
            	            	            	
            	dist = (int) sample[0];
            	
            }
        }
	}
}
