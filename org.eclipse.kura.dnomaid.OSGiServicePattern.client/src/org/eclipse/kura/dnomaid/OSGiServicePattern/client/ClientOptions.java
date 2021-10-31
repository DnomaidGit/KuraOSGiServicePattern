package org.eclipse.kura.dnomaid.OSGiServicePattern.client;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

import java.util.Map;

public class ClientOptions {
	// Default value
    private static final String DEFAULT_NAME = "Default message";
    private static final int DEFAULT_PUBLISH_RATE = 1000;
    // Property Names
    private static final String NAME = "client.name";
    private static final String PUBLISH_RATE = "publish.rate";

    private final Map<String, Object> properties;

    ClientOptions(final Map<String, Object> properties) {
        requireNonNull(properties);
        this.properties = properties;
    }

    String getName() {
        String name = DEFAULT_NAME;
        Object propertie = this.properties.get(NAME);
        if (nonNull(propertie) && propertie instanceof String) {
        	name = (String) propertie;
        }
        return name;
    }
    
    int getPublishRate() {
        int publishRate = DEFAULT_PUBLISH_RATE;
        Object rate = this.properties.get(PUBLISH_RATE);
        if (nonNull(rate) && rate instanceof Integer) {
            publishRate = (int) rate;
        }
        return publishRate;
    }


}
