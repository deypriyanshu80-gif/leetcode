class Solution {
    int []pse(int arr1[])
    {
        Stack<Integer>s=new Stack<>();
        int n=arr1.length;
        int []pse=new int[n];
        for(int i=0;i<n;i++){
        while(!s.isEmpty() && arr1[i]<arr1[s.peek()])
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
        }
        return pse;
    }int []nse(int arr1[])
     {
        Stack<Integer>s=new Stack<>();
        int n=arr1.length;
        int []nse=new int[n];
        for(int i=n-1;i>=0;i--){
        while(!s.isEmpty() && arr1[i]<=arr1[s.peek()])
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
    }int []pge(int arr1[])
     {
        Stack<Integer>s=new Stack<>();
        int n=arr1.length;
        int []pge=new int[n];
        for(int i=0;i<n;i++){
        while(!s.isEmpty() && arr1[i]>arr1[s.peek()])
        {
            s.pop();
        }
        if(s.isEmpty())
        {
            pge[i]=-1;
        }
        else{
            pge[i]=s.peek();
        }
        s.push(i);
        }return pge;
    }int []nge(int arr1[])
     {
        Stack<Integer>s=new Stack<>();
        int n=arr1.length;
        int []nge=new int[n];
        for(int i=n-1;i>=0;i--){
        while(!s.isEmpty() && arr1[i]>=arr1[s.peek()])
        {
            s.pop();
        }
        if(s.isEmpty())
        {
            nge[i]=n;
        }
        else{
            nge[i]=s.peek();
        }
        s.push(i);
        }return nge;
    }
    long summin(int nums[])
    {
        int []pse=pse(nums);    
        int []nse=nse(nums);
        long total=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int ls=i-pse[i];
            int rs=nse[i]-i;
            total+=(long)ls*rs*nums[i];
        }
        return total;

    }
        long summax(int nums[])
    {
        int []pge=pge(nums);    
        int []nge=nge(nums);
        long total=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int ls=i-pge[i];
            int rs=nge[i]-i;
            total+=(long)ls*rs*nums[i];
        }
        return total;

    }
    public long subArrayRanges(int[] nums) {
    long mintotal=summin(nums);
    long maxtotal=summax(nums);
    return maxtotal-mintotal;       

        
    }
}