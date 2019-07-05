class MyHashSet {
    // This design is very similar to the hashmap
    // design so you can tell I reused a lot of the
    // same code. Just made modifications as to not
    // include a "value" field in Node.
    class Node{
         public int key;
         public Node next;
        
        public Node(int key)
        {
            this.key = key;
            this.next = null;
        }
    }
    
    private Node[] map;
    private final int CAPACITY = 10000;
    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new Node[CAPACITY];
    }
    
    public void add(int key) {
        int hash = hashFxn(key);
        
        Node j = map[hash];
        
        if(j == null) // bucket is empty
        {
            map[hash] = new Node(key);
        }
        else // bucket is non-empty
        {
            while(j != null) // checking to see if key already exists
            {
                if (j.key == key)
                    return;
                else
                    j = j.next;
            }
            
            // At this point we've gone through the whole
            // bucket and we did not find the key
            // so we add the new node to the bucket
            Node n = new Node(key);
            n.next = map[hash];
            map[hash] = n;
        }
    }
    
    public void remove(int key) {
        int hash = hashFxn(key);
        
        Node j = map[hash];
        
        if (j != null && j.key == key) // Special case for head
        {
            map[hash] = j.next;
            return;
        }
        
        while(j != null)
        {
            if (j.next != null)
            {
                if (j.next.key == key)
                {
                    j.next = j.next.next;
                    return;
                }
            }
            j = j.next;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hashFxn(key);
        
        Node j = map[hash];
            
        while(j != null)
        {
            if (j.key == key)
                return true;
            else
                j = j.next;
        }
        
        return false;
    }
    
    private int hashFxn(int key)
    {
        int result = 17;
        result = (result * 31 + key) % CAPACITY;
        
        return result;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */