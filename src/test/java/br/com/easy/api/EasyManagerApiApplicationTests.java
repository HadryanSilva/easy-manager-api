package br.com.easy.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class EasyManagerApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void teste() {
		var encoder = new BCryptPasswordEncoder();

		System.out.println(encoder.encode("admin"));
	}

}
