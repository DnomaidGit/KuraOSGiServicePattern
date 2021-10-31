package org.eclipse.kura.dnomaid.OSGiServicePattern.client;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.kura.configuration.ConfigurableComponent;
import org.eclipse.kura.dnomaid.OSGiServicePattern.api.Message;
import org.eclipse.kura.dnomaid.OSGiServicePattern.api.Message.MessageException;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientService implements ConfigurableComponent {
	    private static final Logger S_LOGGER = LoggerFactory.getLogger(ClientService.class);
	    private static final String ALIAS_APP_ID = "ClientDnomaid";

	    private ScheduledExecutorService worker;
	    private ScheduledFuture<?> handle;
	    private Message refMessage;
	    
	    private ClientOptions clientOptions;

		public ClientService() {
			super();
			this.worker = Executors.newSingleThreadScheduledExecutor();
		}
		
		// ----------------------------------------------------------------
	    // Reference
	    // ----------------------------------------------------------------   
		protected void setMessageService(Message messageService) {
			refMessage = messageService;
		}
		protected void unsetMessageService(Message messageService) {
			refMessage = null;
		}	    
		
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
	    	this.worker.shutdown();
	    	S_LOGGER.info("Deactivating "+ ALIAS_APP_ID +"... Done.");
	    }
	    public void updated(Map<String, Object> properties) {
	    	S_LOGGER.info("Updated "+ ALIAS_APP_ID +"...");
	    	this.worker = Executors.newSingleThreadScheduledExecutor();
	    	dumpProperties("Update", properties);
	        this.clientOptions = new ClientOptions(properties);
	        publish();
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
	    private void publish() {
	        if (this.handle != null) {
	            this.handle.cancel(true);
	        }
	        int pubrate = clientOptions.getPublishRate();
	        this.handle = this.worker.scheduleAtFixedRate(new Runnable() {
	            @Override
	            public void run() {
	            	try {
						S_LOGGER.info("Message: {}",refMessage.getMessage(clientOptions.getName()));
					} catch (MessageException e) {
						S_LOGGER.error("Error: {}",e.getCause());
					}
	            }
	        }, 0, pubrate, TimeUnit.MILLISECONDS);
	    }
	
}
