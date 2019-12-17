import java.util.*;

class GraphUtil{
  HashMap<Integer, HashSet<Integer>> grp;
  HashMap<Integer,Integer> seen;
  //Iterator<Map.Entry<Integer,HashSet<Integer>>> git;

  GraphUtil(){
    grp = new HashMap<>();
    seen = new HashMap<>();
  }

  public void addEdge(int i, int j){
    HashSet<Integer> hlist;
    if(!grp.containsKey(i)){
      hlist = new HashSet();
      hlist.add(j);
      grp.put(i, hlist);
    }
    else{
      hlist = grp.get(i);
      hlist.add(j);
      //grp.put(i, grp.get(i).add(j));
    }
    seen.put(i,0);
    seen.put(j,0);
  }

  public void display(){
    Set<Integer> kset = grp.keySet();
    for(int key: kset){
      System.out.println(key+" : "+grp.get(key) );
    }
  }

  //get deadlock.
  private boolean dfsDL(int key){
      if(seen.get(key) == 2){
        System.out.println("DL at node :"+key);
        return true;
      }
      else if(seen.get(key) == 1){
        return false;
      }
      HashSet<Integer> alist = grp.get(key);
      seen.put(key,2);
      if(alist == null){
        seen.put(key,1);
        return false;
      }
      for(int node: alist){
        if(dfsDL(node)){
          return true;
        }
      }
      seen.put(key,1);
      return false;
  }

  //get deadlock.
  public void getDL(){
    Set<Integer> kset = grp.keySet();
    Set<Integer> sset = seen.keySet();
    //null out seen.
    for(int skey: sset){
      seen.put(skey,0);
    }
    for(int key : kset){
      if(seen.get(key) == 0){
        if(dfsDL(key)){
          System.out.println("DL from node: "+key);
        }
        else{
          System.out.println("No DL from node: "+key);
        }
      }
    }
  }

  private void dfs(int knode){
    if(seen.get(knode) == 1){
      return;
    }
    System.out.print(knode+" ");
    seen.put(knode,1);
    HashSet<Integer> alist = grp.get(knode);
    if(alist == null){
      return;
    }
    for(int node: alist){
      dfs(node);
    }
  }
  //get dfs.
  public void getDFS(){
    Set<Integer> kset = grp.keySet();
    Set<Integer> sset = seen.keySet();

    System.out.println("DFS: ");
    //null out seen.
    for(int skey: sset){
      seen.put(skey,0);
    }
    for(int key: kset){
      if(seen.get(key) == 0){
        dfs(key);
        System.out.println("");
      }
    }
  }

  private void bfs(int knode){
    Queue<Integer> bqu = new LinkedList<>();
    bqu.add(knode);
    seen.put(knode,1);
    while(!bqu.isEmpty()){
      int node = bqu.poll();

      System.out.print(node+" ");

      Set<Integer> alist = grp.get(node);
      if(alist == null)
        continue;
      for(int anode: alist){
        if(seen.get(anode) == 0){
          seen.put(anode,1);
          bqu.add(anode);
        }
      }
    }
  }
  public void getBFS(){
    Set<Integer> kset = grp.keySet();
    Set<Integer> sset = seen.keySet();
    System.out.println("BFS: ");
    for(int ks: sset){
      seen.put(ks,0);
    }
    for(int kg: kset){
      if(seen.get(kg) == 0){
        bfs(kg);
        System.out.println("");
      }
    }
  }

  //get mother node.
  public void getMother(){

    Set<Integer> kset = grp.keySet();
    Set<Integer> sset = seen.keySet();
    System.out.println("get mother node : ");
    for(int ks: sset){
      seen.put(ks,0);
    }

    //do dfs node to finish last can be mother.
    int mnode = 0;
    for(int kg: kset){
      if(seen.get(kg) == 0){
        mnode = kg;
        dfs(kg);
      }
    }

    for(int ks: sset){
      seen.put(ks,0);
    }
    System.out.println("");
    dfs(mnode);
    System.out.println("");

    boolean mother = true;
    for(int val: seen.values()){
      if(val != 1){
        mother  = false;
      }
    }
    if(mother)
      System.out.println(mnode+" id mother node");
  }
}
class graph{
  public static void main(String args[]){
    GraphUtil gra = new GraphUtil();
    //gra.addEdge(0,1);
    gra.addEdge(0, 4);
    //gra.addEdge(1, 2);
    //gra.addEdge(1, 3);
    gra.addEdge(1, 4);
    gra.addEdge(2, 1);
    gra.addEdge(2, 3);
    gra.addEdge(3, 2);
    gra.addEdge(3, 4);
    gra.addEdge(4, 0);
    //gra.addEdge(4, 1);


    gra.display();

    gra.getDL();
    gra.getDFS();
    gra.getBFS();
    gra.getMother();
  }
}
