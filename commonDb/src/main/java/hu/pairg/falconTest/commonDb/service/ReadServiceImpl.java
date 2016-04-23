package hu.pairg.falconTest.commonDb.service;

import hu.pairg.falconTest.commonDb.data.model.Message;
import hu.pairg.falconTest.commonDb.data.respository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by pairg on 2016.04.23..
 */
public class ReadServiceImpl implements ReadService {

    private final MessageRepository messageRepository;

    @Autowired
    public ReadServiceImpl(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @Override
    public Iterable<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Iterable<Message> getAllMessagesForRoom(String roomName) {
        return messageRepository.findByRoomNameOrderById(roomName);
    }

}
