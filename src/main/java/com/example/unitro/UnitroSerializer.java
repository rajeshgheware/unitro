package com.example.unitro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.integration.ip.tcp.serializer.AbstractByteArraySerializer;
import org.springframework.integration.ip.tcp.serializer.SoftEndOfStreamException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component(value="unitroSerializeDeserialize")
public class UnitroSerializer extends AbstractByteArraySerializer {
	
	String packetHeader=null;
	
	public void serialize(byte[] bytes, OutputStream outputStream)
			throws IOException {
		outputStream.write(bytes);
		outputStream.flush();
	}

	public byte[] deserialize(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[this.maxMessageSize];
		int n = 0;
		int bite = 0;
		while (bite >= 0) {
			bite = inputStream.read();
			if (bite < 0) {
				if (n == 0) {
					throw new SoftEndOfStreamException("Stream closed between payloads");
				}
				break;
			}
			buffer[n++] = (byte) bite;
			if (n >= this.maxMessageSize) {
				throw new IOException("Socket was not closed before max message length: "
						+ this.maxMessageSize);
			}
			byte[] assembledData = new byte[n];
			System.arraycopy(buffer, 0, assembledData, 0, n);
			String deviceMsg = new String(assembledData);
			if(deviceMsg.endsWith("0D0A")){
//				logger.info("Socket Stream:"+new String(assembledData));
				return assembledData;				
			}
		};
		byte[] assembledData = new byte[n];
		System.arraycopy(buffer, 0, assembledData, 0, n);
		log.info("Socket Stream:"+new String(assembledData));
		return assembledData;
	}

}

