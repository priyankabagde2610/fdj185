package com.springbootday1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@SpringBootApplication
public class Springbootday1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootday1Application.class, args);
		System.out.println("in login page");
	}

}
