package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * was one of the possible moods a user could attach to the tweet
 * to help communicate their feelings
 * @author klark
 * @deprecated never fully implemented
 */
public class Gleeful extends CurrentMood {
    public Date date;
    public String gmood(){
        return  "gleeful";
    }
}
