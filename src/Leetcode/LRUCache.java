import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer,Node> map = new HashMap<>();
    Node head;
    Node tail;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node(-1);
        this.tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key))return -1;
        Node node = removeNode(key);
        updateHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = removeNode(key);
            node.val = value;
            updateHead(node);
            return;
        }
        if(size == capacity){
            removeTail();
            size--;
        }
        Node node = new Node(key,value);
        updateHead(node);
        size++;
    }

    private void updateHead(Node node){
        Node next = head.next;
        node.prev = head;
        node.next = next;
        head.next = node;
        next.prev = node;
    }

    private Node removeNode(int key){
        Node node = map.get(key);
        Node prev = node.prev;
        Node next = node.next;
        node.prev = null;
        node.next = null;
        prev.next = next;
        next.prev = prev;
        return node;
    }

    private void removeTail(){
        Node node = tail.prev;
        if(node == head) return;
        Node prev = node.prev;
        node.prev = null;
        node.next = null;
        prev.next = tail;
        tail.prev = prev;
        map.remove(node.key);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
    }

    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }

        public Node(int key){
            this.key = key;
            this.val = -1;
        }
    }
}
