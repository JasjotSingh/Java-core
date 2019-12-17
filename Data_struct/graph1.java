import java.util.*;

class WNode{
  int val;
  int weight;
  WNode(int val, int weight){
    this.val = val;
    this.weight = weight;
  }

  @Override
  public String toString(){
    return String.valueOf(this.val+" weight:"+this.weight);
  }
}

class grap{
  HashMap<Integer,LinkedList<WNode>> grp;
  HashMap<Integer,Integer> seen;

  grap(){
    grp = new HashMap<>();
    seen = new HashMap<>();
  }

  void addEdge(int v, int u, int we){
    if(!grp.containsKey(v)){
      LinkedList alist = new LinkedList<>();
      alist.add(new WNode(u,we));
      grp.put(v, alist);
    }
    else{
      grp.get(v).add(new WNode(u,we));
    }
    seen.put(v,0);
    seen.put(u,0);
  }

  void display(){
    for(int k: grp.keySet()){
      System.out.println(k+"->"+grp.get(k));
    }
  }

  boolean dlDFS(int sv){
      if(seen.get(sv) == -1){
        System.out.println("dl at :"+sv);
        return false;   //change to true to find all dl's
      }
      if(seen.get(sv) == 1){
        return true;
      }

      seen.put(sv, -1);
      LinkedList<WNode> alist = grp.getOrDefault(sv, null);
      if(alist != null){
        for(WNode node: alist){
          if(!dlDFS(node.val)){
            return false; ////change to true to find all dl's
          }
        }
      }
      seen.put(sv,1);
      return true;
  }

  void getDL(){
    for(int key : seen.keySet()){
      seen.put(key, 0);
    }

    for(int key : grp.keySet()){
      if(seen.get(key) == 0 && !dlDFS(key)){
          return;
      }
    }
  }

  void DFS(int sv){
    seen.put(sv,1);

    LinkedList<WNode> alist = grp.getOrDefault(sv, null);
    if(alist != null){
      for(WNode node: alist){
        if(seen.get(node.val) == 0){
          DFS(node.val);
        }
      }
    }
    System.out.println(sv);//Topological sort.
  }
  void getDFS(){
    for(int key : seen.keySet()){
      seen.put(key, 0);
    }
    System.out.println("DFS: ");
    for(int key : grp.keySet()){
      if(seen.get(key) == 0){
        DFS(key);
      }
    }
  }

  void BFS(int sv){
    Queue<Integer> pq = new LinkedList<>();
    pq.offer(sv);
    seen.put(sv,1);
    while(!pq.isEmpty()){
        sv = pq.poll();
        System.out.println(sv);

        LinkedList<WNode> alist = grp.getOrDefault(sv,null);
        if(alist != null){
          for(WNode node: alist){
            if(seen.get(node.val) == 0){
              pq.offer(node.val);
              seen.put(sv,1);
            }
          }
        }
    }
  }

  void getBFS(){

    for(int key : seen.keySet()){
      seen.put(key,0);
    }
    System.out.println("BFS: ");
    for(int key : grp.keySet()){
      if(seen.get(key) == 0){
        BFS(key);
      }
    }
  }
}

class grpMain{
  public static void main(String args[]){
    grap g = new grap();

    g.addEdge(0, 1,5);
    g.addEdge(0, 2,3);
    g.addEdge(1, 2,2);
    g.addEdge(2, 0,1);
    g.addEdge(2, 3,8);
    g.addEdge(3, 3,10);


    g.display();

    g.getDL();
    g.getDFS();
    g.getBFS();
    // g.getMother();
  }
}
