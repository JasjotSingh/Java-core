class Soluton{
  //start placing elems from back., replace spaces with %20.
  void URLify(char ar[], int len){
    int lindx = len -1;
    for(int i  = ar.length -1 ; i >= 0;lindx--){
      if(ar[lindx] != ' '){
        ar[i--] = ar[lindx];
      }
      else{
        ar[i--] = '0';
        ar[i--] = '2';
        ar[i--] = '%';
      }
    }
    System.out.println(String.valueOf(ar));
  }
}

class URLify{
  public static void main(String[] args) {
      String s1 = "Mr Jhon Smith    ";
      Soluton sol = new Soluton();
      sol.URLify(s1.toCharArray(), 13);
  }
}
