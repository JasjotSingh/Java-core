
import swtch.Switch;
public class Light implements Switch{
  @Override
  public String switchOn(){
    return "light switched on";
  }

  @Override
  public String switchOff(){
    return "light switched off";
  }
}
