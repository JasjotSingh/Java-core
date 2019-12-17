import java.util.*;
class LinkedHmap{
  public static void main(String args[]){
    LinkedHashMap<Integer,String> lhmap = new LinkedHashMap<>();
    LinkedHashMap<Integer,String> lhmap1 = new LinkedHashMap<>(4){
      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer,String> eldest){
        return size() > 4;
      }
    };

    lhmap1.put(3,"fdfd");
    lhmap1.put(4,"dsdw");
    lhmap1.put(1,"dsfdfg");
    lhmap1.put(6,"jgbfr");

    System.out.println(lhmap1.get(3));

    lhmap1.put(43,"fdgvc");
    lhmap1.put(6,"new");

    if(lhmap.isEmpty()){
      lhmap.putAll(lhmap1);
    }

    Iterator<Map.Entry<Integer, String>> ent = lhmap.entrySet().iterator();
    while(ent.hasNext()){
      Map.Entry<Integer, String> it = ent.next();
      System.out.println(it.getKey()+" "+it.getValue());
    }

    System.out.println("\nlhmap size: "+lhmap.size());

  }
}
