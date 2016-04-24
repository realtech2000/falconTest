package hu.pairg.falconTest.ws.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by pairg on 2016.04.24..
 */
public class Message {

    private final String senderName;
    private final String message;

    public Message(
            @JsonProperty("senderName") String senderName,
            @JsonProperty("message") String message
    ){
        this.senderName = senderName;
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getMessage() {
        return message;
    }

}
