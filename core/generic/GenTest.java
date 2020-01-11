class GenObj<T>{
  private T obj;

  GenObj(T obj){
    this.obj = obj;
    System.out.println("in constructor T is: "+this.obj.getClass().getSimpleName());
  }
  public <T,V> void printValue( T key, V value){
    System.out.println("in method T is: "+key.getClass().getSimpleName());
    System.out.println("in constructor T is: "+this.obj.getClass().getSimpleName());
    System.out.println("key: "+key+" value: "+value);
  }

  public T getObj(){
    return this.obj;
  }
}

class GenTest{
  public static void main(String args[]){
    GenObj<String> gobj = new GenObj<>("string obj.");
    System.out.println(gobj.getObj());
    gobj.printValue(22,"ghdf");
  }
}
