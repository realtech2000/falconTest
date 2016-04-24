package hu.pairg.falconTest.ws.service;

import hu.pairg.falconTest.ws.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * Created by pairg on 2016.04.24..
 */
public class ReceiveMessageServiceImpl implements ReceiveMessageService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public ReceiveMessageServiceImpl(SimpMessagingTemplate simpMessagingTemplate){
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void receiveMessage(String roomName, Message message){
        this.simpMessagingTemplate.convertAndSend("/topic/"+roomName, message);
    }

}
