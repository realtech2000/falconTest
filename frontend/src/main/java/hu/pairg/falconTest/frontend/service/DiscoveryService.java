package hu.pairg.falconTest.frontend.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by pairg on 2016.04.25..
 */
@Service
public interface DiscoveryService {

    Optional<ServiceInstance> getWebSocketService();

    Optional<ServiceInstance> getRestApiService();

}
