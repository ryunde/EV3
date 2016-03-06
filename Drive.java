import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
public class Drive {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCD.clear();
		LCD.drawString("NUU NUU", 0, 0);
		// Get an instance of the IR EV3 sensor
		
		
		final EV3IRSensor infraredSensor = new EV3IRSensor(SensorPort.S1);
		RemoteControl checkerThread = new RemoteControl(
				infraredSensor);
		checkerThread.start();
	}
}