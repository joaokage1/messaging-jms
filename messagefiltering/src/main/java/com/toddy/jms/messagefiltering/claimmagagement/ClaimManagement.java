package com.toddy.jms.messagefiltering.claimmagagement;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.naming.InitialContext;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class ClaimManagement {

	public static void main(String[] args) throws Exception {
		InitialContext initialContext = new InitialContext();

		Queue queue = (Queue) initialContext.lookup("queue/requestQueue");

		try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
				JMSContext jmsContext = cf.createContext()) {

			JMSProducer producer = jmsContext.createProducer();
			JMSConsumer consumer = jmsContext.createConsumer(queue, "hospitalID=123");

			ObjectMessage message = jmsContext.createObjectMessage();

			Claim claim = new Claim("Jhon", 123, "gyna", "blue cross", 1000);
			message.setObject(claim);
			message.setIntProperty("hospitalID", claim.getHostpitalID());

			producer.send(queue, message);

			Claim receive = consumer.receiveBody(Claim.class);
			System.out.println(receive.toString());
		}
	}

}
