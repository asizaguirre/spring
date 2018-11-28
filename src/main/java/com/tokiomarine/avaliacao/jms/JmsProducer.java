package com.tokiomarine.avaliacao.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.tokiomarine.avaliacao.domain.Pessoa;

@Component
public class JmsProducer {

	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private JmsTemplate jmsTemplateTopic;

	public void sendToQueue(Pessoa str) {
		jmsTemplate.convertAndSend("queue.pessoa", str);
	}

	public void sendToTopic(Pessoa str) {
		jmsTemplateTopic.convertAndSend("topic.pessoa", str);
	}

}
