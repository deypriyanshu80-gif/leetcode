class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        int []nse=new int[n];
        Stack<Integer>s=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!s.isEmpty()&&prices[i]<s.peek())
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                nse[i]=prices[i];
            }
            else{
                nse[i]=prices[i]-s.peek();
            }
            s.push(prices[i]);
        }
        return nse;
    }
}