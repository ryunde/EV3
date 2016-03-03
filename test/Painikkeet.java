package test;
import java.util.ArrayList;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Painikkeet {
	public static void main(String[] args) {
		
		int keycode;
		String tuloste = "";
		
		ArrayList<String> napit = new ArrayList<String>();
			napit.add("YL");
			napit.add("VA");
			napit.add("AL");
			napit.add("OL");
		
		while (!napit.isEmpty()){
			tuloste = "";
			LCD.clear();
			Button.LEDPattern(0);
			for (String item: napit){
				tuloste += item + " "; 
						
			}
			LCD.drawString(tuloste, 0, 1);
			keycode = Button.waitForAnyPress();
			if(keycode == 1){
				napit.remove("YL");
					
			}else if(keycode == 16){
				napit.remove("VA");
				Button.LEDPattern(0);
				Delay.msDelay(2000);
					
			}else if(keycode == 4){
				napit.remove("AL");
				Button.LEDPattern(1);
				Delay.msDelay(2000);
					
			}else if(keycode == 8){
				napit.remove("OL");
				Button.LEDPattern(3);
				Delay.msDelay(2000);
			}
		}
		LCD.clear();
		LCD.drawString("Nyt kotiin", 0, 0);
		Button.LEDPattern(7);
		Delay.msDelay(5000);
	
	}
}
