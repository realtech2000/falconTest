package hu.pairg.falconTest.api.service;

import hu.pairg.falconTest.api.domain.Message;
import hu.pairg.falconTest.api.messaging.Producer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pairg on 2016.04.23..
 */
public class CommandServiceImpl implements CommandService {

    private final Producer producer;

    @Autowired
    public CommandServiceImpl(Producer producer){
        this.producer = producer;
    }

    @Override
    public void createMessage(Message message) {
        producer.send(message);
    }

}
