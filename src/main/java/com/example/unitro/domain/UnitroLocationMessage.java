package com.example.unitro.domain;

import java.text.ParseException;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitroLocationMessage {

	private String heading;// direction angle
	private String imei;
	private boolean panic;
	private boolean engine;
	private boolean engineCutoff;
	private boolean towing;
	private Date timestamp;
	private boolean valid;// is GPS valid
	private Double latitude;
	private Double longitude;
	private Double speed;
	private Float internalBatteryVolts;
	//TODO any other parameter received from the device

	/**
	 * @param input
	 * @return
	 * @throws ParseException
	 */
	public static UnitroLocationMessage parse(String input) throws ParseException {
		UnitroLocationMessage unitroLocationMessage = new UnitroLocationMessage();

		//TODO parsing code 
		
		
		return unitroLocationMessage;
	}


	public static String response() {
		//TODO write response string here
		return "";
	}

}
