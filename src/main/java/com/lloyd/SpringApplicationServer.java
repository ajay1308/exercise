package com.lloyd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class SpringApplicationServer.
 * Main class to start the server
 * 
 * @author Ajay
 */
@SpringBootApplication
public class SpringApplicationServer {

	/**
	 * The main method.
	 * main method to start the server
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringApplicationServer.class, args);
	}
}
