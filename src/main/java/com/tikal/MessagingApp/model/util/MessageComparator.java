package com.tikal.MessagingApp.model.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

import com.tikal.MessagingApp.model.Message;

public class MessageComparator implements Comparator<Message> {
	@Override
	public int compare(Message m1, Message m2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Message.msgDateFormat);
		LocalDateTime m1Date = LocalDateTime.parse(m1.getMsgDate(), formatter);
		LocalDateTime m2Date = LocalDateTime.parse(m2.getMsgDate(), formatter);
        return m2Date.compareTo(m1Date); 
	}
}
