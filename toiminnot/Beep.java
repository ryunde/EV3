package toiminnot;
import java.io.File;
import lejos.hardware.Sound;

public class Beep {
	
public static void aani(){
	
	File music = new File("hanta2.wav"); //‰‰nitiedosto
	Sound.playSample(music, 100); //soita tiedosto
	Sound.setVolume(100); // ‰‰nen voimakkuus
	Sound.beepSequence(); //varmuuden vuoksi jos ‰‰nitiedosto ei jostain syyst‰ toimi
	
	}

}
