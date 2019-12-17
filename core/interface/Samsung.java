class Samsung implements Phone{
  int count;
  String name;

  Samsung(){
    this.count = 4;
    this.name = "Android";
  }

  @Override
  public int getCount(){
    return this.count;
  }
  @Override
  public String getName(){
    return this.name;
  }

  public String getLogo(){
    return "we suck as well.";
  }
}
