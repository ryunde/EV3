import toiminnot.Attack;
import toiminnot.Movement;
import lejos.hardware.Button;
import lejos.hardware.sensor.EV3IRSensor;


public class RemoteControl extends Thread {

	
    private EV3IRSensor infraredSensor;
    
    public RemoteControl(final EV3IRSensor sensor){
        this.infraredSensor = sensor;
    }	

    public void run() {

    	while(Button.ENTER.isUp()){
            final int remoteCommand = infraredSensor.getRemoteCommand(0);
            switch (remoteCommand){
                case 1:
                	Movement.eteenpain(); //eteenp‰in
                    break;
                case 2:
                	Movement.taaksepain(); //taaksep‰in
                	break;
                case 3:
                	Movement.oikealle(); //oikealle                	
                	break;
                case 4:
                	Movement.vasemmalle(); //vasemmalle                	
                	break;
                case 5:
                	Attack.saksetin(); //sakset sis‰‰n
                	break;
                case 6:
                	Attack.saksetout();  //sakset ulos
                	break;
                case 8:
                	Attack.hanta(); //h‰nt‰
            		break;
                case 9:           	
                	break;
                default:
                	Movement.pysahtyy(); //pys‰htynyt
                	
            }
            
            
        }
    	

    }    
    
}