package mx.com.asteci.activemq.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import mx.com.asteci.activemq.messages.MessageReceiver;
import mx.com.asteci.activemq.model.Message;

@Service
public class MessageService {

	private static Logger LOG = LoggerFactory.getLogger(MessageService.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private MessageReceiver receiver;
	
	
	public void sendMessage(Message message) {
		LOG.info("enviando con convertAndSend() para queue <" + message + ">");
		jmsTemplate.convertAndSend("order-queue" , message);
		
	}
	
	public void get() {
		MessageReceiver m = (MessageReceiver) jmsTemplate.receive();
		System.out.println(m.toString());
	}
	
	/*
	public static void main(String[] args) {
		MessageService impl = new MessageService();
		impl.get();
	}
	*/
	
}
