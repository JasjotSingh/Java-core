import java.util.*;

class str{
  public static void main(String args[]){
    String st = "sdfffg";
    char cst[] = {'d','g','h','r'};

    StringBuffer stb = new StringBuffer(st);
    StringBuffer stbc = new StringBuffer(new String(cst));

    System.out.println("string to stringbuffer: "+stb+"\nchar array to string to string buffer:"+stbc);

    st = String.valueOf(cst);
    //not recomended
    //st = Arrays.toString(cst).substring(1,3*(cst.length)-1).replaceAll(", ","");
    System.out.println("char array to string: "+st);

    cst = st.toCharArray();
    for(char x:cst){
      System.out.println("string to char array: "+x);
    }

    System.out.println("does dt contain 'x': "+st.contains("x"));

    String ar[] = st.split("g");
    for (String x: ar){
      System.out.print("string in split array: "+x+"\n");
    }
  }

}
