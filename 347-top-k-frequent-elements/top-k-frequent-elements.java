class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        PriorityQueue<Integer> min = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );
        for(int i=0;i<n;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (int num : map.keySet()) {
             min.add(num);
        if(min.size()>k)
            min.poll();
            }
            int arr[]=new int[min.size()];
          int i=0;
          while(min.size()>0)
            {
                arr[i]=min.peek();
                min.poll();
                i++;
            }
            return arr;
    }
}