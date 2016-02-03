package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * creats a private arraylist that will contain all entries made by the user
 * using multiple methods other LonelyTwitterActivity can access and manipulate data found
 * inside the array.
 * @version 1/26/16
 * @author klark
 */
public class TweetList {
    /**
     * various functionalities of Tweetlist
     * @see #add(Tweet)
     * @see #hasTweet(Tweet)
     * @see #getTweet(int)
     * @see #delete(Tweet)
     */
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

    /**
     * @deprecated addTweet is not used anywhere in the program as it has been
     * implemented elsewhere
     * @param tweet
     */
    public void addTweet(Tweet tweet){ //-- should throw an IllegalArgumentException when one tries to add a duplicate tweet

        if (tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
    }

    /**
     * @deprecated getTweets is not used anywhere in the program as it has been
     * implemented elsewhere
     * @return
     */
    public ArrayList<Tweet> getTweets(){ //-- should return a list of tweets in chronological order
        ArrayList<Tweet> sortingtweets=tweets;
        Collections.sort(sortingtweets, new Comparator<Tweet>(){
            public int compare (Tweet t1, Tweet t2){
                return t1.getDate().compareTo(t2.getDate());
            }
        });
        return tweets;
    }

    /**
     *
     * @param tweet getTweets is not used anywhere in the program as it has been
     * implemented elsewhere
     * @return
     */
    public boolean hasTweet2(Tweet tweet){ //-- should return true if there is a tweet that equals() another tweet

        if(tweets.contains(tweet)){
            return true;
        }
        return false;
        /*else{
            return false;
        }*/
    }

    /**
     * removes a tweet from tweetlist
     * @param tweet
     */
    public void removeTweet(Tweet tweet){ //-- should remove a tweet

        tweets.remove(tweet);
    }

    /**
     * not used in the code, was supposed to get the number of tweets in the tweet list
     * @deprecated
     */
    public void getCount(){ //-- should accurately count up the tweets
        int arrayplace = tweets.size();
        System.out.format("%d",arrayplace);
    }


}
