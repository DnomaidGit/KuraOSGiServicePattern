package org.eclipse.kura.dnomaid.OSGiServicePattern.api.implementation;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.kura.configuration.ConfigurableComponent;
import org.eclipse.kura.dnomaid.OSGiServicePattern.api.Message;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImplService implements ConfigurableComponent, Message{
	
    private static final Logger S_LOGGER = LoggerFactory.getLogger(ImplService.class);
    private static final String ALIAS_APP_ID = "implDnomaid";

    private ImplOptions implOptions;
	
    // ----------------------------------------------------------------
    // Activation APIs
    // ----------------------------------------------------------------
    protected void activate(ComponentContext componentContext, Map<String, Object> properties) {
    	S_LOGGER.info("Activating "+ ALIAS_APP_ID +"...");
        updated(properties);
        S_LOGGER.info("Activating "+ ALIAS_APP_ID +"... Done.");
    }
    protected void deactivate(ComponentContext componentContext) {
    	S_LOGGER.info("Deactivating "+ ALIAS_APP_ID +"...");
    	S_LOGGER.info("Deactivating "+ ALIAS_APP_ID +"... Done.");
    }
    public void updated(Map<String, Object> properties) {
    	S_LOGGER.info("Updated "+ ALIAS_APP_ID +"...");
        dumpProperties("Update", properties);
        this.implOptions = new ImplOptions(properties);
        S_LOGGER.info("Updated "+ ALIAS_APP_ID +"... Done.");
    }
    
    // ----------------------------------------------------------------
    // Private Methods
    // ----------------------------------------------------------------
    private static void dumpProperties(final String action, final Map<String, Object> properties) {
        final Set<String> keys = new TreeSet<>(properties.keySet());
        for (final String key : keys) {
            S_LOGGER.info("{} - {}: {}", action, key, properties.get(key));
        }
    }
    
    // ----------------------------------------------------------------
    // Implementation
    // ----------------------------------------------------------------
	@Override
	public String getMessage(String clientName) throws MessageException {
		return implOptions.getMessage() + " (Client name::> " + clientName + " )";
	}
        
}
