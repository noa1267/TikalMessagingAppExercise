package com.tikal.MessagingApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tikal.MessagingApp.model.Message;


@RestController
@RequestMapping("messages")

public class MessageController {
	private Map<String, List<Message>> userMsgMap;
	
	
	@GetMapping(path = "/{recipient}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Message>> receiveMessages(@PathVariable String recipient) {
		if (userMsgMap!=null && userMsgMap.containsKey(recipient)) {
			List<Message> msgList = userMsgMap.get(recipient);
			if (msgList!=null && !msgList.isEmpty()) {
				return new ResponseEntity<>(msgList, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Message> sendMessage(@Valid @RequestBody Message msg) {
		List<Message> list;
		if (userMsgMap==null) {
			userMsgMap = new HashMap<String, List<Message>>();
		}
		String recipient = msg.getRecipient();
		if (userMsgMap.containsKey(recipient)) {
			list = userMsgMap.get(recipient);
		}else {
			list = new ArrayList<Message>();
		}
		list.add(msg);
		userMsgMap.put(recipient, list);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
