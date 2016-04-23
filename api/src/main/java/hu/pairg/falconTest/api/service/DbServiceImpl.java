package hu.pairg.falconTest.api.service;

import hu.pairg.falconTest.api.domain.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pairg on 2016.04.23..
 */
public class DbServiceImpl implements DbService {

    @Override
    public boolean createMessage(Message message) {
        return true;
    }

    @Override
    public List<Message> getAllMessages() {
        return new ArrayList<>();
    }

    @Override
    public List<Message> getAllMessagesForRoom(String roomName) {
        return new ArrayList<>();
    }

}
