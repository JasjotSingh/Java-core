
import swtch.Switch;
public class Fan implements Switch{
  @Override
  public String switchOn(){
    return "fan switched on";
  }

  @Override
  public String switchOff(){
    return "fan switched off";
  }
}
