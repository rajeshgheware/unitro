package com.example.unitro;

import org.junit.Test;

import com.example.unitro.domain.UnitroAlertMessage;
import com.example.unitro.domain.UnitroLocationMessage;
import com.example.unitro.domain.UnitroLoginMessage;
import com.example.unitro.domain.UnitroStatusMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageParserTest {

	@Test
	public void testParseLogin() throws Exception {
		String data = "78780D01012345678901234500018CDD0D0A";
		UnitroLoginMessage message = UnitroLoginMessage.parse(data);
		log.info("Platform server: " + message);
	}

	@Test
	public void testParseLocation() throws Exception {
		String data = "78781F120B081D112E10CC027AC7EB0C46584900148F01CC00287D001FB8000380810D0A";
		UnitroLocationMessage message = UnitroLocationMessage.parse(data);
		log.info("Parsed message: " + message.getSpeed());
		Double speed = (new Float(message.getSpeed()).doubleValue()) * 3600 / 1000;
		log.info("Platform server: " + speed);
	}

	@Test
	public void testParseAlert() throws Exception {
		//TODO please verify below message before testing
		String data = "787825160B0B0F0E241DCF027AC8870C4657E60014020901CC00287D001F726506040101003656A40D0A";
		UnitroAlertMessage message = UnitroAlertMessage.parse(data);
		log.info("Platform server: " + message);
	}

	@Test
	public void testParseStatus() throws Exception {
		String data = "";//TODO  please key in sample status message here to test code
		UnitroStatusMessage message = UnitroStatusMessage.parse(data);
		log.info("Platform server: " + message);
	}

}
