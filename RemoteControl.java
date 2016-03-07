
/**
 * Kauko-ohjaimen luokka, jossa sijaitsee metodi kauko-ohjaimen painettujen
 * nappuloiden huomioiminen ja niihin reagoiminen tietyllä tavalla. Aluksi näyttöön
 * ilmestyy teksti ja kuuluu beep-ääni. Erilaisia toimintoja on 7; eteenpäin, taaksepäin, 
 * oikealle ja vasemmalle kääntyminen sekä hännän ja saksien liikuttaminen. Hännän ja saksien
 * liikkumisen yhteydessä vilkkuu myös punainen valo.
 *
 * @author Tuhmat Teletapit
 */
import toiminnot.Attack;
import toiminnot.Movement;
import lejos.hardware.Button;
import lejos.hardware.sensor.EV3IRSensor;
import toiminnot.Beep;
import lejos.hardware.lcd.LCD;

public class RemoteControl extends Thread {

    private EV3IRSensor infraredSensor; //infrapunasensori päässä

    public RemoteControl(final EV3IRSensor sensor) {
        this.infraredSensor = sensor;
    }

    public void run() {

        LCD.clear();
        LCD.drawString("NUU NUU", 0, 5);//kirjottaa ruutuun NUU NUU
        Beep.aani(); // pitää beep äänen

        while (Button.ENTER.isUp()) { //sillä aikaa kun ENTER nappulaa ei ole painittu, seuraavat toiminnot ovat voimassa:

            final int remoteCommand = infraredSensor.getRemoteCommand(0); //sensorin tunnistama ohjaimen painikkeen (jota on painettu) numero

            switch (remoteCommand) {
                case 1: //painike 1 (vas.yl)
                    Movement.eteenpain(); //eteenpäin
                    break;
                case 2: //painike 2 (vas.al)
                    Movement.taaksepain(); //taaksepäin
                    break;
                case 3: //painike 3 (oik.yl)
                    Movement.oikealle(); //oikealle                	
                    break;
                case 4: //painike 4 (oik.al)
                    Movement.vasemmalle(); //vasemmalle                	
                    break;
                case 5: //painikkeet 1+3 
                    Attack.saksetin(); //sakset sisään
                    Attack.punainen(); //punainen välkkyvä valo
                    break;
                case 6: //painikkeet 1+4
                    Attack.saksetout();  //sakset ulos
                    Attack.punainen(); //punainen välkkyvä valo
                    break;
                case 8: //painikkeet 2+4
                    Attack.hanta(); //häntä
                    Attack.punainen(); //punainen välkkyvä valo
                    break;
                default:
                    Movement.pysahtyy(); //pysähtynyt
                    Attack.valopois(); //ei välkkyviä valoja

            }

        }

    }

}
