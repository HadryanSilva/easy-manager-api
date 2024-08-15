package br.com.easy.api;

import br.com.easy.api.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
class EasyManagerApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
