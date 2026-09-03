class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
     
        
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> max = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue());
        
        max.addAll(map.entrySet());
        StringBuilder result =new StringBuilder();

        while(max.size()>0){
            Map.Entry<Character,Integer>entry=max.poll();
            char c=entry.getKey();
            int l=entry.getValue();
        for(int i=0;i<l;i++)
        {
            result.append(c);
        }
        }return result.toString();
    }
}