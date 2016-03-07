/**
 * Liikkumismetodit:
 * Eteenpäin, peruutus, oikealle ja vasemmalle kääntyminen, 
 * B renkaan pyörähdys 360°, pysähtyminen.
 * 
 * @author Tuhmat Teletapit
 */

package toiminnot;
import lejos.hardware.motor.Motor;

public class Movement {

	public static void eteenpain() {
		
		Motor.A.forward(); //eteenpäin
		Motor.B.forward();
	}
	
	public static void taaksepain() {
		
		Motor.A.backward(); //peruutus
                Motor.B.backward();
	}
	
	public static void oikealle() {
		
		Motor.A.forward(); //oikealle
		Motor.B.backward();
	}

	public static void vasemmalle() {
	
		Motor.A.backward(); //vasemmalle
		Motor.B.forward();
	}
	
	public static void kaantyy() {
		
		Motor.B.rotate(-360); // kääntyy
	}
	
	public static void pysahtyy() {
		
		Motor.A.stop(); // pysähtynyt
                Motor.B.stop();
	}
}
