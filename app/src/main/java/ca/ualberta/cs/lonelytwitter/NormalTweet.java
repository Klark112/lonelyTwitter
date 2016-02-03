package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * @version 1.0, 1/12/16
 * @author romansky
 * defines what a normal tweet is, using the methods
 * <ul>
 *     <li>NormalTweet</li>
 *     <li>getDate</li>
 *     <li>getMessage</li>
 *     <li>isImportant</li>
 * </ul>
 */
public class NormalTweet extends Tweet implements Tweetable {
    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    public NormalTweet(String message) {
        super(message);
    }

    public Date getDate() {
        return this.date;
    }

    public String getMessage() {return this.message;}

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
