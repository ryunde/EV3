import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3IRSensor;
public class RemoteControl extends Thread {
	
    private EV3IRSensor infraredSensor;
    
    public RemoteControl(final EV3IRSensor sensor){
        this.infraredSensor = sensor;
    }	
    @Override
    public void run() {
    	while(Button.ENTER.isUp()){
            final int remoteCommand = infraredSensor.getRemoteCommand(0);
            switch (remoteCommand){
                case 1:
                	Motor.A.forward(); //eteenpäin
            		Motor.B.forward(); 
                    break;
                case 2:
                	Motor.A.backward(); //peruutus
                	Motor.B.backward();
                	break;
                case 3:
                	Motor.A.forward(); //oikealle
            		Motor.B.backward();                	
                	break;
                case 4:
                	Motor.A.backward(); //vasemmalle
            		Motor.B.forward();                	
                	break;
                case 5:
                	Motor.C.rotate(140); //sakset
                	break;
                case 6:
                	Motor.C.rotate(-140); //sakset 2
                	break;
                case 8:
                	Motor.D.rotate(15); // häntä
            		Motor.D.rotate(-15);
            		break;
                case 9:
                	              	
                	break;
                default:
                	Motor.A.stop();
                	Motor.B.stop();
                	
            }
            
            
        }
    	
    }    
    
}