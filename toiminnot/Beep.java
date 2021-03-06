/**
 * Biippaus-luokka. Metodit soittavat äänitiedoston ja etukäteen EV3-bricksin 
 * sisältämän biippausjärjestyksen.
 *
 * @author Tuhmat Teletapit
 */
package toiminnot;

import java.io.File;
import lejos.hardware.Sound;

public class Beep {

    public static void aani() {

        File music = new File("hanta2.wav"); //äänitiedosto
        Sound.playSample(music, 100); //soita tiedosto
        Sound.setVolume(100); // äänen voimakkuus
        Sound.beepSequence(); //varmuuden vuoksi jos äänitiedosto ei jostain syystä toimi

    }

    public static void aani2() {
        File music = new File("hanta1.wav"); //äänitiedosto
        Sound.playSample(music, 100); //soita tiedosto
        Sound.setVolume(100); // äänen voimakkuus
        Sound.beepSequence(); //varmuuden vuoksi jos äänitiedosto ei jostain syystä toimi
    }

}
