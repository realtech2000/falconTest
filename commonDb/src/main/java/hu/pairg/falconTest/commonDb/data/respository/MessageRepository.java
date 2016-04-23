package hu.pairg.falconTest.commonDb.data.respository;

import hu.pairg.falconTest.commonDb.data.model.Message;
import org.hibernate.annotations.OrderBy;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by pairg on 2016.04.23..
 */
public interface MessageRepository extends CrudRepository<Message, Long> {

    Iterable<Message> findByRoomNameOrderById(String roomName);

}
