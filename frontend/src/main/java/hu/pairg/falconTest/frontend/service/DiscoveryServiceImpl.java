package hu.pairg.falconTest.frontend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import java.util.Optional;

/**
 * Created by pairg on 2016.04.25..
 */
public class DiscoveryServiceImpl implements DiscoveryService {

    private static final String FULL_APP_NAME = "FalconTest";
    private static final String WS_APP_NAME = "FalconTestWs";
    private static final String API_APP_NAME = "FalconTestApi";

    private final Logger logger = LoggerFactory.getLogger(DiscoveryServiceImpl.class);

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Override
    public Optional<ServiceInstance> getWebSocketService() {
        Optional<ServiceInstance> webSocketService = Optional.empty();
        try{
            webSocketService = Optional.of(this.loadBalancer.choose(WS_APP_NAME));
        }catch (Exception e){
            logger.error("LoadBalancer couldn't find a running WebSocket app instance!", e);
        }

        if(webSocketService.isPresent())
            return webSocketService;
        else
            return this.getFullService();
    }

    @Override
    public Optional<ServiceInstance> getRestApiService() {
        Optional<ServiceInstance> restService = Optional.empty();
        try{
            restService = Optional.of(this.loadBalancer.choose(API_APP_NAME));
        }catch (Exception e){
            logger.error("LoadBalancer couldn't find a running REST API app instance!", e);
        }

        if(restService.isPresent())
            return restService;
        else
            return this.getFullService();
    }

    private Optional<ServiceInstance> getFullService() {
        try{
            return Optional.of(this.loadBalancer.choose(FULL_APP_NAME));
        }catch (Exception e){
            logger.error("LoadBalancer couldn't find a running Full app instance!", e);
            return Optional.empty();
        }
    }

}
