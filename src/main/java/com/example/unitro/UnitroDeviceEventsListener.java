package com.example.unitro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UnitroDeviceEventsListener {

	@Autowired
	ApplicationEventPublisher applicationEventPublisher;

	@ServiceActivator(inputChannel = "unitroDeviceMessagesLocation", outputChannel = "unitroDeviceResponseChannel")
	public String process(Message<String> message) throws Exception {
		log.info("UnitroMessage message {} : {}", deviceConnectionDetails(message.getHeaders()), message.getPayload());
		String payload = message.getPayload();
		// TODO detect message and parse
		// and after parsing publish the parsed message
		// applicationEventPublisher.publishEvent(UnitroLocationMessage);
		String response = "OK";// TODO Get the response if it is a login message
		return response;
	}

	private String deviceConnectionDetails(MessageHeaders msgHeaders) {
		int port = (Integer) msgHeaders.get("ip_tcp_remotePort");
		String ip = (String) msgHeaders.get("ip_address");
		return ip + ":" + port;
	}

}
