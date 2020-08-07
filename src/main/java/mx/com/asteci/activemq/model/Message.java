package mx.com.asteci.activemq.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable{

	private String to;
	private String body;
	
	private static final long serialVersionUID = -9032186424126545307L;
}
