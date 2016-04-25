package hu.pairg.falconTest.frontend.controller;

import hu.pairg.falconTest.frontend.dto.Services;
import hu.pairg.falconTest.frontend.service.DiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/frontend")
public class ServiceDiscoveryController {

    private final DiscoveryService discoveryService;

    @Autowired
    public ServiceDiscoveryController(DiscoveryService discoveryService){
        this.discoveryService = discoveryService;
    }

    @RequestMapping(path = "/services", method = RequestMethod.GET)
    public @ResponseBody Services getServices() {
        return new Services(
                discoveryService.getWebSocketService()
                        .map(ServiceInstance::getPort)
                        .orElse(null),
                discoveryService.getRestApiService()
                        .map(ServiceInstance::getPort)
                        .orElse(null)
        );
    }

}
