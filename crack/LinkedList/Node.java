import java.util.*;
public class Node<T>{
  T val;
  Node<T> next;
  Node<T> head;
  Node(){
    head = null;
  }
  Node(T val){
    this.val = val;
    this.next = null;
  }

  Node<T> addNode(T val){
    Node<T> node = new Node<>(val);
    node.next = head;
    head = node;
    return head;
  }

  Node<T> addNode(List<T> valList){
    for(T val: valList)
      head = addNode(val);
    return head;
  }
}
