package com.tokiomarine.avaliacao.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@EnableJms
public class JmsConfig {

	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;

	@Value("${spring.activemq.user}")
	private String user;

	@Value("${spring.activemq.password}")
	private String password;

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		if ("".equals(user)) {
			return new ActiveMQConnectionFactory(brokerUrl);
		}
		return new ActiveMQConnectionFactory(user, password, brokerUrl);
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	@Bean
	public JmsListenerContainerFactory<?> jmsFactoryTopic(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setMessageConverter(jacksonJmsMessageConverter());
		factory.setPubSubDomain(true);
		configurer.configure(factory, connectionFactory);
		return factory;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setMessageConverter(jacksonJmsMessageConverter());
		template.setConnectionFactory(connectionFactory());
		return template;
	}

	@Bean
	public JmsTemplate jmsTemplateTopic() {
		JmsTemplate template = new JmsTemplate(connectionFactory());
		template.setMessageConverter(jacksonJmsMessageConverter());
		template.setPubSubDomain(true);
		return template;
	}
}
