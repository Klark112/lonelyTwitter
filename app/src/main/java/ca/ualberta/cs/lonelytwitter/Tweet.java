package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * lists all the possible qualities a tweet normal or not can have
 * including the date, message and moods
 * @author romansky
 * @since 1/12/26
 */
public abstract class Tweet {
    protected Date date;
    protected String message;
    private ArrayList<CurrentMood> moods;

    /**
     * @deprecated the function is not implemented and is not used don't bother
     * @return
     */
    public abstract Boolean isImportant();
    //initializes a tweet with a given date
    public Tweet(Date date, String message) {
        this.date = date;
        this.message = message;
    }
    //initializes a tweet with the clock date
    public Tweet(String message) {
        this.message = message;
        this.date=new Date();
    }

    /**
     * was supposed to tell the user if there input was too long
     * @deprecated not used
     * @param message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;

    }
    //change the date on a tweet
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    /**
     * formats the tweet with the date
     */
    public String toString(){
        return (date.toString()+" | " +message);
    }
    //returns the date
    public Date getDate() {
        return this.date;
    }
    //returns the tweet
    public String getMessage() {return this.message;}

}
