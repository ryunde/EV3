/**
 * Liikkumismetodit:
 * Eteenp‰in, peruutus, oikealle ja vasemmalle k‰‰ntyminen, 360∞ k‰‰ntyminen,
 * pys‰htyminen.
 * 
 * @author Tuhmat Teletapit
 */

package toiminnot;
import lejos.hardware.motor.Motor;

public class Movement {

	public static void eteenpain() {
		
		Motor.A.forward(); //eteenp‰in
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
		
		Motor.B.rotate(-360); // k‰‰ntyy
	}
	
	public static void pysahtyy() {
		
		Motor.A.stop(); // pys‰htynyt
                Motor.B.stop();
	}
}
