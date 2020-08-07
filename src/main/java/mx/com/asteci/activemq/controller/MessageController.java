package mx.com.asteci.activemq.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.com.asteci.activemq.messages.MessageReceiver;
import mx.com.asteci.activemq.model.Message;
import mx.com.asteci.activemq.service.MessageService;

@Controller
@RequestMapping("/")
public class MessageController {

	static final Logger LOG = LoggerFactory.getLogger(MessageController.class);	
	
	@Autowired
	private MessageService service;
	
	@Autowired
	private MessageReceiver receiver;
	
	@GetMapping("/send")
	public String sendMessage(Message message) {
		LOG.info("Send message....");
		service.sendMessage(message);
		return "redirect:/";
	}
	
	@GetMapping("/")
	public String create(@ModelAttribute Message message, Model model) {
		List<Message> list = receiver.getMessages();
		
		model.addAttribute("msg", message);
		model.addAttribute("list", list);
		return "/index";
	}
}
