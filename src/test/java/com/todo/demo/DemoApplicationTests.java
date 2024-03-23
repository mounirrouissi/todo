package com.todo.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // Use the "test" profile for test-specific configurations
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
