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
	// TODO Auto-generated method stub
       	
	LCD.clear();
        LCD.drawString("NUU NUU", 0, 5);
        
	// get a port instance
        Port port = LocalEV3.get().getPort("S1");
        
        sensor = new EV3IRSensor(port);
        
        // get an instance of this sensor in measurement mode
        SampleProvider distance= sensor.getMode("Distance");
        
        while (Button.ENTER.isUp()) {
        	
        	Delay.msDelay(2000);
        	
        	Motor.A.forward();
    		Motor.B.forward();
        	
        	// stack a filter on the sensor that gives the running average of the last 5 samples
        	SampleProvider average = new MeanFilter(distance, 5);
        	// initialize an array of floats for fetching samples
        	float[] sample = new float[average.sampleSize()];
        	// fetch a sample
        	average.fetchSample(sample, 0);
        	
        	int dist = (int) sample[0];
        	
        	while (dist < 35 && Button.ENTER.isUp()) {
        		Motor.A.backward();
        		Motor.B.backward();
            	            	            	            	
            	// stack a filter on the sensor that gives the running average of the last 5 samples
            	average = new MeanFilter(distance, 5);
            	
            	// initialize an array of floats for fetching samples
            	sample = new float[average.sampleSize()];
            	
            	// fetch a sample
            	average.fetchSample(sample, 0);
            	            	            	
            	dist = (int) sample[0];
            	
            }
        }
	}
}