package hu.pairg.falconTest.api.service;

import hu.pairg.falconTest.commonDb.service.ReadService;
import hu.pairg.falconTest.api.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by pairg on 2016.04.23..
 */
public class QueryServiceImpl implements QueryService {

    private final ReadService dbReadService;

    @Autowired
    public QueryServiceImpl(ReadService dbReadService){
        this.dbReadService = dbReadService;
    }

    @Override
    public List<Message> getAllMessages() {
        Iterable<hu.pairg.falconTest.commonDb.data.model.Message> iter = dbReadService.getAllMessages();

        return StreamSupport.stream(iter.spliterator(), false)
                .map(e -> new Message(e.getRoomName(), e.getSenderName(), e.getMessage()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Message> getAllMessagesForRoom(String roomName) {
        Iterable<hu.pairg.falconTest.commonDb.data.model.Message> iter =
                dbReadService.getAllMessagesForRoom(roomName);

        return StreamSupport.stream(iter.spliterator(), false)
                .map(e -> new Message(e.getRoomName(), e.getSenderName(), e.getMessage()))
                .collect(Collectors.toList());
    }

}
