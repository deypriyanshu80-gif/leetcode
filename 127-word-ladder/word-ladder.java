class Solution {
     record Pair(String text,int number){};
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       Set<String>k=new HashSet<>();
        Queue<Pair>q=new ArrayDeque<>();
        q.offer(new Pair(beginWord,1));
        for(int i=0;i<wordList.size();i++)
        {
            k.add(wordList.get(i));
        }
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            String j=curr.text();
            int num=curr.number();
            if(j.equals(endWord))
            return num;
            for(int i=0;i<j.length();i++)
            {
                char charArr[]=j.toCharArray();
                char org=charArr[i];
                for(char c='a';c<='z';c++)
                {
                   
                    if(c==org)
                    continue;
                     charArr[i]=c;
                    String newWord=new String(charArr);
                    if(k.contains(newWord))
                    {
                        q.offer(new Pair(newWord,num+1));
                        k.remove(newWord);
                    }
                }
            }
        }
return 0;
    }
}