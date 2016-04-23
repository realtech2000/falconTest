package hu.pairg.falconTest.commonDb.service;

import hu.pairg.falconTest.commonDb.data.model.Message;
import org.springframework.stereotype.Service;

/**
 * Created by pairg on 2016.04.23..
 */
@Service
public interface WriteService {

    void createMessage(Message message);

}
