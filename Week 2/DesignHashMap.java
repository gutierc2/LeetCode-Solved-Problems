class MyHashMap {
    // Since for this problem it was specfied that the
    // number of operations would be between 1 and 10000,
    // I figured that the maximum amount of possible values
    // being inserted into our map will be 10000, for the
    // purpose of this problem. In an actual hashmap
    // implementation, we would have a load factor that would
    // determine when we would increase the size of our data
    // structure to allow for more values.
    class Node{
         public int key;
         public int value;
         public Node next;
        
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private Node[] map;
    private int capacity;
    //private int size;
    //private final double LOAD_FACTOR = 0.75;
    
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        capacity = 10000;
        map = new Node[capacity];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hashFxn(key);
        
        Node j = map[hash];
        
        
        if(j == null) // bucket is empty
        {
            map[hash] = new Node(key, value);
        }
        else // bucket is non-empty
        {
            while(j != null) // checking to see if key already exists
            {
                if (j.key == key)
                {
                    j.value = value;
                    return;
                }
                else
                {
                    j = j.next;
                }
            }
            
            // At this point we've gone through the whole
            // bucket and we did not find the key
            // so we add the new node to the bucket
            Node n = new Node(key, value);
            n.next = map[hash];
            map[hash] = n;
        }
        
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hashFxn(key);
        
        Node j = map[hash];
            
        while(j != null)
        {
            if (j.key == key)
                return j.value;
            else
                j = j.next;
        }
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
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
    
    private int hashFxn(int key)
    {
        int result = 17;
        result = (result * 31 + key) % capacity;
        
        return result;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */