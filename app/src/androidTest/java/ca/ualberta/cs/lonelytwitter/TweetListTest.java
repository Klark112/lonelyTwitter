package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by klark on 1/26/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test Tweet");

        tweets.add(tweet);

        assertTrue(tweets.hasTweet(tweet));
    }

    public void testhasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        assertFalse(tweets.hasTweet(tweet));

        tweets.add(tweet);
        tweets.hasTweet(tweet);

        assertTrue(tweets.hasTweet(tweet));
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test Tweet");

        tweets.add(tweet);
        tweets.delete(tweet);


        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet(("Test Tweet"));

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(),tweet.getMessage());
        assertEquals(returnedTweet.getDate(),tweet.getDate());
    }

    public void testgetCount(){
        ArrayList<Tweet> tweets = new ArrayList<Tweet>();
        Tweet tweet = new NormalTweet("Test Tweet");
        int arrayplace = tweets.size();
        assertEquals(0,arrayplace);
        tweets.add(tweet);
        arrayplace+=1;
        assertEquals(1,arrayplace);
    }

    public void testhasTweet2(){
        ArrayList<Tweet> tweets = new ArrayList<Tweet>();
        assertTrue(tweets.isEmpty());
    }

    public ArrayList testgetTweets(){
        ArrayList<Tweet> tweets = new ArrayList<Tweet>();
        assertFalse(tweets.size()==0);
        tweets.add(new NormalTweet("Test Tweet1"));
        tweets.add( new NormalTweet("Test Tweet2"));
        tweets.add( new NormalTweet("Test Tweet3"));
        tweets.add( new NormalTweet("Test Tweet4"));
        tweets.add( new NormalTweet("Test Tweet5"));
        tweets.add( new NormalTweet("Test Tweet6"));
        assertTrue(tweets.size()>2);
        for(int i=1;i<tweets.size();i++){
            Date date1=tweets.get(i-1).getDate();
            Date date2=tweets.get(i).getDate();
            assertTrue(date1.before(date2));
        }
        return tweets;
    }
    public void testremoveTweet() { //-- should remove a tweet
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet1");
        tweets.add(tweet);
        tweets.removeTweet(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }
    public void testaddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet1");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }


}
