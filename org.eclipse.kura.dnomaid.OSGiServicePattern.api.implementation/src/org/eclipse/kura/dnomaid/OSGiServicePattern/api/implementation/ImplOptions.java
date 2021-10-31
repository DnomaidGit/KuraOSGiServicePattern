package org.eclipse.kura.dnomaid.OSGiServicePattern.api.implementation;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

import java.util.Map;

public class ImplOptions {
	// Default value
    private static final String DEFAULT_MESSAGE = "Default message";
    // Property Names
    private static final String MESSAGE = "message.text";

    private final Map<String, Object> properties;

    ImplOptions(final Map<String, Object> properties) {
        requireNonNull(properties);
        this.properties = properties;
    }

    String getMessage() {
        String message = DEFAULT_MESSAGE;
        Object propertie = this.properties.get(MESSAGE);
        if (nonNull(propertie) && propertie instanceof String) {
        	message = (String) propertie;
        }
        return message;
    }

}
