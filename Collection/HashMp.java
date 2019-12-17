import java.util.*;

class Emphmp{
  int num;
  String name;

  Emphmp(int num, String name){
      this.num = num;
      this.name = name;
  }

  int getNum(){
    return this.num;
  }
  String getName(){
    return this.name;
  }
}
class HashMp{
  public static void main(String args[]){
    HashMap<Integer,Emphmp> hmap = new HashMap<>();
    HashMap<Integer,Emphmp> hmap1 = new HashMap<>();
    hmap.put(2,new Emphmp(231,"ddsr"));
    hmap.put(4,new Emphmp(1221,"feg"));
    hmap.put(1,new Emphmp(433,"dvddsr"));
    hmap.put(5,new Emphmp(11,"f3fdeg"));

    Iterator<Map.Entry<Integer,Emphmp>> itr = hmap.entrySet().iterator();

    while(itr.hasNext()){
      Map.Entry<Integer,Emphmp> eset = itr.next();
      System.out.println(eset.getKey()+" "+eset.getValue().getNum()+" "+eset.getValue().getName());
    }

    if(hmap1.isEmpty()){
      System.out.println("\nall elems added to hmap1");
      hmap1.putAll(hmap);
      hmap.clear();
    }

    if(hmap1.containsKey(2)){
      Emphmp val = hmap1.get(2);
      System.out.println("\npresent in hmap1");
      System.out.println(val.getNum()+" "+val.getName());
    }
    else{
      System.out.println("\nprinting keys in hmap1");
      Set<Integer> kset = hmap1.keySet();
      for(int x: kset)
        System.out.println(x);
    }
  }
}
