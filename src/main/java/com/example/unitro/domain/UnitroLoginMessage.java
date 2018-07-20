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
public class UnitroLoginMessage {

	private String imei;
	//TODO define all parameters received from device for Login message

	/**
	 * @param input
	 * @return
	 * @throws ParseException
	 */
	public static UnitroLoginMessage parse(String input) throws ParseException {
		UnitroLoginMessage message = new UnitroLoginMessage();

		//TODO parsing code 
		
		
		return message;
	}


	public static String response() {
		//TODO write response string here
		return "";
	}

}
