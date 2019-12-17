/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 //variation of leet code instead of merging list of k srted linkedlist,
 //here merging k sorted list of lists.(can simply be done by min heap as well.)
 //add all elems from all lists in min heap and return.
 import java.util.*;
class Solution {

    void mergeSort(List<List<Integer>> lists, int strt, int end){
        List<Integer> l1 = lists.get(strt);
        List<Integer> l2 = lists.get(end);
        List<Integer> tmp = new ArrayList<Integer>();
        //System.out.println(l1+" "+l2);
        //ListNode prev = tmp;
        int i = 0 ; int j = 0;
        while(i < l1.size() && j < l2.size()){
            int num1 = l1.get(i);
            int num2 = l2.get(j);
            if(num1 < num2){
                tmp.add(num1);
                i++;
            }
            else{
              tmp.add(num2);
              j++;
            }
        }
        while(i < l1.size()){

          int num1 = l1.get(i);
          tmp.add(num1);
          i++;
        }
        while(j < l2.size()){
          int num2 = l2.get(j);
          tmp.add(num2);
          j++;
        }

        lists.set(strt,new ArrayList<Integer>(tmp) );// = ;
        lists.set(end,new ArrayList<Integer>(tmp)); //= new ArrayList<Integer>(tmp);

    }

    void Merge(List<List<Integer>> lists, int strt, int end){
        if(strt >= end){
            return;
        }
        int mid = (strt+end)/2;
        Merge(lists,strt,mid);
        Merge(lists,mid+1,end);
        mergeSort(lists,strt,end);

        System.out.println(lists.get(strt)+" "+strt+" "+end);

    }
    public List<Integer> mergeKLists(List<List<Integer>> lists) {
        if(lists.size() == 0)
            return null;
        Merge(lists, 0, lists.size() -1);
        return lists.get(0);
    }

    public List<Integer> mergeKListsMinHeap(List<List<Integer>> lists){
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for(List<Integer> lst : lists){
        for(int i: lst){
          pq.offer(i);
        }
      }

      List<Integer> ret =  new ArrayList<>();
      while(!pq.isEmpty()){
        ret.add(pq.poll());
      }
      return ret;
    }
}

class mergek{

  public static void main(String args[]){
    Solution sl = new Solution();

    List<List<Integer>> ar = new ArrayList<>();
    ar.add(new ArrayList<Integer>(Arrays.asList(1,2,500)));
    ar.add(new ArrayList<Integer>(Arrays.asList(1,2,3,4,11,12,1000)));
    ar.add(new ArrayList<Integer>(Arrays.asList(5,6,400)));
    ar.add(new ArrayList<Integer>(Arrays.asList(25,26,40)));
    System.out.println(sl.mergeKLists(ar));

    ar = new ArrayList<>();
    ar.add(new ArrayList<Integer>(Arrays.asList(1,2,500)));
    ar.add(new ArrayList<Integer>(Arrays.asList(1,2,3,4,11,12,1000)));
    ar.add(new ArrayList<Integer>(Arrays.asList(5,6,400)));
    ar.add(new ArrayList<Integer>(Arrays.asList(25,26,40)));
    System.out.println(sl.mergeKListsMinHeap(ar));
  }
}
