/**
 * Hännän ja Saksien sekä valon väläytyksen luokka. Häntä liikkuu eteenpäin ja
 * taaksepäin. Sakset sulkeutuvat ja aukeavat. Punainen vilkkuva valo ja valot pois.
 *
 * @author Tuhmat Teletapit
 */
package toiminnot;

import lejos.hardware.motor.Motor;
import lejos.hardware.Button;

public class Attack {

    public static void saksetin() {

        Motor.C.rotate(140); //sakset sisään
    }

    public static void saksetout() {

        Motor.C.rotate(-140); //sakset ulos
    }

    public static void hanta() {

        Motor.D.rotate(15); // häntä eteen
        Motor.D.rotate(-15); // häntä taakse
    }

    public static void punainen() { //punainen valo vilkkuu
        Button.LEDPattern(8);
    }

    public static void valopois() { //mikään led-valo ei loista
        Button.LEDPattern(0);
    }

}
