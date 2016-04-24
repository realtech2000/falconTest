package hu.pairg.falconTest.ws.service;

import hu.pairg.falconTest.ws.messaging.Producer;
import hu.pairg.falconTest.ws.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pairg on 2016.04.24..
 */
public class WsCommandServiceImpl implements WsCommandService {

    private final Producer producer;

    @Autowired
    public WsCommandServiceImpl(Producer producer){
        this.producer = producer;
    }

    @Override
    public void createMessage(String roomName, Message message) {
        this.producer.send(roomName, message);
    }

}
