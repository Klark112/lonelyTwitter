package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by klark on 1/12/16.
 */
public class Frustrated extends CurrentMood {
    public Date date;
    public String fmood(){
        return  "frustrated";
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public Date getDate() {
        return date;
    }
}
