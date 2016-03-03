/**
 * Robotti NuuNuu
 * Pääohjelmaluokka Drive, jossa main metodin myötä luokka voidaan suorittaa 
 * sovelluksena.
 * Suorittaessa robotin ruudulle ilmestyy tekstiä ja kuuluu ääni.
 * Infrapunasensorin ja ohjaimen määrittely, jotta kauko-ohjaimesta tulevat
 * kommennot voidaan lukea.
 * 
 * @author Tuhmat Teletapit
 */

import toiminnot.Beep;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;

public class Drive {

	public static void main(String[] args) {

		LCD.clear(); 
		LCD.drawString("NUU NUU", 0, 5);//kirjottaa ruutuun NUU NUU
		Beep.aani(); // pitää beep äänen
		
		final EV3IRSensor infraredSensor = new EV3IRSensor(SensorPort.S1); // infrapuna EV3 sensori-instanssi

		RemoteControl checkerThread = new RemoteControl(infraredSensor); // uusi ohjain
		checkerThread.start(); //alkaa huomioimaan objekteja
		
		
	}

}
