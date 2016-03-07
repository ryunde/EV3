
/**
 * Robotti NuuNuu
 * P‰‰ohjelmaluokka Drive, jossa main metodin myˆt‰ luokka voidaan suorittaa
 * sovelluksena. Suorittaessa robotin ruudulle ilmestyy teksti‰ ja kuuluu ‰‰ni.
 * Infrapunasensorin ja ohjaimen m‰‰rittely, jotta kauko-ohjaimesta tulevat
 * kommennot voidaan lukea.
 *
 * @author Tuhmat Teletapit
 */
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;

public class Drive {

    public static void main(String[] args) {

        final EV3IRSensor infraredSensor = new EV3IRSensor(SensorPort.S1); // infrapuna EV3 sensori-instanssi

        RemoteControl checkerThread = new RemoteControl(infraredSensor); // uusi ohjain-olio
        checkerThread.start(); //alkaa huomioimaan objekteja

    }

}
