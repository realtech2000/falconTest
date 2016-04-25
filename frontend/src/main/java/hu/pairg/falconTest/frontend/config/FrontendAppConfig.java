package hu.pairg.falconTest.frontend.config;

import hu.pairg.falconTest.frontend.service.DiscoveryService;
import hu.pairg.falconTest.frontend.service.DiscoveryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pairg on 2016.04.25..
 */
@Configuration
public class FrontendAppConfig {

    @Bean(name = "FrontendDiscoveryService")
    public DiscoveryService discoveryService() {
        return new DiscoveryServiceImpl();
    }


}
