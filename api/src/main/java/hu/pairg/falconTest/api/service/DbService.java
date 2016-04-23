package hu.pairg.falconTest.api.service;

import hu.pairg.falconTest.api.domain.Message;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pairg on 2016.04.23..
 */
@Service
public interface DbService {

    boolean createMessage(Message message);

    List<Message> getAllMessages();

    List<Message> getAllMessagesForRoom(String roomName);

}
