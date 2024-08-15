package br.com.easy.api;

import br.com.easy.api.config.SecurityConfigTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@Import(SecurityConfigTest.class)
@SpringBootTest
@ActiveProfiles("test")
class EasyManagerApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
