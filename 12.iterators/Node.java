public class Node<T> {
      private T    data; // Entry in list
      private Node<T> next; // Reference variable storing the address of the next node
      
      public Node(T data, Node<T> next) {
         this.data = data;
         this.next = next;
      } // end constructor
      
      public Node(T data) {
          this(data, null);
      } // end constructor
       
      public T getData() {
         return this.data;
      } // end getData
      
      public void setData(T newData) {
         this.data = newData;
      } // end setData
      
      public Node<T> getNext() {
         return this.next;
      } // end getNextNode
      
      public void setNext(Node<T> nextNode) {
         this.next = nextNode;
      } // end setNextNode
} // end Node