
import toiminnot.Beep;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;

public class Drive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LCD.clear(); 
		LCD.drawString("NUU NUU", 0, 5);//kirjottaa ruutuun NUU NUU
		Beep.aani(); // pit‰‰ beep ‰‰nen

		// Get an instance of the IR EV3 sensor
		
		
		final EV3IRSensor infraredSensor = new EV3IRSensor(SensorPort.S1); // infrapuna EV3 sensori-instanssi

		RemoteControl checkerThread = new RemoteControl(infraredSensor); // uusi ohjain
		checkerThread.start(); //alkaa huomioimaan objekteja
		
		
	}

}