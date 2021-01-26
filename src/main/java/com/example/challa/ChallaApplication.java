package com.example.challa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ChallaApplication {


	public static void main(String[] args) {
		SpringApplication.run(ChallaApplication.class, args);
//		//Get encoded password
//		String encoded = new BCryptPasswordEncoder().encode("87654321");
//		System.out.println("=======> Encoded password:" + encoded);
	}

}
