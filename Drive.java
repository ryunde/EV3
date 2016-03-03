import java.io.File;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
public class Drive {
	public static void main(String[] args) {
		LCD.clear();
		LCD.drawString("NUU NUU", 0, 0);
		
		
		final EV3IRSensor infraredSensor = new EV3IRSensor(SensorPort.S1);
		RemoteControl checkerThread = new RemoteControl(
				infraredSensor);
		checkerThread.start();
		
		
	}
}
