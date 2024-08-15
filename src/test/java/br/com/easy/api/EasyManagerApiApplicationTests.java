package br.com.easy.api;

import br.com.easy.api.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class EasyManagerApiApplicationTests {

	@Autowired
	private SecurityConfig securityConfig;

	@Test
	void contextLoads() {
	}

}
