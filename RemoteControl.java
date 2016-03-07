
/**
 * Kauko-ohjaimen luokka, jossa sijaitsee metodi kauko-ohjaimen painettujen
 * nappuloiden huomioiminen ja niihin reagoiminen tietyll‰ tavalla. Erilaisia
 * toimintoja on 7; eteenp‰in, taaksep‰in, oikealle ja vasemmalle k‰‰ntyminen
 * sek‰ h‰nn‰n ja saksien liikuttaminen.
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

    private EV3IRSensor infraredSensor; //infrapunasensori p‰‰ss‰

    public RemoteControl(final EV3IRSensor sensor) {
        this.infraredSensor = sensor;
    }

    public void run() {

        LCD.clear();
        LCD.drawString("NUU NUU", 0, 5);//kirjottaa ruutuun NUU NUU
        Beep.aani(); // pit‰‰ beep ‰‰nen

        while (Button.ENTER.isUp()) { //sill‰ aikaa kun ENTER nappulaa ei ole painittu, seuraavat toiminnot ovat voimassa:7

            final int remoteCommand = infraredSensor.getRemoteCommand(0); //sensorin tunnistama ohjaimen painikkeen (jota on painettu) numero

            switch (remoteCommand) {
                case 1: //painike 1 (vas.yl)
                    Movement.eteenpain(); //eteenp‰in
                    break;
                case 2: //painike 2 (vas.al)
                    Movement.taaksepain(); //taaksep‰in
                    break;
                case 3: //painike 3 (oik.yl)
                    Movement.oikealle(); //oikealle                	
                    break;
                case 4: //painike 4 (oik.al)
                    Movement.vasemmalle(); //vasemmalle                	
                    break;
                case 5: //painikkeet 1+3 
                    Attack.saksetin(); //sakset sis‰‰n
                    Attack.punainen(); //punainen v‰lkkyv‰ valo
                    break;
                case 6: //painikkeet 1+4
                    Attack.saksetout();  //sakset ulos
                    Attack.punainen(); //punainen v‰lkkyv‰ valo
                    break;
                case 8: //painikkeet 2+4
                    Attack.hanta(); //h‰nt‰
                    Attack.punainen(); //punainen v‰lkkyv‰ valo
                    break;
                default:
                    Movement.pysahtyy(); //pys‰htynyt
                    Attack.valopois(); //ei v‰lkkyvi‰ valoja

            }

        }

    }

}
