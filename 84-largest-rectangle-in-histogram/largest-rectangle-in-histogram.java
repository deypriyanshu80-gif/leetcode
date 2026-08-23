class Solution {
    int []nse(int arr[])
    {   
        Stack<Integer>s=new Stack<>();
        int n=arr.length;
        int []nse=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while(!s.isEmpty()&&arr[i]<=arr[s.peek()])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                nse[i]=n;
            }
            else{
                nse[i]=s.peek();
            }
        s.push(i);
        }return nse;
    }
        int []pse(int arr[])
    {   
        Stack<Integer>s=new Stack<>();
        int n=arr.length;
        int []pse=new int[n];
        for(int i=0;i<n;i++)
        {
            while(!s.isEmpty()&&arr[i]<arr[s.peek()])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                pse[i]=-1;
            }
            else{
                pse[i]=s.peek();
            }
        s.push(i);
        }return pse;
    }

    public int largestRectangleArea(int[] heights) {
        int []pse=pse(heights);
        int []nse=nse(heights);

        int n=heights.length;
        int max=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,heights[i]*(nse[i]-pse[i]-1));           
        }
    return max;
    }
}