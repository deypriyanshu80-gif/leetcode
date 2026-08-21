class Solution {
    int []nse(int arr1[])
    {
        Stack<Integer>s=new Stack<>();
        int n=arr1.length;
        int []nse=new int[n];
        for(int i=n-1;i>=0;i--){
        while(!s.isEmpty()&&arr1[i]<=arr1[s.peek()])
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
        }
    return nse;}
        int []pse(int arr1[])
    {
        Stack<Integer>s=new Stack<>();
        int n=arr1.length;
        int []pse=new int[n];
        for(int i=0;i<n;i++){
        while(!s.isEmpty()&&arr1[i]<arr1[s.peek()])
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
    return pse;}
    public int sumSubarrayMins(int[] arr) {
        int mod = (int)(1e9 + 7);
        int []nse=nse(arr);
        int []pse=pse(arr);
        int n=arr.length;
        long c;
        long total=0;
        for(int i=0;i<n;i++)
        {
            int ld=i-pse[i];
            int rd=nse[i]-i;
            c=(long)ld*rd*arr[i];
             total = (total + c) % mod;
        }
       return (int)total;
    }
}