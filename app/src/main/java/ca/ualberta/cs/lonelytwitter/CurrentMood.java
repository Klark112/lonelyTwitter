package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by klark on 1/12/16.
 */
public abstract class CurrentMood {
    public Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
