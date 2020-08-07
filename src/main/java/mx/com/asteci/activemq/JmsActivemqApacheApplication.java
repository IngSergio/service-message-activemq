package mx.com.asteci.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.jms.core.JmsTemplate;

import mx.com.asteci.activemq.config.MessageConfig;
import mx.com.asteci.activemq.model.Message;
import mx.com.asteci.activemq.config.MessageConfig;

@SpringBootApplication
public class JmsActivemqApacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsActivemqApacheApplication.class, args);
	}

}
