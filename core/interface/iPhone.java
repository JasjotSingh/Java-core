class iPhone implements Phone{
  int count;
  String name;

  iPhone(){
    this.count = 2;
    this.name = "iphone";
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
    return "we suck.";
  }
}
