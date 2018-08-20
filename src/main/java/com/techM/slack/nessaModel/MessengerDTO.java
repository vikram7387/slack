package com.techM.slack.nessaModel;

public class MessengerDTO {
	
	private Recipient recipient;
	private MessengerMessage messengerMessage;
	private MessangerSession messangerSession;
	
	public MessangerSession getMessangerSession() {
		return messangerSession;
	}
	public void setMessangerSession(MessangerSession messangerSession) {
		this.messangerSession = messangerSession;
	}
	public Recipient getRecipient() {
		return recipient;
	}
	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}
	public MessengerMessage getMessengerMessage() {
		return messengerMessage;
	}
	public void setMessengerMessage(MessengerMessage messengerMessage) {
		this.messengerMessage = messengerMessage;
	}
	
}
