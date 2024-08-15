package br.com.easy.api;

import br.com.easy.api.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@Import(SecurityConfig.class)
@SpringBootTest
class EasyManagerApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
