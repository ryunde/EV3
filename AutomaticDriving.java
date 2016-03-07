
/**
 * Toinen ohjelmaluokka, joka toimii sovelluksena ja k‰ynnistyess‰‰n selvitt‰‰
 * infrapunsasensorillaan edess‰ olevan esteen et‰isyyden ja toimii sen mukaan.
 * Jos ei ole estett‰ havaittavissa, robotti liikkuu eteenp‰in.
 * Mik‰li este on liian l‰hell‰, robotti pys‰htyy, v‰lkytt‰‰ punaista valoa,
 * liikuttaa saksiaan, k‰‰ntyy ja jatkaa matkaa taas.
 *
 * @author Tuhmat Teletapit
 */
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

        LCD.drawString("NUU NUU", 0, 5); //ruudulle teksti
        Beep.aani(); //‰‰ni

        Port port = LocalEV3.get().getPort("S1"); // portti instanssin haku

        sensor = new EV3IRSensor(port); // uusi sensori

        SampleProvider distance = sensor.getMode("Distance"); // hae kyseisen sensorin instanssi mittaus-muodossa !

        while (Button.ENTER.isUp()) { // kun painaa ENTER ohjelma loppuu -> muuten tulevat komennot ovat toiminnassa

            Delay.msDelay(2000);

            Movement.eteenpain(); // ajaa eteenp‰in automaattisesti

            SampleProvider average = new MeanFilter(distance, 2); // kasataan filter sensorin p‰‰lle joka antaa viimeisimm‰n kahden n‰ytteen keskiarvon
            float[] sample = new float[average.sampleSize()]; // alustetaan n‰yte-array
            average.fetchSample(sample, 0); // haetaan n‰yte

            int dist = (int) sample[0]; // aloitus-n‰yte

            while (dist < 35 && Button.ENTER.isUp()) { // mik‰li et‰isyys on alle 35, ja ENTER nappulaa ei edelleenk‰‰n painettu, seuraavat kommenot tapahtuvat:

                Movement.pysahtyy(); // pys‰htyy
                Beep.aani2(); //‰‰ni
                Attack.punainen(); // punainen v‰lkkyv‰ valo
                Attack.saksetin(); // sakset kiinni
                Attack.saksetout(); // sakset auki
                Movement.kaantyy(); // k‰‰ntyy

                average = new MeanFilter(distance, 2); // kasataan filter sensorin p‰‰lle taas

                sample = new float[average.sampleSize()]; // alustetaan n‰yte-array

                average.fetchSample(sample, 0); // haetaan n‰yte

                dist = (int) sample[0]; // aloitus-n‰yte

            }
        }
    }
}
