class Solution {
    int []nse(int arr[])
    {   int n=arr.length;
        int nse[]=new int[n];
        Stack<Integer>s=new Stack<>();
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
        }
        return nse;
    }
    int []pse(int arr[])
    {   int n=arr.length;
        int pse[]=new int[n];
        Stack<Integer>s=new Stack<>();
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
        }
        return pse;
    }
    int histogram(int arr[])
    {   int n=arr.length;
        int []pse=pse(arr);
        int[]nse=nse(arr);
        int max=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,arr[i]*(nse[i]-pse[i]-1));
        }
        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int []psum=new int[n];
        int max=0;
        for(int i=0;i<m;i++)
        {
            
            for(int j=0;j<n;j++)
            {
              
                if(matrix[i][j]=='0')
                psum[j]=0;
                else
                
                psum[j]++;
            }
        
           max=Math.max(max,histogram(psum));
        }
        
        return max;
    }
}