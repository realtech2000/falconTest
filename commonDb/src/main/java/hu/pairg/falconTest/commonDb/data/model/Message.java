package hu.pairg.falconTest.commonDb.data.model;

import javax.persistence.*;

/**
 * Created by pairg on 2016.04.23..
 */
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_seq_gen")
    @SequenceGenerator(name = "message_seq_gen", sequenceName = "message_id_seq")
    private long id;

    @Column(nullable = false)
    private String roomName;

    @Column(nullable = false)
    private String senderName;

    @Column(nullable = false)
    private String message;

    protected Message(){}

    public Message(String roomName, String senderName, String message) {
        this.roomName = roomName;
        this.senderName = senderName;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format(
                "Message[id=%d, roomName='%s', senderName='%s', message='%s']",
                id, roomName, senderName, message
        );
    }

    public long getId() {
        return id;
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
