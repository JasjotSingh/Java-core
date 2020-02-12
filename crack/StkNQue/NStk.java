

class Solution{
  int stk[];
  int stksize;
  int size[];

  Solution(int cap, int nstk){
    stk = new int[cap*nstk];
    stksize = cap;
    size = new int[nstk];
  }

  public void push(int val, int stknum){
    if(isFull(stknum)){
      System.out.println("stk: "+stknum+" is full");
      return;
    }
    int stkindx = size[stknum] + ((stknum)*stksize);
    stk[stkindx] = val;
    size[stknum]++;
    System.out.println("stk: "+stknum+" stksize:"+size[stknum]);
  }

  public int pop(int stknum){
    if(isEmpty(stknum)){
      System.out.println("stk: "+stknum+" is Empty");
      return-1;
    }

    size[stknum]--;
    int stkindx = size[stknum] + ((stknum)*stksize);
    return stk[stkindx];
  }

  public int top(int stknum){
    if(isEmpty(stknum)){
      System.out.println("stk: "+stknum+" is Empty");
      return -1;
    }
    int stkindx = size[stknum] + ((stknum)*stksize) - 1;
    return stk[stkindx];
  }
  boolean isFull(int stknum){
    return size[stknum] == stksize;
  }
  boolean isEmpty(int stknum){
    return size[stknum] == 0;
  }
}

class NStk{

  public static void main(String[] args) {

    Solution sol = new Solution(5,3);
    System.out.println("push: ");
    for(int i  = 0 ; i < 7; i++){
      sol.push(i*1, 0);
      sol.push(i*2, 1);
      sol.push(i*3, 2);
    }
    System.out.println("pop: ");
    for(int i  = 0 ; i < 7; i++){
      System.out.println(sol.pop(0));
      System.out.println(sol.pop(1));
      System.out.println(sol.pop(2));
    }

    System.out.println("push: ");
    for(int i  = 0 ; i < 7; i++){
      sol.push(i*1, 0);
      sol.push(i*2, 1);
      sol.push(i*3, 2);
    }

    System.out.println("top: ");
    for(int i  = 0 ; i < 7; i++){
      System.out.println(sol.top(0));
      System.out.println(sol.top(1));
      System.out.println(sol.top(2));
    }

    System.out.println("pop: ");
    for(int i  = 0 ; i < 7; i++){
      System.out.println(sol.pop(0));
      System.out.println(sol.pop(1));
      System.out.println(sol.pop(2));
    }
  }
}
