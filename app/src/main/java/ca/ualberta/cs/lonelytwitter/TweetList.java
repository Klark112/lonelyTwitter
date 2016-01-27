package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by klark on 1/26/16.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add( Tweet tweet){
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    public void addTweet(){} //-- should throw an IllegalArgumentException when one tries to add a duplicate tweet
    public void getTweets(){} //-- sould return a list of tweets in chronological order
    public void hasTweet(){} //-- should return true if there is a tweet that equals() another tweet
    public void removeTweet(){} //-- should remove a tweet
    public void getCount(){} //-- should accurately count up the tweets


}
