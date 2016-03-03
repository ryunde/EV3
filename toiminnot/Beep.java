package toiminnot;
import java.io.File;
import lejos.hardware.Sound;

public class Beep {
	
public static void aani(){
	
	File music = new File("hanta2.wav"); //ääni
	Sound.playSample(music, 100);
	Sound.setVolume(100);
	Sound.beepSequence();
	
	}

}
