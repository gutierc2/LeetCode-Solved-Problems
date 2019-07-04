class Solution {
    // At first I tried a much more complicated approach involving
    // a hashmap and updating each value as we traversed the candies list,
    // but then I realized that the maximum amount of different candies
    // that the sister could have is equal to have the length of the array.
    // So if we have less "kinds" of candies in the array than half the length
    // of the array, then the sister can only have a maximum of different
    // candies equal to the amount of different kinds of candies we have.
    
    // A HashSet is much more suitable for this problem than a HashMap.
    public int distributeCandies(int[] candies) {
        
        HashSet<Integer> candiesSet = new HashSet<Integer>();
        
        // Experimenting with an enhanced for loop
        for(int i : candies)
        {
           candiesSet.add(i);
        }
        
        return (candies.length/2 < candiesSet.size()) ? 
            candies.length/2 : candiesSet.size();
        
        
    }
}