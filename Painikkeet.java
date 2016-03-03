import java.util.ArrayList;
public class Painikkeet {
	
	class Button {
		Button(String name, int color, int keycode){
			this.name = name;
			this.color = color;
			this.keycode = keycode;
		}
		public String name;
		public int color;
		public int keycode;
	}
	
	class Buttons{
		ArrayList<Button> buttonList = new ArrayList<Button>();
		
		void initList(){
			buttonList.add(new Button("YL", 1, 2));
			buttonList.add(new Button("OI", 2, 5));
			buttonList.add(new Button("AL", 3, 6));
			buttonList.add(new Button("VA", 0, 3));
		}
		
		Boolean hasChoice(){
			return !buttonList.isEmpty();
		}
		
		void showAvailable(){
			for(int i=0; i<buttonList.size(); i++) {
				Button b = buttonList.get(i);
				System.out.println("Not pressed:" + b.name);
			}
		}
		
		Boolean isValid(int keycode){
			for(int i=0; i<buttonList.size(); i++) {
				Button b = buttonList.get(i);
				if (b.keycode==keycode)
					return true;
			}
			return false;
		}
		
		void hasPressed(int keycode){
			for(int i=0; i<buttonList.size(); i++) {
				Button b = buttonList.get(i);
				if (b.keycode==keycode) {
					buttonList.remove(i);
					Button.LEDPattern(b.color);
					break;
				}
			}
		}
	}
	
	public void run(){
		
		Buttons buttons = new Buttons();
		
		
		while (buttons.hasChoice()) {
			buttons.showAvailable();
			int keycode = Button.waitForAnyPress();
			if ( buttons.isValid(keycode)) {
				buttons.hasPressed(keycode);
			} else {
				// wrong button, pressed again
			}
		}
		//endgame++
		
		
	
	// LCD.drawString("YL OI AL VA", 0, 0);
	
	}
}