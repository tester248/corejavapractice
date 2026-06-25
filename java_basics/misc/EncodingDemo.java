package misc;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class EncodingDemo {
	public static void main(String[] args) {
		String password = "P@ssw0rd123";
		System.out.println("Original str: " + password);
		
		Encoder encoder = Base64.getEncoder();
		String encoded = encoder.encodeToString(password.getBytes());
		System.out.println("Base64 encoded str: " + encoded);
		
		Decoder decoder = Base64.getDecoder();
		byte[] decoded = decoder.decode(encoded.getBytes());
		System.out.println("Decoded str: " + new String(decoded));
	}
}
