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
                	Motor.C.rotate(120); //sakset
                	Motor.C.setSpeed(3000);
                	Motor.C.rotate(-120);
                	break;
                case 3:
                	Motor.A.forward(); //oikealle
            		Motor.B.stop();                	
                	break;
                case 4:
                	Motor.A.stop(); //vasemmalle
            		Motor.B.forward();                	
                	break;
                case 8:
                	Motor.A.backward(); //peruutus
                	Motor.B.backward();
                case 9:
                	Motor.A.stop(); //pysähdys
            		Motor.B.stop();                	
                	break;
                default:
            }
        }
    }    
    
}