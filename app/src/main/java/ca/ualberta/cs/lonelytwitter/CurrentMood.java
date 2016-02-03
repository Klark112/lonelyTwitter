package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * @author klark
 * @since 1/12/16
 * @deprecated never fully implemented
 * was supposed to show a mood attached to the tweet
 * @see Frustrated
 * @see Gleeful
 */
public abstract class CurrentMood {
    public Date date;

    public CurrentMood(){
        this.date = new Date();

    };
    public CurrentMood(Date date){
        this.date = date;
    };

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
