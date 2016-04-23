package hu.pairg.falconTest.api.service;

import hu.pairg.falconTest.api.domain.Message;
import org.springframework.stereotype.Service;

/**
 * Created by pairg on 2016.04.23..
 */
@Service
public interface CommandService {

    boolean createMessage(Message message);

}
