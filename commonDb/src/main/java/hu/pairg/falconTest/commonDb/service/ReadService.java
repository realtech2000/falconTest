package hu.pairg.falconTest.commonDb.service;

import hu.pairg.falconTest.commonDb.data.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pairg on 2016.04.23..
 */
@Service
public interface ReadService {

    Iterable<Message> getAllMessages();

    Iterable<Message> getAllMessagesForRoom(String roomName);

}
