package org.eclipse.kura.dnomaid.OSGiServicePattern.api;

public interface Message {
	class MessageException extends Exception {
		private static final long serialVersionUID = 1L;
	};
	String getMessage(String clientName)throws MessageException;
}
