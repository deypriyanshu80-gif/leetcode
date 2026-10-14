class Twitter {
    private class Tweet{
        int authorId;
        int tweetId;
        public Tweet(int authorId,int tweetId)
        {
            this.authorId=authorId;
            this.tweetId=tweetId;
        }
    }
        List<Tweet>alltweet;
        HashMap<Integer,Set<Integer>>follow;
    
    public Twitter() {
        alltweet=new ArrayList<>();
        follow=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newtweet=new Tweet(userId,tweetId);
        alltweet.add(newtweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer>feed=new ArrayList<>();
        for(int i=alltweet.size()-1;i>=0;i--)
        {
            Tweet currtweet=alltweet.get(i);
            boolean mytweet=(currtweet.authorId==userId);
            boolean isfollowertweet=follow.containsKey(userId)&&follow.get(userId).contains(currtweet.authorId);
            if(mytweet||isfollowertweet)
            {
                feed.add(currtweet.tweetId);

            }
            if(feed.size()==10)
            {
                break;
            }
            
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)
        return;
        if(!follow.containsKey(followerId))
        {
            follow.put(followerId,new HashSet<>());
        }
        follow.get(followerId).add(followeeId);

    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follow.containsKey(followerId))
        {
            follow.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */