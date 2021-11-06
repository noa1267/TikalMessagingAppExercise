package com.tikal.MessagingApp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Message{
	private static int instanceCounter = 0;
	public static final String msgDateFormat = "dd/MM/yy HH:mm:ss";

	private final int minLength = 1;
	private final int nameMaxLength = 25;
	private final int msgMaxLength = 5000;
	
	private int msgId;
	
	@NotNull(message="sender cannot be null")
	@Size(min=minLength, max=nameMaxLength, message = "sender possible length is " + minLength + "-" + nameMaxLength + " characters")
	private String sender;
	
	@NotNull(message="recipient cannot be null")
	@Size(min=minLength, max=nameMaxLength, message = "recipient possible length is " + minLength + "-" + nameMaxLength + " characters")
	private String recipient;
	
	@NotNull(message="msgContent cannot be null")
	@Size(min=minLength, max=msgMaxLength, message = "msgContent possible length is " + minLength + "-" + msgMaxLength + " characters")
	private String msgContent;
	
	private String msgDate;

	public Message(String sender, String recipient, String msgContent) {
		super();
		synchronized(this){
			instanceCounter++;
		}
		this.msgId = instanceCounter; //id is AI according to instanceCounter value
		this.sender = sender;
		this.recipient = recipient;
		this.msgContent = msgContent;
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(msgDateFormat);
		this.msgDate = now.format(formatter);
	}


	public int getMsgId() {
		return msgId;
	}

	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getRecipient() {
		return recipient;
	}


	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}


	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}


	public String getMsgDate() {
		return msgDate;
	}


	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", sender=" + sender + ", recipient=" + recipient + ", msgContent="
				+ msgContent + ", msgDate=" + msgDate + "]";
	}
}