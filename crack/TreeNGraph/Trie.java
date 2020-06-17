/*

  {j, [26]}
  {a}

*/
import java.util.*;

class Node{
  char ch;
  Boolean last;
  TreeMap<Character, Node>links;

  Node(char ch, Boolean last){
    this.ch = ch;
    this.last = last;
    this.links = new TreeMap<>(Comparator.reverseOrder());
  }

  @Override
  public String toString(){
    return "[ ch:"+this.ch+", last :"+this.last+" links: "+this.links.keySet()+" ]";
  }
}

class Solution{
  Node head;
  public Solution(){
    head = new Node('', false);
  }


//============ PUT WORD START===========//
  // j a s j o t
  // 0 1 2 3 4 5
  private void add(Node node, String word, int indx){ //0 1 2 3 4 5 6
    if(indx >= word.length())
      return;

    Node newNode = null;
    char letter = word.charAt(indx); //j,0 a,1 s,2 j,3 o,4 t,5
    //create new node for new char.

    //see if node alread exists.
    newNode = node.links.getOrDefault(letter, null);
    if(newNode != null){
      //yes, see if last value needs to be updated.
      if(indx >= word.length()-1 )
        newNode.last = true;
    }
    else{
      //no, create new.
      if(indx < word.length()-1 )
        newNode = new Node(letter, false);
      else
        newNode = new Node(letter, true);
    }

    //add newnode to current nodes map.
    node.links.put(letter, newNode);

    //look at next.
    add(newNode, word, indx+1);
  }

  private void add(String wrd){
      TreeMap<Character, Node> childLinks = head.links;
      Node child = null;
      for(int i = 0 ; i <wrd.length(); i++){

        char c = wrd.charAt(i);
        child = childLinks.getOrDefault(c, null);

        if(child != null){
          childLinks = child.links;
        }
        else{
          //update child, in case last child we need to mark last true.
          child = new Node(c, false);
          childLinks.put(c, child);
          childLinks = child.links;
        }

      }
      child.last = true;
  }

  public void storeWords(String[] arr){
    //DFS
    // for(String word: arr){
    //   add(head, word, 0);
    // }

    //BFS
    for(String word: arr){
      add(word);
    }
  }
//============ PUT WORD END===========//

//============ GET ALL WORD STRT===========//

private void get(Node node, List<StringBuffer> wordList, StringBuffer str){
  // System.out.println(node);
  if(node == null)
    return;

  str.append(node.ch);

  if(node.last){
    wordList.add(str);
    // System.out.println(str);
  }

  for(char childCh : node.links.keySet()){
    StringBuffer tempStr = new StringBuffer(str);
    get(node.links.get(childCh), wordList, tempStr);
  }
}

public void printAllWords(){
  List<StringBuffer> wordList = new ArrayList<>();

  //DFS
  for(char childCh : head.links.keySet()){
    StringBuffer str = new StringBuffer();
    get(head.links.get(childCh), wordList, str);
  }

  //BFS, can not be done iteratively.
  // get(wordList);

  System.out.println(wordList);
}

//============ GET ALL WORD END===========//


//============ GET N WORD END===========//

private void getN(Node node, List<StringBuffer> wordList, StringBuffer str, String chkStr, int chkIndx, int n){
  // System.out.println(node);
  if(node == null)
    return;

  if(wordList.size() == n){
    return;
  }
  str.append(node.ch);

  if(node.last){
    wordList.add(str);
    // System.out.println(str);
  }

  if(chkIndx <  chkStr.length()){
    StringBuffer tempStr = new StringBuffer(str);
    getN(node.links.get(chkStr.charAt(chkIndx)), wordList, tempStr, chkStr, chkIndx+1, n);
  }
  else{
    for(char childCh : node.links.keySet()){
      StringBuffer tempStr = new StringBuffer(str);
      getN(node.links.get(childCh), wordList, tempStr, chkStr, chkIndx+1, n);
    }
  }
}

public void printNWords(String chkStr, int n){

  List<StringBuffer> wordList = new ArrayList<>();
  StringBuffer str = new StringBuffer();

  if(chkStr.equals("") || n == 0){
    System.out.println(wordList);
    return;
  }

  getN(head.links.get(chkStr.charAt(0)), wordList, str, chkStr, 1, n);
  System.out.println(wordList);
}

//============ GET N WORD END===========//
}

class Trie{
  public static void main(String[] args) {
    //, "singh", "is", "awsomely", "awsome"
    // String []words = {"jasjot" , "singh", "is", "awsomely", "awsome"};
    String []words = {"jasjot" , "jack", "james", "jhon", "jameson", "manas" };
    Solution sol = new Solution();
    sol.storeWords(words);
    sol.printAllWords();
    sol.printNWords("ja", 10);

    // Returns if the word is in the trie.
    // Returns if there is any word in the trie that starts with the given prefix.
  }
}
