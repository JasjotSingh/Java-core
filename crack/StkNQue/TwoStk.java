
class Solution{
  int stk[];
  int indx1;
  int indx2;
  int cap;

  Solution(int cap){
    this.cap = cap;
    stk = new int[cap];
    indx1 = -1;
    indx2 = cap;
  }

  void push(int val, int stknum){
    if(indx1 == indx2-1){
      System.out.println("stk:"+stknum+" is full ");
      return;
    }

    if(stknum == 0){
      stk[++indx1] = val;
    }
    else{
      stk[--indx2] = val;
    }
  }

  void pop(int stknum){
    if(stknum == 0){
      if(indx1 == -1){
        System.out.println("stk:"+stknum+" is empty ");
        return;
      }
      System.out.println(stk[indx1--]);
    }
    else{
      if(indx2 == cap){
        System.out.println("stk:"+stknum+" is empty ");
        return;
      }
      System.out.println(stk[indx2++]);
    }
  }
}

class TwoStk{
  public static void main(String[] args) {
    Solution sol = new Solution(2);

    sol.push(0,0);
    sol.push(1,0);
    sol.push(1,0);
    sol.push(2,1);
    sol.pop(0);
    sol.push(2,1);
    sol.push(3,1);
    sol.pop(0);
    sol.push(3,1);
    sol.push(1,1);
    sol.push(0,0);
    sol.pop(1);
    sol.pop(1);
    sol.push(0,0);
    sol.push(2,1);
    sol.push(1,0);
    sol.push(3,1);
  }
}
