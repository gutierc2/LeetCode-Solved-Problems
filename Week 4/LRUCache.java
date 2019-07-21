class LRUCache {

    class Node
    {
        int val;
        int key;
        Node prev;
        Node next;
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
        
        public boolean isEqualTo(Node n)
        {
            return n.key == key;
        }
    }
    
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    
    public LRUCache(int capacity) {
        
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        
        int output = -1;
        
        if (capacity > 0)
        {
            if (map.containsKey(key))
            {
                Node n = map.get(key);
                output = n.val;
                
                if (!n.isEqualTo(head))
                { 
                    if (n.isEqualTo(tail))
                        tail = tail.prev;
                    
                    if (n.prev != null)
                        n.prev.next = n.next;
                    if (n.next != null)
                        n.next.prev = n.prev;

                    n.next = head;
                    n.prev = null;

                    head.prev = n;
                    head = n;
                }
            }
        }
        
        return output;
    }
    
    public void put(int key, int value) {
        
        if (!map.containsKey(key))
        {
            if (map.size() == capacity)
            {
                map.remove(tail.key);
                tail = tail.prev;
                if (tail != null)
                    tail.next = null;
                else
                    head = null;
            }

            Node n = new Node(key, value);
            n.prev = null;
            n.next = head;
            if (head != null)
                head.prev = n;

            map.put(key, n);
            head = n;

            if (map.size() == 1)
                tail = head;
        }
        else
        {
            Node n = map.get(key);
            n.val = value;
            
            if (!n.isEqualTo(head))
            {
                if (n.isEqualTo(tail))
                    tail = tail.prev;

                if (n.prev != null)
                    n.prev.next = n.next;
                if (n.next != null)
                    n.next.prev = n.prev;

                n.next = head;
                n.prev = null;

                head.prev = n;
                head = n;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */