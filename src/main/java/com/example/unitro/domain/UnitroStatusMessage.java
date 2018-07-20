package com.example.unitro.domain;

import java.text.ParseException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitroStatusMessage {

	private String imei;
	//TODO define all parameters received from device for Status message

	/**
	 * @param input
	 * @return
	 * @throws ParseException
	 */
	public static UnitroStatusMessage parse(String input) throws ParseException {
		UnitroStatusMessage message = new UnitroStatusMessage();

		//TODO parsing code 
		
		
		return message;
	}


	public static String response() {
		//TODO write response string here
		return "";
	}

}
