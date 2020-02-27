class fibb{
  public static void main(String[] args) {
    int dp[] = new int[6];
    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2 ; i < 6;i++){
      dp[i] = dp[i-1]+dp[i-2];
      System.out.println(i+" : "+dp[i]);
    }

  }
}
