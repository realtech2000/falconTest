package hu.pairg.falconTest.commonDb.service;

import hu.pairg.falconTest.commonDb.data.model.Message;
import hu.pairg.falconTest.commonDb.data.respository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pairg on 2016.04.23..
 */
public class WriteServiceImpl implements WriteService {

    private final MessageRepository messageRepository;

    @Autowired
    public WriteServiceImpl(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @Override
    public void createMessage(Message message) {
        messageRepository.save(message);
    }

}
