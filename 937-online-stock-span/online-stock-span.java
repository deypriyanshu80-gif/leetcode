class StockSpanner {
Stack<int[]>s;
int index;
    public StockSpanner() {
        s=new Stack<>();
         index=-1;
    }
    
    public int next(int price) {
       index=index+1;
        while(!s.isEmpty()&&price>=s.peek()[0])
        {
          s.pop();
        }
        int ans=index-(s.isEmpty()?-1:s.peek()[1]);
        s.push(new int[]{price,index});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */