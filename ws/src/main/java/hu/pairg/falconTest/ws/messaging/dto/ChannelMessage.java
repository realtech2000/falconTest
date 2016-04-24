package hu.pairg.falconTest.ws.messaging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChannelMessage {

    private final String roomName;
    private final String senderName;
    private final String message;

    public ChannelMessage(
            @JsonProperty(value = "roomName", required = true) String roomName,
            @JsonProperty(value = "senderName", required = true) String senderName,
            @JsonProperty(value = "message", required = true) String message
    ) {
        this.roomName = roomName;
        this.senderName = senderName;
        this.message = message;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getMessage() {
        return message;
    }

}
