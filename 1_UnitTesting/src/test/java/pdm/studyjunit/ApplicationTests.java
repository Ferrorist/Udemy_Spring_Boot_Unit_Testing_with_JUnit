package pdm.studyjunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import pdm.studyjunit.Utils.DemoUtils;

@SpringBootTest
@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
class ApplicationTests {

	DemoUtils demoUtils;

	@BeforeEach
	void setUp() {
		demoUtils = new DemoUtils();
	}

	@Test
	@DisplayName("Equals And Not Equals")
	void testEqualsAndNotEquals() {
		assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
		assertNotEquals(8, demoUtils.add(2, 4), "2+4 must be not 8");
	}

	@Test
	void testNullAndNotNull() {
		String str1 = null;
		String str2 = "luv2code";

		assertNull(demoUtils.checkNull(str1), "Object should be null");
		assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
	}

	// @BeforeAll
	// static void beforeAll() {
	// 	System.out.println("@BeforeAll print!");
	// }
	//
	// @AfterEach
	// void tearDown() {
	// 	System.out.println("@AfterEach print!");
	// }
	//
	// @AfterAll
	// static void afterAll() {
	// 	System.out.println("@AfterAll print!");
	// }
}
