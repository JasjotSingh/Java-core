
import swtch.*;

class ControllerOnOff{
  public void controllerOnOff(boolean onoff, Switch sw){
    if(onoff){
      System.out.println(sw.switchOn());
    }
    else{
      System.out.println(sw.switchOff());
    }
  }
}
class Controller{
  public static void main(String args[]){
    Switch fansw = new Fan();
    Switch lightsw = new Light();

    ControllerOnOff con = new ControllerOnOff();
    con.controllerOnOff(true, fansw);
    con.controllerOnOff(false, lightsw);
  }
}
