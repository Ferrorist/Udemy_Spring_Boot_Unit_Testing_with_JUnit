package pdm.studyjunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import pdm.studyjunit.Utils.DemoUtils;

@SpringBootTest
class ApplicationTests {

	@Test
	void testEqualsAndNotEquals() {
		DemoUtils demoUtils = new DemoUtils();

		assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
		assertNotEquals(8, demoUtils.add(2, 4), "2+4 must be not 8");
	}

	@Test
	void testNullAndNotNull() {
		DemoUtils demoUtils = new DemoUtils();

		String str1 = null;
		String str2 = "luv2code";

		assertNull(demoUtils.checkNull(str1), "Object should be null");
		assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
	}

}
