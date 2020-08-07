package mx.com.asteci.activemq.messages;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Session;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import mx.com.asteci.activemq.model.Message;

@Component
public class MessageReceiver {
	
	List<Message> list = new ArrayList<>();
	
	@JmsListener(destination = "order-queue", containerFactory = "myFactory")
	public void receiverMessages(Message message) {
		System.out.println("Received <" + message + ">");
		if (message != null) {
			list.add(message);
		}
	}
	
	public List<Message> getMessages() {
		return list;
	}
}

