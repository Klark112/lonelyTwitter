package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

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


    //start of lab 4
    public void addTweet(Tweet tweet){ //-- should throw an IllegalArgumentException when one tries to add a duplicate tweet

        if (tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
    }
    public ArrayList<Tweet> getTweets(){ //-- should return a list of tweets in chronological order
        ArrayList<Tweet> sortingtweets=tweets;
        Collections.sort(sortingtweets, new Comparator<Tweet>(){
            public int compare (Tweet t1, Tweet t2){
                return t1.getDate().compareTo(t2.getDate());
            }
        });
        return tweets;
    }

    public boolean hasTweet2(Tweet tweet){ //-- should return true if there is a tweet that equals() another tweet

        if(tweets.contains(tweet)){
            return true;
        }
        return false;
        /*else{
            return false;
        }*/
    }
    public void removeTweet(Tweet tweet){ //-- should remove a tweet

        tweets.remove(tweet);
    }
    public void getCount(){ //-- should accurately count up the tweets
        int arrayplace = tweets.size();
        System.out.format("%d",arrayplace);
    }


}
