/**
 * H‰nn‰n ja Saksien sek‰ valon v‰l‰ytyksen luokka. H‰nt‰ liikkuu eteenp‰in ja
 * taaksep‰in. Sakset sulkeutuvat ja aukeavat. Punainen vilkkuva valo ja valot pois.
 *
 * @author Tuhmat Teletapit
 */
package toiminnot;

import lejos.hardware.motor.Motor;
import lejos.hardware.Button;

public class Attack {

    public static void saksetin() {

        Motor.C.rotate(140); //sakset sis‰‰n
    }

    public static void saksetout() {

        Motor.C.rotate(-140); //sakset ulos
    }

    public static void hanta() {

        Motor.D.rotate(15); // h‰nt‰ eteen
        Motor.D.rotate(-15); // h‰nt‰ taakse
    }

    public static void punainen() {
        Button.LEDPattern(8);
    }

    public static void valopois() {
        Button.LEDPattern(0);
    }

}
